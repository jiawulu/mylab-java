package com.taobao.wireless.net;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络\本地文件操作
 *
 * @author mickshu E-mail: butai@taobao.com
 * @version ：2013-6-3 下午2:16:56 类说明
 */
public class FileUtils {


	private final static long MAX_LENGTH = 1024 * 1024;


	/**
	 * 读取网络文件内容,默认utf-8编码
	 * @param fileUrl 文件url
	 * @return
	 */
	public static StringBuilder readUrl(String fileUrl)
	{
		return readUrl(fileUrl,"utf-8");
	}

	/**
	 * 读取网络文件内容
	 * @param fileUrl 文件url
	 * @param encoding 文件编码
	 * @return
	 */
	public static StringBuilder readUrl(String fileUrl,String encoding) {
		StringBuilder out = null;
		BufferedReader rd = null;
		HttpURLConnection hConnect = null;

		try {
			URL newUrl = new URL(fileUrl);
			hConnect = (HttpURLConnection) newUrl.openConnection();

			// 读取内容
			rd = new BufferedReader(new InputStreamReader(
					hConnect.getInputStream(),encoding));
			out = new StringBuilder(1024);
			String line = rd.readLine();
            long len = 0;
			while(line !=null && (len + line.length()) < MAX_LENGTH)
			{
				out.append(line);
				len = len + line.length();
				line = rd.readLine();
			}

		} catch (Exception e) {

			return null;
		} finally {
			if (rd != null) {
				try {
					rd.close();
				} catch (IOException e) {
                    e.printStackTrace();
				}
			}
			if (hConnect != null) {
				hConnect.disconnect();
			}

		}

		return out;
	}

    @Test
    public void test(){
        String url = "http://a.tbcdn.cn/g/mtb/app-item/page_item.js";
        System.out.println(FileUtils.readUrl(url));
    }

}

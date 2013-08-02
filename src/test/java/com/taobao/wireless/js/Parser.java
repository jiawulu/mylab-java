package com.taobao.wireless.js;

import com.taobao.wireless.net.FileUtils;
import org.junit.Test;
import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.Scriptable;

/**
 * Created with IntelliJ IDEA.
 * User: wuzhong
 * Date: 13-8-2
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
public class Parser {

    String URL = "http://a.tbcdn.cn/g/mtb/app-item/page_item.js";
    @Test
    public void parseJS() {
        //1、通过Http请求获取js的String数据，格式如上
        String source = FileUtils.readUrl(URL).toString();
        //2、定义跟js中的Class的声明

        //3、初始化Context
        Context cx = Context.enter();
        Scriptable scope = cx.initStandardObjects();
        Object result = cx.evaluateString(scope, "{a:1};", "return", 1, null);
        System.out.println(result);
        Context.exit();
    }

}

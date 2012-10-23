package com.taobao.wireless;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuzhong
 * @create 2012 4:56 PM
 * @moduleDes
 *
 *
 *  java -classpath . com.taobao.wireless.UniqLine  ~/btrace/bin/btrace  `ps -ef | grep jboss.Main | awk '{print $2}'` com/taobao/wireless/VmClean.java e
 */
public class UniqLine {

    private static Set<String> sets = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        exec(args);
    }

    public static void exec(String[] args) throws Exception {

        Process process = Runtime.getRuntime().exec(args);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));

        while (true) {
           String line =  bufferedReader.readLine();
           if (null != line){
            print(line);
           }
        }

    }

    private static void print(String arg) {
        if (!sets.contains(arg)){
            sets.add(arg);
            System.out.println(arg);
        }
    }

}
package com.taobao.wireless;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

/**
 * @author wuzhong
 * @create 2012 4:05 PM
 * @moduleDes
 *
 *
 * ~/btrace/bin/btrace  `ps -ef | grep jboss.Main | awk '{print $2}'` VmClean.java
 */
@BTrace
public class VmClean {

    @OnMethod(
            clazz = "org.apache.velocity.runtime.parser.node.SimpleNode",
            method = "getTemplateName",
            location=@Location(Kind.RETURN))
    public static void execute(@Return final Object obj) {
         println(obj);
    }

}

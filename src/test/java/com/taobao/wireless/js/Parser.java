package com.taobao.wireless.js;

import com.taobao.wireless.net.FileUtils;
import junit.framework.Assert;
import org.junit.Test;
import sun.org.mozilla.javascript.internal.NativeArray;
import sun.org.mozilla.javascript.internal.NativeObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Parser {

    String URL = "http://a.tbcdn.cn/g/mtb/app-item/page_desc.js";

    @Test
    public void parseJS() throws ScriptException, IOException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Run InvScript.js
        Reader scriptReader = new InputStreamReader(
                Parser.class.getResourceAsStream("app.js"));
        try {
            engine.eval(scriptReader);
        } finally {
            scriptReader.close();
        }

        String source = FileUtils.readUrl(URL).toString();
        engine.eval(source);

        Object result = engine.eval("window.PAGECONFIG;");

        NativeObject a = (NativeObject)result;

        System.out.println(((NativeObject) result).get("name").toString());
        System.out.println(((NativeObject) result).get("title").toString());
        System.out.println(((NativeObject) result).get("route").toString());

        NativeObject res = (NativeObject)a.get("resources");
        NativeArray arr = (NativeArray) res.get("js");
        for(int i=0; i < arr.getLength(); i++) {
            System.out.println(arr.get(i, arr));
        }

        //ADD REGEX CHECK!!!


        Assert.assertTrue((Boolean) engine.eval("testRoute('detail\\\\/(P<pid>\\\\d+)\\\\/?','detail/123456')"));
        Assert.assertFalse((Boolean) engine.eval("testRoute('detail\\\\/(P<pid>\\\\d+)\\\\/?','desc/123456')"));


    }

}

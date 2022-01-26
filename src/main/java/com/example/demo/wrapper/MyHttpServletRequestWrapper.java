package com.example.demo.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;

//https://stackoverflow.com/questions/7318632/java-lang-illegalstateexception-getreader-has-already-been-called-for-this-re
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private String getBodyAsString() {
        StringBuffer buff = new StringBuffer();
        buff.append(" BODY_DATA START [ ");
        char[] charArr = new char[getContentLength()];
        try {
            BufferedReader reader = new BufferedReader(getReader());
            reader.read(charArr, 0, charArr.length);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buff.append(charArr);
        buff.append(" ] BODY_DATA END ");
        return buff.toString();
    }

    public String toString() {
        return getBodyAsString();
    }
}
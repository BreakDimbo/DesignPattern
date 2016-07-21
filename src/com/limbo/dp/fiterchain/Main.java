package com.limbo.dp.fiterchain;

/**
 * Created by Break.D on 7/13/16.
 */
public class Main {

    public static void main(String[] args) {
        String msg = "大家好,我是<小明>, 呵呵呵。";

        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("Response");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(request, response, fc);

        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());

    }

}

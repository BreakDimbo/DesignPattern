package com.limbo.dp.fiterchain;

/**
 * Created by Break.D on 7/13/16.
 */
public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        String msg = request.getRequestStr().replaceAll("<", "[").replaceAll(">", "]") + "----HTMLFilter";
        request.setRequestStr(msg);
        fc.doFilter(request, response, fc);
        response.setResponseStr(response.getResponseStr() + "----HTMLFilter");
    }
}

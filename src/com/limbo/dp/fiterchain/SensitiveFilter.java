package com.limbo.dp.fiterchain;

/**
 * Created by Break.D on 7/13/16.
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        String msg = request.getRequestStr().replaceAll("呵呵呵", "哈哈哈") + "----SensitiveFilter";
        request.setRequestStr(msg);
        fc.doFilter(request, response, fc);
        response.setResponseStr(response.getResponseStr() + "----SensitiveFilter");
    }
}

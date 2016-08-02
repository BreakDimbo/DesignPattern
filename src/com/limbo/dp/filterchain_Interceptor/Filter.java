package com.limbo.dp.filterchain_Interceptor;

/**
 * Created by Break.D on 7/13/16.
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain fc);
}

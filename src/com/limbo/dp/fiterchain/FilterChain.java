package com.limbo.dp.fiterchain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Break.D on 7/13/16.
 */
public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public int size() {
        return filters.size();
    }

    int index = 0;

    public FilterChain add(Filter fc) {
        filters.add(fc);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        while (index < fc.size()) {
            Filter f = filters.get(index++);
            f.doFilter(request, response, fc);
        }
    }
}

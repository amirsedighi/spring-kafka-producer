package io.meshk.k8s.springk8s.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class Metrics {


    final String WRAPPER_OPEN = "[";
    final String WRAPPER_CLOSE = "]";

    final String LOCATION = "Location:";


    final String TOTAL_TRANSACTIONS = "Total Transactions:";

    final String RESPONSE_TIME_MS = "RT(ms):";
    final String METRIC = "METRIC";
    @Value("${spring.application.name}")
    String app;

    final String SEPARATOR = " | ";

    public String responseTime(String location, StopWatch timer){
        return wrap(METRIC) + wrap(app) + wrap (RESPONSE_TIME_MS + timer.getTotalTimeMillis() ) + wrap(LOCATION+location);
    }


    public String totalTransaction(String location, Integer transactions, StopWatch timer){
        return wrap(METRIC) + wrap(app) + wrap (TOTAL_TRANSACTIONS + transactions ) + wrap (RESPONSE_TIME_MS + timer.getTotalTimeMillis() ) + wrap(LOCATION+location);
    }


    private String wrap(String item){
        return WRAPPER_OPEN+item+WRAPPER_CLOSE;
    }

}

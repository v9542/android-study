package com.somo.test.server;

/**
 * Created by yebonkim on 2016. 11. 19..
 */

public class ClearTimeRequest {
    String clean_date_time;

    public ClearTimeRequest(String clean_date_time) {
        this.clean_date_time = clean_date_time;
    }

    public String getClean_date_time() {
        return clean_date_time;
    }

    public void setClean_date_time(String clean_date_time) {
        this.clean_date_time = clean_date_time;
    }
}

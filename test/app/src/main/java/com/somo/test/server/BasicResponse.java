package com.somo.test.server;

/**
 * Created by Omjoon on 16. 2. 1..
 */
public class BasicResponse {
    String results;
    public BasicResponse(String result){
        this.results = result;

    }

    public String getResult() {
        return results;
    }

    public void setResult(String result) {
        this.results = result;
    }
}

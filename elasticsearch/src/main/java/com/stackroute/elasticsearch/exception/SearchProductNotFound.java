package com.stackroute.elasticsearch.exception;

public class SearchProductNotFound  extends Exception{
    public String error;

    public SearchProductNotFound() {

    }

    public SearchProductNotFound(String error) {
        super();
        this.error = error;
    }
}

package com.palvair.spring.mvc.form.security.annotations.rest;

import lombok.Data;

@Data
public class ErrorInfo {

	private final String url;
    private final String ex;

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
}

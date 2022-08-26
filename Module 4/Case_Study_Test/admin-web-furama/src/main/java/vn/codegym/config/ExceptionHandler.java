package vn.codegym.config;

import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String showPageError() {
        return "error";
    }

}

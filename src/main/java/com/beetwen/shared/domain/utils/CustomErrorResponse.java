package com.beetwen.shared.domain.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomErrorResponse {
    @JsonProperty("error")
    private ErrorDetails errorDetails;

    public CustomErrorResponse(int status, Throwable error, String message) {
        this.errorDetails = new ErrorDetails(status, message);
    }

    @Getter
    static class ErrorDetails {
        @JsonProperty("code")
        private int code;
        @JsonProperty("message")
        private String message;

        public ErrorDetails(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
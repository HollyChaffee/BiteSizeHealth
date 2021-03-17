package com.bytesizehealth.server.controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


    @ResponseStatus
    public class ResourceNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String message) {
        }

        public String ResourceNotFoundException(String message) {
            return message;
        }

        public ResourceNotFoundException(String message, Throwable throwable){
            super(message, throwable);
        }
    }


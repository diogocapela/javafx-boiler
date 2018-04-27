package com.diogocapela.javafxboiler.exceptions;

public class DuplicateException extends Exception {

    public DuplicateException(String message) {
        super("DuplicateException: " + message);
    }

}

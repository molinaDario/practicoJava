package com.molindario.exception;

public class ProductoException extends RuntimeException {

    public ProductoException() {

    }

    public ProductoException(String msj) {
        super(msj);
    }
}

package com.molindario.exception;


public class ClienteException extends RuntimeException{

    public ClienteException() {
        super("Se ha producido un error");
    }

    public ClienteException(String message) {
        super(message);
    }
    
    
}

package com.sennovate.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(long id){
        super(String.format("No client found with id: <%s>",id));
    }
}

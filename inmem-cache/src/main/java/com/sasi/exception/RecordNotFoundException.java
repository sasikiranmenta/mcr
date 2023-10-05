package com.sasi.exception;

import lombok.experimental.FieldDefaults;

@FieldDefaults
public class RecordNotFoundException extends Exception{

    public RecordNotFoundException(String message) {
        super(message);
    }

}

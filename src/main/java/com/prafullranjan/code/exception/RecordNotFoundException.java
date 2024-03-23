package com.prafullranjan.code.exception;

import java.io.IOException;

/**
 * RecordNotFoundException
 *
 * @author Prafull
 */
public class RecordNotFoundException extends IOException {

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String msg) {
        super(msg);
    }
}

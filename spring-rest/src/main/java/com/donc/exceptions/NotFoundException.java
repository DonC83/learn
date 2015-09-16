package com.donc.exceptions;

/**
 * This class is used to mitigate writing response entities for restful methods that are unable to locate the
 * requested resource.
 *
 * Created by donovan on 15/09/16.
 */
public class NotFoundException extends RuntimeException {

    private long id;

    public NotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}

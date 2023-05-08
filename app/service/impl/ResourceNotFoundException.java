package service.impl;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource, String field, String value) {
        super("Not found: " + resource + " with " + field + "=" + value);
    }
    public ResourceNotFoundException(){

    }
}

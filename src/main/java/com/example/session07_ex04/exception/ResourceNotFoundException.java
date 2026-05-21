package com.example.session07_ex04.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String resourceType;
    private String resourceId;

    public ResourceNotFoundException(String resourceType, String resourceId) {
        super(String.format("%s với ID '%s' không tồn tại trong hệ thống", resourceType, resourceId));
        this.resourceType = resourceType;
        this.resourceId = resourceId;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public String getResourceType() { return resourceType; }
    public String getResourceId() { return resourceId; }
}

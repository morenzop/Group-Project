package com.groupproject.Group.Project.models;

public class EnhancedResponse extends BasicResponse {
    private Object data;

    public EnhancedResponse () {

    }
    public EnhancedResponse(Object data) {
        this.data = data;
    }

    public EnhancedResponse(int code, String message, Object data) {
        super(code, message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnhancedResponse create (Object data, String message, int code) {
        return new EnhancedResponse(code, message, data);
    }
}

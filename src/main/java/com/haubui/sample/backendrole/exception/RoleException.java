package com.haubui.sample.backendrole.exception;

import com.haubui.sample.common.exception.GeneralException;

public class RoleException extends GeneralException {

    private String errorCode;

    private String errorMessage;

    private Object[] params;

    public RoleException() {
        super();
    }

    public RoleException(String errorMessage) {
        super(errorMessage);
    }

    public RoleException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RoleException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RoleException(String errorCode, String errorMessage, Object[] params, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.params = params;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object[] getParams() {
        return params;
    }
}

package com.school.modules.appCommon.exceptions;
import lombok.Setter;

@Setter
public class TechnicalException extends Exception {
    String message;

    public TechnicalException(String errorCode) {
        super(errorCode);
        message=errorCode;
    }

    public TechnicalException(String errorCode, String msg) {
        super(errorCode);
        this.message = msg;
    }

    public TechnicalException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

}
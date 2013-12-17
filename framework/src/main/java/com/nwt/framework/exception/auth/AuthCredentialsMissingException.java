package com.nwt.framework.exception.auth;

import com.nwt.framework.exception.BaseException;

/**
 * Exception indicating Auth credentials missing.
 *
 * @author: Prabakar Singaram
 */
public class AuthCredentialsMissingException extends BaseException {
    private static final long serialVersionUID = 672693922566865605L;


    public AuthCredentialsMissingException(String message) {
        super(message);
    }


    public AuthCredentialsMissingException(String message, Object errorCode) {
        super(message, errorCode);
    }
}

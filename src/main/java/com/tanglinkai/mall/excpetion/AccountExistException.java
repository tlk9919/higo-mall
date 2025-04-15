package com.tanglinkai.mall.excpetion;

/**
 * 账号重复异常
 */
public class AccountExistException extends RuntimeException{

    public AccountExistException() {
    }
    public AccountExistException(String message) {
        super(message);
    }
    public AccountExistException(Throwable cause) {
        super(cause);
    }
    public AccountExistException(String message, Throwable cause) {
        super(message, cause);
    }
}

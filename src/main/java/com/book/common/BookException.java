package com.book.common;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 19:23
 */
public class BookException extends Exception {
    /**
     * 异常
     *
     * @param message exception messagge
     */
    public BookException(String message) {
        super(message);
    }

    public BookException(String message, Object... args) {
        super(MessageFormatter.format(message, args).getMessage());
    }

    public BookException(Exception e, String message, Object... args) {
        super(MessageFormatter.format(message, args).getMessage(), e);
    }
}

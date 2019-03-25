package com.book.common;

import com.book.common.function.RunnableWithValue;

/**
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
public class Extend {

    public static <T> void ifNull(T value, Runnable runnable) {
        if (value == null) {
            runnable.run();
        }
    }

    public static <T> T isNull(T value, RunnableWithValue<T> runnable){
        if(value == null){
            return runnable.run();
        }
        return value;
    }

    public static <T> T with(T value, Runnable runnable) {
        runnable.run();
        return value;
    }

}

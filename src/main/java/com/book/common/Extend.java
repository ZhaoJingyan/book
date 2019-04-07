package com.book.common;

import com.book.common.function.RunnableWithArgument;
import com.book.common.function.RunnableWithValue;

/**
 * lambda 扩展方法
 *
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@SuppressWarnings("unused")
public class Extend {

    public static <T> void is(boolean condition, Runnable runnable) {
        if (condition) {
            runnable.run();
        }
    }

    /**
     * 如果为空，执行runnable
     *
     * @param value    条件值
     * @param runnable lambda
     * @param <T>      Object
     */
    public static <T> void ifNull(T value, Runnable runnable) {
        if (value == null) {
            runnable.run();
        }
    }

    /**
     * 如果值为空，返回默认值
     *
     * @param value        条件值
     * @param defaultValue 默认值
     * @param <T>          Object
     * @return 预期值
     */
    public static <T> T isNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }


    public static <T> T isNull(T value, RunnableWithValue<T> runnable) {
        if (value == null) {
            return runnable.run();
        }
        return value;
    }

    public static <T> T with(T value, RunnableWithArgument<T> runnable) {
        runnable.run(value);
        return value;
    }

    public static <T> T print(T value) {
        System.out.println(value.toString());
        return value;
    }

}

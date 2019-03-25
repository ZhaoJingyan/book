package com.book.common.function;

/**
 * 函数接口, T function()
 *
 * @param <T> 返回值
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
@FunctionalInterface
public interface RunnableWithValue<T> {

    /**
     * 函数方法
     *
     * @return 返回值
     */
    T run();

}

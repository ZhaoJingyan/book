package com.book.common.function;

/**
 * @author Zhao Jinyan
 * @date 2019/4/4 10:18
 */
@FunctionalInterface
public interface RunnableWithArgument<T> {

    /**
     * 函数方法
     *
     * @param argument 参数
     */
    void run(T argument);

}

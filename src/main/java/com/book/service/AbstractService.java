package com.book.service;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 20:51
 */
public interface AbstractService {

    /**
     * 保存摘要
     *
     * @param content 摘要内容
     * @return 摘要id
     */
    long save(String content);

    /**
     * 保存摘要
     *
     * @param id      摘要id
     * @param content 摘要内容
     * @return 摘要id
     */
    long save(long id, String content);

}

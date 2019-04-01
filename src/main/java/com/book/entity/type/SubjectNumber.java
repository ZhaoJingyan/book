package com.book.entity.type;

import com.book.common.OptionalUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 科目号
 *
 * @author Zhao Jinyan
 * @date 2019/3/31 21:22
 */
public class SubjectNumber {

    /**
     * 空目录号
     */
    private final static String EMPTY_ID = "00000000";

    /**
     * 空科目号，也是根目录号
     */
    private final static SubjectNumber EMPTY_SUBJECT_NUMBER = new SubjectNumber(EMPTY_ID);

    /**
     * 客户号缓存
     */
    private static Map<String, SubjectNumber> cache = new HashMap<>();

    /**
     * 获取科目号
     *
     * @param id 号码
     * @return 科目号
     */
    public static SubjectNumber of(final String id) {
        if (OptionalUtils.isBlank(id) || EMPTY_ID.equals(id)) {
            return EMPTY_SUBJECT_NUMBER;
        }
        SubjectNumber number = cache.get(id);
        if (number == null) {
            number = new SubjectNumber(id);
            cache.put(id, number);
        }
        return number;
    }

    private String id;

    private SubjectNumber(final String id) {
        this.id = OptionalUtils.isBlank(id) ? EMPTY_ID : id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SubjectNumber && this.id.equals(((SubjectNumber) obj).getId());
    }

    private String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

}

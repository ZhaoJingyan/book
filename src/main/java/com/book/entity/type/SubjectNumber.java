package com.book.entity.type;

import com.book.common.OptionalUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 科目号
 *
 * @author Zhao Jinyan
 * @date 2019/3/31 21:22
 */
public class SubjectNumber {

    private final static String EMPTY_ID = "00000000";

    private final static SubjectNumber EMPTY_SUBJECT_NUMBER = new SubjectNumber(EMPTY_ID);

    private static Map<String, SubjectNumber> cache = new HashMap<>();

    public static SubjectNumber of(final String id){
        if(OptionalUtils.isBlank(id) || EMPTY_ID.equals(id)){
            return EMPTY_SUBJECT_NUMBER;
        }
        SubjectNumber number = cache.get(id);
        if(number == null){
            number = new SubjectNumber(id);
            cache.put(id, number);
        }
        return number;
    }

    private String id;

    private SubjectNumber(final String id){
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

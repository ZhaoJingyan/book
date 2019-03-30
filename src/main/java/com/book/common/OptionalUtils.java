package com.book.common;

/**
 * @author Zhao Jinyan
 * @date 2019-03-30
 */
@SuppressWarnings("unused")
public class OptionalUtils {

    private static final String EMPTY_STRING = "";

    private static boolean isNull(Object object){
        return object == null;
    }

    private static boolean isEmpty(String string){
        return isNull(string) || EMPTY_STRING.equals(string);
    }

    private static boolean isBlank(String string){
        return isEmpty(string.trim());
    }

    public static boolean isNotBlank(String string){
        return !isBlank(string);
    }

}

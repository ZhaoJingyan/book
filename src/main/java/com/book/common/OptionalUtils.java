package com.book.common;

/**
 * @author Zhao Jinyan
 * @date 2019-03-30
 */
@SuppressWarnings("unused")
public class OptionalUtils {

    /**
     * 空白字符串
     */
    private static final String EMPTY_STRING = "";

    private static boolean isNull(Object object) {
        return object == null;
    }

    private static boolean isEmpty(String string) {
        return isNull(string) || EMPTY_STRING.equals(string);
    }

    /**
     * 判断字符串为空白
     *
     * @param string 字符串
     * @return 判断结果
     */
    public static boolean isBlank(String string) {
        return string == null || isEmpty(string.trim());
    }

    /**
     * 判断字符串不为空白
     *
     * @param string 字符串
     * @return 判断结果
     */
    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

}

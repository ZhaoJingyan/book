package com.book.entity.type;

import com.book.common.OptionalUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 科目路径
 *
 * @author Zhao Jinyan
 * @date 2019-03-30
 */
public class SubjectPath {

    final static String ROOT_PATH = "/";

    public final static SubjectPath ROOT = new SubjectPath(ROOT_PATH);

    private String pathString;

    private LinkedList<String> subjectNameChain = new LinkedList<>();

    /**
     * 构造方法
     *
     * @param pathString 路径字符串
     */
    public SubjectPath(String pathString) {
        subjectNameChain.add(ROOT_PATH);
        if (OptionalUtils.isNotBlank(pathString) && !ROOT_PATH.equals(pathString)) {
            Arrays.stream(pathString.split(ROOT_PATH)).filter(OptionalUtils::isNotBlank).forEach(subjectNameChain::add);
        }
        updatePathString();
    }

    private void updatePathString() {
        if (subjectNameChain.size() == 1) {
            pathString = ROOT_PATH;
            return;
        }
        StringBuilder builder = new StringBuilder();
        subjectNameChain.stream().skip(1).forEach(name -> builder.append(ROOT_PATH).append(name));
        pathString = builder.toString();
    }

    /**
     * 获取路径
     *
     * @return 路径
     */
    public String getDirectoryPath() {
        if (SubjectPath.ROOT.equals(this)) {
            return ROOT_PATH;
        }
        return pathString.substring(0, pathString.lastIndexOf(subjectNameChain.getLast()));
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
     String getName() {
        return subjectNameChain.getLast();
    }

    @Override
    public String toString() {
        return pathString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubjectPath that = (SubjectPath) o;
        return Objects.equals(pathString, that.pathString) && Objects.equals(subjectNameChain, that.subjectNameChain);
    }

    @Override
    public int hashCode() {
        return pathString.hashCode();
    }
}

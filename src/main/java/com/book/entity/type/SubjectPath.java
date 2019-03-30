package com.book.entity.type;

import com.book.common.OptionalUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 科目路径
 *
 * @author Zhao Jinyan
 * @date 2019-03-30
 */
public class SubjectPath {

    private final static String ROOT = "/";

    private String pathString;

    private LinkedList<String> subjectNameChain = new LinkedList<>();

    /**
     * 构造方法
     *
     * @param pathString 路径字符串
     */
    public SubjectPath(String pathString) {
        subjectNameChain.add(ROOT);
        if (OptionalUtils.isNotBlank(pathString) && !ROOT.equals(pathString)) {
            Arrays.stream(pathString.split(ROOT)).filter(OptionalUtils::isNotBlank).forEach(subjectNameChain::add);
        }
        updatePathString();
    }

    private void updatePathString() {
        if (subjectNameChain.size() == 1) {
            pathString = ROOT;
        }
        StringBuilder builder = new StringBuilder();
        subjectNameChain.forEach(name -> builder.append(ROOT).append(name));
        pathString = builder.toString();
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

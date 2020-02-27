package com.jiker.keju;

import lombok.Getter;

/**
 * @ProjectName: my-test
 * @Author: xwy
 * @Description:
 * @Date: 2020/2/26
 * @Version: 1.0
 */
public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair( L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}

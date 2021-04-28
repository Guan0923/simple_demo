package com.guan.simpledemo.pojo;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:14
 */
@FunctionalInterface
public interface MyFunctionSupplier<A, B, C, D> {
    D get(A a, B b, C c);
}

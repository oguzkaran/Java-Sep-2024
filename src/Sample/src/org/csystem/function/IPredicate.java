package org.csystem.function;

public interface IPredicate<T> {
    boolean test(T t) throws Exception;
}

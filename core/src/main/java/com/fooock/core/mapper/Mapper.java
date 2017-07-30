package com.fooock.core.mapper;

/**
 *
 */
public interface Mapper<F, T> {

    T map(F from);
}

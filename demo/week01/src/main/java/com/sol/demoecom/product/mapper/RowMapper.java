package com.sol.demoecom.product.mapper;

public interface RowMapper<T, S> {
    T mapRow(S s);
}

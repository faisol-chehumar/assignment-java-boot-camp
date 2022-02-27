package com.sol.demoecom.common;

import com.sol.demoecom.product.controller.response.AttributesItem;

import java.util.List;

public interface RowMapper<T, S> {
    T mapRow(S s);
    T mapRow(S s, List<AttributesItem> attributesItem);
}

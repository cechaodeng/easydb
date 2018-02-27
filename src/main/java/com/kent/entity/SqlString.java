package com.kent.entity;

import lombok.Data;

/**
 * @author Kent
 * @date 2018-02-26.
 */
@Data
public class SqlString {
    private String sql;

    public SqlString(String sql) {
        this.sql = sql;
    }
}

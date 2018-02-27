package com.kent.service;

import com.kent.dto.DataDTO;

/**
 * @author Kent
 * @date 2018-02-27.
 */
public interface DbOpService {
    DataDTO execute(String sql);
}

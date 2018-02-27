package com.kent.service;

import com.kent.dto.DataDTO;

import java.util.HashMap;
import java.util.List;

/**
 * @author Kent
 * @date 2018-02-27.
 */
public interface DbOpService {
    List<HashMap<String, String>> execute(String sql);

    DataDTO execute2(String sql);
}

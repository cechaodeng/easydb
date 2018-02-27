package com.kent.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Kent
 * @date 2018-02-27.
 */
public interface DbOpService {
    List<HashMap<String, String>> execute(String sql);

    String execute2(String sql);
}

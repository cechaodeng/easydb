package com.kent.service.impl;

import com.kent.dao.DbMapper;
import com.kent.dto.DataDTO;
import com.kent.entity.SqlString;
import com.kent.service.DbOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Kent
 * @date 2018-02-27.
 */
@Service
public class DbOpServiceImpl implements DbOpService {

    @Autowired
    private DbMapper dbMapper;

    @Override
    public List<HashMap<String, String>> execute(String sql) {
        return null;
    }

    /**
     * 查询数据库，并将数据库中内容拼接成controller层需要的对象
     * @param sql
     * @return
     */
    @Override
    public DataDTO execute2(String sql) {
        //查询
        List<HashMap<String, String>> list = dbMapper.queryDb(new SqlString(sql));
        //查询无结果
        if (list == null || list.size() <= 0) {
            return null;
        }
        DataDTO dataDTO = new DataDTO();
        //拼装
        StringBuilder dataJsonStr = new StringBuilder("");
        dataJsonStr.append("[");
        /**
         * 第一种思路，将表头和内容都放在一起，key用col+i的形式表示
         */
        //拼装表头
        dataJsonStr.append("{");
        //字段集合
        Set<String> keySet = list.get(0).keySet();
        //保存字段数量
        dataDTO.setColNum(keySet.size());
        String[] headArr = new String[keySet.size()];
        headArr = keySet.toArray(headArr);
        for (int i = 0; i < headArr.length; i++) {
            dataJsonStr.append("\"" + "COL" + i + "\"");
            dataJsonStr.append(":");
            dataJsonStr.append("\"" + headArr[i] + "\"");
            dataJsonStr.append(",");
        }
        //去掉末尾逗号
        dataJsonStr.deleteCharAt(dataJsonStr.length() - 1);
        //表头行结束，添加]
        dataJsonStr.append("}");

        //拼装内容
        for (int i = 0; i < list.size(); i++) {
            //其中一行数据,表头肯定存在，所以每一行的数据分隔逗号可以直接在这里append
            dataJsonStr.append(",{");
            HashMap<String, String> rowData = list.get(i);
            //对一行数据进行循环，取出每一列的数据
            for (int j = 0; j < headArr.length; j++) {
                String value = rowData.get(headArr[j]);
                //拼装到json中
                dataJsonStr.append("\"" + "COL" + j + "\"");
                dataJsonStr.append(":");
                dataJsonStr.append("\"" + value + "\"");
                dataJsonStr.append(",");
            }
            //去掉最后一个逗号
            dataJsonStr.deleteCharAt(dataJsonStr.length() - 1);
            //添加一个]
            dataJsonStr.append("}");
        }
        dataJsonStr.append("]");
        dataDTO.setDataJsonStr(dataJsonStr.toString());
        return dataDTO;
    }

}

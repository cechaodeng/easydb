package com.kent.dto;

import lombok.Data;

/**
 * @author Kent
 * @date 2018-02-27.
 */
@Data
public class DataDTO {
    private int colNum;
    private String dataJsonStr;

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public String getDataJsonStr() {
        return dataJsonStr;
    }

    public void setDataJsonStr(String dataJsonStr) {
        this.dataJsonStr = dataJsonStr;
    }
}

package com.meahu.retrofit.retrofit2.model;

import com.meahu.retrofit.retrofit2.model.IPDataModel;

/**
 * Created by Tiger on 2016/7/23.
 */
public class IPModel {
    private int code;

    private IPDataModel data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setData(IPDataModel data) {
        this.data = data;
    }

    public IPDataModel getData() {
        return this.data;
    }

}

package com.anthony;

import com.anthony.file.StockFile;
import com.anthony.manager.StockManager;

import java.util.List;

/**
 * Created by chend on 2017/6/27.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = StockFile.getStockCodeList();
        if(null==list)
            return;
        StockManager sm = new StockManager(list);

        sm.updateStockInfoMap();
    }
}

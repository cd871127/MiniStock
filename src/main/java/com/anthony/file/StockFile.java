package com.anthony.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chend on 2017/6/27.
 */
public class StockFile {
    public static List<String> getStockCodeList() {
        File file = new File("stock.list");
        ArrayList<String> stockList;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            stockList = new ArrayList<>();
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                if (!tmp.contains("#") && tmp.length() == 8)
                    stockList.add(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("股票代码列表文件不存在: stock.list");
            stockList = null;
        } catch (IOException e) {
            System.out.println("股票代码列表文件读写异常: stock.list");
            stockList = null;
        }
        return stockList;
    }
}

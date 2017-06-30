package com.anthony.manager;

import com.anthony.StockInfo;
import com.anthony.browsermocker.mocker.SimpleBrowserMocker;
import com.anthony.processor.StockProcessor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by chend on 2017/6/27.
 */
public class StockManager {

    private List<String> stockList = new ArrayList<>();
    final private static List<String> title = Arrays.asList("代码", "名称", "现价", "涨跌", "涨幅", "今开", "昨收", "最高", "最低");
//
//    public StockManager() {
//        stockList = new ArrayList<>();
//        String shanghaiCompositeIndexCode = "sh000001";
//        String SZSEComponentIndexCode = "sz399001";
//        stockList.add(shanghaiCompositeIndexCode);
//        stockList.add(SZSEComponentIndexCode);
//    }

    public StockManager(List<String> stockCodeList) {
//        this();
        stockList.addAll(stockCodeList);
    }

    private void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStockInfoMap() {
        SimpleBrowserMocker<List<StockInfo>> mocker = (SimpleBrowserMocker<List<StockInfo>>) SimpleBrowserMocker.<List<StockInfo>>builder().setProcessor(new StockProcessor()).build();
        StringBuilder stringBuilder = new StringBuilder();
        stockList.forEach((k) -> stringBuilder.append(k).append(","));
        String stockCodeStr = stringBuilder.toString();
        URL url = null;

        try {
            url = new URL("http://hq.sinajs.cn/list=" + stockCodeStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (null == url) {
            System.out.println("url error");
            return;
        }

        StringBuilder titleStringBuilder = new StringBuilder();
        titleStringBuilder.append("| ");
        title.forEach((k) -> titleStringBuilder.append("  ").append(k).append("   | "));
        String titleStr = titleStringBuilder.toString();

        String splitFormatStr = "|%98s|";
        String splitStr = String.format(splitFormatStr, "").replace(" ", "-");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            do {
                List<StockInfo> stockInfos = mocker.get(url);
                long currentTimeMillis = System.currentTimeMillis();
                Date date = new Date(currentTimeMillis);
                Thread.sleep(1000);
                clearConsole();
                System.out.println(splitStr);
                System.out.println(titleStr);
                System.out.println(splitStr);
                if (stockInfos == null) {
                    System.out.println("网络连接异常");
                    continue;
                }
                stockInfos.forEach((v) -> {
                    System.out.println(format(v));
                    System.out.println(splitStr);
                });
                System.out.println(df.format(date));
                Thread.sleep(4000);
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String format(StockInfo stockInfo) {
        String strFormat = "%.2f";
        ArrayList<String> tmpList = new ArrayList<>();
        tmpList.add(stockInfo.getStockCode());
        tmpList.add(stockInfo.getStockName());

        tmpList.add(String.format(strFormat, stockInfo.getCurrentPrice()));
        tmpList.add(String.format(strFormat, stockInfo.getDelta()));
        tmpList.add(String.format(strFormat, stockInfo.getRate()) + "%");
        tmpList.add(String.format(strFormat, stockInfo.getOpeningPrice()));
        tmpList.add(String.format(strFormat, stockInfo.getClosingPrice()));
        tmpList.add(String.format(strFormat, stockInfo.getHighestPrice()));
        tmpList.add(String.format(strFormat, stockInfo.getMinimumPrice()));

        for (int i = 2; i != tmpList.size(); ++i) {
            String tmp = tmpList.get(i);
            if (tmp.length() < 8) {
                String spaceFormat = "%" + (8 - tmp.length()) + "s";
                tmp = String.format(spaceFormat, "") + tmp;
                tmpList.set(i, tmp);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("| ");
        tmpList.forEach((v) -> stringBuilder.append(v).append(" | "));
        return stringBuilder.toString();
    }

}

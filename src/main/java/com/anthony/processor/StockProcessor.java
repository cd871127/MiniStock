package com.anthony.processor;

import com.anthony.StockInfo;
import com.anthony.browsermocker.processor.HttpResponseProcessor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by chend on 2017/6/27.
 */
public class StockProcessor implements HttpResponseProcessor<List<StockInfo>> {
    @Override
    public List<StockInfo> process(CloseableHttpResponse response) {
        return process(response);
    }

    @Override
    public List<StockInfo> process(CloseableHttpResponse response, Map param) {
        if (200 != response.getStatusLine().getStatusCode())
            return null;
        InputStream in = null;
        HttpEntity entity = response.getEntity();
        ArrayList<StockInfo> res = new ArrayList<>();
        try {
            in = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                res.add(parseLine(tmp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    private StockInfo parseLine(String line) {
        final String prefix = "var hq_str_";
        if (!line.contains(prefix))
            return null;
        StockInfo stockInfo = new StockInfo();
        int startIndex = line.indexOf(prefix) + prefix.length();
        String stockCode = line.substring(startIndex, startIndex + 8);
        stockInfo.setStockCode(stockCode);

        String stockData = line.split("\"")[1];

        String[] col = stockData.split(",");

        stockInfo.setStockName(col[0]);
        stockInfo.setOpeningPrice(Double.valueOf(col[1]));
        stockInfo.setClosingPrice(Double.valueOf(col[2]));
        stockInfo.setCurrentPrice(Double.valueOf(col[3]));
        stockInfo.setHighestPrice(Double.valueOf(col[4]));
        stockInfo.setMinimumPrice(Double.valueOf(col[5]));

        stockInfo.setDelta(stockInfo.getCurrentPrice()-stockInfo.getClosingPrice());
        stockInfo.setRate(stockInfo.getDelta()/stockInfo.getClosingPrice()*100);

        return stockInfo;
    }
}

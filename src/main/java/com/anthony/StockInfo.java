package com.anthony;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by chend on 2017/6/27.
 */
public class StockInfo {

    public StockInfo() {
    }

    public StockInfo(String stockCode) {
        this.stockCode = stockCode;
    }
    //    private final static String[] title = {"今开", "昨收", "现价", "最高", "最低", "竞买价", "竞卖价", "成交量", "成交额", "买1", "买1金额", "买2", "买2金额", "买3", "买3金额", "买4", "买4金额", "买5", "买5金额", "卖1", "卖1金额", "卖2", "卖2金额", "卖3", "卖3金额", "卖4", "卖4金额", "卖5", "卖5金额", "日期", "时间"};

    private String stockCode;//股票代码
    private String stockName;//股票名字
    private double openingPrice; //今开
    private double closingPrice; //昨收
    private double currentPrice; //现价
    private double highestPrice; //最高
    private double minimumPrice; //最低
    private BigInteger volume; //成交量
    private BigDecimal turnover; //成交额
    private BigInteger buyAmount1; //买1
    private BigDecimal buyPrice1; //买1金额
    private BigInteger buyAmount2; //买2
    private BigDecimal buyPrice2; //买2金额
    private BigInteger buyAmount3; //买3
    private BigDecimal buyPrice3; // 买3金额
    private BigInteger buyAmount4; //买4
    private BigDecimal buyPrice4;//买4金额
    private BigInteger buyAmount5; //买5
    private BigDecimal buyPrice5; //买5金额
    private BigInteger saleAmount1; //卖1
    private BigDecimal salePrice1; //卖1金额
    private BigInteger saleAmount2; //卖2
    private BigDecimal salePrice2;//卖2金额
    private BigInteger saleAmount3; //卖3
    private BigDecimal salePrice3; //卖3金额
    private BigInteger saleAmount4; //卖4
    private BigDecimal salePrice4;//卖4金额
    private BigInteger saleAmount5; //卖5
    private BigDecimal salePrice5; //卖5金额
    private Date dateTime; //时间

    private double delta;
    private double rate;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigInteger getBuyAmount1() {
        return buyAmount1;
    }

    public void setBuyAmount1(BigInteger buyAmount1) {
        this.buyAmount1 = buyAmount1;
    }

    public BigDecimal getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(BigDecimal buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public BigInteger getBuyAmount2() {
        return buyAmount2;
    }

    public void setBuyAmount2(BigInteger buyAmount2) {
        this.buyAmount2 = buyAmount2;
    }

    public BigDecimal getBuyPrice2() {
        return buyPrice2;
    }

    public void setBuyPrice2(BigDecimal buyPrice2) {
        this.buyPrice2 = buyPrice2;
    }

    public BigInteger getBuyAmount3() {
        return buyAmount3;
    }

    public void setBuyAmount3(BigInteger buyAmount3) {
        this.buyAmount3 = buyAmount3;
    }

    public BigDecimal getBuyPrice3() {
        return buyPrice3;
    }

    public void setBuyPrice3(BigDecimal buyPrice3) {
        this.buyPrice3 = buyPrice3;
    }

    public BigInteger getBuyAmount4() {
        return buyAmount4;
    }

    public void setBuyAmount4(BigInteger buyAmount4) {
        this.buyAmount4 = buyAmount4;
    }

    public BigDecimal getBuyPrice4() {
        return buyPrice4;
    }

    public void setBuyPrice4(BigDecimal buyPrice4) {
        this.buyPrice4 = buyPrice4;
    }

    public BigInteger getBuyAmount5() {
        return buyAmount5;
    }

    public void setBuyAmount5(BigInteger buyAmount5) {
        this.buyAmount5 = buyAmount5;
    }

    public BigDecimal getBuyPrice5() {
        return buyPrice5;
    }

    public void setBuyPrice5(BigDecimal buyPrice5) {
        this.buyPrice5 = buyPrice5;
    }

    public BigInteger getSaleAmount1() {
        return saleAmount1;
    }

    public void setSaleAmount1(BigInteger saleAmount1) {
        this.saleAmount1 = saleAmount1;
    }

    public BigDecimal getSalePrice1() {
        return salePrice1;
    }

    public void setSalePrice1(BigDecimal salePrice1) {
        this.salePrice1 = salePrice1;
    }

    public BigInteger getSaleAmount2() {
        return saleAmount2;
    }

    public void setSaleAmount2(BigInteger saleAmount2) {
        this.saleAmount2 = saleAmount2;
    }

    public BigDecimal getSalePrice2() {
        return salePrice2;
    }

    public void setSalePrice2(BigDecimal salePrice2) {
        this.salePrice2 = salePrice2;
    }

    public BigInteger getSaleAmount3() {
        return saleAmount3;
    }

    public void setSaleAmount3(BigInteger saleAmount3) {
        this.saleAmount3 = saleAmount3;
    }

    public BigDecimal getSalePrice3() {
        return salePrice3;
    }

    public void setSalePrice3(BigDecimal salePrice3) {
        this.salePrice3 = salePrice3;
    }

    public BigInteger getSaleAmount4() {
        return saleAmount4;
    }

    public void setSaleAmount4(BigInteger saleAmount4) {
        this.saleAmount4 = saleAmount4;
    }

    public BigDecimal getSalePrice4() {
        return salePrice4;
    }

    public void setSalePrice4(BigDecimal salePrice4) {
        this.salePrice4 = salePrice4;
    }

    public BigInteger getSaleAmount5() {
        return saleAmount5;
    }

    public void setSaleAmount5(BigInteger saleAmount5) {
        this.saleAmount5 = saleAmount5;
    }

    public BigDecimal getSalePrice5() {
        return salePrice5;
    }

    public void setSalePrice5(BigDecimal salePrice5) {
        this.salePrice5 = salePrice5;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

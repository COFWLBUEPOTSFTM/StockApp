package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockImpl implements Stock {
  private final String url;
  private final String company;
  private final String ticker;
  private double currentPrice;

  private double numOfStocks = 0;
  private double amountInvested = 0;

  public StockImpl(String url) throws IOException {
    this.url = url;
    Document doc = Jsoup.connect(url).get();

    this.company = doc.select("meta[name=name]").attr("content");
    this.ticker = doc.select("meta[name=tickerSymbol]").attr("content");
    this.currentPrice = Double.parseDouble(doc.select("meta[name=price]").attr("content").substring(1));
  }

  @Override
  public String getURL() {
    return url;
  }

  @Override
  public String getCompany() {
    return company;
  }

  @Override
  public String getTickerSymbol() {
    return ticker;
  }

  @Override
  public double getCurrentPrice() {
    return currentPrice;
  }

  @Override
  public void printData(){
    System.out.print("\n");
    System.out.println("Website: \t\t" + getURL());
    System.out.println("Company: \t\t" + getCompany());
    System.out.println("Ticker: \t\t" + getTickerSymbol());
    System.out.println("Price:   \t\t" + getCurrentPrice());
  }

  @Override
  public void update() throws IOException {
    Document doc = Jsoup.connect(url).get();

    this.currentPrice = Double.parseDouble(doc.select("meta[name=price]").attr("content").substring(1));
  }

  @Override
  public double getNumberOfStocks() {
    return numOfStocks;
  }

  @Override
  public double getAmountInvested() {
    return amountInvested;
  }

  @Override
  public double getCurrentInvested() {
    return numOfStocks * getCurrentPrice();
  }

  @Override
  public void buyStock(double numStocks) {
    if (numStocks < 0){
      throw new IllegalArgumentException("Can't buy negative stocks");
    }
    this.numOfStocks +=numStocks;
    this.amountInvested += numStocks * getCurrentPrice();
  }

  @Override
  public double sellStock(double numStocks) {
    if (numStocks < 0){
      throw new IllegalArgumentException("Can't sell negative stocks");
    }
    if (numStocks > getNumberOfStocks()){
      numStocks = getNumberOfStocks();
    }
    this.numOfStocks -= numStocks;
    double profit = numStocks*getCurrentPrice();
    this.amountInvested -= profit;
    return profit;
  }
}

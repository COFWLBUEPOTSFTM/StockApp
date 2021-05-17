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

  public static StockImpl AAPL, GME, MSFT;
  public static List<StockImpl> stockList= new ArrayList<>();

  public static void createAll(){
    try {
      AAPL = new StockImpl("https://www.marketwatch.com/investing/stock/aapl");
      GME = new StockImpl("https://www.marketwatch.com/investing/stock/GME");
      MSFT = new StockImpl("https://www.marketwatch.com/investing/stock/msft");
      stockList.add(AAPL);  stockList.add(GME);   stockList.add(MSFT);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private StockImpl(String url) throws IOException {
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

  public static void updateAll() throws IOException {
    for (StockImpl s : stockList){
      s.update();
    }
  }

  public static void printAllData() {
    for (StockImpl s : stockList){
      s.printData();
    }
  }

}

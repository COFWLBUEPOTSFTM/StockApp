package model;

import model.Stock;
import model.StockImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfStocks {
  private static List<Stock> stockList;
  public static Stock AAPL, GME, MSFT;

  public static List<Stock> create() throws IOException {
    if (stockList == null){
      createList();
    }
    return stockList;
  }


  public static void updateAll() throws IOException {
    for (Stock s : stockList){
      s.update();
    }
  }

  public static void printAllData() {
    for (Stock s : stockList){
      s.printData();
    }
  }

  private static void createList() throws IOException {
    stockList = new ArrayList<>();

    AAPL = new StockImpl("https://www.marketwatch.com/investing/stock/aapl");
    GME = new StockImpl("https://www.marketwatch.com/investing/stock/GME");
    MSFT = new StockImpl("https://www.marketwatch.com/investing/stock/msft");

    stockList.add(AAPL);
    stockList.add(GME);
    stockList.add(MSFT);
  }

}

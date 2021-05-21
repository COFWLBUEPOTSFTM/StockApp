package controller;

import model.ModelObserver;
import model.Stock;

import java.util.List;

public interface Controller{
  int getStockCount();
  int getStockIndex();

  void setStockIndex(int i);
  void buyStock(Stock s, double d);
  void ownedCheck(boolean b);
  void sellStock(Stock s, double d);

  double getProfit();
  boolean isDisplayingOwned();

  List<Stock> displayedStocks();
}

package model;

import java.util.List;

public interface Model {
  int getStockCount();
  int getStockIndex();

  void setStockIndex(int i);
  void buyStock(Stock s, double d);
  void ownedCheck(boolean b);
  void sellStock(Stock s, double d);

  double getProfit();
  boolean isDisplayingOwned();

  void addObserver(ModelObserver modelObserver);
  void removeObserver(ModelObserver modelObserver);

  List<Stock> displayedStocks();
}

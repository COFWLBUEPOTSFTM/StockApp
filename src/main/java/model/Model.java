package model;

public interface Model {
  int getStockCount();
  int getStockIndex();

  void setStockIndex();
  void buyStock(Stock s);


  void addObserver(ModelObserver modelObserver);
  void removeObserver(ModelObserver modelObserver);
}

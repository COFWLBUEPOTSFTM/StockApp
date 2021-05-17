package model;

public interface Position {
  //interface for implementing how much we have of each stock

  Stock getStock();
  double getNumberOfStocks();
  double getAmountInvested();
  double getCurrentInvested();

}

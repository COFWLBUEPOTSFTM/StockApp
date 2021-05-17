package model;

import java.io.IOException;

public interface Stock {
  //Interface for implementing stocks with

  String getURL();
  String getCompany();
  String getTickerSymbol();

  double getCurrentPrice();

  void printData();
  void update() throws IOException;

  double getNumberOfStocks();
  double getAmountInvested();
  double getCurrentInvested();

  void buyStock(double numStocks);
  double sellStock(double numStocks);
}

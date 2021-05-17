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
}

package controller;

import model.Model;
import model.Stock;

import java.util.List;

public class ControllerImpl implements Controller{
  private Model model;

  public ControllerImpl (Model model) {
    this.model = model;
  }

  @Override
  public int getStockCount() {
    return model.getStockCount();
  }

  @Override
  public int getStockIndex() {
    return model.getStockIndex();
  }

  @Override
  public void setStockIndex(int i) {
    model.setStockIndex(i);
  }

  @Override
  public void buyStock(Stock s, double d) {
    model.buyStock(s, d);
  }

  @Override
  public void ownedCheck(boolean b) {
    model.ownedCheck(b);
  }

  @Override
  public void sellStock(Stock s, double d) {
    model.sellStock(s, d);
  }

  @Override
  public double getProfit() {
    return model.getProfit();
  }

  @Override
  public boolean isDisplayingOwned() {
    return model.isDisplayingOwned();
  }

  @Override
  public List<Stock> displayedStocks() {
    return model.displayedStocks();
  }
}

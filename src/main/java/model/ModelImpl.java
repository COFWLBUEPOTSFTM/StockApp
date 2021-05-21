package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelImpl implements Model{
  List<ModelObserver> modelObservers;
  double profit = 0;
  List<Stock> stockList;
  int currentDisplayed = 0;
  boolean displayOnlyBought = false;

  public ModelImpl(List<Stock> stockList){
    this.stockList = stockList;
    modelObservers = new ArrayList<>();
  }

  @Override
  public int getStockCount() {
    return stockList.size();
  }

  @Override
  public int getStockIndex() {
    return currentDisplayed;
  }

  @Override
  public void setStockIndex(int i) {
    if ( i > getStockCount() || i < 0){
      throw new IllegalArgumentException();
    }
    currentDisplayed = i;
    notifyObservers();
  }

  @Override
  public void buyStock(Stock s, double d) {
    if (!stockList.contains(s)){
      throw new IllegalArgumentException("Stock doesn't exist in List");
    }

    s.buyStock(d);
    notifyObservers();
  }

  @Override
  public void ownedCheck(boolean b) {
    displayOnlyBought = b;
  }


  @Override
  public void sellStock(Stock s, double d) {
    if (!stockList.contains(s)){
      throw new IllegalArgumentException("Stock doesn't exist in List");
    }

    profit += s.sellStock(d);
    notifyObservers();
  }

  @Override
  public double getProfit() {
    return profit;
  }

  @Override
  public boolean isDisplayingOwned() {
    return displayOnlyBought;
  }


  @Override
  public void addObserver(ModelObserver modelObserver) {
    modelObservers.add(modelObserver);
  }

  @Override
  public void removeObserver(ModelObserver modelObserver) {
    modelObservers.remove(modelObserver);
  }

  @Override
  public List<Stock> displayedStocks() {
    List<Stock> stockCopy = new ArrayList<>();
    Collections.copy(stockCopy, stockList);
    if (displayOnlyBought){
      stockCopy.removeIf(s -> s.getNumberOfStocks() == 0);
    }
    return stockCopy;
  }

  private void notifyObservers(){
    for (ModelObserver m : modelObservers){
      m.update(this);
    }
  }
}

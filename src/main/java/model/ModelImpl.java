package model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model{
  List<ModelObserver> modelObservers = new ArrayList<>();

  @Override
  public int getStockCount() {
    return 0;
  }

  @Override
  public int getStockIndex() {
    return 0;
  }

  @Override
  public void setStockIndex() {

  }

  @Override
  public void buyStock(Stock s) {

  }

  @Override
  public void addObserver(ModelObserver modelObserver) {
    modelObservers.add(modelObserver);
  }

  @Override
  public void removeObserver(ModelObserver modelObserver) {

  }

  private void notifyObservers(){
    for (ModelObserver m : modelObservers){
      m.update(this);
    }
  }
}

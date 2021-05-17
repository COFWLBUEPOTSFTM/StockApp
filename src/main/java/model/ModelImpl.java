package model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model{
  List<ModelObserver> modelObservers = new ArrayList<>();

  @Override
  public void addObserver(ModelObserver modelObserver) {
    modelObservers.add(modelObserver);
  }
}

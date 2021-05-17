package controller;

import model.Model;

public class ControllerImpl implements Controller{
  private Model model;

  public ControllerImpl (Model model) {
    this.model = model;
  }
}

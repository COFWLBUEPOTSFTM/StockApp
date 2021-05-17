package model;

public class PositionImpl implements Position {

  Stock s;
  double numberOfStocks;
  double amountInvested;

  //public void

  private PositionImpl(Stock s, double stockNum){
    this.s = s;
    this.amountInvested = s.getCurrentPrice()*stockNum;
    numberOfStocks = stockNum;
  }

  @Override
  public Stock getStock() {
    return this.s;
  }

  @Override
  public double getNumberOfStocks() {
    return this.numberOfStocks;
  }

  @Override
  public double getAmountInvested() {
    return this.amountInvested;
  }

  @Override
  public double getCurrentInvested(){
    return this.numberOfStocks * this.s.getCurrentPrice();
  }

}

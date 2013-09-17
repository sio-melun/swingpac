package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class MonBidule extends Bidule {

  public MonBidule(String name) {
    super(name);
    setBackground(Color.GRAY);
  }

  public MonBidule() {
    this("MonBidule");
    
  }

  
  @Override
  public void doMove() {
    super.doMove();
    List<Bidule> proches = this.getBidulesProches(10);
    if (proches.size()>0)
      if (proches.get(0).getDELAY() < this.getDELAY()) { /*...*/ }
  }

  @Override
  protected void doAfterImpactByOther() {
    super.doAfterImpactByOther();
    if (isGoDown())
      goOnRight();

  }

  
  
}

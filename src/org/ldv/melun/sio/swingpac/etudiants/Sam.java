package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;

import org.ldv.melun.sio.swingpac.Bidule;

public class Sam extends Bidule {

 
  public Sam() {
    super("Sam");
   
    setBackground(Color.lightGray);   
  }

  @Override
  public void doMove() { 
    super.doMove();   
  }

  @Override
  protected void doAfterImpactByOther() {
        super.doAfterImpactByOther();
        getBidulesProches(0);
       
        if (isGoDown())
          goOnTop();
        else if (isGoRight())
            goOnLeft();
        else if (isGoLeft())
            goOnRight();
        else
            goOnDown();

      }

 
}

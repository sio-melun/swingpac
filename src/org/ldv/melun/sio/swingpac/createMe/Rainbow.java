package org.ldv.melun.sio.swingpac.createMe;

import java.awt.Color;

import org.ldv.melun.sio.swingpac.Bidule;

public class Rainbow  extends Bidule {

	  public Rainbow(String name) {
	    super(name);
	  }

	  public Rainbow() {
	    super("Rainbow Dash");
	    setBackground(Color.CYAN);
	  }
	  

	  
	  @Override
	  public void doMove() {
	    super.doMove();
	  }

	  @Override
	  protected void doAfterImpactByOther() {
	    super.doAfterImpactByOther();
	    if (isGoDown())
	      goOnTop();

	  }

	  
	  
	}


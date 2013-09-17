package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class ZedSuissia extends Bidule {
  
  public ZedSuissia() {
    super("ZedSuissia");
    setBackground(Color.BLACK);
        
  }

  @Override
  public void doMove() {  
	  List<Bidule> bidulesProches = this.getBidulesProches(10);
	  
	    
	    if(bidulesProches.size()==0){
	    	super.doMove();
	    }
	    else{
	    //1
	    if (bidulesProches.get(0).getDELAY() > this.getDELAY() ){
	    	if (bidulesProches.get(0).getWidth() >= this.getWidth() ) {
	    		if ( bidulesProches.get(0).isGoUp() && this.isGoUp()) {
	    			goOnDown();
	    		}
	    		else if ( bidulesProches.get(0).isGoDown() && this.isGoDown()) {
	    			goOnTop();
	    		}
	    	}
	    	if (bidulesProches.get(0).getWidth() < this.getWidth() ) {
	    		if ( bidulesProches.get(0).isGoUp() && this.isGoDown()) {
	    			goOnTop();
	    		}
	    		else if ( bidulesProches.get(0).isGoDown() && this.isGoUp()) {
	    			goOnDown();
	    		}
	    	}
	    }
	    //2
	    else if (bidulesProches.get(0).getDELAY() < this.getDELAY() ){
	    	if (bidulesProches.get(0).getWidth() >= this.getWidth() ) {
	    		if ( bidulesProches.get(0).isGoUp() && this.isGoUp()) {
	    			goOnDown();
	    		}
	    		else if ( bidulesProches.get(0).isGoDown() && this.isGoDown()) {
	    			goOnTop();
	    		}
	    	}
	    	if (bidulesProches.get(0).getWidth() < this.getWidth() ) {
	    		if ( bidulesProches.get(0).isGoUp() && this.isGoUp()) {
	    			goOnDown();
	    		}
	    		else if ( bidulesProches.get(0).isGoDown() && this.isGoDown()) {
	    			goOnTop();
	    		}
	    	}
	    }
	    
	    //3
	    else {
	    	super.doMove();
	    }
	  }
  }

  @Override
  protected void doAfterImpactByOther() {
	List<Bidule> bidules = this.getBidulesProches(50);
	if(bidules.size()==0){
    super.doAfterImpactByOther();
	}
	else {
		if (bidules.get(0).getWidth() > this.getWidth()){
			if (isGoUp() && isGoLeft());
			goOnDown();
			if (isGoUp() && isGoRight()){
				goOnDown();
			}
			if (isGoDown() && isGoLeft()){
				goOnTop();
			}
			if (isGoDown() && isGoRight()){
				goOnTop();
			}
		}
		else if (bidules.get(0).getWidth() < this.getWidth()){
			if (bidules.get(0).isGoUp() && bidules.get(0).isGoLeft()){
				goOnTop();
				goOnLeft();
			}
				
			if (bidules.get(0).isGoUp() && bidules.get(0).isGoRight()){
				goOnTop();
				goOnRight();
			}
			if (bidules.get(0).isGoDown() && bidules.get(0).isGoLeft()){
				goOnDown();
				goOnLeft();
			}
			if (bidules.get(0).isGoDown() && bidules.get(0).isGoRight()){
				goOnDown();
				goOnRight();
			}

		}
	}
  }

  
}

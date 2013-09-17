package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;


import java.awt.Component;
import java.util.List;



import org.ldv.melun.sio.swingpac.Bidule;

public class Thana extends Bidule {

  
  public Thana() {
    super("Thana");
    setBackground(Color.ORANGE);    
  }

  @Override
  public void doMove() {  
    super.doMove();
    /*
    List <Bidule> proches =  this.getBidulesProches(10);
    	for (int i = 0; i<=9 ; i++){ 
          if ( proches.get(i).getDELAY()> 5){
        	  proches.get(i).goOnDown();
        	  this.doMove();
          }
    	}*/
    
    	
    		
    }
  	  
//	  
//    public void tuEstouchePar(Bidule biduleQuiATouche) {
//    	 this.doMove();
//    	
//    	 
//    }
//	
  
  
  
  @Override
  protected void doAfterImpactByOther() {
    super.doAfterImpactByOther();
    

    
  }
  
 
  
}

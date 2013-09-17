package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;


	public class Nbr extends Bidule {
		 
		  
		  public Nbr() {
		    super("Nbr");
		    setBackground(Color.yellow);    
		      
		  }

		  @Override
		  public void doMove() {  
		    
			  
			  
			super.doMove();   
		   
		      
		    
		    
		    List<Bidule> bidules1 =this.getBidulesProches(5);
		     
		    for (Bidule bidule : bidules1){
		    	   if (bidule.isGoUp()==true)   { this.goOnDown();}
		         else if (bidule.isGoDown()==true) { this.goOnTop();}
		    	 else if (bidule.isGoLeft()==true) { this.goOnRight();}
		    	 else if (bidule.isGoRight()==true){ this.goOnLeft();}
		    	 
		    }
		    
		    /**  for (Bidule bidule : bidules1){
		    	* int x= bidule.getIncX()-this.getIncX();
		    	* int y= bidule.getIncY()-this.getIncY();
		    	*  System.out.println(y);
		    	* if ( x == -2 || y == 2 )		    	
		    	*	{goOnRight();}
		    	* else if ( x == 2 || y == -2 ) {	goOnLeft();  }
		    	 
		    	* else
		          
		    */
		    
		    
		     
		          
		 

		  }

		 

		@Override
		  protected void doAfterImpactByOther() {
		    super.doAfterImpactByOther();
		  }

		  
		}
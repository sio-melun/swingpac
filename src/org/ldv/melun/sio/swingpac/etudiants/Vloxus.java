package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import org.ldv.melun.sio.swingpac.Bidule;



public class Vloxus extends Bidule {

public Vloxus(String name, Image image) {
		super(name);
		this.image = image;
	}

private Image image;

  	public Vloxus(String name)  {
  		super(name);
  		image = null;
  	}


	public Vloxus() {
    super("Vloxus");
    setBackground(Color.BLACK);
    
  
  }

  @Override
  public void doMove() {
	    super.doMove();
	    
	  }

  /** public void tuEstouchePar(Bidule biduleImpacteur) {
	  
	  if (getWidth() <= 10) {
		  
		  
	  
	  						}
	  } */
 
 public void paintCompenent(Graphics g) {
	 
	 super.paintComponents(g);
	 
	if (image==null) {
		 image = getToolkit().getImage("images/logo.jpg");
	g.drawImage((Image) image, 0, 0, getWidth(), getHeight(), this); 	 
	 }
	 
 							
 }
 

}
	  




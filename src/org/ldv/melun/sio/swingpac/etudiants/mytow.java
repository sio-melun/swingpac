package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class mytow extends Bidule {
	private int nb = 0;
	private int tot = 0;
	private int aleax;
	private int aleay;
	private int x;
	private int y;
	private Image image = null;
	
	public mytow() {
    super("Tommy");
    //setBackground(Color.DARK_GRAY);
    setOpaque(false);
  }

  @Override
  public void doMove() {  
    super.doMove();
    nb++;
    List<Bidule> proches = getBidulesProches(30);
    if(nb > 200){
	    for(int i =0; i< proches.size();i++){
	    	if(proches.get(i).isGoDown()){
	    		if(proches.get(i).isGoLeft()){
	        		this.setIncX(1);
	        		this.setIncY(-1);
	        		
	        	}else if(proches.get(i).isGoRight()){
	        		this.setIncX(-1);
	        		this.setIncY(-1);
	        	}
	    	}else if(proches.get(i).isGoUp()){
	    		if(proches.get(i).isGoLeft()){
	    			this.setIncX(1);
	        		this.setIncY(1);
	        		
	        	}else if(proches.get(i).isGoRight()){
	        		this.setIncX(-1);
	        		this.setIncY(1);
	        	}
	    	}
	    }
    	
    }
    /*nb++;
    tot = nb;
    aleax = (int) Math.random();
	aleay = (int) Math.random();
	
	x = aleax;
	y = aleax;
	setIncX(aleax);
	setIncY(aleay);
    if(nb > 100){
    	x++;
    	y++;
    	setIncX(x);
    	setIncY(y);
    	System.out.println("nb "+nb+" |aleax "+aleax+" |aleay "+aleay+" |");
    	nb = 0;
    }*/
   
  }

  @Override
  protected void doAfterImpactByOther() {
    super.doAfterImpactByOther();
   // this.setBackground(Color.GRAY);
    
  }

  public void paintComponent(Graphics g) {
	    image = getToolkit().getImage("images/ninja50.jpg");
		if(image != null) // Si l'image existe, ...
		g.drawImage(image, this.getIncX(),this.getIncY(), getWidth(),getHeight(), this); // ... on la dessine
 }
}




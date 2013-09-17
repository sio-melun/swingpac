package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;

import org.ldv.melun.sio.swingpac.Bidule;

public class Fred extends Bidule {

	private Image image;
	private int nbDeplacements;
	

	public Fred() {
		super("Fred");
		image = getToolkit().getImage("images/image.png");
		setBackground(Color.WHITE);
		nbDeplacements = 0;
	}

	@Override
	public void doMove() {
		nbDeplacements++;
		super.doMove();
		 if (isGoDown() && nbDeplacements % 100 == 0) 
		      if (isGoLeft())
		        goOnRight();
		      else
		        goOnLeft();
		 if ( isGoUp() && nbDeplacements % 100 == 0){
			 if (isGoLeft())
			        goOnRight();
			      else
			        goOnLeft();
		 }
			 
	
		
		List<Bidule> proches = this.getBidulesProches(1);
		if (proches.size() > 1) {
			if (proches.get(1).getDELAY() < this.getDELAY()) {
				if (isGoDown() )
					goOnLeft();
				else if (isGoUp())
					goOnDown();
				else if (isGoRight())
					goOnTop();
				else if (isGoLeft())
					goOnDown();
			}
		}
	}

	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
		if (isGoDown() )
			goOnLeft();
		else if (isGoUp())
			goOnDown();
		else if (isGoRight())
			goOnTop();
		else if (isGoLeft())
			goOnDown();
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

}

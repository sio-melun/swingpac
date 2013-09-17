package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class LISIK extends Bidule {

	private int nbDeplacements;

	public LISIK() {
		super("LISIK");

		nbDeplacements = 0;
	}

	public void paintComponent(Graphics g) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		if (isGoDown() && isGoRight()) {
			Image icone = kit.getImage("assets/Lisik/LisikBasDroit.png");
			g.drawImage(icone, 0, 0, getHeight(), getWidth(), null);
		} else if (isGoDown() && isGoLeft()) {
			Image icone = kit.getImage("assets/Lisik/LisikBasGauche.png");
			g.drawImage(icone, 0, 0, getHeight(), getWidth(), null);
		} else if (isGoUp() && isGoRight()) {
			Image icone = kit.getImage("assets/Lisik/LisikHautDroit.png");
			g.drawImage(icone, 0, 0, getHeight(), getWidth(), null);
		} else if (isGoUp() && isGoLeft()) {
			Image icone = kit.getImage("assets/Lisik/LisikHautGauche.png");
			g.drawImage(icone, 0, 0, getHeight(), getWidth(), null);
		}
	}

	@Override
	public void doMove() {
		nbDeplacements++;
		super.doMove();

		List<Bidule> proches = this.getBidulesProches(50);

		if (proches.size() > 0) {
			if (proches.get(0).getWidth() < this.getWidth()) {
				if (proches.get(0).isGoDown()  && this.isGoDown()) {
					goOnLeft();
				}
				if ( proches.get(0).isGoRight()  && this.isGoRight()) {
					goOnDown();
				}
				if (proches.get(0).isGoUp()  && this.isGoUp()) {
					goOnDown();
				}
				if (proches.get(0).isGoLeft() && this.isGoLeft()) {
					goOnDown();
				}
			

			}
			if (proches.get(0).getWidth() < this.getWidth()) {
				if(proches.get(0).isGoLeft() && this.isGoRight()){
					goOnTop();}
				if(proches.get(0).isGoRight() && this.isGoLeft()){
					goOnDown();}
				if(proches.get(0).isGoDown() && this.isGoUp()){
					goOnLeft();}
				if(proches.get(0).isGoUp() && this.isGoDown()){
					goOnRight();}
				}
			if (proches.get(0).getWidth() < this.getWidth()) {
				if (proches.get(0).isGoDown() && proches.get(0).isGoLeft()  && this.isGoDown() && this.isGoLeft()) {
					goOnTop();
				}
				if (proches.get(0).isGoDown() && proches.get(0).isGoRight()  && this.isGoDown() && this.isGoRight()) {
					goOnLeft();
				}
				if (proches.get(0).isGoUp() && proches.get(0).isGoRight() && this.isGoUp() && this.isGoRight()) {
					goOnDown();
				}
				if (proches.get(0).isGoUp() && proches.get(0).isGoLeft() && this.isGoUp() && this.isGoLeft()) {
					goOnRight();
				}
			

			}
			if (proches.get(0).getWidth() < this.getWidth()) {
				if (proches.get(0).isGoDown() && proches.get(0).isGoLeft()  && this.isGoDown() && this.isGoLeft()) {
					goOnTop();}
				if (proches.get(0).isGoDown() && proches.get(0).isGoRight()  && this.isGoDown() && this.isGoRight()){
					goOnTop();}
				if (proches.get(0).isGoUp() && proches.get(0).isGoLeft()  && this.isGoUp() && this.isGoRight()){
					goOnDown();}
				if (proches.get(0).isGoUp() && proches.get(0).isGoRight()  && this.isGoUp() && this.isGoLeft()){
					goOnDown();}
				}
			}
			
		
		
		else 
			super.doMove();
	}

}

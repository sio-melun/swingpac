package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.ldv.melun.sio.swingpac.Bidule;

public class Darius extends Bidule {
	
	private int nbDeplacements;

	private int nbDeplace;

	public Darius() {
		super("Darius");

	}
	/*
	public void paintComponent(Graphics g){
	    try {
	      Image img = ImageIO.read(new File("images/darius.png"));
	      g.drawImage(img, 0, 0, this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }               
	  }               
	*/

	@Override
	public void doMove() {  
		nbDeplacements++;
		nbDeplace++;
		super.doMove();
		// tous les 200 deplacements
		if (nbDeplacements % 200 == 0) {
			if (isGoLeft()) {
				goOnRight();
				nbDeplacements =0; }
			else if (isGoRight()) {
				goOnLeft();
				nbDeplacements = 0; }
			else if (isGoDown()) {
				goOnTop();
				nbDeplacements = 0; }
			else if (isGoUp()) {
				goOnDown();
				nbDeplacements = 0; } 
		}

		if (nbDeplace % 400 == 0) {
			this.setBounds(getX(), getY(), getWidth() + 3, getHeight() + 3);
			nbDeplace=0; }
	}
	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
	}


}

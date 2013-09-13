package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Rectangle;

import org.ldv.melun.sio.swingpac.Bidule;

public class Rainbow  extends Bidule {

	  public Rainbow(String name) {
	    super(name);
	  }

	  public Rainbow() {
	    super("Rainbow Dash");
	    setBackground(Color.CYAN);
	    this.setIncX(-1);
	    this.setIncY(-1);
	  }
	  
	  @Override
		public void doMove() {
			// obtenir les coordonnées de la scene
			Rectangle rect = getParent().getBounds();

			// changement de direction si une frontière est atteinte
			if (getX() + getWidth() + getIncX() > rect.width)
				goOnTop();
			if (getX() + getIncX() < 0)
				goOnDown();
			if (getY() + getHeight() + getIncY() > rect.height)
				goOnRight();
			if (getY() + getIncY() < 0)
				goOnLeft();
		}
	  
	  /**
		 * oriente le déplacement vers le bas
		 */
		public void goOnDown() {
			if (getIncY() < 0)
				setIncY(getIncY() * -1);
		}

		/**
		 * oriente le déplacement vers le haut
		 */
		public void goOnTop() {
			if (getIncY() > 0)
				setIncY(getIncY() * -1);
		}

		/**
		 * oriente le déplacement vers la droite
		 */
		public void goOnRight() {
			if (getIncX() < 0)
				setIncX(getIncX() * -1);
		}

		/**
		 * oriente le déplacement vers la gauche
		 */
		public void goOnLeft() {
			if (getIncX() > 0)
				setIncX(getIncX() * -1);
		}
		
		protected void doAfterImpactByOther() {
			
			
		}
	  
	}


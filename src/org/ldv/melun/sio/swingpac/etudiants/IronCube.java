package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class IronCube extends Bidule {

	public IronCube() {
		super("IronCube");
		setBackground(Color.RED);
	}

	@Override
	public void doMove() {
		List<Bidule> bidulesproches = this.getBidulesProches(20);

		if (bidulesproches.size() != 0) { // Vérifie si la liste est vise ou non, si elle contient un bidule, elle est exécutée
			if (bidulesproches.get(0).isGoDown() && this.isGoDown()) { // si les bidules vont dans le même sens
				if ((bidulesproches.get(0).getY() < this.getY()) && (bidulesproches.get(0).getDELAY() > this.getDELAY())
						&& (bidulesproches.get(0).getWidth() < this.getWidth())) {
					this.setIncY(bidulesproches.get(0).getIncY());
					this.setIncX(bidulesproches.get(0).getIncX());
				} else if (((bidulesproches.get(0).getY() > this.getY()) || bidulesproches
						.get(0).getWidth() > this.getWidth())
						&& bidulesproches.get(0).isGoLeft()) {
					this.goOnRight();
				} else {
					this.goOnLeft();
				}
			}
			if (bidulesproches.get(0).isGoUp() && this.isGoUp()) {
				if ((bidulesproches.get(0).getY() > this.getY()) && (bidulesproches.get(0).getDELAY() > this.getDELAY())
						&& (bidulesproches.get(0).getWidth() < this.getWidth())) {
					this.setIncY(bidulesproches.get(0).getIncY());
					this.setIncX(bidulesproches.get(0).getIncX());
				} else if (((bidulesproches.get(0).getY() < this.getY()) || bidulesproches
						.get(0).getWidth() > this.getWidth())
						&& bidulesproches.get(0).isGoLeft()) {
					this.goOnRight();
				} else {
					this.goOnLeft();
				}
			}
			if (bidulesproches.get(0).isGoRight() && this.isGoRight()) {
				if ((bidulesproches.get(0).getX() > this.getX()) && (bidulesproches.get(0).getDELAY() > this.getDELAY())
						&& (bidulesproches.get(0).getWidth() < this.getWidth())) {
					this.setIncY(bidulesproches.get(0).getIncY());
					this.setIncX(bidulesproches.get(0).getIncX());
				} else if (((bidulesproches.get(0).getX() < this.getX()) || bidulesproches
						.get(0).getWidth() > this.getWidth())
						&& bidulesproches.get(0).isGoUp()) {
					this.goOnDown();
				} else {
					this.goOnTop();
				}
			}
			if (bidulesproches.get(0).isGoLeft() && this.isGoLeft()) {
				if ((bidulesproches.get(0).getX() < this.getX()) && (bidulesproches.get(0).getDELAY() > this.getDELAY())
						&& (bidulesproches.get(0).getWidth() < this.getWidth())) {
					this.setIncY(bidulesproches.get(0).getIncY());
					this.setIncX(bidulesproches.get(0).getIncX());
				} else if (((bidulesproches.get(0).getX() > this.getX()) || bidulesproches
						.get(0).getWidth() > this.getWidth())
						&& bidulesproches.get(0).isGoUp()) {
					this.goOnDown();
				} else {
					this.goOnTop();
				}
			}
		} else
			super.doMove();
	}

	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
	}

}

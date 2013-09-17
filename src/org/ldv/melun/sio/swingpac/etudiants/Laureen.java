package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class Laureen extends Bidule {

	private int incY, incX;

	private int nbImpact;

	private Image image = null;

	public Laureen(String name) {
		super(name);
	}

	public Laureen() {
		this("Laureen");
		// setBackground(Color.cyan);

	}

	public void doMove() {

		List<Bidule> proches = this.getBidulesProches(10);
		if (proches.size() > 0) {
			if (proches.get(0).getDELAY() < this.getDELAY()) {
				if (proches.get(0).isGoLeft()) {
					setIncX(1);
					setIncY(0);
				} else if (proches.get(0).isGoRight()) {
					setIncX(1);
					setIncY(-1);
				} else if (proches.get(0).isGoUp()) {
					setIncX(1);
					setIncY(1);
				} else {
					setIncX(-1);
					setIncY(0);
				}
			}
		}
		super.doMove();
	}

	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
		if (isGoLeft()) {
			goOnRight();
		} else {
			goOnLeft();
		}
		if (isGoUp()) {
			goOnDown();
		} else {
			goOnTop();
		}
	}

	public void paintComponent(Graphics g) {
		if (isGoUp()) {
			if (isGoRight()) {
				image = getToolkit().getImage("images/smiley.png");
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			} else if (isGoLeft()) {
				image = getToolkit().getImage("images/smiley2.png");
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		} else if (isGoDown()) {
			if (isGoRight()) {
				image = getToolkit().getImage("images/smiley3.png");
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			} else if (isGoLeft()) {
				image = getToolkit().getImage("images/smiley4.png");
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		}

	}

}

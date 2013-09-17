package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class Kevin extends Bidule {

	private Image image;

	public Kevin(String name) {
		super(name);
		image = null;
		// mettre transparence images
		setOpaque(false);
	}

	public Kevin() {
		super("Kevin");
		this.setBackground(Color.WHITE);
	}

	@Override
	public void doMove() {
		super.doMove();
		List<Bidule> proches = this.getBidulesProches(50);
		if (proches.size() > 40) {
			if (proches.get(0).getDELAY() < this.getDELAY()) { 
				goOnTop();
			
			}

		}
	}
// action apres impact
	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
		if (isGoDown())
			goOnTop();

	}
// Mettre une image
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image == null)
			image = getToolkit().getImage("images/541px-Pacman.svg.png");
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

}

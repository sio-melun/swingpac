package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class Baptista extends Bidule {

	public Baptista() {
		super("Baptista");
		setBackground(Color.CYAN);
	}

	@Override
	public void doMove() {
		super.doMove();
		List<Bidule> proches = this.getBidulesProches(50);
		if (proches.isEmpty() == false) {
			for (Bidule proche : proches) {
				if ((proche.getDELAY() > this.getDELAY())
						&& (proche.getHeight() < this.getHeight())) {
					// si mon bidule est plus rapide que le bidule proche
					// et qu'il est plus gros
					poursuit(proche);
					return;
				} else if ((proche.getDELAY() > this.getDELAY())
						&& (proche.getHeight() > this.getHeight())) {
					// si mon bidule est plus rapide que le bidule proche
					// et qu'il est moins gros
					seDesaxeDe(proche);
				} else if ((proche.getDELAY() < this.getDELAY())
						&& (proche.getHeight() > this.getHeight())) {
					// si mon bidule est moins rapide que le bidule proche
					// et qu'il est plus gros
					seDesaxeDe(proche);
				} else if ((proche.getDELAY() < this.getDELAY())
						&& (proche.getHeight() >= this.getHeight())) {
					// si mon bidule est moins rapide que le bidule proche
					// et qu'il est moins gros
					fuit(proche);
					return;
				}
			}

		}
	}

	private void poursuit(Bidule proche) {
		if (proche.getIncX() == this.getIncX()
				&& proche.getIncY() == this.getIncY()) {
			// si mon bidule va dans la même direction que le bidule proche
			if (this.getX() - proche.getX() < (this.getX() + this.getIncX())
					- proche.getX()) {
				// si mon bidule est "devant" le bidule proche
				this.setIncX(this.getIncX() * (-1));
				this.setIncY(this.getIncY() * (-1));
				// se met en sens inverse +/- = attaque
			}
		} else if (proche.getIncX() != this.getIncX()
				|| proche.getIncY() != this.getIncY()) {
			this.setIncX(proche.getIncX());
			this.setIncY(proche.getIncY());
			// sinon, si mon bidule va dans la même direction
		}
	}

	private void seDesaxeDe(Bidule proche) {
		if (proche.getIncX() != this.getIncX()
				&& proche.getIncY() != this.getIncY()) {
			// si mon bidule va dans la direction opposé au bidule proche
			this.setIncX(this.getIncX() * (-1));
			// se desaxe
		}
	}

	private void fuit(Bidule proche) {
		if ((proche.getIncX() == this.getIncX() && proche.getIncY() == this
				.getIncY())
				|| (proche.getIncX() != this.getIncX() && proche.getIncY() != this
						.getIncY())) {
			// si mon bidule va dans la même direction que le bidule proche
			// ou si ils vont dans des directions opposée
			this.setIncX(this.getIncX() * (-1));
			// se désaxe du bidule
		}
	}

	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
		this.setIncY(this.getIncY() * (-1));
		// se desaxe

	}

}
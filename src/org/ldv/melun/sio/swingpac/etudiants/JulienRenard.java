package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.util.List;

import org.ldv.melun.sio.swingpac.Bidule;

public class JulienRenard extends Bidule {

	private int nbDeplacements;
	private int nbDeplacements2;

	public JulienRenard() {
		super("Hulkube");
		setBackground(Color.GREEN);
	}

	@Override
	public void doMove() {
		nbDeplacements++;
		super.doMove();
		List<Bidule> bidulesproches = this.getBidulesProches(20);
		if (bidulesproches.size() != 0)
		{
			if(bidulesproches.get(0).isGoDown() && this.isGoDown())
			{
				if(bidulesproches.get(0).getY() < this.getY() && bidulesproches.get(0).getHeight() < this.getHeight())
				{
					this.setIncY(bidulesproches.get(0).getIncY());
					this.setIncX(bidulesproches.get(0).getIncX());
				}
				else if((bidulesproches.get(0).getY() > this.getY()) || bidulesproches.get(0).getHeight() > this.getHeight() & bidulesproches.get(0).isGoRight())
				{
					this.goOnLeft();
				}
				else
				{
					this.goOnRight();
				}

				if(bidulesproches.get(0).isGoUp() && this.isGoUp())
				{
					if(bidulesproches.get(0).getY() > this.getY() && bidulesproches.get(0).getHeight() < this.getHeight())
					{
						this.setIncY(bidulesproches.get(0).getIncY());
						this.setIncX(bidulesproches.get(0).getIncX());
					}
					else if((bidulesproches.get(0).getY() < this.getY()) || bidulesproches.get(0).getHeight() > this.getHeight() & bidulesproches.get(0).isGoRight())
					{
						this.goOnLeft();
					}
					else
					{
						this.goOnRight();
					}

					if(bidulesproches.get(0).isGoRight() && this.isGoRight())
					{
						if(bidulesproches.get(0).getX() > this.getX() && bidulesproches.get(0).getHeight() < this.getHeight())
						{
							this.setIncY(bidulesproches.get(0).getIncY());
							this.setIncX(bidulesproches.get(0).getIncX());
						}
						else if((bidulesproches.get(0).getX() < this.getX()) || bidulesproches.get(0).getHeight() > this.getHeight() & bidulesproches.get(0).isGoUp())
						{
							this.goOnDown();
						}
						else
						{
							this.goOnTop();
						}
					}
				}
			}
			// tous les 50 deplacements et si descente
			if (isGoDown() && nbDeplacements % 150 == 0)
				if (isGoRight()) {
					goOnLeft();
					goOnDown();
				} else if (isGoUp())
					goOnDown();
				else if (isGoDown())
					goOnTop();
				else if (isGoLeft())
					goOnRight();

			if (isGoRight() && nbDeplacements % 750 == 0)
				if (isGoUp())
					goOnDown();
				else
					goOnTop();
		}
	}

	@Override
	protected void doAfterImpactByOther() {
		super.doAfterImpactByOther();
		nbDeplacements2++;

		if (isGoRight() && nbDeplacements2 % 50 == 0) {
			if (isGoUp())
				goOnDown();
			else
				goOnTop();

		}
	}
}
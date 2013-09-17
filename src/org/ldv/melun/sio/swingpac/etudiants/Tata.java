
package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import org.ldv.melun.sio.swingpac.Bidule;

public class Tata extends Bidule {

  private int nbDeplacements;

  public Tata() {
    super("Warrio");
    setBackground(Color.MAGENTA);
    nbDeplacements = 0;
  }

  @Override
  public void doMove() {
    nbDeplacements++;
    super.doMove();
    // tous les 200 deplacements et si descente
    if (isGoDown() && nbDeplacements % 200 == 0)
      if (isGoLeft())
        goOnRight();
      else
        goOnLeft();
  }
  private Image image = null;
  protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        image = getToolkit().getImage("images/xbox.jpg");
        if(image!=null)
            g.drawImage(image, 0 ,0 ,getWidth(), getHeight(), this);
  }
}


/*
 * MyStage
 */

package thegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author Sandro
 */

public class MyStage extends JPanel implements ActionListener, KeyListener {

  Image img;
  Dimension dim;
  Timer tm;
  int x, y, velX, velY;

  public MyStage(String imgname) {
    if ( imgname==null || imgname.length()==0) {
        img = null;
        dim = new Dimension(800, 600);
    } else {
        img = new ImageIcon(imgname).getImage();
        dim = new Dimension(img.getWidth(null), img.getHeight(null));
    }
    setPreferredSize(dim);
    setMinimumSize(dim);
    setMaximumSize(dim);
    setSize(dim);
    setLayout(null);
    x=dim.width/2;
    y=dim.height/2;
    velX=velY=0;
    tm = new Timer(5, this);
    tm.start();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img!=null) g.drawImage(img, 0, 0, null);
    g.setColor(Color.red);
    g.fillRect(x, y, 50, 30);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (x<0 || x>dim.width) velX = -velX;
      if (y<0 || y>dim.height) velY = -velY;
      x = x + velX;
      y = y + velY;
      repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        switch (c) {
            case KeyEvent.VK_LEFT:
                velX=-1; velY=0; break;
            case KeyEvent.VK_RIGHT:
                velX=1; velY=0; break;
            case KeyEvent.VK_UP:
                velX=0; velY=-1; break;
            case KeyEvent.VK_DOWN:
                velX=0; velY=1; break;
            default:
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

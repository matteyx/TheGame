/*
 * TheGame
 */

package thegame;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Sandro
 */
public class TheGame extends JPanel {

  public static void main(String... argv) {
    
    MyStage panel = new MyStage("res/background.jpg");
    // MyStage panel = new MyStage(null);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
  
}

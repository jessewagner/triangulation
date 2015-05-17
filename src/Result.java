/**
 * Created by Brad on 5/16/15.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Result extends JFrame {

  private int x1, x2, x3, y1, y2, y3, r1, r2, r3;
  private boolean los;

  Result() {
    super();
    x1 = x2 = x3 = y1 = y2 = y3 = r1 = r2 = r3 = 0;
    los = false;
  }

  Result(int x, int xx, int xxx, int y, int yy, int yyy, int r, int rr, int rrr, boolean lineOfSight) {
    //super();
    x1 = x;
    x2 = xx;
    x3 = xxx;
    y1 = y;
    y2 = yy;
    y3 = yyy;
    r1 = r;
    r2 = rr;
    r3 = rrr;
    los = lineOfSight;
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    if (los) {
      g2d.drawOval(x1, y1, -(r1), -(r1));
      g2d.drawOval(x2, y2, -(r2), -(r2));
      g2d.drawOval(x3, y3, -(r2), -(r2));
    }
    else {
      g2d.drawOval(x1, y1, -(r1)/2, -(r1)/2);
      g2d.drawOval(x2, y2, -(r2)/2, -(r2)/2);
      g2d.drawOval(x3, y3, -(r2)/2, -(r2)/2);
    }
  }


}

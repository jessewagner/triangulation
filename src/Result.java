/**
 * Created by Brad on 5/16/15.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Double;

public class Result extends JFrame {

  private int x1, x2, x3, y1, y2, y3, d1, d2, d3, r1, r2, r3;
  private int pixelsToFeet = 20;
  private boolean los;
  private double slopeLOS = -5.935;
  private double slopeNoLOS = -0.2827;
  private double yInterceptLOS = 33.459;
  private double yInterceptNoLOS = 59.808;

  Result() {
    super();
    x1 = x2 = x3 = y1 = y2 = y3 = d1 = d2 = d3 = r1 = r2 = r3 = 0;
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

    System.out.print(d1 + " " + d2 + " " + d3);
    if (los) {
      d1 = distanceCalcLOS(r1);
      d2 = distanceCalcLOS(r2);
      d3 = distanceCalcLOS(r3);
    }
    else {
      d1 = distanceCalcNoLOS(r1);
      d2 = distanceCalcNoLOS(r2);
      d3 = distanceCalcNoLOS(r3);
    }
    g2d.drawOval(x1-(d1/2), y1-(d1/2), d1, d1);
    g2d.drawOval(x2-(d2/2), y2-(d2/2), d2, d2);
    g2d.drawOval(x3-(d3/2), y3-(d3/2), d3, d3);
  }

  private int distanceCalcLOS(int signal)
  {
    double distance = (signal + yInterceptLOS) / slopeLOS;
    distance = Math.exp(distance);

    return (int) distance * pixelsToFeet;
  }

  private int distanceCalcNoLOS(int signal)
  {
    double distance = (signal + yInterceptNoLOS) / -slopeNoLOS;
    return (int) distance * pixelsToFeet;
  }
}

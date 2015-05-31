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
  private double slopeNoLOS = -6.291;
  private double yInterceptLOS = 33.459;
  private double yInterceptNoLOS = 47.802;

  Result() {
    super();
    x1 = x2 = x3 = y1 = y2 = y3 = d1 = d2 = d3 = r1 = r2 = r3 = 0;
    los = false;
  }

  Result(int x, int xx, int xxx, int y, int yy, int yyy, int r, int rr, int rrr, boolean lineOfSight) {
    //super();
    x1 = x * pixelsToFeet;
    x2 = xx * pixelsToFeet;
    x3 = xxx * pixelsToFeet;
    y1 = y * pixelsToFeet;
    y2 = yy * pixelsToFeet;
    y3 = yyy * pixelsToFeet;
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
      d1 = distanceCalcLOS(r1);                                             //calls the distanceCalcLOS method to calculate
      d2 = distanceCalcLOS(r2);                                             //the distance from the signal
      d3 = distanceCalcLOS(r3);
    }
    else {
      d1 = distanceCalcNoLOS(r1);                                           //calls the distanceCalcNoLOS method to calculate
      d2 = distanceCalcNoLOS(r2);                                           //the distance from the signal
      d3 = distanceCalcNoLOS(r3);
    }
    g2d.drawOval(x1-(d1/2), y1-(d1/2), d1, d1);                             //draws the first circle to indicate signal strength
    g2d.drawOval(x1-(d1/60), y1-(d1/60), d1/30, d1/30);                     //draws the location the signal was recorded from
    g2d.drawOval(x2-(d2/2), y2-(d2/2), d2, d2);                             //draws the second circle to indicate signal strength
    g2d.drawOval(x2-(d2/60), y2-(d2/60), d2/30, d2/30);                     //draws the location the signal was recorded from
    g2d.drawOval(x3-(d3/2), y3-(d3/2), d3, d3);                             //draws the third circle to indicate signal strength
    g2d.drawOval(x3-(d3/60), y3-(d3/60), d3/30, d3/30);                     //draws the location the signal was recorded from
  }

  private int distanceCalcLOS(int signal)                                   //uses a logarithmic formula to calculate
  {                                                                         //the distance to a signal
    double distance = (signal + yInterceptLOS) / slopeLOS;
    distance = Math.exp(distance);

    return (int) distance * pixelsToFeet;
  }

  private int distanceCalcNoLOS(int signal)                                 //uses a logarithmic formula to calculate
  {                                                                         //the distance to a signal
    double distance = (signal + yInterceptNoLOS) / -slopeNoLOS;
    distance = Math.exp(distance);

    return (int) distance * pixelsToFeet;
  }
}

/**
 * Created by Brad and Jesse on 5/16/15.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class Triangulation extends JFrame {

  // private variables
  private JTextField tfWidth, tfLength, tfX1, tfX2, tfX3, tfY1, tfY2, tfY3, tfRead1, tfRead2, tfRead3;
  private JCheckBox lineOfSight;
  private int wid, len;

  private int pixelsToFeet = 20;

  /** Constructor to setup the GUI components */
  public Triangulation() {
    Container cp = getContentPane();

    // Content-pane sets layout
    cp.setLayout(new GridLayout(13,1));

    cp.add(new JLabel("Room Width"));
    tfWidth = new JTextField(10);
    tfWidth.setEditable(true);
    cp.add(tfWidth);

    cp.add(new JLabel("Room Length"));
    tfLength = new JTextField(10);
    tfLength.setEditable(true);
    cp.add(tfLength);

    cp.add(new JLabel("X-position 1"));
    tfX1 = new JTextField(10);
    tfX1.setEditable(true);
    cp.add(tfX1);

    cp.add(new JLabel("Y-position 1"));
    tfY1 = new JTextField(10);
    tfY1.setEditable(true);
    cp.add(tfY1);

    cp.add(new JLabel("Reading 1"));
    tfRead1 = new JTextField(10);
    tfRead1.setEditable(true);
    cp.add(tfRead1);

    cp.add(new JLabel("X-position 2"));
    tfX2 = new JTextField(10);
    tfX2.setEditable(true);
    cp.add(tfX2);

    cp.add(new JLabel("Y-position 2"));
    tfY2 = new JTextField(10);
    tfY2.setEditable(true);
    cp.add(tfY2);

    cp.add(new JLabel("Reading 2"));
    tfRead2 = new JTextField(10);
    tfRead2.setEditable(true);
    cp.add(tfRead2);

    cp.add(new JLabel("X-position 3"));
    tfX3 = new JTextField(10);
    tfX3.setEditable(true);
    cp.add(tfX3);

    cp.add(new JLabel("Y-position 3"));
    tfY3 = new JTextField(10);
    tfY3.setEditable(true);
    cp.add(tfY3);

    cp.add(new JLabel("Reading 3"));
    tfRead3 = new JTextField(10);
    tfRead3.setEditable(true);
    cp.add(tfRead3);

    //cp.add(new JLabel("Line of Sight?"));
    lineOfSight = new JCheckBox("Line of Sight?");
    cp.add(lineOfSight);

    // Content-pane adds components
    JButton btnCalculate = new JButton("Calculate");
    cp.add(btnCalculate);

    // Source object adds listener
    btnCalculate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // JFrame frame = new JFrame("Results");
        Result r = new Result(Integer.parseInt(tfWidth.getText()),
                Integer.parseInt(tfLength.getText()),
                Integer.parseInt(tfX1.getText()),
                Integer.parseInt(tfX2.getText()),
                Integer.parseInt(tfX3.getText()),
                Integer.parseInt(tfY1.getText()),
                Integer.parseInt(tfY2.getText()),
                Integer.parseInt(tfY3.getText()),
                Integer.parseInt(tfRead1.getText()),
                Integer.parseInt(tfRead2.getText()),
                Integer.parseInt(tfRead3.getText()),
                lineOfSight.isSelected());
        wid = Integer.parseInt(tfWidth.getText());
        len = Integer.parseInt(tfLength.getText());
        //r.setSize(wid, len);
        r.setPreferredSize(new Dimension(wid * pixelsToFeet, len * pixelsToFeet));
        r.pack();
        r.setVisible(true);
        r.setTitle("Results");
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


      }
    });

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Exit the program when the close-window button clicked
    setTitle("Wifi Triangulation");  // "this" JFrame sets title
    setSize(400, 400);   // "this" JFrame sets initial size (or pack())
    setVisible(true);    // show it
  }



  /** The entry main() method */
  public static void main(String[] args) {
    // Run GUI codes in Event-Dispatching thread for thread-safety
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new Triangulation();  // Let the constructor do the job
      }
    });
  }
}
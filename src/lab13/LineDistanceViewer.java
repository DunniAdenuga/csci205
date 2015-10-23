/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 20, 2015
 * Time: 1:30:34 PM
 *
 * Project: csci205
 * Package: lab13
 * File: LineDistanceViewer
 * Description:
 *
 * ****************************************
 */
package lab13;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * ••• Testing P2.8Write a program LineDistanceTester that constructs a line
 * joining the points (100, 100) and (200, 200), then constructs points (100,
 * 200), (150, 150), and (250, 50). Print the distance from the line to each of
 * the three points, using the ptSegDist method of the Line2D class. Also print
 * the expected values. (Draw a sketch on graph paper to find what values you
 * expect.) •• Graphics P2.9Repeat Exercise P2.8, but now write a graphical
 * application that shows the line and the points. Draw each point as a tiny
 * circle. Use the drawString method to draw each distance next to the point,
 * using c allsg2.drawString("Distance: " + distance, p.getX(), p.getY());
 *
 * @author ia005
 */
class LineDistanceComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D.Double point = new Point2D.Double(100, 200);
        Point2D.Double point1 = new Point2D.Double(150, 150);
        Point2D.Double point2 = new Point2D.Double(250, 50);
        Line2D.Double line = new Line2D.Double(100, 100, 200, 200);

        g2.setStroke(new BasicStroke(3));
        g2.drawLine(100, 100, 100,
                    100);
        g2.drawLine(200, 200, 200,
                    200);

        g2.setStroke(new BasicStroke(1));
        g2.draw(line);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine((int) point.getX(), (int) point.getY(), (int) point.getX(),
                    (int) point.getY());
        double distance = line.ptLineDist(point);
        g2.drawString("Distance " + distance, (int) point.getX(),
                      (int) point.getY());

        g2.drawLine((int) point1.getX(), (int) point1.getY(),
                    (int) point1.getX(),
                    (int) point1.getY());
        double distance2 = line.ptLineDist(point1);
        g2.drawString("Distance " + distance2, (int) point1.getX(),
                      (int) point1.getY());

        g2.drawLine((int) point2.getX(), (int) point2.getY(),
                    (int) point2.getX(),
                    (int) point2.getY());
        double distance3 = line.ptLineDist(point2);
        g2.drawString("Distance " + distance3, (int) point2.getX(),
                      (int) point2.getY());
    }
}

public class LineDistanceViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame("Line Distance");
                    frame.getContentPane().add(new LineDistanceComponent());

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setSize(500, 300);
                    frame.setLocationRelativeTo(null);
                    //frame.pack();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

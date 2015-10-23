/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 20, 2015
 * Time: 12:25:23 PM
 *
 * Project: csci205
 * Package: lab13
 * File: TrafficLightViewer
 * Description:
 *
 * ****************************************
 */
package lab13;

import java.awt.BorderLayout;
import static java.awt.Color.BLACK;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author ia005
 */
class TrafficLightComponent extends JComponent {
    TrafficLightComponent() {
        //setPreferredSize(new Dimension(300, 600));

    }

    @Override
    public void paintComponent(Graphics g) {
        //g.drawRect(300, 300, 50, 100);
        //Help from Anmol Singh
        g.setColor(RED);

        g.fillOval(0, 0, getWidth(), getHeight() / 4);
        g.setColor(YELLOW);
        g.fillOval(0, getHeight() / 3, getWidth(), getHeight() / 4);
        g.setColor(GREEN);
        g.fillOval(0, getHeight() * 2 / 3, getWidth(), getHeight() / 4);

    }
}

public class TrafficLightViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame("Traffic Light");
        //JPanel jpanel = new JPanel();
                    //jpanel.add(new TrafficLightComponent(), BorderLayout.CENTER);
                    //frame.add(jpanel);

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().setLayout(new BorderLayout());
                    frame.getContentPane().add(new TrafficLightComponent(),
                                               BorderLayout.CENTER);
                    frame.setSize(150, 600);
                    frame.setLocationRelativeTo(null);
                    //frame.pack();
                    frame.getContentPane().setBackground(BLACK);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

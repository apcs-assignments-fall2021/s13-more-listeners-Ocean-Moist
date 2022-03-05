import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class HotAndColdGame {
    JFrame frame;
    JPanel panel1;
    JTextField field1;
    int winx = (int) (Math.random() * 500);
    int winy = (int) (Math.random() * 500);
    int prevx = -1;
    int prevy = -1;

    public HotAndColdGame() {
        // Set up the frame
        frame = new JFrame("Mouse Listener Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up components/panels
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500,500));
        frame.add(panel1, BorderLayout.NORTH);

        field1 = new JTextField();
        frame.add(field1, BorderLayout.SOUTH);


        // Set up MouseListener
        panel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // distance formula
                int d = (int) Math.sqrt(Math.abs(e.getX() - winx) * Math.abs(e.getX()) - winx) + Math.abs(e.getY() - winy) * Math.abs(e.getY() - winy);
                if (d > 70) {
                    field1.setText("garbanzo beans");
                } else if (d > 40) {
                    field1.setText("garbage");
                } else if (d > 30) {
                    field1.setText("avg");
                } else if (d > 20) {
                    field1.setText("getting warmer");
                } else if (d > 10) {
                    field1.setText("hot");
                } else if (d > 5) {
                    field1.setText("very hot");
                } else if (d > 1) {
                    field1.setText("burning");
                } else {
                    field1.setText("game over");
                }

                if (prevx != -1) {
                    prevx = e.getX();
                    prevy = e.getY();
                } else {
                    int prev = d(e.getX(), e.getY(), winx, winy);
                    int cur = d(e.getX(), e.getY(), prevx, prevy);
                    if (cur < prev) {
                        field1.setText("getting warmer");
                    } else {
                        field1.setText("getting colder");
                }
                    prevx = e.getX();
                    prevy = e.getY();

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // pack and show
        frame.pack();
        frame.setVisible(true);
    }

    public static int d(int x, int y, int winx, int winy) {
        return (int) Math.sqrt(Math.abs(x - winx) * Math.abs(x - winx) + Math.abs(y - winy) * Math.abs(y - winy));
    }



    public static void main(String[] args) {
        HotAndColdGame s = new HotAndColdGame();
    }
}

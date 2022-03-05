import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class KeyCounter {
    JFrame frame;
    JTextField field1, field2;
    JButton button1;
    int counter = 0;
    public KeyCounter() {
        // YOUR CODE HERE
        // displays number of times keys were pressed
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field1 = new JTextField();
        button1 = new JButton("Count");

        field2 = new JTextField();
        field2.setEditable(false);
        field2.setText(counter + "");

        frame.add(field1);
        frame.add(button1);
        frame.add(field2);
        button1.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
               counter++;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });


        frame.pack();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        KeyCounter s = new KeyCounter();
    }
}

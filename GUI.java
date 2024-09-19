import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private int clicks = 0;
    private final JLabel label = new JLabel("Number of crimininal offence made:  0     ");

    public GUI() {

        // the clickable button
        JButton button = new JButton("Touch me");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        // set up the frame and display it
        JFrame frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Number of crimininal offence made:  " + clicks);
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }
}
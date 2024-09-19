import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleSwingApp {
    public static void main(String[] args) {
        // Create a JFrame (window) and set its title and size
        JFrame frame = new JFrame("Simple Swing App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold our components
        JPanel panel = new MyPanel();
        frame.add(panel);

        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a JLabel
        JLabel userLabel = new JLabel("Enter Text:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Create a JTextField
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Create a JButton
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(10, 80, 80, 25);
        panel.add(displayButton);

        // Create a JLabel to display the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 300, 25);
        panel.add(resultLabel);

        // Add an ActionListener to the button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the text of the result label to the text from the text field
                resultLabel.setText("You entered: " + userText.getText());
            }
        });
    }

    static class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw a rectangle
            g.setColor(Color.BLUE);
            g.fillRect(50, 150, 100, 50);

            // You can add more drawing code here
        }
    }
}


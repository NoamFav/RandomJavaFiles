import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enhanced Swing App");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private static void placeComponents(MyPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter Shape:");
        userLabel.setBounds(10, 20, 100, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(120, 20, 165, 25);
        panel.add(userText);

        JButton drawButton = new JButton("Draw");
        drawButton.setBounds(10, 80, 80, 25);
        panel.add(drawButton);

        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        JComboBox<String> colorBox = new JComboBox<>(colors);
        colorBox.setBounds(120, 80, 165, 25);
        panel.add(colorBox);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(300, 20, 80, 25);
        panel.add(clearButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(300, 80, 80, 25);
        panel.add(exitButton);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape = userText.getText().toLowerCase();
                String color = (String) colorBox.getSelectedItem();
                panel.drawShape(shape, color);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearDrawing();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    static class MyPanel extends JPanel {
        private String shape = "";
        private Color color = Color.BLACK;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(color);
            switch (shape) {
                case "circle":
                    g.fillOval(50, 150, 100, 100);
                    break;
                case "rectangle":
                    g.fillRect(50, 150, 100, 50);
                    break;
                // Add more shapes as needed
            }
        }

        public void drawShape(String shape, String color) {
            this.shape = shape;
            this.color = parseColor(color);
            repaint();
        }

        public void clearDrawing() {
            this.shape = "";
            repaint();
        }

        private Color parseColor(String color) {
            switch (color.toLowerCase()) {
                case "red":
                    return Color.RED;
                case "blue":
                    return Color.BLUE;
                case "green":
                    return Color.GREEN;
                case "yellow":
                    return Color.YELLOW;
                default:
                    return Color.BLACK;
            }
        }
    }
}


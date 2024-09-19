import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoGUI extends JFrame {

    // Constructor to set up the GUI
    public DemoGUI() {
        // Frame setup
        setTitle("Swing Cheat Sheet");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2)); // Grid layout

        // Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        // Button with action listener
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> System.out.println("Button clicked"));
        panel.add(button);

        // Label with styling
        JLabel label = new JLabel("Styled Label");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(label);

        // Text Field with action listener for Enter key
        JTextField textField = new JTextField(10);
        textField.addActionListener(e -> {
        	System.out.println("TextField: " + textField.getText());
        	label.setText(textField.getText());
        });
        panel.add(textField);

        // Checkbox (Radio Button)
        JCheckBox checkBox = new JCheckBox("Launch timer");
        panel.add(checkBox);

        // Choice Box (ComboBox)
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Black", "Red", "yellow"});
        panel.add(comboBox);

        

        // Custom component with painting
        JPanel customPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(50, 50, 100, 100); // Rectangle

                g.setColor(Color.BLUE);
                g.drawOval(0, 0, 50, 50);
                g.fillOval(50, 50, 30, 30);
            }
        };
        customPanel.setPreferredSize(new Dimension(100, 100));
        add(customPanel);

        // Timer

        Timer timer = new Timer(1000, e -> System.out.println("Timer tick"));

        checkBox.addActionListener(e -> {
	        if (checkBox.isSelected()) {
	        	timer.start();
	        } else {
	        	timer.stop();
	        }
    	});

        // Mouse listener
        customPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at " + e.getPoint());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DemoGUI().setVisible(true);
        });
    }
}

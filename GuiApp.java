import javax.swing.*;
import java.awt.*;

public class GuiApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Title Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            
            // Add title at the top
            JLabel titleLabel = new JLabel("Welcome to My Application", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
            titleLabel.setPreferredSize(new Dimension(800, 100));
            
            // Set background image
            ImageIcon backgroundImage = new ImageIcon("path_to_your_image.jpg"); // replace with your image path
            JLabel backgroundLabel = new JLabel(backgroundImage);
            
            frame.setLayout(new BorderLayout());
            frame.add(titleLabel, BorderLayout.NORTH);
            frame.add(backgroundLabel, BorderLayout.CENTER);
            
            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true);
        });
    }
}

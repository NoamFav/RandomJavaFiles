import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUI3 {
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Simple Swing App with Drawing");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create a menu
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        // Create a menu item for clearing the drawing
        JMenuItem clearItem = new JMenuItem("Clear");
        menu.add(clearItem);

        // Add action listener to the menu item
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.clearDrawings();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    static class DrawingPanel extends JPanel {
        private ArrayList<Point> points = new ArrayList<>();

        public DrawingPanel() {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }

        public void clearDrawings() {
            points.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point point : points) {
                int radius = 10; // Fixed radius for all circles
                g.fillOval(point.x - radius / 2, point.y - radius / 2, radius, radius);
            }
        }
    }
}


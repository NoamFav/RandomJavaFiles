import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class PaintApp {
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Paint Application");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Add the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        mainPanel.add(drawingPanel, BorderLayout.CENTER);

        // Add the control panel
        JPanel controlPanel = new JPanel();
        mainPanel.add(controlPanel, BorderLayout.NORTH);

        // Add components to the control panel
        JLabel colorLabel = new JLabel("Select Color:");
        controlPanel.add(colorLabel);

        JButton colorButton = new JButton("Choose Color");
        controlPanel.add(colorButton);

        // Add action listener for the color button
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color chosenColor = JColorChooser.showDialog(frame, "Choose a color", Color.BLACK);
                if (chosenColor != null) {
                    drawingPanel.setCurrentColor(chosenColor);
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    static class DrawingPanel extends JPanel {
        private Color currentColor = Color.BLACK;
        private ArrayList<Line> lines = new ArrayList<>();

        public DrawingPanel() {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Start a new line on mouse press
                    lines.add(new Line(currentColor, e.getPoint()));
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // Add to the current line on drag
                    Line currentLine = lines.get(lines.size() - 1);
                    currentLine.addPoint(e.getPoint());
                    repaint(); // Repaint the panel
                }
            });
        }

        public void setCurrentColor(Color color) {
            this.currentColor = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Line line : lines) {
                line.draw(g);
            }
        }
    }

    static class Line {
        private Color color;
        private ArrayList<Point> points = new ArrayList<>();

        public Line(Color color, Point start) {
            this.color = color;
            points.add(start);
        }

        public void addPoint(Point point) {
            points.add(point);
        }

        public void draw(Graphics g) {
            g.setColor(color);
            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}


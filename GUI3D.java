import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class GUI3D {
    public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Drawing App");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel);

        // Make the frame visible
        frame.setVisible(true);
    }

    static class DrawingPanel extends JPanel {
        private ArrayList<Line> lines = new ArrayList<>();

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // Start a new line on mouse press
                    lines.add(new Line(e.getPoint()));
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

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Line line : lines) {
                line.draw(g);
            }
        }
    }

    static class Line {
        private ArrayList<Point> points = new ArrayList<>();

        public Line(Point start) {
            points.add(start);
        }

        public void addPoint(Point point) {
            points.add(point);
        }

        public void draw(Graphics g) {
            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}


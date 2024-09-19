import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldExample extends JFrame {
    private JTextField textField;
    private JTextField textarea;
    
    public TextFieldExample() {
        // Set up the JFrame
        setTitle("TextField Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create JTextField
        textField = new JTextField();
        textField.setBounds(50, 50, 200, 30);
        add(textField);

        textarea = new JTextField();
        textarea.setBounds(100,100,200,30);
        textarea.setText("hello");
        add(textarea);

        // Add ActionListener to JTextField
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textarea.setText(text);
                textField.setText("");
            }
        });

    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextFieldExample().setVisible(true);
            }
        });
    }
}

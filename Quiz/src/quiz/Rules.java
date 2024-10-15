package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        // Set the main background color
        getContentPane().setBackground(new Color(255, 228, 196)); // Pastel Peach
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Welcome " + name + " to TriviaTornado");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Georgia", Font.BOLD, 28));
        heading.setForeground(new Color(255, 69, 0)); // Coral
        add(heading);

        // Rules Text
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Arial", Font.PLAIN, 16));
        rules.setForeground(new Color(50, 50, 50)); // Dark Gray
        rules.setText(
    "<html>" +
        "1. Please answer all questions to the best of your ability." + "<br><br>" +
        "2. Maintain respect towards fellow participants throughout the quiz." + "<br><br>" +
        "3. Ensure that you adhere to the time limits set for each question." + "<br><br>" +
        "4. Use only permitted materials and resources during the quiz." + "<br><br>" +
        "5. Good luck, and aim to demonstrate your knowledge effectively!" + "<br><br>" +
    "</html>"
);

        add(rules);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setForeground(Color.BLACK); // Black
        back.setBackground(new Color(220, 20, 60)); // Crimson
        back.setFocusPainted(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        // Adding Hover Effect
        back.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                back.setBackground(new Color(255, 69, 0)); // Darker Coral
            }
            public void mouseExited(MouseEvent e) {
                back.setBackground(new Color(220, 20, 60)); // Crimson
            }
        });
        add(back);

        // Start Button
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setFont(new Font("Arial", Font.BOLD, 16));
        start.setForeground(Color.BLACK); // Black
        start.setBackground(new Color(72, 209, 204)); // Light Teal
        start.setFocusPainted(false);
        start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        start.addActionListener(this);
        // Adding Hover Effect
        start.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                start.setBackground(new Color(0, 160, 160)); // Darker Teal
            }
            public void mouseExited(MouseEvent e) {
                start.setBackground(new Color(72, 209, 204)); // Light Teal
            }
        });
        add(start);

        // Frame settings
        setSize(800, 650);
        setLocation(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}

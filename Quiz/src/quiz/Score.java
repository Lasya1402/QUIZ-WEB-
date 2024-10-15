package quiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        // Set frame properties
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(new Color(255, 228, 196)); // Pastel Peach background
        setLayout(null);
        
        // Heading label
        JLabel heading = new JLabel("Thank you " + name + " for playing TriviaTornado");
        heading.setBounds(45, 30, 700, 60); // Increased height for better spacing
        heading.setFont(new Font("Georgia", Font.BOLD, 30)); // Bigger font for clear visibility
        heading.setForeground(new Color(255, 69, 0)); // Coral heading color
        heading.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        add(heading);
        
        // Score label
        int frameWidth = 750; // Width of the frame
        int labelWidth = 300; // Width of the score label
        int xPos = (frameWidth - labelWidth) / 2; // Calculate x position for centering
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(xPos, 150, labelWidth, 50); // Use calculated xPos for centering
        lblscore.setFont(new Font("Arial", Font.PLAIN, 28)); // Bigger font for the score
        lblscore.setForeground(new Color(34, 34, 34)); // Dark gray text color
        lblscore.setHorizontalAlignment(SwingConstants.CENTER); // Center the score horizontally
        add(lblscore);
        
        // Play Again button
        JButton submit = new JButton("Play Again");
        submit.setBounds(275, 250, 200, 50); // Adjusted placement and size for better visibility
        submit.setBackground(new Color(220, 20, 60)); // Crimson background
        submit.setForeground(Color.BLACK); // White text color
        submit.setFont(new Font("Arial", Font.BOLD, 20)); // Bigger font for better clarity
        submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        
        // Hover effect for Play Again button
        submit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(new Color(255, 69, 0)); // Darker Coral on hover
            }
            public void mouseExited(MouseEvent e) {
                submit.setBackground(new Color(220, 20, 60)); // Crimson when not hovered
            }
        });
        add(submit);
        
        // Frame visibility and close operation
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false); // Hide current frame
        new Login(); // Navigate back to login
    }

    public static void main(String[] args) {
        new Score("User", 0); // For testing purposes
    }
}

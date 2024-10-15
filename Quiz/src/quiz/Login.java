package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    JButton rules, back;
    JTextField tfname;
    JComboBox<String> subjectBox;
    
    Login() {
        // Set the main background color
        getContentPane().setBackground(new Color(255, 228, 196)); // Pastel Peach

        setLayout(null);
        
        // Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image img = i1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(img);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        // Heading
        JLabel heading = new JLabel("TriviaTornado");
        heading.setBounds(650, 60, 500, 60);
        heading.setFont(new Font("Georgia", Font.BOLD, 50));
        heading.setForeground(new Color(255, 69, 0)); // Coral
        add(heading);
        
        // Name Label
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(650, 160, 300, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setForeground(new Color(50, 50, 50)); // Dark Gray
        add(name);
        
        // Text Field
        tfname = new JTextField();
        tfname.setBounds(650, 210, 400, 40);
        tfname.setFont(new Font("Arial", Font.PLAIN, 18));
        tfname.setBackground(new Color(175, 238, 238)); // Light Mint
        tfname.setForeground(new Color(34, 34, 34)); // Dark Gray
        tfname.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 250))); // Light Lavender
        add(tfname);
        
        // Subject Label
        JLabel subjectLabel = new JLabel("Select Your Subject");
        subjectLabel.setBounds(650, 270, 300, 30);
        subjectLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subjectLabel.setForeground(new Color(50, 50, 50)); // Dark Gray
        add(subjectLabel);
        
        // Dropdown Box for Subjects
        String[] subjects = {
            "Select", "Full Stack", "Python", "Data Structures",
            "C", "C++", "Java", "Machine Learning"
        };
        subjectBox = new JComboBox<>(subjects);
        subjectBox.setBounds(650, 310, 400, 40);
        subjectBox.setFont(new Font("Arial", Font.PLAIN, 18));
        subjectBox.setBackground(new Color(175, 238, 238)); // Light Mint
        subjectBox.setForeground(new Color(34, 34, 34)); // Dark Gray
        subjectBox.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 250))); // Light Lavender
        subjectBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(subjectBox);
        
        // Rules Button
        rules = new JButton("Rules");
        rules.setBounds(650, 380, 180, 40);
        rules.setFont(new Font("Arial", Font.BOLD, 18));
        rules.setForeground(Color.BLACK); // Black
        rules.setBackground(new Color(72, 209, 204)); // Light Teal (Adjusted for consistency)
        rules.setFocusPainted(false);
        rules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rules.addActionListener(this);
        // Adding Hover Effect
        rules.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                rules.setBackground(new Color(0, 160, 160)); // Darker Teal
            }
            public void mouseExited(MouseEvent e) {
                rules.setBackground(new Color(72, 209, 204)); // Light Teal
            }
        });
        add(rules);
        
        // Back Button
        back = new JButton("Back");
        back.setBounds(870, 380, 180, 40);
        back.setFont(new Font("Arial", Font.BOLD, 18));
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
        
        // Frame settings
        setSize(1200, 500);
        setLocation(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
 if (ae.getSource() == rules) {
 String name = tfname.getText();
 String subject = (String) subjectBox.getSelectedItem();
 setVisible(false);
 new Rules(name);
 } else if (ae.getSource() == back) {
 setVisible(false);
 }
 }
    
    
    public static void main(String[] args) {
      
        
        new Login();
    }
}

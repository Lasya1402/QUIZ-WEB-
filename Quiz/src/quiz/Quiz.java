package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(new Color(255, 228, 196)); // Pastel Peach
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Georgia", Font.BOLD, 24)); // Changed font
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Georgia", Font.BOLD, 24)); // Changed font
        question.setForeground(new Color(255, 69, 0)); // Coral
        add(question);

        // Initialize questions and answers
        initializeQuestionsAndAnswers();

        // Radio buttons for options
        opt1 = createRadioButton(170, 520);
        opt2 = createRadioButton(170, 560);
        opt3 = createRadioButton(170, 600);
        opt4 = createRadioButton(170, 640);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // Buttons
        next = createButton("Next", 1100, 550);
        lifeline = createButton("50-50 Lifeline", 1100, 630);
        submit = createButton("Submit", 1100, 710);
        submit.setEnabled(false); // Disabled until needed

        start(count); // Start the quiz

        setVisible(true);
    }

    // Create radio button with common properties
    private JRadioButton createRadioButton(int x, int y) {
        JRadioButton radioButton = new JRadioButton();
        radioButton.setBounds(x, y, 700, 30);
        radioButton.setBackground(new Color(255, 228, 196)); // Match background color
        radioButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(radioButton);
        return radioButton;
    }

    // Create button with common properties
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 40);
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        button.setBackground(new Color(30, 144, 255)); // Match button color
        button.setForeground(Color.BLACK); // Black text
        button.addActionListener(this);
        add(button);
        return button;
    }

    // Initialize questions and answers
    private void initializeQuestionsAndAnswers() {
    questions[0][0] = "Which language is primarily used for front-end web development?";
    questions[0][1] = "Python";
    questions[0][2] = "JavaScript"; // Correct Answer
    questions[0][3] = "Java";
    questions[0][4] = "C++";

    questions[1][0] = "Which of the following is a popular front-end framework?";
    questions[1][1] = "Django";
    questions[1][2] = "React"; // Correct Answer
    questions[1][3] = "Flask";
    questions[1][4] = "Spring";

    questions[2][0] = "What does CRUD stand for in database management?";
    questions[2][1] = "Create, Read, Update, Delete"; // Correct Answer
    questions[2][2] = "Create, Replace, Update, Delete";
    questions[2][3] = "Create, Read, Upload, Download";
    questions[2][4] = "Create, Read, Use, Delete";

    questions[3][0] = "Which HTTP method is used to retrieve data from a server?";
    questions[3][1] = "POST";
    questions[3][2] = "GET"; // Correct Answer
    questions[3][3] = "PUT";
    questions[3][4] = "DELETE";

    questions[4][0] = "Which database is a NoSQL database?";
    questions[4][1] = "MySQL";
    questions[4][2] = "PostgreSQL";
    questions[4][3] = "MongoDB"; // Correct Answer
    questions[4][4] = "Oracle";

    questions[5][0] = "Which of the following is used to style web pages?";
    questions[5][1] = "HTML";
    questions[5][2] = "CSS"; // Correct Answer
    questions[5][3] = "JavaScript";
    questions[5][4] = "PHP";

    questions[6][0] = "Which of the following is a back-end programming language?";
    questions[6][1] = "HTML";
    questions[6][2] = "JavaScript";
    questions[6][3] = "Java"; // Correct Answer
    questions[6][4] = "CSS";

    questions[7][0] = "Which protocol is used to send data to a server?";
    questions[7][1] = "HTTP"; // Correct Answer
    questions[7][2] = "FTP";
    questions[7][3] = "SMTP";
    questions[7][4] = "Telnet";

    questions[8][0] = "What does API stand for?";
    questions[8][1] = "Application Programming Interface"; // Correct Answer
    questions[8][2] = "Application Process Interface";
    questions[8][3] = "Advanced Programming Interface";
    questions[8][4] = "Application Program Interface";

    questions[9][0] = "Which of the following is used for version control?";
    questions[9][1] = "MySQL";
    questions[9][2] = "Git"; // Correct Answer
    questions[9][3] = "Node.js";
    questions[9][4] = "Docker";

    answers[0][1] = "JavaScript";
    answers[1][1] = "React";
    answers[2][1] = "Create, Read, Update, Delete";
    answers[3][1] = "GET";
    answers[4][1] = "MongoDB";
    answers[5][1] = "CSS";
    answers[6][1] = "Java";
    answers[7][1] = "HTTP";
    answers[8][1] = "Application Programming Interface";
    answers[9][1] = "Git";
}


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            enableOptions(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            calculateScore();
            setVisible(false);
            new Score(name, score);
        }
    }

    private void enableOptions(boolean enable) {
        opt1.setEnabled(enable);
        opt2.setEnabled(enable);
        opt3.setEnabled(enable);
        opt4.setEnabled(enable);
    }

    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            } else {
                score += 0;
            }
        }
    }

    public void start(int count) {
        // Setting up the question and options
        qno.setText("" + (count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // Resetting options
        groupoptions.clearSelection();
        enableOptions(true);
    }

    public static void main(String[] args) {
        new Quiz("");
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab04_7 {

    static int n1, n2, ans;
    static int question = 1;
    static int score = 0;

    public static void main(String[] args) {

        JFrame win = new JFrame("Easy Math Quiz");
        win.setBounds(100, 100, 500, 300);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel subwin = new JPanel();
        subwin.setBackground(new Color(50,150,250));

        JLabel labelQ = new JLabel("Question 1/10");
        labelQ.setFont(new Font("Serif", Font.PLAIN, 20));
        subwin.add(labelQ);

        JLabel label1 = new JLabel();
        label1.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label1);

        JLabel labelOp = new JLabel();
        labelOp.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelOp);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(label2);

        JLabel labelEq = new JLabel(" = ");
        labelEq.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(labelEq);

        JTextField ansBox = new JTextField(3);
        ansBox.setFont(new Font("Serif", Font.PLAIN, 40));
        subwin.add(ansBox);

        JButton b1 = new JButton("Check");
        b1.setFont(new Font("Serif", Font.PLAIN, 20));
        subwin.add(b1);

        JLabel labelResult = new JLabel();
        labelResult.setFont(new Font("Serif", Font.PLAIN, 25));
        subwin.add(labelResult);

        // สุ่มโจทย์ครั้งแรก
        generateQuestion(label1, label2, labelOp);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int userAns = Integer.parseInt(ansBox.getText());

                    if (userAns == ans) {
                        score++;
                        labelResult.setText("Correct!");
                    } else {
                        labelResult.setText("Wrong!");
                    }

                    question++;

                    if (question > 10) {
                        JOptionPane.showMessageDialog(
                                win,
                                "Your score: " + score + " / 10"
                        );
                        System.exit(0);
                    }

                    labelQ.setText("Question " + question + "/10");
                    ansBox.setText("");
                    generateQuestion(label1, label2, labelOp);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(win, "Please enter a number");
                }
            }
        });

        win.add(subwin);
        win.setVisible(true);
    }

    // เมธอดสุ่มโจทย์
    static void generateQuestion(JLabel l1, JLabel l2, JLabel lop) {

        n1 = (int)(Math.random() * 10);
        n2 = (int)(Math.random() * 10);
        int op = (int)(Math.random() * 3);

        char operator;

        if (op == 0) {
            operator = '+';
            ans = n1 + n2;
        } else if (op == 1) {
            operator = '-';
            ans = n1 - n2;
        } else {
            operator = '*';
            ans = n1 * n2;
        }

        l1.setText("" + n1);
        l2.setText("" + n2);
        lop.setText(" " + operator + " ");
    }
}


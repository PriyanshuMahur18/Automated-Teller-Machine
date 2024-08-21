package demo;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, sign, clear;
    public static JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {

        setTitle("AUTOMATED TELLER  MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMG-20231128-WA0001.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 30));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 160, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        sign = new JButton("Sign up");
        sign.setBounds(300, 350, 230, 30);
        sign.setBackground(Color.black);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);

        setSize(700, 600);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } 
        else if (ae.getSource() == login) {
            Jdbc_con c = new Jdbc_con();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query4 = "Select * from login where CARDNUMBER= '" + cardnumber + "' and PIN = '" + pinnumber + "'";

            try {
                ResultSet rs = c.smt.executeQuery(query4);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(cardnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == sign) {
            setVisible(false);
            new Signup_1().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
        System.out.println("execute successfully");
    }
}


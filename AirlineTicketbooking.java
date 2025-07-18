package com.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserDao extends JFrame implements ActionListener {

    // Components
    JLabel lblTitle, lblName, lblFlight, lblClass;
    JTextField txtName;
    JComboBox<String> comboFlight, comboClass;
    JButton btnReserve, btnClear;
    JTextArea txtArea;

    public UserDao() {
        // Frame title
        setTitle("Airline Reservation System");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title
        lblTitle = new JLabel("Airline Reservation System");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(80, 10, 300, 30);
        add(lblTitle);

        // Name
        lblName = new JLabel("Passenger Name:");
        lblName.setBounds(50, 60, 120, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(180, 60, 180, 25);
        add(txtName);

        // Flight Selection
        lblFlight = new JLabel("Select Flight:");
        lblFlight.setBounds(50, 100, 120, 25);
        add(lblFlight);

        String[] flights = {"Flight 101 - NYC to LA", "Flight 202 - LA to Chicago", "Flight 303 - Chicago to Miami"};
        comboFlight = new JComboBox<>(flights);
        comboFlight.setBounds(180, 100, 180, 25);
        add(comboFlight);

        // Class Selection
        lblClass = new JLabel("Class:");
        lblClass.setBounds(50, 140, 120, 25);
        add(lblClass);

        String[] classes = {"Economy", "Business", "First Class"};
        comboClass = new JComboBox<>(classes);
        comboClass.setBounds(180, 140, 180, 25);
        add(comboClass);

        // Buttons
        btnReserve = new JButton("Reserve");
        btnReserve.setBounds(100, 190, 100, 30);
        btnReserve.addActionListener(this);
        add(btnReserve);

        btnClear = new JButton("Clear");
        btnClear.setBounds(220, 190, 100, 30);
        btnClear.addActionListener(this);
        add(btnClear);

        // Text area for displaying reservation details
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(50, 240, 320, 100);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnReserve) {
            String name = txtName.getText().trim();
            String flight = (String) comboFlight.getSelectedItem();
            String travelClass = (String) comboClass.getSelectedItem();

            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter passenger name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String reservationDetails = "Reservation Confirmed!\n" +
                    "Name: " + name + "\n" +
                    "Flight: " + flight + "\n" +
                    "Class: " + travelClass + "\n" +
                    "Thank you for booking with us.";

            txtArea.setText(reservationDetails);

        } else if(e.getSource() == btnClear) {
            txtName.setText("");
            comboFlight.setSelectedIndex(0);
            comboClass.setSelectedIndex(0);
            txtArea.setText("");
        }
    }

    public static void main(String[] args) {
        // Run GUI in Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new UserDao());
    }
}


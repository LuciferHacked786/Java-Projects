import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class HotelManagementSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HOTEL MANAGEMENT SYSTEM");

        JLabel nameLb, emailLb, mobileLb, genderLb, checkInLb, checkOutLb, paymentLb, addressLb, bookingId;
        JTextField nameTf, emailTf, mobileTf, genderTf, checkinTf, checkoutTf, paymentTf, addressTf;
        JButton bookButton, clearButton, exitButton;

        nameLb = new JLabel("Name:");
        emailLb = new JLabel("Email:");
        mobileLb = new JLabel("Mobile:");
        genderLb = new JLabel("Gender:");
        checkInLb = new JLabel("Checkin:");
        checkOutLb = new JLabel("Checkout:");
        paymentLb = new JLabel("Payment:");
        addressLb = new JLabel("Address:");
        bookingId = new JLabel();

        nameTf = new JTextField();
        emailTf = new JTextField();
        mobileTf = new JTextField();
        genderTf = new JTextField();
        checkinTf = new JTextField();
        checkoutTf = new JTextField();
        paymentTf = new JTextField();
        addressTf = new JTextField();

        clearButton = new JButton("Clear");
        bookButton = new JButton("Book Now");
        exitButton = new JButton("Exit");

        nameLb.setBounds(20, 30, 100, 40);
        emailLb.setBounds(20, 70, 100, 40);
        mobileLb.setBounds(20, 110, 100, 40);
        genderLb.setBounds(280, 30, 100, 40);
        checkInLb.setBounds(280, 70, 100, 40);
        checkOutLb.setBounds(280, 110, 100, 40);
        paymentLb.setBounds(280, 150, 100, 40);
        addressLb.setBounds(20, 150, 100, 40);
        bookingId.setBounds(50, 300, 450, 40);

        nameTf.setBounds(120, 30, 150, 40);
        emailTf.setBounds(120, 70, 150, 40);
        mobileTf.setBounds(120, 110, 150, 40);
        genderTf.setBounds(400, 30, 150, 40);
        checkinTf.setBounds(400, 70, 150, 40);
        checkoutTf.setBounds(400, 110, 150, 40);
        paymentTf.setBounds(400, 150, 150, 40);
        addressTf.setBounds(120, 150, 150, 40);

        clearButton.setBounds(50, 200, 150, 45);
        bookButton.setBounds(220, 200, 150, 45);
        exitButton.setBounds(400, 200, 150, 45);

        frame.add(nameLb);
        frame.add(emailLb);
        frame.add(mobileLb);
        frame.add(genderLb);
        frame.add(checkInLb);
        frame.add(checkOutLb);
        frame.add(paymentLb);
        frame.add(addressLb);

        frame.add(nameTf);
        frame.add(emailTf);
        frame.add(mobileTf);
        frame.add(genderTf);
        frame.add(checkinTf);
        frame.add(checkoutTf);
        frame.add(paymentTf);
        frame.add(addressTf);
        frame.add(bookingId);

        frame.add(clearButton);
        frame.add(bookButton);
        frame.add(exitButton);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(600, 500);
        frame.setVisible(true);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTf.setText("");
                emailTf.setText("");
                mobileTf.setText("");
                genderTf.setText("");
                checkinTf.setText("");
                checkoutTf.setText("");
                paymentTf.setText("");
                addressTf.setText("");
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nameTf.getText().toString().isEmpty() || emailTf.getText().toString().isEmpty()
                        || mobileTf.getText().toString().isEmpty() || genderTf.getText().toString().isEmpty()
                        || checkinTf.getText().toString().isEmpty() || checkoutTf.getText().toString().isEmpty()
                        || paymentTf.getText().toString().isEmpty() || addressTf.getText().toString().isEmpty()) {
                    bookingId.setText("PLEASE FILL THE DETAILS!!!");
                } else {
                    String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
                    String userName = "root";
                    String password = "";

                    try {
                        Connection connection = DriverManager.getConnection(url, userName, password);
                        String sql = " insert into booking" + " values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString(1, nameTf.getText().toString());
                        preparedStmt.setString(2, emailTf.getText());
                        preparedStmt.setString(3, mobileTf.getText());
                        preparedStmt.setString(4, addressTf.getText().toString());
                        preparedStmt.setString(5, genderTf.getText().toString());
                        preparedStmt.setString(6, checkinTf.getText().toString());
                        preparedStmt.setString(7, checkoutTf.getText().toString());
                        preparedStmt.setString(8, paymentTf.getText().toString());
                        preparedStmt.execute();
                        System.out.println("Database Connected. ");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex + "Not connected. ");
                    }
                    Random random = new Random();
                    int id = random.nextInt(999999);
                    bookingId.setText("YOUR BOOKING IS CONFIRMED AND YOUR BOOKING ID IS " + id);
                }
            }
        });
    }
}
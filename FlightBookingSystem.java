import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FlightBookingSystem {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Flight Booking System");
        JLabel namelabel = new JLabel("Person Name:-");
        JTextField nametextfield = new JTextField();
        JLabel emaillabel = new JLabel("EMAIL ID:-");
        JTextField emailtextfield = new JTextField();
        JLabel mobilelabel = new JLabel("Mobile NO:-");
        JTextField mobiletextfield = new JTextField();
        JLabel sourcelabel = new JLabel("From:-");
        JTextField sourcetextfield = new JTextField();
        JLabel destilabel = new JLabel("To:-");
        JTextField destitextfield = new JTextField();
        JLabel datelabel = new JLabel("Date of Journey:-");
        JTextField datetextfield = new JTextField();
        JLabel classTypelabel = new JLabel("Select Class:-");
        JTextField classtextfield = new JTextField();
        JLabel ticketIdlabel = new JLabel();
        JButton bookNowBtn = new JButton("BOOK NOW");
        JButton clearBtn = new JButton("CLEAR");
        JButton closeBtn = new JButton("EXIT");
        // to set size and position of components in frame
        namelabel.setBounds(40, 40, 150, 40);
        nametextfield.setBounds(160, 40, 200, 30);

        emaillabel.setBounds(40, 90, 150, 40);
        emailtextfield.setBounds(160, 90, 200, 30);

        mobilelabel.setBounds(40, 140, 150, 40);
        mobiletextfield.setBounds(160, 140, 200, 30);

        sourcelabel.setBounds(420, 40, 150, 40);
        sourcetextfield.setBounds(540, 40, 200, 30);

        destilabel.setBounds(420, 90, 150, 40);
        destitextfield.setBounds(540, 90, 200, 30);

        datelabel.setBounds(420, 140, 150, 40);
        datetextfield.setBounds(540, 140, 200, 30);

        clearBtn.setBounds(100, 200, 100, 25);

        bookNowBtn.setBounds(270, 200, 150, 25);

        closeBtn.setBounds(500, 200, 100, 25);

        // to attach the components in frame
        frame.add(namelabel);
        frame.add(nametextfield);
        frame.add(emaillabel);
        frame.add(emailtextfield);
        frame.add(mobilelabel);
        frame.add(mobiletextfield);
        frame.add(sourcelabel);
        frame.add(sourcetextfield);
        frame.add(destilabel);
        frame.add(destitextfield);
        frame.add(datelabel);
        frame.add(datetextfield);
        frame.add(clearBtn);
        frame.add(bookNowBtn);
        frame.add(closeBtn);
        frame.add(ticketIdlabel);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(800, 500);
        frame.setVisible(true);

        // to perform click action on the clear button
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // to clear the form
                nametextfield.setText("");
                emailtextfield.setText("");
                mobiletextfield.setText("");
                sourcetextfield.setText("");
                destitextfield.setText("");
                datetextfield.setText("");
            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        bookNowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nametextfield.getText().toString().isEmpty() ||
                        emailtextfield.getText().toString().isEmpty() ||
                        mobilelabel.getText().toString().isEmpty() ||
                        sourcetextfield.getText().toString().isEmpty() ||
                        destitextfield.getText().toString().isEmpty() ||
                        datelabel.getText().toString().isEmpty()) {
                    ticketIdlabel.setText("Please fill the complete details");
                } else {
                    Random randomId = new Random();
                    int ticketId = randomId.nextInt(9999);
                    ticketIdlabel.setText("Your Ticket is successfully booked and ticket id : " + ticketId);
                }
            }
        });

    }
}
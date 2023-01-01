package GUI;

import Console.Consultations;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame{
    JFrame frame;
    JButton viewDoctorsButton;
    JButton addConsultations;
    public Home(){
        // Components
        try{
            ImageIcon homeImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("homeImage.png")));
            JLabel leftPanelLabel = new JLabel();
            JLabel rightPanelLabel = new JLabel();
            viewDoctorsButton = new JButton("View Doctors");
            viewDoctorsButton.setFocusPainted(false);
            viewDoctorsButton.addActionListener(e -> {
                if(e.getSource() == viewDoctorsButton){
                    frame.dispose();
                    new ViewDoctors();
                }
            });
            addConsultations = new JButton("Add a Consultation");
            addConsultations.setFocusPainted(false);
            addConsultations.addActionListener(e -> {
                if(e.getSource() == addConsultations){
                    frame.dispose();
                    AddConsultations.loadAvailableConsultations();
                    AddConsultations.loadConsultations();
                    new AddConsultations();
                }
            });
            leftPanelLabel.setIcon(homeImage);

            // Grid Layout Panel
            JPanel rightInnerPanel = new JPanel(new GridBagLayout());
            rightInnerPanel.setBorder(new EmptyBorder(5,5,5,5));
            JPanel buttonAndTextPanel = new JPanel(new GridLayout(10,1,10,50));
            rightPanelLabel.setText("Choose an option: ");
            buttonAndTextPanel.add(rightPanelLabel);
            buttonAndTextPanel.add(viewDoctorsButton);
            buttonAndTextPanel.add(addConsultations);
            buttonAndTextPanel.setAlignmentY(250);
            rightInnerPanel.add(buttonAndTextPanel);

            // Left Panel
            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(Color.lightGray.brighter());
            leftPanel.setBounds(0,0,500,500);

            // Right Panel
            JPanel rightPanel = new JPanel();
            rightPanel.setBounds(500,0,300,500);

            // Frame
            frame = new JFrame("Westminster Skin Consultations");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setResizable(false);
            leftPanel.add(leftPanelLabel);
            rightPanel.add(rightInnerPanel, BorderLayout.CENTER);
            frame.add(leftPanel);
            frame.add(rightPanel);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

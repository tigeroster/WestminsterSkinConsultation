package GUI;

import Console.Consultations;
import Console.Doctor;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewConsultations extends JFrame {
    JScrollPane scroll;
    public ViewConsultations(){
        ViewConsultationModel consultationModel = new ViewConsultationModel(Consultations.consultations);
        JTable table = new JTable(consultationModel);

        JLabel topic = new JLabel("Consultations");
        JLabel guide = new JLabel("1: Click the column name to sort");
        JLabel guide2 = new JLabel("2: Double click on the row to view details");
        topic.setFont(new Font("Arial", Font.PLAIN, 30));
        topic.setSize(500,30);
        topic.setLocation(500,20);
        guide.setFont(new Font("Arial", Font.ITALIC, 16));
        guide.setSize(1000,30);
        guide.setLocation(550,50);
        guide2.setFont(new Font("Arial", Font.ITALIC, 16));
        guide2.setSize(1000,30);
        guide2.setLocation(550,70);
        add(guide2);
        add(topic);
        add(guide);

        table.setRowHeight(30);
        table.getTableHeader().setBackground(Color.yellow);
        table.setAutoCreateRowSorter(true);
        scroll = new JScrollPane(table);
        scroll.setLocation(0,100);
        scroll.setSize(1300, 500);
        add(scroll, BorderLayout.CENTER);
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    String[] options = new String[] {"View", "Edit", "Delete", "Cancel"};
                    int response = JOptionPane.showOptionDialog(null, "Please select an option", "Title",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    if(response == 0){
                        int index = table.getSelectedRow();
                        TableModel model = table.getModel();
                        String pId = model.getValueAt(index, 0).toString();
                        String pName = model.getValueAt(index, 1).toString();
                        String pDob = model.getValueAt(index, 2).toString();
                        String pMob = model.getValueAt(index, 3).toString();
                        String pGender = model.getValueAt(index, 4).toString();
                        String conId = model.getValueAt(index, 5).toString();
                        String doctor = model.getValueAt(index, 6).toString();
                        String cost = model.getValueAt(index, 7).toString();
                        String date = model.getValueAt(index, 8).toString();
                        String time = model.getValueAt(index, 9).toString();
                        new ConsultationDetails(pId, pName, pDob, pMob, pGender, conId, doctor, cost, date, time);
                    }
                }
            }
        });

        setSize(1300, 600);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Consultations - Westminster Skin Consultations");
    }
}

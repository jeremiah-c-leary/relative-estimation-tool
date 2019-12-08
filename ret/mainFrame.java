
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class mainFrame extends JFrame {

//    private JTextArea textArea;
//    private JButton btn;
    private JLabel labelTask;
    private JLabel labelDescription;
    private JLabel labelPercent;
    private JLabel labelHours;
    private JLabel oHour;
    private static int row_height = 20;

    public mainFrame() {
        super("Relative Estimation Tool");

        setLayout(new GridBagLayout());

        paint_header();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void paint_header() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelTask = new JLabel("Task");
        labelTask.setBackground(Color.BLUE);
        labelTask.setOpaque(true);
        labelTask.setPreferredSize(new Dimension(200,row_height));
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(labelTask, gbc);

        labelDescription = new JLabel("Description");
        labelDescription.setBackground(Color.RED);
        labelDescription.setOpaque(true);
        labelDescription.setPreferredSize(new Dimension(500,row_height));
        gbc.gridheight = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(labelDescription, gbc);

        labelPercent = new JLabel("Percent");
        labelPercent.setBackground(Color.YELLOW);
        labelPercent.setOpaque(true);
        labelPercent.setHorizontalAlignment(JLabel.CENTER);
        labelPercent.setPreferredSize(new Dimension(100,row_height));
        gbc.gridheight = 2;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(labelPercent, gbc);

        labelHours = new JLabel("Hours");
        labelHours.setBackground(Color.GRAY);
        labelHours.setOpaque(true);
        labelHours.setHorizontalAlignment(JLabel.CENTER);
        labelHours.setPreferredSize(new Dimension(100,row_height));
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(labelHours, gbc);

        for(int i=3;i<6;i++) {
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.gridx = i;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            oHour = new JLabel("200");
            oHour.setBackground(Color.GREEN);
            oHour.setPreferredSize(new Dimension(100, row_height));
            oHour.setOpaque(true);
            oHour.setHorizontalAlignment(JLabel.CENTER);
            add(oHour, gbc);
        }
    }
}

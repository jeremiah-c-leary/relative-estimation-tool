
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import java.text.*;

import javax.swing.*;


public class MainFrame extends JFrame {

    private JLabel labelTask;
    private JLabel labelDescription;
    private JLabel labelPercent;
    private JLabel labelHours;
    private JFormattedTextField hourCell;
    private static int row_height = 20;
    
    private int numHours = 0;
    private NumberFormat hourFormat;
    private JFormattedTextField hourField;

    public MainFrame() {
        super("Relative Estimation Tool");

        setLayout(new GridBagLayout());

        paintHeader();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void paintHeader() {
        paintTask();
        paintDescription();
        paintPercent();
        paintHours(); 
    }

    private void paintTask() {
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
    }

    private void paintDescription() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelDescription = new JLabel("Description");
        labelDescription.setBackground(Color.RED);
        labelDescription.setOpaque(true);
        labelDescription.setPreferredSize(new Dimension(500,row_height));
        gbc.gridheight = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(labelDescription, gbc);
    }

    private void paintPercent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
    }

    private void paintHours() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
            hourCell = new JFormattedTextField(hourFormat);
            hourCell.setValue(Integer.valueOf(numHours));
            hourCell.setColumns(10);
            hourCell.setBackground(Color.GREEN);
            hourCell.setPreferredSize(new Dimension(100, row_height));
            hourCell.setOpaque(true);
            hourCell.setHorizontalAlignment(JLabel.CENTER);
            add(hourCell, gbc);
        }
    }
}

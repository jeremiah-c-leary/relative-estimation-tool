
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import java.text.*;
import java.util.ArrayList;

import javax.swing.*;


public class MainFrame extends JFrame {

    private JLabel labelTask;
    private JLabel labelDescription;
    private JLabel labelPercent;
    private JLabel labelHours;
    private static int row_height = 20;

    ArrayList<Integer> numHours = new ArrayList<Integer>();
    private NumberFormat hourFormat;
    private JFormattedTextField hourCell;

    private NumberFormat nameFormat;
    private JFormattedTextField nameCell;
    private NumberFormat descriptionFormat;
    private JFormattedTextField descriptionCell;
    private NumberFormat percentFormat;
    private JFormattedTextField percentCell;
    private JLabel labelCell;

    private Task topTask;

    public MainFrame() {
        super("Relative Estimation Tool");
        setLayout(new GridBagLayout());

        initializeHours();

        paintHeader();

        topTask = new Task();
        topTask.setPercent(100);
        topTask.setName("Enter Task Name");
        topTask.setDescription("Enter Task Description");
        topTask.setHours(numHours);

        paintRows();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void initializeHours() {
        numHours.add(0);
        numHours.add(0);
        numHours.add(0);
        numHours.add(0);
    }

    private void paintRows() {

        ArrayList<Task> allTasks = new ArrayList<Task>(topTask.getRecursiveSubtasks());
        for(int i=0;i<allTasks.size();i++) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridheight = 1;
            gbc.gridx = 0;
            gbc.gridy = i + 2;
 
            nameCell = new JFormattedTextField(nameFormat); 
            nameCell.setBackground(Color.PINK);
            nameCell.setOpaque(true);
            nameCell.setPreferredSize(new Dimension(200,row_height));
            nameCell.setValue(allTasks.get(i).getName());
            add(nameCell, gbc);

            descriptionCell = new JFormattedTextField(nameFormat); 
            descriptionCell.setBackground(Color.PINK);
            descriptionCell.setOpaque(true);
            descriptionCell.setPreferredSize(new Dimension(500,row_height));
            descriptionCell.setValue(allTasks.get(i).getDescription());
            gbc.gridx = 1;
            gbc.gridy = i + 2;
            add(descriptionCell, gbc);

            percentCell = new JFormattedTextField(nameFormat); 
            percentCell.setBackground(Color.PINK);
            percentCell.setOpaque(true);
            percentCell.setPreferredSize(new Dimension(100,row_height));
            percentCell.setValue(allTasks.get(i).getPercent());
            gbc.gridheight = 1;
            gbc.gridx = 2;
            gbc.gridy = i + 2;
            add(percentCell, gbc);

            ArrayList<Integer> myHours = new ArrayList<Integer>(allTasks.get(i).getCalculatedHours());

            for(int j=0;j<myHours.size();j++) {
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.gridx = j + 3;
                gbc.gridy = i + 2;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                labelCell = new JLabel(Integer.toString(myHours.get(j)));
                labelCell.setBackground(Color.PINK);
                labelCell.setOpaque(true);
                labelCell.setHorizontalAlignment(JLabel.CENTER);
                labelCell.setPreferredSize(new Dimension(100, row_height));
                add(labelCell, gbc);
            }
        }
    }

//*****************************************************************************
// Header methods
//*****************************************************************************

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
        gbc.gridwidth = numHours.size();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(labelHours, gbc);

        for(int i=0;i<numHours.size();i++) {
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.gridx = i + 3;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            hourCell = new JFormattedTextField(hourFormat);
            hourCell.setValue(numHours.get(i));
            hourCell.setColumns(10);
            hourCell.setBackground(Color.GREEN);
            hourCell.setPreferredSize(new Dimension(100, row_height));
            hourCell.setOpaque(true);
            hourCell.setHorizontalAlignment(JLabel.CENTER);
            add(hourCell, gbc);
        }
    }
}

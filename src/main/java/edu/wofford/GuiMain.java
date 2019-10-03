package edu.wofford;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMain extends JFrame implements ActionListener {
    private JButton buttons1;
    private JButton buttons2;
    private JButton buttons3;
    private JButton buttons4;
    private JButton buttons5;
    private JButton buttons6;
    private JButton buttons7;
    private JButton buttons8;
    private JButton buttons9;
    private int changeTurns = 0;
    private JLabel topLabel;
    private int fullBoard = 0;


    public void actionPerformed(ActionEvent event) {

        JButton buttonClicked = (JButton) event.getSource();
        if (changeTurns % 2 == 0) {
            buttonClicked.setText("X");
            buttonClicked.setEnabled(false);
        } else {
            buttonClicked.setText("O");
            buttonClicked.setEnabled(false);
        }
        if(winningCondition()) {
            if ((changeTurns) % 2 == 0) {
                topLabel.setText("X wins");
            } else{
                topLabel.setText("O wins");
            }
            buttons1.setEnabled(false);
            buttons2.setEnabled(false);
            buttons3.setEnabled(false);
            buttons4.setEnabled(false);
            buttons5.setEnabled(false);
            buttons6.setEnabled(false);
            buttons7.setEnabled(false);
            buttons8.setEnabled(false);
            buttons9.setEnabled(false);
        }
        if (fullBoard == 8){
            topLabel.setText("Tie");
        }
        changeTurns++;
        fullBoard ++;
    }

    private boolean winningCondition(){
        String clicked;
        if (changeTurns % 2 == 0) {
            clicked = "X";
        } else {
            clicked = "O";
        }
        return ((buttons1.getText().equals(clicked) && buttons2.getText().equals(clicked) && buttons3.getText().equals(clicked)) ||
                (buttons4.getText().equals(clicked) && buttons5.getText().equals(clicked) && buttons6.getText().equals(clicked)) ||
                (buttons7.getText().equals(clicked) && buttons8.getText().equals(clicked) && buttons9.getText().equals(clicked)) ||
                (buttons1.getText().equals(clicked) && buttons4.getText().equals(clicked) && buttons7.getText().equals(clicked)) ||
                (buttons2.getText().equals(clicked) && buttons5.getText().equals(clicked) && buttons8.getText().equals(clicked)) ||
                (buttons3.getText().equals(clicked) && buttons6.getText().equals(clicked) && buttons9.getText().equals(clicked)) ||
                (buttons1.getText().equals(clicked) && buttons5.getText().equals(clicked) && buttons9.getText().equals(clicked)) ||
                (buttons3.getText().equals(clicked) && buttons5.getText().equals(clicked) && buttons7.getText().equals(clicked)));
    }

    public GuiMain() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topLabel = new JLabel();
        topLabel.setName("result");
        JPanel topPanel = new JPanel();

        topPanel.add(topLabel);
        add(topPanel, BorderLayout.NORTH);

        buttons1 = new JButton();
        buttons1.setName("location00");
        buttons1.addActionListener(this);

        buttons2 = new JButton();
        buttons2.setName("location01");
        buttons2.addActionListener(this);

        buttons3 = new JButton();
        buttons3.setName("location02");
        buttons3.addActionListener(this);

        buttons4 = new JButton();
        buttons4.setName("location10");
        buttons4.addActionListener(this);

        buttons5 = new JButton();
        buttons5.setName("location11");
        buttons5.addActionListener(this);

        buttons6 = new JButton();
        buttons6.setName("location12");
        buttons6.addActionListener(this);

        buttons7 = new JButton();
        buttons7.setName("location20");
        buttons7.addActionListener(this);

        buttons8 = new JButton();
        buttons8.setName("location21");
        buttons8.addActionListener(this);

        buttons9 = new JButton();
        buttons9.setName("location22");
        buttons9.addActionListener(this);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3));

        centerPanel.add(buttons1);
        centerPanel.add(buttons2);
        centerPanel.add(buttons3);
        centerPanel.add(buttons4);
        centerPanel.add(buttons5);
        centerPanel.add(buttons6);
        centerPanel.add(buttons7);
        centerPanel.add(buttons8);
        centerPanel.add(buttons9);
        add(centerPanel);

        pack();
        setSize(500, 500);
    }

    public static void main(String[] args) {
        GuiMain window = new GuiMain();
        window.setVisible(true);
    }
}
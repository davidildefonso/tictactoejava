package com.tictactoe;
import java.awt.*;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tttGame extends JPanel {
    char playerMark = 'X';
    JButton[] buttons = new JButton[9];

    public tttGame(){
        setLayout(new GridLayout(3,3));
        initializeButtons();
    }

    public void initializeButtons(){
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(new Font(
                    "Arial",
                    Font.PLAIN,
                    40
            ));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   JButton buttonClicked = (JButton) e.getSource();
                   buttonClicked.setText(String.valueOf(playerMark));



                   if(playerMark == 'X'){
                       playerMark = 'O';
                       buttonClicked.
                        setBackground(Color.CYAN);
                   }else{
                       playerMark = 'X';
                       buttonClicked.
                               setBackground(Color.ORANGE);
                   }
                   displayWinner();
                }
            });

            add(buttons[i]);
        }
    }

    public void displayWinner(){
        if(checkForWinner()){
            playerMark = playerMark == 'X' ? 'O' : 'X';
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.
                    showConfirmDialog(pane, "Gamer Over. '" +
                            playerMark + "' wins. Would" +
                            "you like to play again?",
                            "Game Over.",
                            JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                resetTheButtons();
            }else System.exit(0);
        }else if(checkDraw()){
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(
                    pane,
                    "Draw. Play again?",
                    "Game Over.",
                    JOptionPane.YES_NO_OPTION
            );
            if(dialogResult == JOptionPane.YES_OPTION){
                resetTheButtons();
            }else System.exit(0);
        }
    }

    public void resetTheButtons(){
        playerMark = 'X';
        for(int i=0; i<9; i++){
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
        }
    }

    public boolean checkDraw(){
        for(int i= 0; i< 9; i++){
            if(buttons[i].getText().charAt(0) == ' '){
                return false;
            }

        }
        return true;
    }

    public boolean checkForWinner(){
        if(checkRows() || checkColumns() || checkDiagonals()){
            return true;
        }
        return false;
    }

    public  boolean checkRows(){
        int i= 0;
        for(int j= 0; j < 3 ; j++){
            if(buttons[i].getText().equals(buttons[i +1].getText())
            && buttons[i].getText().equals(buttons[i+2].getText())
            && buttons[i].getText().charAt(0) != ' '){
                return true;
            }
            i+=3;
        }
        return false;
    }

    public  boolean checkColumns(){
        int i= 0;
        for(int j= 0; j < 3 ; j++){
            if(buttons[i].getText().equals(buttons[i + 3].getText())
                    && buttons[i].getText().equals(buttons[i+ 6].getText())
                    && buttons[i].getText().charAt(0) != ' '){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean checkDiagonals(){
        if(buttons[0].getText().equals(buttons[4].getText())
        && buttons[0].getText().equals(buttons[8].getText())
        && buttons[0].getText().charAt(0) != ' '){
            return true;
        }else if(buttons[2].getText().equals(buttons[4].getText())
                && buttons[2].getText().equals(buttons[6].getText())
                && buttons[2].getText().charAt(0) != ' '){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new tttGame());
        window.setBounds(500, 500 ,500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }


}

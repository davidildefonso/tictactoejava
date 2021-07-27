package com.tictactoe;
import java.util.Scanner;

public class Main {

    static char[][] board;

    public void ticTacToe(){
        System.out.println("Game is starting, " +
                "initializing the board!");
        board = new char[3][3];
        int n = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Character.forDigit(n, 10);
                n++;
            }
        }
    }


    static char playerMark = 'X';

    public void printBoard(){
        System.out.println("_______________");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("_______________");

        }
    }

    public void printCurrentMark() {
        System.out.println("Current player mark is: " + playerMark);
    }

    public void setMark(int positionRow, int positionColumn) {
        if(board[positionRow][positionColumn] == 'X'
        || board[positionRow][positionColumn] == 'O'){
            System.out.println("that place is already taken." +
                    "Please select other");
            System.out.println("This is the current board:");
            printBoard();
        }else{
            System.out.println("setting the " + playerMark
                    + " player mark");
            board[positionRow][positionColumn] = playerMark;
            playerMark = playerMark == 'X' ? 'O' : 'X';
            printBoard();
           // printCurrentMark();
        }
    }

    public boolean checkForWinner(){
        if(checkRows() || checkColumns()
        || checkDiagonals()) return true;
        return false;
    }

    public boolean checkRows(){
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == board[i][1] &&
            board[i][1] == board[i][2]) return true;
        }
        return false;
    }

    public boolean checkColumns(){
        for (int i = 0; i < board.length; i++) {
            if(board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) return true;
        }
        return false;
    }

    public boolean checkDiagonals(){
        if(board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) return true;
        if(board[2][0] == board[1][1] &&
                board[1][1] == board[0][2]) return true;
        return false;
    }

    public static void main(String[] args) {
        Main ttt = new Main();
        ttt.ticTacToe();
        ttt.printBoard();
        Scanner scanner = new Scanner(System.in);
        while(!ttt.checkForWinner()){
            System.out.println("Player '"+ playerMark +
                    "' turn");
            System.out.println("select a position: ");
            String position = scanner.nextLine();
            switch (position){
                case "1":
                    ttt.setMark(0,0);
                    break;
                case "2":
                    ttt.setMark(0,1);
                    break;
                case "3":
                    ttt.setMark(0,2);
                    break;
                case "4":
                    ttt.setMark(1,0);
                    break;
                case "5":
                    ttt.setMark(1,1);
                    break;
                case "6":
                    ttt.setMark(1,2);
                    break;
                case "7":
                    ttt.setMark(2,0);
                    break;
                case "8":
                    ttt.setMark(2,1);
                    break;
                case "9":
                    ttt.setMark(2,2);
                    break;

            }
        }

        System.out.println("Win!");
        char winner = playerMark == 'X' ? 'O' : 'X';
        System.out.println("the winner is player '" +
                winner + "'!");

    }

}



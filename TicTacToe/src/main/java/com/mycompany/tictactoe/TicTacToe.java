/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tictactoe;

/**
 *
 * @author s1500057
 */
import java.util.*;

public class TicTacToe{

  public static void main(String[] args)
  {
      try (Scanner sc = new Scanner(System.in)) {
          //add 2dimensional array board/grid
          char[][] board = {{' ' , ' ' , ' '},
              {' ' , ' ' , ' '},
              {' ' , ' ' , ' '}};
          
          drawBoard(board);//print out the board or grid from calling the method
          
          while(true){
              playerTurn(board, sc);
              isGameOver(board);
              drawBoard(board);
              compTurn(board);
              if(isGameOver(board)){
                  break;
              }
              drawBoard(board);
          }
      }
  }
    //computer turn to randomly choose a number between 1 and 9 
    public static void compTurn(char[][] board) {
        
        Random rand = new Random();
        int compTurn;
        while(true){
            compTurn = rand.nextInt(9)+1;//to get a number between 1 and 9 add 1
            
            //if the computer makes a move that is valid then break or leave the loop
            if(isValid( board, compTurn)){
                break;
            }
        }
        System.out.println("\n\nComputer chose " + compTurn);
        placeMove( board, Integer.toString(compTurn),'O');
    }
  //check for the available space and the position of the space then return false if space not found.
  public static boolean isValid(char[][] board,int pos) {
      return switch (pos) {
          case 1 -> board[0][0] == ' ';
          case 2 -> board[0][1] == ' ';
          case 3 -> board[0][2] == ' ';
          case 4 -> board[1][0] == ' ';
          case 5 -> board[1][1] == ' ';
          case 6 -> board[1][2] == ' ';
          case 7 -> board[2][0] == ' ';
          case 8 -> board[2][1] == ' ';
          case 9 -> board[2][2] == ' ';
          default -> false;
      };
  
       }
      
  
    //Player turn to play a number
    public static void playerTurn(char[][] board, Scanner sc) {
        int num;
        while(true){
            System.out.print("Enter your position (1-9): ");
            num = sc.nextInt();
            //check for the number, validate
            if(isValid(board, num)){
                break;
                
            }else{
                System.out.println(num + " is not valid, enter valid move.");//tell the user the number entered not valid
            }
        }
        placeMove(board,Integer.toString(num), 'X');//player uses an X charactor when placing a move
    }
    
    //want to know which position and the charactor  is X or O.
    public static void placeMove(char[][] board, String pos, char par) {
        //assign a charactor to each number the player or computer chooses.
        switch(pos){ 
            case "1" -> board[0][0] = par;
            case "2" -> board[0][1] = par;
          
            case "3" -> board[0][2] = par;
          
            case "4" -> board[1][0] = par;
            case "5" -> board[1][1] = par;
            case "6" -> board[1][2] = par;
            case "7" -> board[2][0] = par;
            case "8" -> board[2][1] = par;
            case "9" -> board[2][2] = par;           
        }
    }

    public static void drawBoard(char[][] board) {
        //print first row and columns 3 x 3 with a separator as dashes between rows
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
        System.out.println("------");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
        System.out.println("------");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");
        
    }
    
    //check whether the game is finished/over
    public static boolean isGameOver(char[][] board) {
        //check for the winner if whether is a player 'X' or Computer 'O'
        if(hasWon(board, 'X')){
            drawBoard(board);
            System.out.println("You win!");
            return true;
        }
        
        if(hasWon(board, 'O')){
            drawBoard(board);
            System.out.println("Computer win!");
            return true;
        }
      //loop through the rows and columns to check for an empty block/space in a board
      for (char[] board1 : board) {
          for (int j = 0; j < board1.length; j++) {
              if (board1[j] == ' ') {
                  return false;
              }
          }
      }
        drawBoard(board);
        System.out.println("It is a tie!");
        return true;
    }

    //check for who won the game by checking each row, column and diagonal check
    public static boolean hasWon(char[][] board,char par) {
        
        return (board[0][0] == par && board[0][1] == par && board[0][2] == par)||
                (board[1][0] == par && board[1][1] == par && board[1][2] == par)||
                (board[2][0] == par && board[2][1] == par && board[2][2] == par)||
                
                (board[0][0] == par && board[1][0] == par && board[2][0] == par)||
                (board[0][1] == par && board[1][1] == par && board[2][1] == par)||
                (board[0][2] == par && board[1][2] == par && board[2][2] == par)||
                
                (board[0][0] == par && board[1][1] == par && board[2][2] == par)||
                (board[0][2] == par && board[1][1] == par && board[2][0] == par);
    }
    
}
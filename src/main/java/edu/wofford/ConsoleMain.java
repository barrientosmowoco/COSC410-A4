package edu.wofford;


import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicTacToeModel game = new TicTacToeModel();
		int row;
		int col;
		while (game.getResult() == TicTacToeModel.Result.NONE) {
			System.out.println("Player x starts. Whats your input. Row and then Col:");
			row = keyboard.nextInt();
			col = keyboard.nextInt();
			game.setMarkAt(row,col);
			System.out.println(game.toString());
		}
		if (game.getResult() == TicTacToeModel.Result.OWIN){
			System.out.println("O wins");
		}
		else if (game.getResult() == TicTacToeModel.Result.XWIN){
			System.out.println("X wins");
		}
		else if (game.getResult() == TicTacToeModel.Result.TIE){
			System.out.println("Tie");
		}
	}
}
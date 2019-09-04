package connect4;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		State s = new State();
		long testB = State.stringToLong("0000000" +
				 						"0000000" +
				 						"0000000" +
				 						"0000000" +
				 						"0000000" +
				 						"0000000" +
										"0000000");
		
		s.setMask(State.stringToLong("0000000" +
									 "0000000" +
									 "0000011" +
									 "0000111" +
									 "0000000" +
									 "0000000" +
									 "0000001"));
		
		s.setP1(State.stringToLong(  "0000000" +
				 					 "0000000" +
				 					 "0000010" +
				 					 "0000001" +
				 					 "0000000" +
				 					 "0000000" +
									 "0000001"));
		s.setMoves(6);
		
		//s.printBoard();
		System.out.println();
		//s.place(6).place(3).printBoard();
		//System.out.println(State.fourInARow(testB));
		playGame();
	}
	
	public static void playGame() {
		Scanner keyboard = new Scanner(System.in);
		State curState = new State();
		curState.printBoard();
		
		while (!curState.gameOver()) {
			if (curState.isP1Turn()) {
				System.out.println("Player 1 turn:");
			} else {
				System.out.println("Player 2 turn:");
			}
			curState = curState.place(keyboard.nextInt()-1);
			curState.printBoard();
		}
		
		System.out.println("Game Over");
		keyboard.close();
	}

}

package connect4;

public class Main {

	public static void main(String[] args) {
		State s = new State();
		s.setMask(State.stringToLong("0000001" +
									 "0000000" +
									 "0000011" +
									 "0000111" +
									 "0000000" +
									 "0000000" +
									 "0000001"));
		
		s.setP1(State.stringToLong(  "0000000" +
				 					 "0000000" +
				 					 "0000010" +
				 					 "0000101" +
				 					 "0000000" +
				 					 "0000000" +
									 "0000001"));
		s.printBoard();
		System.out.println();
		s.place(3).printBoard();
	}

}

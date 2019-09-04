package connect4;

public class Main {

	public static void main(String[] args) {
		State s = new State();
		s.setMask(State.stringToLong("0000000" +
									 "1000000" +
									 "0000000" +
									 "1110000" +
									 "1100000" +
									 "0000000" +
									 "1000000"));
		
		s.setP1(State.stringToLong(  "0000000" +
				 					 "0000000" +
				 					 "0000000" +
				 					 "1010000" +
				 					 "0100000" +
				 					 "0000000" +
									 "1000000"));
		s.printBoard();

	}

}

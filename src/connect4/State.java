package connect4;

/**

.  .  .  .  .  .  .
5 12 19 26 33 40 47
4 11 18 25 32 39 46
3 10 17 24 31 38 45
2  9 16 23 30 37 44
1  8 15 22 29 36 43
0  7 14 21 28 35 42

**/

public class State {
	private static final int HEIGHT = 6;
	private static final int WIDTH = 7;
	//moves = number of pieces on the board
	private int moves;
	private long p1Pieces;
	private long mask;

	public State() {
		moves = 0;
		p1Pieces = 0L;
		mask = 0L;
	}

	public State(State old) {
		moves = old.moves;
		p1Pieces = old.p1Pieces;
		mask = old.mask;
	}
	
	//setters
	public void setP1(long l) {
		p1Pieces = l;
	}
	public void setMask(long l) {
		mask = l;
	}
	public void setMoves(int m) {
		moves = m;
	}
	
	public long p2Pieces() {
		return p1Pieces^mask;
	}
	public void addMove() {
		moves++;
	}
	public boolean isP1Turn() {
		return moves%2 == 0;
	}
	
	
	public static long bottomMask(int col) {
		return 1L << (col*(HEIGHT+1));
	}
	
	// columns start at 0
	public State place(int column) {
		State newS = new State(this);
		long newMask = mask | (mask + bottomMask(column));
		
		//if player 1's turn
		if (isP1Turn()) {
			newS.setP1(p1Pieces | (mask^newMask));
		}
		
		newS.setMask(newMask);

		
		newS.addMove();
		return newS;
	}
	
	public static boolean fourInARow(long b1) {
		//columns
		long b2 = b1 & (b1 << 2);
		if ((b2 & (b2 << 1)) != 0) {
			return true;
		}
		
		//rows
		b2 = b1 & (b1 << (HEIGHT+1)*2);
		if ((b2 & (b2 << (HEIGHT+1))) != 0) {
			return true;
		}
		
		// diagonal /
		b2 = b1 & (b1 << ((HEIGHT+1)*2+2));
		if ((b2 & (b2 << (HEIGHT+1)+1)) != 0) {
			return true;
		}
		
		//diagonal \
		b2 = b1 & (b1 << ((HEIGHT+1)*2-2));
		if ((b2 & (b2 << (HEIGHT+1)-1)) != 0) {
			return true;
		}
			
			
		return false;
	}
	
	public boolean gameOver() {
		return fourInARow(p1Pieces) || fourInARow(p2Pieces());
	}
	
	public static long stringToLong(String s) {
		long res = 0L;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				res ^= 1L << (s.length()-1-i);
			}
		}
		return res;
	}

	public static String longToString(long l) {
		String b = Long.toBinaryString(l);
		int x = b.length();
		for (int i = 0; i < (WIDTH*(HEIGHT+1))-x; i++) {
			b = '0' + b;
		}
		return b;
	}
	
	public void printBoard() {
		String p1 = longToString(p1Pieces);
		String p2 = longToString(p2Pieces());
		
		for (int i = HEIGHT-1; i >= 0; i--) {
			for (int j = 0; j < 7; j++) {
				if (p1.charAt((WIDTH*(HEIGHT+1)-1)-(i+7*j)) == '1') {
					System.out.print("o ");
				} else if (p2.charAt((WIDTH*(HEIGHT+1)-1)-(i+7*j)) == '1') {
					System.out.print("x ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}

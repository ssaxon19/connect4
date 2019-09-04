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
	private boolean p1Turn;
	private long p1Pieces;
	private long mask;

	public State() {
		p1Turn = true;
		p1Pieces = 0L;
		mask = 0L;
	}

	public State(State old) {
		p1Turn = old.p1Turn;
		p1Pieces = old.p1Pieces;
		mask = old.mask;
	}
	
	public void setP1(long l) {
		p1Pieces = l;
	}
	public void setMask(long l) {
		mask = l;
	}
	
	// columns start at 0
	public State place(int column) {
		State newS = new State(this);
		
		
		return newS;
	}
	
	public long p2Pieces() {
		return p1Pieces^mask;
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
		for (int i = 0; i < 49-x; i++) {
			b = '0' + b;
		}
		return b;
	}
	
	public void printBoard() {
		String p1 = longToString(p1Pieces);
		String p2 = longToString(p2Pieces());
		
		for (int i = HEIGHT-1; i >= 0; i--) {
			for (int j = 0; j < 7; j++) {
				if (p1.charAt(i+7*j) == '1') {
					System.out.print("o ");
				} else if (p2.charAt(i+7*j) == '1') {
					System.out.print("x ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}

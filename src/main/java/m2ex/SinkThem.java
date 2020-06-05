package m2ex;

import java.util.Arrays;
import java.util.Scanner;

public class SinkThem {
    static public final char SHIP = 'S';
    static public final char WRECK = 'W';
    static public final char MISS = 'M';
    static public final char EMPTY = '_';
    static public final char UNKNOWN = '?';

    static public final int POINTS_FOR_SINK = 5;
    static public final int POINTS_FOR_MISS = 1;

    /** the battlefield */
    private char[][] board;
    /** ships on board */
    private int counter;
    /** current player score */
    private int points;

    /**
     * Create the squared board game filled with EMPTY cells
     * 
     * @param dimension board size
     */
    public SinkThem(int dimension) {
       	if(dimension <= 0) {
       		throw new IllegalArgumentException("This dimension is not possible in this game");
       	}
       	this.points = 0;
        board = new char[dimension][dimension];
    }

    /**
     * @return the current score
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return true if no more ships
     */
    public boolean done() {
        return counter == 0;
    }

    /**
     * The board is a square
     * 
     * @return board size
     */
    public int getBoardSize() {
        return board.length;
    }

    /**
     * A user representation for the board
     * 
     * Only MISS and WRECK should be shown
     * 
     * UNKWNOWN should hide EMPTY and SHIP
     * 
     * @return a string
     */
    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				char cell = this.board[i][j];
				if(cell == MISS || cell == WRECK) {
					sb.append(cell);
				} else if(j == board.length - 1) {
					sb.append("\n");
				}
				else {
					sb.append(UNKNOWN);
				}
			}
		}
        return sb.toString();
    }

    /**
     * Place a ship on the board
     * 
     * @param row
     * @param col
     * @return false if it can't be placed
     */
    public boolean place(int row, int col) {
        if(row < this.getBoardSize() && col < this.getBoardSize()) {
        	this.board[row][col] = SHIP;
        	return true;
        }
        return false;
    }

    /**
     * Shoot to a cell
     * 
     * a miss would cost POINTS_FOR_MISS, a center would give POINTS_FOR_SINK
     * 
     * @param row
     * @param col
     * @return true for a sink
     */
    public boolean shoot(int row, int col) {
        if(row < this.getBoardSize() && col < this.getBoardSize()) {
        	if(this.board[row][col] == SHIP) {
        		this.board[row][col] = WRECK;
        		this.points += POINTS_FOR_SINK;
        		return true;
        	}
        	this.board[row][col] = MISS;
        	this.points -= POINTS_FOR_MISS;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(board);
    }

    /**
     * Apply a simple strategy to the game
     * 
     * @param st the game
     */
    public static void shootAll(SinkThem st) {
        for (int i = 0; i < st.getBoardSize(); i++) {
            for (int j = 0; j < st.getBoardSize(); j++) {
                System.out.println(st.getBoard());
                if (st.shoot(i, j)) {
                    System.out.println("Hit!");
                    if (st.done()) {
                        System.out.println("You win!");
                        return;
                    }
                } else {
                    System.out.println("Miss ...");
                }
            }
        }
    }

    public static int schermoMenu(Scanner in) {
    	System.out.println("+-------------------------------------------+");
    	System.out.println("+ 0. Esci                                   +");
    	System.out.println("+ 1. Inserisci dimensione board             +");
    	System.out.println("+ 2. Mostrami la board                      +");
    	System.out.println("+ 3. Mostra il punteggio1                   +");
    	System.out.println("+ 4. Shoot                                  +");
    	System.out.println("+ 5. Shoot All                              +");
    	System.out.println("+-------------------------------------------+");
    	int scelta = in.nextInt();
    	if(scelta > 0 || scelta < 6) {
    		return scelta;
    	} else {
    		return 0;
    	}
    }
    
    
    
    public static void main(String[] args) {
         //TODO: use Scanner for user interaction
    	System.out.println("Inserisci una dimensione valida");
    	Scanner scanner = new Scanner(System.in);
    	SinkThem st = null;
    	while(scanner.hasNext()) {
    		if(scanner.hasNextInt()) {
    			int dimension = scanner.nextInt();
    		    try {
    		    	st = new SinkThem(dimension);
    		    	break;
    		    } catch(IllegalArgumentException|NullPointerException e) {
    		    	e.printStackTrace();
    		    }
    		} else {
    			System.out.println("Non hai inserito un valore valido");
    			return;
    		}
    	}
        // TODO: let the player choose for a (sensible) board size
    	
        // TODO: place the ships randomly instead
        st.place(0, 2);
        st.place(1, 1);
        st.place(2, 0);

        // TODO: use Scanner instead
        System.out.println("Spara in un punto");
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la coordinata x");
        int x = sc.nextInt();
        System.out.println("Inserisci la coordinata y");
        int y = sc.nextInt();
        
        st.shoot(x, y);

        System.out.println(st.getBoard());
        System.out.println("You scored " + st.getPoints());
    }
}

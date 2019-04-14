import java.util.Random;
import java.util.Scanner;

public class CandyLand {
	
	public static void main(String[] args) {
		
		/*
		 * These are the local variables we need to play
		 */
		//1. Create a Board
		Board board = new Board();
		
		//2. Create 2 players
		Player player1 = new Player();
		Player player2 = new Player();
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		boolean continuePlay = true;
		
		//7. Play is continuous
		while(continuePlay) {
			//Player 1 turn
			System.out.println("My friend Player 1, press any key to generate your move" + "on the board");
			scan.nextLine();
			//3. Generate a random number between 1 and 18 for player to move
			int moveSpaces = generator.nextInt(18) + 1;
			//4. using board's move method move the player to their new location
			Square newSquare = board.move(player1.getBoardLocation(), moveSpaces);
			player1.setBoardLocation(newSquare.getBoardLocation());
			//5. announce the color and location of the square the player has landed on
			System.out.println("Hello Player 1, you are now on a " + newSquare.getColor() + " square at location " + player2.getBoardLocation()
			+ " on the board");
			//check if player has won
			if (player1.getBoardLocation() == board.END_OF_BOARD) {
				break;
			}
			
			//Repeat above steps for player 2
			System.out.println("Player 2, press any key to generate your move "
					+ "on the board");
			scan.hasNextLine();
			moveSpaces = generator.nextInt(18) + 1;
			newSquare = board.move(player2.getBoardLocation(), moveSpaces);
			player2.setBoardLocation(newSquare.getBoardLocation());
			System.out.println("Player 2, you are on a " + newSquare.getColor() 
			+ " square at location " + player2.getBoardLocation() + " on the board");
			if (player2.getBoardLocation() == board.END_OF_BOARD) {
				break;
			}
		}
		//8. Announce winner
		System.out.println("Lucky Dog! You've reached the end of the board,lol");
		scan.close();
		
	}

}

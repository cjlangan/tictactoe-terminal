
import java.util.*;
import java.io.*;

public class TicTac{
	public static void main(String args[]){
		
		char grid[] = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
		char playerChar;
		boolean gameOn = true;
		int gameLoop = 0;
		
		// Printing Initial Grid
		for(int i = 0; i < 9; i++){
			System.out.print(grid[i] + " ");
			if((i + 1) % 3 == 0) System.out.println();
		}		

		while(gameOn){

		// Taking user input
		if(gameLoop % 2 == 0) playerChar = 'X';
		else playerChar = 'O';

		System.out.print("Player " + playerChar + ". Type a number 1-9 to choose a box.  ");

		boolean isValid = false;
		Scanner scan = new Scanner(System.in);

		while(!isValid){
			int input = scan.nextInt();

			if(input >= 1 && input <= 9){
				if(grid[input - 1] == '-'){
					isValid = true;
					grid[input - 1] = playerChar;
				}
				else System.out.print("That box is already taken.  ");
			}
			else System.out.print("The number must be within 1-9.  ");
		}
		
		// Printing Grid
		for(int i = 0; i < 9; i++){
			System.out.print(grid[i] + " ");
			if((i + 1) % 3 == 0) System.out.println();
		}		

		// Checking for a win
		boolean isWin = false;

		for(int i = 0; i <= 6 && !isWin; i += 3){
			if((grid[i] == 'X' || grid[i] == 'O') && grid[i] == grid[i + 1] && grid[i] == grid[i + 2])
				isWin = true;
		}
		for(int i = 0; i <= 2 && !isWin; i++){
			if((grid[i] == 'X' || grid[i] == 'O') && grid[i] == grid[i + 3] && grid[i] == grid[i + 6])
				isWin = true;
		}
		if(!isWin){
			if((grid[4] == 'X' || grid[4] == 'O') && ((grid[0] == grid[4] && grid[0] == grid[8]) || (grid[2] == grid[4] && grid[4] == grid[6])))
				isWin = true;
		}
		
		// Ending Game
		if(isWin){
			System.out.print("Player " + playerChar + " wins!");	
			gameOn = false;
		}
		if(++gameLoop == 9){
			System.out.print("Tie Game.");
			gameOn = false;
		}
		}
	}
}

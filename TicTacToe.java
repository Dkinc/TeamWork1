import java.util.Scanner;

public class TicTacToe {
	static void fillPlace(char[][] masiv, char fill, int vert, int hor) {
		
			masiv[vert][hor] = fill;
	}

	static boolean isFree(char[][] masiv, int vert, int hor) {
		if (masiv[vert][hor] == '0' || masiv[vert][hor] == 'X') {
			return false;
		} else {
			return true;
		}
	}


	static boolean horizontal(char[][] masiv,int []victory) {
		for (int br = 0; br <= masiv.length - 1; br++) {
			if (compareThree(masiv[br][0], masiv[br][1], masiv[br][2],victory) == true) {
				return true;
			}
		}
		return false;
	}

	static boolean vertical(char[][] masiv,int []victory) {
		for (int bro = 0; bro <= masiv[0].length - 1; bro++) {

			if (compareThree(masiv[0][bro], masiv[1][bro], masiv[2][bro],victory) == true) {
				return true;
			}
		}
		return false;
	}
	static boolean diagonals(char[][] masiv,int []victory) {
		if (compareThree(masiv[0][0],masiv [1][1],masiv [2][2],victory)==true ||compareThree(masiv[0][2],masiv[1][1],masiv[2][0],victory)==true){
			return true;
		}
		else{
			return false;
		}
		
	}
	static boolean draw (char[][] masiv){
		for (int br=0; br<=masiv.length-1;br++){
			for (int bro=0; bro<=masiv [0].length-1; bro++){
				if (masiv[br][bro]!='0' && masiv [br][bro]!='X'){
					return false;
				}
			}
		}
		return true;
	}
	static boolean gameOver(char[][] masiv, int []victory){
		if( horizontal(masiv,victory)==true || vertical(masiv,victory)==true || diagonals(masiv,victory)==true || draw(masiv)==true){
			return true;
		}
		else{
			return false;
		}
	}

	static boolean compareThree(char a, char b, char c,int []victory) {
		if (a == '0' && b == '0' && c == '0' ){
			victory [0]=2;
			return true;
		}
		if( a == 'X' && b == 'X' && c == 'X') {
			victory [0]=1;
			return true;
		}
		
		
			return false;
		}
	static void printBoard(char [][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		char[][] masiv = new char[3][3];
		Scanner potr = new Scanner(System.in);
		int playerVert = 0;
		int playerHor = 0;
		char tic= 'X';
		char tac ='0';
		int []victory =new int[2];
		
		while(gameOver(masiv,victory)==false){
			System.out.println("Player1 enter coordinates of a square:");
			printBoard(masiv);
			playerVert=potr.nextInt()-1;
			playerHor=potr.nextInt()-1;
			if((playerVert < 0 || playerVert > 3) || (playerHor < 0 || playerHor > 3)){
				System.out.println("Invalid cordinats");
				return;
			}
			while (isFree(masiv,playerVert,playerHor)==false){
				System.out.println("The square you chose is already taken. Choose another square:");
				playerVert=potr.nextInt()-1;
				playerHor=potr.nextInt()-1;
			}
			fillPlace(masiv,tic,playerVert, playerHor);
			if (gameOver(masiv,victory)==true){
				break;
			}
			System.out.println("Player2 enter coordinates of a square:");
			printBoard(masiv);
			playerVert=potr.nextInt()-1;
			playerHor=potr.nextInt()-1;
			if((playerVert < 0 || playerVert > 3) || (playerHor < 0 || playerHor > 3)){
				System.out.println("Invalid cordinats");
				return;
			}
			while (isFree(masiv,playerVert,playerHor)==false){
				System.out.println("The square you chose is already taken. Choose another square:");
				playerVert=potr.nextInt()-1;
				playerHor=potr.nextInt()-1;
			}
			fillPlace(masiv,tac,playerVert, playerHor);
			}
		if (draw(masiv)==true){
			System.out.println("The game is a draw.");
		}
		else{
			System.out.println("Player "+victory[0]+" wins!Congrats!");
		}
		

	}

}

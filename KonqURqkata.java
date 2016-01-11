import java.util.Scanner;

public class KonqURqkata {

	static boolean isFree(char[][] masiv, int vert, int hor) {
		if (vert >= 0 && vert <= masiv.length - 1 && hor >= 0 && hor <= masiv[0].length - 1
				&& masiv[vert][hor] == ' ') {

			return true;

		} else {

			return false;
		}
	}

	static void fillDot(char[][] masiv, int vert, int hor) {
		masiv[vert][hor] = '.';
	}

	static boolean oneDirection(char[][] masiv, int vert, int hor) {
		fillDot(masiv, vert, hor);
		if (isFree(masiv, vert - 2, hor - 1) == true && oneDirection(masiv, vert - 2, hor - 1) == true) {
			return true;
		}
		if (isFree(masiv, vert - 2, hor + 1) && oneDirection(masiv, vert - 2, hor + 1)) {
			return true;
		}
		if (isFree(masiv, vert - 1, hor + 2) && oneDirection(masiv, vert - 1, hor + 2)) {
			return true;
		}
		if (isFree(masiv, vert + 1, hor + 2) && oneDirection(masiv, vert + 1, hor + 2)) {
			return true;
		}
		if (isFree(masiv, vert + 2, hor - 1) == true && oneDirection(masiv, vert + 2, hor - 1)) {
			return true;
		}
		if (isFree(masiv, vert + 2, hor + 1) == true && oneDirection(masiv, vert + 2, hor + 1) == true) {
			return true;
		}
		if (isFree(masiv, vert - 1, hor - 2) == true && oneDirection(masiv, vert - 1, hor - 2) == true) {
			return true;
		}
		if (isFree(masiv, vert + 1, hor - 2) == true && oneDirection(masiv, vert + 1, hor - 2) == true) {
			return true;
		}
		return false;
	}

	static void inPut(char[][] masiv) {
		for (int br = 0; br <= masiv.length - 1; br++) {
			for (int bro = 0; bro <= masiv.length - 1; bro++) {
				masiv[br][bro] = ' ';
			}
		}
	}

	public static void main(String[] args) {
		Scanner potr = new Scanner(System.in);
		System.out.println("Enter the dimentions of the chessboard:");
		int vert = potr.nextInt();
		int hor = potr.nextInt();
		if(vert <= 0){
			System.out.println("Invalid dimention");
		}
		if(hor <= 0){
			System.out.println("Invalid dimention");
		}
		else{
		char[][] chess = new char[vert][hor];
		inPut(chess);
		System.out.println("Enter the coordinates of the starting point:");
		int startVert = potr.nextInt();
		int startHor = potr.nextInt();
		if(startVert < 0 || startHor < 0 || startHor >= hor || startVert >= vert){
			System.out.println("Invalid Starting Point");
		}
		else{
		oneDirection(chess, startVert, startHor);
		for (int br = 0; br <= chess.length - 1; br++) {
			for (int bro = 0; bro <= chess[0].length - 1; bro++) {
				System.out.print(chess[br][bro] + " ");
			}
			System.out.println();
		}
		}
		}

	}

}

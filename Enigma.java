import java.util.Scanner;

public class Enigma {
	static int findHorizontal (char f, char [][]tablica){
		for (int br=0; br<=tablica.length-1; br++){
			for (int bro=0; bro<=tablica[0].length-1; bro++){
				if (tablica [br][bro]==f){
					return bro;
					
				}
			}
			
		}
		return 0;
		
	}
	static int findVertical (char f, char [][]tablica){
		for (int br=0; br<=tablica.length-1; br++){
			for (int bro=0; bro<=tablica[0].length-1; bro++){
				if (tablica [br][bro]==f){
					return br;
					
				}
			}
			
		}
		return 0;
		
	}
	static int outOfBonds(int place, char [][]tablica){
		if (place>tablica.length-1){
			place=place-tablica.length;
		}
		if (place<0){
			place=place+tablica.length;
		}
		return place;
	}
	
	static String encrypt (StringBuilder mode, char [][] masiv){
		char [] phrase = new char[mode.length()];
		for(int br=0; br<=phrase.length-1;br++){
			phrase [br]= mode.charAt(br);
		}
		int ednoHor=0;
		int ednoVert=0;
		int dveHor=0;
		int dveVert=0;
		for (int bro=0; bro<=phrase.length-1; bro+=2){
			ednoVert= findVertical(phrase [bro],masiv);
			ednoHor = findHorizontal (phrase [bro],masiv);
			dveHor= findHorizontal (phrase [bro+1],masiv);
			dveVert = findVertical(phrase [bro+1],masiv);
			if (ednoVert!=dveVert && ednoHor!=dveHor){
				phrase [bro]=masiv[ednoVert][dveHor];
				phrase [bro+1]=masiv [dveVert][ednoHor];
				
			}
			else{
				if (ednoHor==dveHor){
					ednoVert=outOfBonds(ednoVert+1,masiv);
					phrase [bro]= masiv [ednoVert][ednoHor];
					dveVert =outOfBonds (dveVert+1,masiv);
					phrase [bro+1]=masiv [dveVert][dveHor];
				}
				if (ednoVert==dveVert){
					ednoHor=outOfBonds(ednoHor+1,masiv);
					phrase [bro]=masiv[ednoVert][ednoHor];
					dveHor=outOfBonds(dveHor+1,masiv);
					phrase [bro+1]=masiv [dveVert][dveHor];
				}
			}
		}
		String end = new String (phrase);
		return end;
		
		
	}
	static String decrypt (StringBuilder mode, char [][] masiv){
		char [] phrase = new char[mode.length()];
		for(int br=0; br<=phrase.length-1;br++){
			phrase [br]= mode.charAt(br);
		}
		int ednoHor=0;
		int ednoVert=0;
		int dveHor=0;
		int dveVert=0;
		for (int bro=0; bro<=phrase.length-1; bro+=2){
			ednoVert= findVertical(phrase [bro],masiv);
			ednoHor = findHorizontal (phrase [bro],masiv);
			dveHor= findHorizontal (phrase [bro+1],masiv);
			dveVert = findVertical(phrase [bro+1],masiv);
			if (ednoVert!=dveVert && ednoHor!=dveHor){
				phrase [bro]=masiv[ednoVert][dveHor];
				phrase [bro+1]=masiv [dveVert][ednoHor];
				
			}
			else{
				if (ednoHor==dveHor){
					ednoVert=outOfBonds(ednoVert-1,masiv);
					phrase [bro]= masiv [ednoVert][ednoHor];
					dveVert =outOfBonds (dveVert-1,masiv);
					phrase [bro+1]=masiv [dveVert][dveHor];
				}
				if (ednoVert==dveVert){
					ednoHor=outOfBonds(ednoHor-1,masiv);
					phrase [bro]=masiv[ednoVert][ednoHor];
					dveHor=outOfBonds(dveHor-1,masiv);
					phrase [bro+1]=masiv [dveVert][dveHor];
				}
			}
		}
		String end = new String (phrase);
		return end;
		
		
	}
	

	public static void main(String[] args) {
		char [][] masiv =  { {'C','Y','I','M','E'},
							{'T','H','O','D','R'},
							{'U','A','S','P','K'},
							{'F','L','G','V','W'},
							{'N','J','Q','B','X'}
	};
		Scanner potr= new Scanner(System.in);
		System.out.println("Enter a phrase:");
		String user = potr.nextLine();
		StringBuilder mode = new StringBuilder(user.toUpperCase());
		if (mode.length()%2!=0){
			mode.append('A');
		}
		boolean hasZ = false;
		for(int i = 0; i < mode.length(); i++){
			if(mode.charAt(i) != 'Z'){
				hasZ = true;
				break;
			}
		}
		if(hasZ){
			System.out.println("Please enter a word without the letter 'Z'");
		}
		else{
		String result = " ";
		result = encrypt(mode,masiv);
		System.out.println(result);
		StringBuilder end = new StringBuilder(result);
		String fin =" ";
		fin = decrypt(end,masiv);
		System.out.println(fin);
		}
		
		
		
		

}
}

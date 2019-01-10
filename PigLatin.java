import java.util.Scanner;

public class PigLatin {
    public static Scanner keyboard;

	public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        String repeat = "Yes"; //this is setting repeat to yes so the method will run at least one time
        while (repeat.equals("Yes") || repeat.equals("yes")) { //this while loop will keep running if the user wants to enter another sentence
            System.out.print("Enter your words here: ");
            String sentence = keyboard.nextLine();
            String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"); //splits the sentence up into the individual words in an array 
            //the above code also makes everything lower case and removes punctuation to make the result look better
            try {
            	System.out.println(translateSentenceIntoPigLatin(words));
            	System.out.println(" ");
                System.out.println("Would you like to translate another sentence? Please respond with either Yes or No");
                repeat = keyboard.nextLine();
            }
            catch (NoWordEnteredException e){
            	System.out.println("No words were entered. Would you like to try again? Please respond with either Yes or No");
            	repeat = keyboard.nextLine();	
            }
            
        }
	}
	
	public static int firstVowelInWord(String word) {
        for (int i = 0; i < word.length(); i++) {   
        if (word.charAt(i) == 'a' || word.charAt(i) == 'e'
            || word.charAt(i) == 'i' || word.charAt(i) == 'o'
            || word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i)=='E'
            || word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') {
            return i;
            }
        }
        return -1; //just need to return this for the case of there being no vowel in the word
    }
	
	public static String translateSentenceIntoPigLatin(String[] words) throws NoWordEnteredException {
		if (words.length == 0) {
			throw new NoWordEnteredException(words);
		}
		else {
			String pigLatin = "";
			for (String word: words) {
				int position = firstVowelInWord(word);
				if (position == 0) {
					pigLatin = pigLatin + " " + word + "way ";        	
					}
				else if (position == -1) {
					pigLatin = pigLatin + " " + word + " ";
					}
				else {
					String firstPart = word.substring(position);
					String secondPart = word.substring(0, position) + "ay ";
					pigLatin = pigLatin + " " + firstPart + secondPart;
         	}	
         }
			return pigLatin;
	}
}
}

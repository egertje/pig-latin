
public class NoWordEnteredException extends Exception {
	String[] emptySentence;
	
	NoWordEnteredException(String[] emptySentence) {
		this.emptySentence = emptySentence;
	}

}

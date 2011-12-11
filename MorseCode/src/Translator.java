import java.util.ArrayList;

public class Translator {
	private Dictionary dictionary = new Dictionary();
	private ArrayList<Code> code = dictionary.getDictionary();
	
	public Translator() {
	}

	public String decode(String input) {
		String[] seg = input.split("  ");
		String output = "";
		for (int i = 0; i < seg.length; i++) {
			for (int d = 0; d < code.size(); d++) {
				if (seg[i].contains(code.get(d).getSequence())) {
					output += code.get(d).getCharacter();
				}
			}
		}
		return output;
	}
	
	public String encode(String input) {
		input = input.toUpperCase();
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			for (int d = 0; d < code.size(); d++) {
				if (input.charAt(i) == code.get(d).getCharacter()) {
					output += code.get(d).getSequence();
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		new Translator();
	}
}
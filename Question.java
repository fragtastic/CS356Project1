import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Question {

	protected String question;
	protected String[] options;
	protected HashSet<Integer> correctAnswers;
	protected HashMap<String, int[]> answers;

	public Question(String question, String[] options) {
		this.question = question;
		this.correctAnswers = new HashSet<>();
		this.options = options;
		this.answers = new HashMap<>();
	}

	public abstract void answerQuestion(String student, int ... answers);
	
	public void displayQuestion() {
		System.out.println(question);
	}
	
	public void displayOptions() {
		for (int i = 0; i < options.length; i++) {
			System.out.println(i + ": " + options[i]);
		}
	}
	
	public int getNumberOfOptions() {
		return options.length;
	}
	
	public Set<Entry<Integer, Integer>> getAnswers() {
		HashMap<Integer, Integer> a = new HashMap<>();
		for (int[] e : answers.values()) {
			for (int i : e) {
				if (a.containsKey(i)) {
					a.put(i, a.get(i)+1);
				} else {
					a.put(i, 1);
				}
			}
		}
		return a.entrySet();
	}
	
	public String toString() {
		String output = "";
		output += question + '\n';
		for (int i = 0; i < options.length; i++) {
			output += i + ": " + options[i];
			if (i+1 < options.length) {
				output += '\n';
			}
		}
		return output;
	}
}
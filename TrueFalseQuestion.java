import java.util.Set;

public class TrueFalseQuestion extends Question {

	public TrueFalseQuestion(String question, int correctAnswer) {
		super(question, new String[]{"True", "False"});
	}
	
	public void answerQuestion(String studentId, int ... answers) {
		if (answers.length > 0) {
			this.answers.put(studentId, new int[]{answers[0]});
		}
	}
}
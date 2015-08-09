import java.util.Set;

public class SingleChoiceQuestion extends Question {

	public SingleChoiceQuestion(String question, int correctAnswer, String[] options) {
		super(question, options);
	}
	
	public void answerQuestion(String studentId, int ... answers) {
		if (answers.length > 0) {
			this.answers.put(studentId, new int[]{answers[0]});
		}
	}
}
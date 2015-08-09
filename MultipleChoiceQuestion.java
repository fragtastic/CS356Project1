import java.util.Set;

public class MultipleChoiceQuestion extends Question {

	public MultipleChoiceQuestion(String question, int[] correctAnswers, String[] options) {
		super(question, options);
	}
	
	public void answerQuestion(String studentId, int ... answers) {
		this.answers.put(studentId, answers);
	}
}
import java.util.ArrayList;
import java.util.Map.Entry;

public class IVoteService {

	private ArrayList<Question> questions;

	public IVoteService() {
		this.questions = new ArrayList<>();
	}
	
	public void displayAnswers(int questionNumber) {
		System.out.println("Answers");
		for (Entry<Integer, Integer> e : this.questions.get(questionNumber).getAnswers()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}
	
	public void answerQuestion(int questionNumber, String studentId, int[] answers) {
			questions.get(questionNumber).answerQuestion(studentId, answers);
	}
	
	public Question getQuestion(int questionNumber) {
		return this.questions.get(questionNumber);
	}
	
	public void displayQuestion(int questionNumber) {
		System.out.println("Question " + questionNumber + ": " + questions.get(questionNumber));
	}
	
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
	public int getNumberOfQuestions() {
		return questions.size();
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void addTrueFalseQuestion(String question, int correctAnswer) {
		this.questions.add(new TrueFalseQuestion(question, correctAnswer));
	}
	
	public void addSingleChoiceQuestion(String question, int correctAnswer, String ... options) {
		this.questions.add(new SingleChoiceQuestion(question, correctAnswer, options));
	}
	
	public void addMultipleChoiceQuestion(String question, int[] correctAnswers, String ... options) {
		this.questions.add(new MultipleChoiceQuestion(question, correctAnswers, options));
	}
}
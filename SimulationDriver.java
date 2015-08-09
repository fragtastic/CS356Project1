import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {

	private Random rng;
	private IVoteService ivs;
	private ArrayList<Student> students;

	public SimulationDriver() {
		this.rng = new Random();
		this.ivs = new IVoteService();
		this.students = new ArrayList<>();
	}
	
	public void run() {
		ivs.addTrueFalseQuestion("1 + 1 = 3", 1);
		ivs.addSingleChoiceQuestion("Which one does not belong.", 2, new String[]{"Horse", "Cat", "Whale", "Dog"});
		ivs.addMultipleChoiceQuestion("Choose all of the planets.", new int[]{0, 2, 3, 5}, new String[]{"Mars", "The Moon", "Venus", "Earth", "Pluto", "Jupiter"});

		populateStudents(this.rng.nextInt(100));

		for (int q = 0; q < ivs.getNumberOfQuestions(); q++) {
			int numberOfOptions = ivs.getQuestion(q).getNumberOfOptions();
			for (Student s : students) {
				ivs.answerQuestion(q, s.getStudentId(), this.getRandomAnswers(numberOfOptions));
			}
			ivs.displayQuestion(q);
			ivs.displayAnswers(q);
		}
	}
	
	private Student getRandomStudent() {
		return students.get(rng.nextInt(students.size()));
	}
	
	private int[] getRandomAnswers(int numberOfOptions) {
		int[] a = new int[numberOfOptions];
		for (int i = 0; i < a.length; i++) {
			a[i] = rng.nextInt(numberOfOptions);
		}
		return a;
	}
	
	private void populateStudents(int num) {
		for (int i = 0; i < num; i++) {
			this.students.add(new Student(generateStudentId(5)));
		}
		System.out.println("Created " + num + " students.");
	}
	
	public String generateStudentId(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static void main(String[] args) {
		SimulationDriver sd = new SimulationDriver();
		sd.run();
	}
}

public class QuizBank {
	
	private final int WAITING = 0;
	private final int PROBLEM = 1;
	private final int ANSWER = 2;
	private int state = WAITING;
	
	int currentProblem = 0;
	
	private String[] problems = {
									"네트워크 처리 패키지는?", 
									"서버쪽 소켓 클래스는?", 
									"인터넷에서 컴퓨터를 식별하는 주소는?"
									};
	
	private String[] answers = { "java.net", "ServerSocket", "IP주소" };
	
	public String process(String input) { // input = null, y or n, java.net, y
		
		String output = null;
		if(state == WAITING) {
			output = "퀴즈를 시작합니다.(y/n)";
			state = PROBLEM;
		}
		else if(state == PROBLEM) {
			if(input.equals("y")) {
				output = problems[currentProblem];
				state = ANSWER;
			}
			else {
				output = "QUIT";
				state = WAITING;
			}
		}
		else if(state == ANSWER) {
			if(input.equals(answers[currentProblem])) {
				output = "정답입니다. 계속하시겠습니까?(y/n)";
				state = PROBLEM;
			}
			else {
				output = "오답입니다. 계속하시겠습니까?(y/n)";
				state = PROBLEM;
			}
			
			currentProblem = (currentProblem+1) % 3;
		}
		
		return output;
	}
	
}

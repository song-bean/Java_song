import java.util.Calendar;

//java.util.Calendar
//protected Calendar() {
//
// }

public class Ex09_14_Calendar {
	public static void main(String[] args) {
		
		//new Calendar(); 왜 안될까?
	
		String[] week = {"","일","월","화","수","목","금","토"};
		Calendar cal = Calendar.getInstance();
		//System.out.println("cal:" + cal.toString());
		System.out.println("cal:" + cal);
		System.out.print(cal.get(Calendar.YEAR) + "년 ");
		System.out.print(cal.get(Calendar.MONTH)+1 + "월 "); // 1월이 0월로 나오기 때문에 1을 더해줘야 함(월만 그렇게 나옴)
		System.out.print(cal.get(Calendar.DATE) + "일 ");
		System.out.println();
		System.out.print(cal.get(Calendar.DAY_OF_WEEK) + "요일/"); // 일요일이 1임, 토요일은 7
		System.out.print(week[cal.get(Calendar.DAY_OF_WEEK)] + "요일"); // 일요일이 1임, 토요일은 7
		
		System.out.println();
		
		int am_pm = cal.get(Calendar.AM_PM); //오전은 0 오후는 1
		if(am_pm == 0) {
			System.out.print("오전 ");
		}
		else {
			System.out.print("오후 ");
		}
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(hour + "시 " + minute + "분 " + second + "초 입니다.");
		
	}

}

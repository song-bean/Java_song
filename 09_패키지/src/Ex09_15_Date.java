import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_15_Date {
	public static void main(String[] args) {
		
		Date now = new Date();
		//System.out.println("d:" + d.toString());
		System.out.println("now: " + now);
		
		System.out.println();
		System.out.print(now.getYear()+1900 + "년 "); // 기준이 1900년
		System.out.print(now.getMonth()+1 + "월 ");
		System.out.print(now.getDate() + "일 "); //일
		
		String[] week = {"일","월","화","수","목","금","토"};
		System.out.println(week[now.getDay()] + "요일"); //요일
		
		SimpleDateFormat sdf, sdf2, sdf3;
		sdf = new SimpleDateFormat("YY-MM-d일 E요일"); // 날짜의 형식을 지정하는 클래스
		System.out.println(sdf.format(now));
		
		// MM(달)과 mm(분)만 구별, 나머지는 대소문자 구분X, a는 오전/오후
		sdf2 = new SimpleDateFormat("yyyy/MM/DD hh:mm:ss a"); 
		System.out.println(sdf2.format(now));
		
		sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf3.format(now));
		
	}

}

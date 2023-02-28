import java.io.File;

public class Ex12_02_File {
	public static void main(String[] args) {
		
		File win = new File("/Users/songnayoung");
		System.out.println("win:" + win); //toString이 오버라이딩 되어있음
		
		boolean result1 = win.isDirectory(); // win이 폴더냐 --> 맞으면 true
		System.out.println("result1:" + result1);
		
		//삼항연산자: 조건식? 참:거짓
		String result2 = win.isDirectory() ? "폴더" : "파일";
		System.out.println("result2:" + result2);
		
		result2 =  win.isFile() ? "파일" : "폴더" ; // win이 파일이냐 
		System.out.println("result2:" + result2);
		
		String[] lists = win.list();
		System.out.println(lists.length);
		for(int i=0;i<lists.length;i++) {
			File kind = new File(win,lists[i]);
			if(kind.isFile()) {
				System.out.println("파일 : " + lists[i]);
			}
			else {
				System.out.println("폴더 : " + lists[i]);
			}
		}//for
		
		
	}
}

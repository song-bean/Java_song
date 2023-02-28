import java.io.*;
import java.util.Scanner;

public class Ex12_10_송나영 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		BufferedReader br = null;

		while(true) {
			System.out.println("1.단어입력 2.단어검색 3.종료");
			System.out.print(">>");
			int input = sc.nextInt();
			if(input == 1) {
				System.out.print("단어/뜻 입력>>");
				BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
				try {
					fw = new FileWriter("voca.txt", true);
					bw = new BufferedWriter(fw);
					bw.write(bri.readLine());
					bw.write(10);
					//bw.newLine();
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(input == 2) {
				System.out.print("검색 단어 입력>>");
				BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
				//파일 읽어오기
				try {
					String str1 = bri.readLine();
					fr = new FileReader("voca.txt");
					br = new BufferedReader(fr);
					String str2;
					boolean flag = false;
					while ((str2 = br.readLine()) != null) { 
						if(str2.contains(str1)) {
							int index = str2.indexOf("/");
							System.out.println("단어>" + str2.substring(0,index));
							System.out.println("단어의 뜻>" + str2.substring(index+1));
							flag = true;
						}
						//강사님 방법
//						String[] tokens = str2.split("/");
//						if(tokens[0].equals(str1)) {
//							System.out.println("단어>" + tokens[0]);
//							System.out.println("단어의 뜻>" + tokens[1]);
//							flag = true;
//						}
					}
					if(flag == false) {
						System.out.println("찾는 단어 없음");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}//else if
			else if(input == 3) {
				System.out.println("프로그램을 종료합니다.");
				if(bw != null)
					bw.close();
				if(br != null)
					br.close();
				System.exit(0); // 0 1 --> 0은 정상적인 종료
				//break;
			}//else if
		}//while
		
	}
}


//voca.txt
//1. sky/하늘 이런식으로 단어 입력, 공백도 입력 가능
//2. 영어를 입력하면 뜻 알려줌
//2. 없는 단어 --> 찾는 단어 없음
//3. 종료
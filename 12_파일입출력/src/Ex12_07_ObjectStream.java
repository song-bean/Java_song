import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Person implements Serializable{ // 객체를 파일에 출력하기 위해서는 Serializable 필요 --> 객체를 직렬화
	String name = "아이유";
	int age = 20;
}//Person



public class Ex12_07_ObjectStream {
	public static void main(String[] args) {
		
		Person per = new Person();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fos = new FileOutputStream("objectfile.txt"); // 1차스트림 
			oos = new ObjectOutputStream(fos); // 2차스트림 
			oos.writeObject(per);
			oos.writeObject(new Date());
			
			
			fis = new FileInputStream("objectfile.txt"); // 1차
			ois = new ObjectInputStream(fis); //2차 
			
			Person p = (Person)ois.readObject(); // readObject()가 object를 리턴하므로 Person으로 다운캐스팅 해줘야 함
			System.out.println(p.name);
			System.out.println(p.age);
			
			Date d = (Date)ois.readObject();
			System.out.println(d);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}

//ObjectOutputStream도 2차스트림
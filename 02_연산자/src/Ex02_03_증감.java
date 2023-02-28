
public class Ex02_03_증감 {

	public static void main(String[] args) {
		
		int a = 5, b = 5, aa, bb;
		System.out.println("a = " + a);
		//a = a + 1;
		//a += 1;
		//a++; // 1증가 ,a--: 1감소 
		++a;
		System.out.println("a = " + a);
		
		
		a = 5;
		System.out.println("a = " + a); // a = 5
		
		aa = ++a; // 변수 앞에 ++은 먼저 
		System.out.println("a = " + a + ", aa = " + aa); // a가 증가한 뒤에 aa에 넣기 -> a = 6, aa = 6
		
		
		a = 5;
		System.out.println("a = " + a);
		
		aa = a++; // 변수 뒤에 ++은 나중에 
		System.out.println("a = " + a + ", aa = " + aa); 
		
		
		
		a = 5;
		System.out.println("a = " + a); // a = 5
		
		aa = --a; 
		System.out.println("a = " + a + ", aa = " + aa); 
		
		
		a = 5;
		System.out.println("a = " + a);
		
		aa = a--; 
		System.out.println("a = " + a + ", aa = " + aa); 
		
		System.out.println();
		
		int i = 10;
		System.out.println(i);
		System.out.println(i++); //	콘솔 = i++ 
		System.out.println(++i); // 콘솔 = ++i
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);
		
		System.out.println();
		
		i =10;
		
		System.out.println(i);
		System.out.println(i--); 
		System.out.println(--i); 
		System.out.println(--i);
		System.out.println(i--);
		System.out.println(i);
		
			
	}

}

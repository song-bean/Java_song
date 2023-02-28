
public class Ex09_08_Wrapper {
	public static void main(String[] args) {
	
		int[] num = {1,2,3,4,5};
		
		int i,sum =0;
		for(i=0;i<num.length;i++) {
			sum += num[i];
		}
		System.out.println("합계1:" + sum);
		
		sum = 0;
		String sum2 ="";
		String[] num2 = {"1","2","3","4","5"};
		for(i=0;i<num2.length;i++) {
			sum2 += num2[i];
//			int s = Integer.valueOf(num2[i]);
//			System.out.print(s);
//			sum += s;
			sum += Integer.parseInt(num2[i]);
		}
		System.out.println();
		System.out.println("합계2:" + sum2);
		System.out.println("합계3:" + sum);
		
		sum=0;
		String[] str = {"웬디:70","아이유:90","크리스탈:30"};
		for(i=0;i<str.length;i++) {
			//System.out.println(str[i]);
			int index = str[i].indexOf(":");
			//System.out.println(index);
			
			//sum += Integer.valueOf(str[i].substring(index+1));
			sum += Integer.parseInt(str[i].substring(index+1));
		}
		System.out.println("합계4:" + sum);
		
		System.out.println();
		sum = 0;
		for(i=0;i<str.length;i++) {
			String[] arr = str[i].split(":");
			sum += Integer.parseInt(arr[1]);
		}
		System.out.println("합계:" + sum);
		
	}
}

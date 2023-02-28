abstract class Employee3 {
	String empno;
	String name;
	int pay;

	public abstract double getMonthPay();
	
	public Employee3(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}
	public void display() {
		System.out.println("사번:" + empno);
		System.out.println("이름:" + name);
		System.out.println("금액:" + pay);
	}
	
}//Employee3

class PartTime extends Employee3{
	int workDay;
	
	public PartTime(String empno, String name, int pay, int workDay) {
		super(empno, name, pay);
		this.workDay = workDay;
	}
	public double getMonthPay() {
		return pay*workDay;
	}
	public void dispaly() {
		super.display();
		System.out.println("월 근무일:" + workDay);
	}
	
}//PartTime

class Contract extends Employee3{ // pay/(double)12 * hireYear
	int hireYear;
	
	public Contract(String empno, String name, int pay, int hireYear) {
		super(empno, name, pay);
		this.hireYear = hireYear;
	}
	public double getMonthPay() {
			return (pay/(double)12) * hireYear;
	}
	public void dispaly() {
		super.display();
		System.out.println("계약기간:" + hireYear);
	}
	
}//Contract

class FullTime extends Employee3{
	int bonus;
	
	public FullTime(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		this.bonus = bonus;
	}
	public double getMonthPay() {
			return (pay/(double)12) + (bonus/(double)12);
	}
	public void dispaly() {
		super.display();
		System.out.println("보너스:" + bonus);
	}
	
}//FullTime

//pdf 80pg
public class Ex06_13_송나영 {
	public static void main(String[] args) {
	
		PartTime p = new PartTime("P1","수지",30,20);
		p.dispaly();
		System.out.println("월급:" + p.getMonthPay());
		System.out.println("-----------------------");
		
		Contract c = new Contract("C2","보검",250,3);
		c.dispaly();
		System.out.println("월급:" + c.getMonthPay());
		System.out.println("-----------------------");
		
		FullTime f = new FullTime("F3","제니",3000,500);
		f.dispaly();
		System.out.println("월급:" + f.getMonthPay());
		System.out.println("-----------------------");
		
		
		//배열로
		System.out.println("***배열***");
		Employee3[] arr = {
							new PartTime("P1","수지",30,20),
							new Contract("C2","보검",250,3),
							new FullTime("F3","제니",3000,500)
							};
		for(int i=0;i<arr.length;i++) {
			arr[i].display();
			System.out.println("월급:" + arr[i].getMonthPay());
			System.out.println("-----------------------");
		}
		
		

	}

}


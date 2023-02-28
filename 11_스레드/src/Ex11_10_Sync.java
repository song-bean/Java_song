class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public synchronized void saveMoney(int money) {
		this.money = this.money + money;
	}
	
	
}//Bank
class Park extends Thread{
	public void run() {
		Ex11_10_Sync.myBank.saveMoney(3000);
		System.out.println("park 3000:" + Ex11_10_Sync.myBank.getMoney());
	}
}//Park

class Kim extends Thread{
	public void run() {
		Ex11_10_Sync.myBank.saveMoney(500);
		System.out.println("kim 500:" + Ex11_10_Sync.myBank.getMoney());
	}
}//Kim
public class Ex11_10_Sync {
	
	public static Bank myBank = new Bank();
	
	public static void main(String[] args) {
		
		//System.out.println("원금:" + Ex11_10_Sync.myBank.getMoney());
		System.out.println("원금:" + myBank.getMoney());
		
		Park p = new Park();
		Kim k = new Kim();
		
		p.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		k.start();
		
	
		
	}
}

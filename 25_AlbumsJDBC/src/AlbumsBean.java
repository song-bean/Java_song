
public class AlbumsBean {
	private int num;
	private String song;
	private String singer;
	private String company;
	private int price;
	private String pub_day;
	
	public AlbumsBean() {
		
	}
	
	public AlbumsBean(int num, String song, String singer, String company, int price, String pub_day) {
		super();
		this.num = num;
		this.song = song;
		this.singer = singer;
		this.company = company;
		this.price = price;
		this.pub_day = pub_day;
	}



	public void setNum(int num) {
		this.num = num;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPub_day(String pub_day) {
		this.pub_day = pub_day;
	}
	
	public int getNum() {
		return num;
	}
	public String getSong() {
		return song;
	}
	public String getSinger() {
		return singer;
	}
	public String getCompany() {
		return company;
	}
	public int getPrice() {
		return price;
	}
	public String getPub_day() {
		return pub_day;
	}
	
}

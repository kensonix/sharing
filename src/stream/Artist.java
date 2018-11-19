package stream;

public class Artist {
	private String name;
	public Artist(String name){
		this.name =name;
	}
	
	public boolean isMale(){
		return true;
	}
	
	public String toString(){
		return "Aritist's name : " + this.name;
	}
}

package fruits;

import java.util.ArrayList;
import java.util.List;

public abstract class Fruit {
	protected String name;
	protected List<Fruit> subFruits = new ArrayList<Fruit>();
	protected boolean isGreen;
	protected int price;
	public Fruit(String name,int price,boolean isGreen){
		this.name = name;
		this.price = price;
		this.isGreen = isGreen;
	}
	
	public boolean isGreen(){
		return isGreen;
	}
	public String toString(){
		return "Fruit's name : " + this.name + "\r\n";
	}
}

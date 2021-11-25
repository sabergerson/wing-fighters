package bergerson.SPT;

//import necessary modules
import java.io.Serializable;

//Location class
public class Location implements Serializable {
	
	//Data fields
	private static final long serialVersionUID = 1L;
	private int X;
	private int Y;
	
	//Constructor
	public Location(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	//Implemented methods (serializable)
	//name: toString
	//method: returns string version of location
	//input: none
	//output: String
	@Override
	public String toString() {
		String location;
		location = "[X: " + X + ", Y: " + Y + "]";
		return location;
	}

	//Accessors and mutators
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
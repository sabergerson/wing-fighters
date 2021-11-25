package bergerson.XWINGS;

//import necessary modules
import bergerson.ENUMS.XEngine;
import bergerson.ENUMS.XModel;
import bergerson.ENUMS.XSensor;
import bergerson.ENUMS.XWeapon;
import bergerson.INTERFACES.Specifiable;
import java.io.Serializable;
import java.util.Comparator;

//XWingFighter class
public abstract class XWingFighter implements Serializable, Specifiable {
	
	//Data fields
	private static final long serialVersionUID = 1L;
	private String FighterID;
	private XModel FighterModel;
	private double FLength;
	private double FWidth;
	private double FHeight;
	private double FMass;
	private double FMaxSpeed;
	private XSensor FSensors;
	private XEngine FEngine;
	private XWeapon FPrimaryWpns;
	private XWeapon FSecondaryWpns;
	
	//Constructor
	public XWingFighter(String FighterID, XModel FighterModel, double FLength, 
			double FWidth, double FHeight, double FMass, double FMaxSpeed) {
		this.FighterID = FighterID;
		this.FighterModel = FighterModel;
		this.FLength = FLength;
		this.FWidth = FWidth;
		this.FHeight = FHeight;
		this.FMass = FMass;
		this.FMaxSpeed = FMaxSpeed;
	}
	
	//Behaviors: Implemented methods (specifiable)
	//name: displayFighterSpecs
	//method: displays fighter information
	//input: none
	//output: void
	@Override
	public void displayFighterSpecs() {
		System.out.println("MODEL: "+this.FighterModel);
		System.out.println("Fighter ID: "+this.FighterID);
		System.out.println("Length: "+this.FLength);
		System.out.println("Width: "+this.FWidth);
		System.out.println("Height: "+this.FHeight);
		System.out.println("Mass: "+this.FMass);
		System.out.println("Engines: "+this.FEngine.getEngineType());
		System.out.println("Sensors: "+this.FSensors.getSensorType());
		System.out.println("Laser Cannons: "+this.FPrimaryWpns.getWeaponType());	
	}

	//name: costToBuild
	//method: calculates cost to build fighter
	//input: none
	//ouput: void
	@Override
	public double costToBuild() {
		//initialize cost to zero 
		double totalCost = 0;
		//add all component costs
		int ec = this.getFEngine().getEngineCost();
		int sc = this.getFSensors().getSensorCost();
		int pwc = this.getFPrimaryWpns().getWeaponCost();
		int swc = this.getFSecondaryWpns().getWeaponCost();
		totalCost = ec + sc + pwc + swc;
		//return total cost
		return totalCost;
	}
	
	//Accessors and mutators
	public String getFighterID() {
		return FighterID;
	}

	public void setFighterID(String FighterID) {
		this.FighterID = FighterID;
	}

	public XModel getFighterModel() {
		return FighterModel;
	}

	public void setFighterModel(XModel FighterModel) {
		this.FighterModel = FighterModel;
	}

	public double getFLength() {
		return FLength;
	}

	public void setFLength(double FLength) {
		this.FLength = FLength;
	}

	public double getFWidth() {
		return FWidth;
	}

	public void setFWidth(double FWidth) {
		this.FWidth = FWidth;
	}

	public double getFHeight() {
		return FHeight;
	}

	public void setFHeight(double FHeight) {
		this.FHeight = FHeight;
	}

	public double getFMass() {
		return FMass;
	}

	public void setFMass(double FMass) {
		this.FMass = FMass;
	}

	public double getFMaxSpeed() {
		return FMaxSpeed;
	}

	public void setFMaxSpeed(double FMaxSpeed) {
		this.FMaxSpeed = FMaxSpeed;
	}

	public XSensor getFSensors() {
		return FSensors;
	}

	public void setFSensors(XSensor FSensors) {
		this.FSensors = FSensors;
	}

	public XEngine getFEngine() {
		return FEngine;
	}

	public void setFEngine(XEngine FEngine) {
		this.FEngine = FEngine;
	}

	public XWeapon getFPrimaryWpns() {
		return FPrimaryWpns;
	}

	public void setFPrimaryWpns(XWeapon FPrimaryWpns) {
		this.FPrimaryWpns = FPrimaryWpns;
	}

	public XWeapon getFSecondaryWpns() {
		return FSecondaryWpns;
	}

	public void setFSecondaryWpns(XWeapon FSecondaryWpns) {
		this.FSecondaryWpns = FSecondaryWpns;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

//XCompare class 
class XCompare implements Comparator<XWingFighter> {

	//Implemented methods (Comparator)
	//name: compare
	//method: lexigraphically compares fighters
	//input: XWingFighter (x2)
	//output: int (comparison value)
	@Override
	public int compare(XWingFighter F1, XWingFighter F2) {
		//Lexigraphical comparison: A to Z
		return F1.getFighterModel().compareTo(F2.getFighterModel());
	}
	
}
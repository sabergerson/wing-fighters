package bergerson.XWINGS;

//import necessary modules
import bergerson.ENUMS.XEngine;
import bergerson.ENUMS.XModel;
import bergerson.ENUMS.XSensor;
import bergerson.ENUMS.XWeapon;
import bergerson.SPT.Location;

//XWingT85 class
public class XWingT85 extends XWingFighter {
	
	//Data fields
	private static final long serialVersionUID = 1L;
	private Location pos; 

	//Constructor
	public XWingT85(String fighterID) {
		super(fighterID, XModel.T85, 15.68, 13.65, 2.7, 15.68, 30.1);
		this.setFSensors(XSensor.ANr1v3);
		this.setFPrimaryWpns(XWeapon.KX14);
		this.setFSecondaryWpns(XWeapon.MG7A);
		this.setFEngine(XEngine.FTE5L9);
	}

	//Implemented methods (XWingFighter
	//name: displayFighterSpecs
	//method: displays fighter information
	//input: none
	//output: void
	@Override
	public void displayFighterSpecs() {
		System.out.println("++++++T85++++++");
		super.displayFighterSpecs();
		System.out.println("Torpedo Launcher: "+this.getFSecondaryWpns().getWeaponType());
		System.out.println("++++++++++++++++");	
		System.out.println();
	}

	//name: costToBuild
	//method: calculates cost to build fighter
	//input: none
	//output: double
	@Override
	public double costToBuild() {
		double totalCost = super.costToBuild();
		double mc = 0.85*(this.getFighterModel().getModelCost());
		totalCost = totalCost + mc;
		return totalCost;
	}
	
	//Behaviors: Instance methods
	//name: displayT65Location
	//method: displays formatted location
	//input: none
	//output: void
	public void displayT85Location() {
		System.out.println("coords-> "+this.getPos().toString());		
	}
	
	//Accessors and mutators
	public Location getPos() {
		return pos;
	}

	public void setPos(Location pos) {
		this.pos = pos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
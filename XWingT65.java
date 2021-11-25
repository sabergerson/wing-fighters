package bergerson.XWINGS;

//import necessary modules
import bergerson.ENUMS.XEngine;
import bergerson.ENUMS.XModel;
import bergerson.ENUMS.XSensor;
import bergerson.ENUMS.XWeapon;
import bergerson.SPT.Location;

//XWingT65 class
public class XWingT65 extends XWingFighter {

	//Data fields 
	private static final long serialVersionUID = 1L;
	private Location pos; 
	
	//Constructor
	public XWingT65(String fighterID) {
		super(fighterID, XModel.T65B, 13.4, 11.6, 2.4, 13.4, 26.2);
		this.setFSensors(XSensor.ANs5D);
		this.setFPrimaryWpns(XWeapon.KX9);
		this.setFSecondaryWpns(XWeapon.MG7);
		this.setFEngine(XEngine.CPG04Z);
	}

	//Implemented methods (XWingFighter)
	//name: displayFighterSpecs
	//method: displays fighter information
	//input: none
	//output: void
	@Override
	public void displayFighterSpecs() {
		System.out.println("++++++T65++++++");
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
	public void displayT65Location() {
		System.out.println("coords-> "+this.getPos().toString());		
	}
	
	//Accessors and mutators
	public Location getPos() {
		return pos;
	}

	public void setPos(Location pos) {
		this.pos = pos;
	}

}
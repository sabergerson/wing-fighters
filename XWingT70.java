package bergerson.XWINGS;

//import necessary modules
import bergerson.ENUMS.XEngine;
import bergerson.ENUMS.XModel;
import bergerson.ENUMS.XSensor;
import bergerson.ENUMS.XWeapon;
import bergerson.SPT.Location;

//XWingT70 class
public class XWingT70 extends XWingFighter {
	
	//Data fields
	private static final long serialVersionUID = 1L;
	private Location pos; 
	private XWeapon FTertiaryWpns;

	//Constructor
	public XWingT70(String fighterID) {
		super(fighterID, XModel.T70, 12.49, 11.6, 1.92, 12.49, 29.2);
		this.setFSensors(XSensor.ANq5v8);
		this.setFPrimaryWpns(XWeapon.KX12);
		this.setFSecondaryWpns(XWeapon.MG7A);
		this.setFTertiaryWpns(XWeapon.AX190);
		this.setFEngine(XEngine.FTE5L5);
	}

	//Implemented methods (XWingFighter
	//name: displayFighterSpecs
	//method: displays fighter information
	//input: none
	//output: void
	@Override
	public void displayFighterSpecs() {
		System.out.println("++++++T70++++++");
		super.displayFighterSpecs();
		System.out.println("Heavy Laser Cannons: "+this.getFTertiaryWpns().getWeaponType());
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
		double mc = 1.5*(this.getFighterModel().getModelCost());
		double twc = this.getFTertiaryWpns().getWeaponCost();
		totalCost = totalCost + mc + twc;
		return totalCost;
	}
	
	//Behaviors: Instance methods
	//name: displayT65Location
	//method: displays formatted location
	//input: none
	//output: void
	public void displayT70Location() {
		System.out.println("coords-> "+this.getPos().toString());		
	}
	
	//Accessors and mutators
	public Location getPos() {
		return pos;
	}

	public void setPos(Location pos) {
		this.pos = pos;
	}

	public XWeapon getFTertiaryWpns() {
		return FTertiaryWpns;
	}

	public void setFTertiaryWpns(XWeapon fTertiaryWpns) {
		this.FTertiaryWpns = fTertiaryWpns;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
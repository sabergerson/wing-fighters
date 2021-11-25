package bergerson.XWING_DEV;

//import necessary modules
import java.text.DecimalFormat;
//import necessary modules
import java.util.ArrayDeque;
import bergerson.SPT.Location;
import bergerson.XWINGS.XWingFighter;
import bergerson.XWINGS.XWingT65;
import bergerson.XWINGS.XWingT70;
import bergerson.XWINGS.XWingT85;

//XWingFactory class
public class XWingFactory {
	
	//Data fields
	private String name;
	private Location factoryLoc;
	private ArrayDeque<XWingFighter> XWingWarehouse;
	private int buildCapacity;
	
	//Constructor
	public XWingFactory(String name, Location factoryLoc, int buildCapacity) {
		this.name = name;
		this.factoryLoc = factoryLoc;
		this.buildCapacity = buildCapacity;
	}
	
	//Behaviors: instance methods
	//name: buildFighters
	//method: build specified number of fighters of each type
	//input: int (x3, number of each fighter to build)
	//output: boolean
	public boolean buildFighters(int T65Count, int T70Count, int T85Count) {
		//initialize warehouse for storage
		this.XWingWarehouse = new ArrayDeque<XWingFighter>(); 
		//set count to zero for all fighters
		int count = 0;
		//set cost to zero for all fighters
		int t65cost = 0; int t70cost = 0; int t85cost = 0;
		//initialize success variable
		boolean success;
		//initialize fighter types
		XWingT65 t65; XWingT70 t70; XWingT85 t85;
		//create specified number of T65 fighters
		while(count < T65Count) {
			count++;
			//create fighter with new ID, add to warehouse
			t65 = new XWingT65("T65-"+count);
			this.XWingWarehouse.add(t65);
			//increase cost to build
			t65cost += t65.costToBuild();
		}
		//reset count
		count = 0;
		//create specified number of T70 fighters
		while(count < T70Count) {
			count++;
			//create fighter with new ID, add to warehouse
			t70 = new XWingT70("T70-"+count);
			this.XWingWarehouse.add(t70);
			//increase cost to build
			t70cost += t70.costToBuild();
		}
		//reset count
		count = 0;
		//create specified number of T85 fighters
		while(count < T85Count) {
			count++;
			//create fighter with new ID, add to warehouse
			t85 = new XWingT85("T85-"+count);
			this.XWingWarehouse.add(t85);
			//increase cost to build
			t85cost += t85.costToBuild();
		}
		//if operation was successful, print build report to user
		if (this.XWingWarehouse.size() == 6) {
			//update success to true
			success = true;
			DecimalFormat df = new DecimalFormat("###,###,###.###");
			System.out.println("______XWing Fighter Build Report______");
			System.out.println("Type     Number Built   Build Cost");
			System.out.println("T65            "+T65Count+"        "+df.format(t65cost)+" credits");
			System.out.println("T70            "+T70Count+"        "+df.format(t70cost)+" credits");
			System.out.println("T85            "+T85Count+"        "+df.format(t85cost)+" credits");
			System.out.println("____Reported Created By "+this.name+" Factory");
			System.out.println();
		}
		//if operation unsuccessful, notify user
		else {
			//update success to false
			success = false;
			System.out.println("Fighter Build Failed");
			System.out.println();
		}
		//return success status
		return success;	
	}

	//Accessors and mutators
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getFactoryLoc() {
		return factoryLoc;
	}

	public void setFactoryLoc(Location factoryLoc) {
		this.factoryLoc = factoryLoc;
	}

	public ArrayDeque<XWingFighter> getXWingWarehouse() {
		return XWingWarehouse;
	}

	public void setXWingWarehouse(ArrayDeque<XWingFighter> xWingWarehouse) {
		this.XWingWarehouse = xWingWarehouse;
	}

	public int getBuildCapacity() {
		return buildCapacity;
	}

	public void setBuildCapacity(int buildCapacity) {
		this.buildCapacity = buildCapacity;
	}	
	
}
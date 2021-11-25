package bergerson.MAIN;

//import necessary modules
import java.io.IOException;

//import necessary modules
import bergerson.SPT.Location;
import bergerson.XWINGS.XWingFighter;
import bergerson.XWING_DEV.XWingFactory;
import bergerson.XWING_DEV.XWingStorage;

//Main method
public class XWING_Bergerson {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		XWingFactory fac = new XWingFactory("ALPHA-BUILD", new Location(10,10), 100);
		fac.buildFighters(2, 2, 2);
		XWingStorage stor = new XWingStorage("ALPHA-STORE", new Location(20, 20));
		stor.storeFighters(fac.getXWingWarehouse(), XWingStorage.DIR + "Fighters");
		stor.retrieveFighters(XWingStorage.DIR + "Fighters");
		for(XWingFighter x: stor.getHoldingPlatform()) {
			x.displayFighterSpecs();
		}
	}
}
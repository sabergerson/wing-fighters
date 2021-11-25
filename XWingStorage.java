package bergerson.XWING_DEV;

//import necessary modules
import java.io.EOFException;
//import necessary modules
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import bergerson.SPT.Location;
import bergerson.XWINGS.XWingFighter;

//XWingStorage
public class XWingStorage {
	
	//Data fields
	private String name;
	private Location storageLoc;
	private ArrayDeque<XWingFighter> holdingPlatform;
	public static final String DIR = "//Users//sage//eclipse-workspace//Bergerson_HW7//src//bergerson//XWING_DEV//";
	
	//Constructor
	public XWingStorage(String name, Location storageLoc) {
		this.name = name;
		this.storageLoc = storageLoc;
	}
	
	//Behaviors: instance methods
	//name: storeFighters
	//method: serializes fighters, stores fighter objects in file
	//input: none
	//output: boolean
	public boolean storeFighters(ArrayDeque<XWingFighter> wh, String fn) throws IOException {	
		//initialize success variable
		boolean success;
		//try serializing fighter objects to file using iteration
		try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(fn));
            Iterator<XWingFighter> iter = wh.iterator();
            while (iter.hasNext()) {       	
            	objectOut.writeObject(iter.next());       	
            }
            objectOut.close();
            //update success to true
            success = true;
		}
		//catch FileNotFound exception
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
			//update success to false
			success = false;
		}
		//catch IOException
		catch (IOException ex) {
			success = false;
			ex.printStackTrace();
			//update success to false
			success = false;
		}       
		//return success status
        return success;
	}
	
	//name: retrieveFighter
	//method: deserializes fighters, reads from files
	//input: none
	//output: boolean
	public boolean retrieveFighters(String fn) throws ClassNotFoundException, FileNotFoundException, IOException {
		//initialize success variable
		boolean success;
		//initialize holding platform for fighters
		this.holdingPlatform = new ArrayDeque<XWingFighter>();
		//try deserializing fighter objects from file
		ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(fn));
		XWingFighter fighter;
		try {   
            while ((fighter = (XWingFighter)objectIn.readObject()) != null) {
            	this.holdingPlatform.add(fighter);
            }        
            objectIn.close();
            //update success to true
            success = true;
        }     
		//catch EOF exception
		catch (EOFException ex) {
			objectIn.close();
			//update success to false
			success = false;
		}
		//catch ClassNotFound exception
        catch(ClassNotFoundException | IOException ex) {
        	objectIn.close();
        	ex.printStackTrace();
        	//update success to false
        	success = false;  
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

	public Location getStorageLoc() {
		return storageLoc;
	}

	public void setStorageLoc(Location storageLoc) {
		this.storageLoc = storageLoc;
	}

	public ArrayDeque<XWingFighter> getHoldingPlatform() {
		return holdingPlatform;
	}

	public void setHoldingPlatform(ArrayDeque<XWingFighter> holdingPlatform) {
		this.holdingPlatform = holdingPlatform;
	}

	public static String getDir() {
		return DIR;
	}	
	
}
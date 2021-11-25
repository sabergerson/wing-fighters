package bergerson.ENUMS;

//XSensor enumerator
public enum XSensor {
	
	//Object types
	ANs5D("Fabritech","Tracking",30,1200),
	ANq5v8("Fabritech","Tracking",42,1850),
	ANr1v3("Fabritech","Tracking",51,1975);

	//Data fields
	private String manufacturer;
	private String sensorType;
	private int sensorRange;
	private int sensorCost;
	
	//Constructor
	private XSensor(String manufacturer, String sensorType, int sensorRange, int sensorCost) {
		this.manufacturer = manufacturer;
		this.sensorType = sensorType;
		this.sensorRange = sensorRange;
		this.sensorCost = sensorCost;
	}

	//Accessors and mutators
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public int getSensorRange() {
		return sensorRange;
	}

	public void setSensorRange(int sensorRange) {
		this.sensorRange = sensorRange;
	}

	public int getSensorCost() {
		return sensorCost;
	}

	public void setSensorCost(int sensorCost) {
		this.sensorCost = sensorCost;
	}
	
}
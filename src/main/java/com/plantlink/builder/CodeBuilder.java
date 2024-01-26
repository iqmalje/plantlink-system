package com.plantlink.builder;

public abstract class CodeBuilder {
	
	//todo : combine all those functions into one
	
	//WIFI METHODS
	public abstract void generateWIFIVariable();
	public abstract void generateWifiConnect();
	
	
	
	public abstract void generateVariableAPI(String APIKey);
	
	public abstract void generateSendMethod();
	
	public abstract void generateStructure();
	
	public abstract void generateEthernetVariable();
	
	public abstract void generateEndpointVariable();
	
	
	public abstract void generateEthernetConnect();
	
	public abstract void generateImportsWIFI();
	
	public abstract void generateImportsEthernet();
	
	public abstract SensorCode build();

}

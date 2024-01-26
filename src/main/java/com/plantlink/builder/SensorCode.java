package com.plantlink.builder;

public class SensorCode {
	private String APIVariable, sendMethod, structure, WIFIVariable, ethernetVariable, endpointVariable, wifiConnect, ethernetConnect, importsWIFI, importsEthernet;
	
	
	SensorCode(String APIVariable, String sendMethod, String structure, String WIFIVariable, String ethernetVariable, String endpointVariable, String wifiConnect, String ethernetConnect, String importsWIFI, String importsEthernet) {
		this.APIVariable = APIVariable;
	    this.sendMethod = sendMethod;
	    this.structure = structure;
	    this.WIFIVariable = WIFIVariable;
	    this.endpointVariable = endpointVariable;
	    this.wifiConnect = wifiConnect;
	    this.importsWIFI = importsWIFI;
	    this.importsEthernet = importsEthernet;
	    this.ethernetConnect = ethernetConnect;
	    this.ethernetVariable = ethernetVariable;
	}
	
	public String getAPIKey() {
	    return this.APIVariable;
	  }
	  public String getSendMethod() {
	    return this.sendMethod;
	  }
	  public String getStructure() {
	    return this.structure;
	  }

	  public String getWIFIVariable() {
	    return this.WIFIVariable;
	  }
	  public String getEthernetVariable() {
	    return this.ethernetVariable;
	  }

	  public String getEndpointVariable() {
	    return this.endpointVariable;
	  }

	  public String getWifiConnect() {
	    return this.wifiConnect;
	  }
	  public String getEthernetConnect() {
	    return this.ethernetConnect;
	  }

	  public String getImportsWIFI() {
	    return this.importsWIFI;
	  }
	  public String getImportsEthernet() {
	    return this.importsEthernet;
	  }
}

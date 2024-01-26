package com.plantlink.builder;

public class ArduinoCodeBuilder extends CodeBuilder {
	private String APIVariable, sendMethod, structure, WIFIVariable, ethernetVariable, endpointVariable, wifiConnect, ethernetConnect, importsWIFI, importsEthernet;
	@Override
	public void generateVariableAPI(String APIKey) {
		// TODO Auto-generated method stub
		 this.APIVariable = String.format("char* APIKEY = \"%s\"<br /><br />", APIKey);
	}

	@Override
	public void generateSendMethod() {
		// TODO Auto-generated method stub
		this.sendMethod = ""
				+ "int postData(int data) {<br />"
				+ "	client.println(\"POST \" + API_ENDPOINT + \" HTTP/1.1\");<br />"
				+ "	client.println(\"Connection: close\");<br />"
				+ "	client.println(); //close the connection<br />"
				+ "	char* body = \"{ \"apikey\": APIKEY, \"name\": SENSOR NAME HERE }\";<br />"
				+ "	client.println(body); <br />"
				+ "}<br /><br /";
		
	}

	@Override
	public void generateStructure() {
		// TODO Auto-generated method stub
		this.structure = ""
				+ "// for setting up your sensors<br />"
				+ "void setup() {<br />"
				+ "<br />"
				+ "}<br />"
				+ "<br />"
				+ "// the loop function runs forever<br />"
				+ "void loop() {<br />"
				+ "   // read sensor's data<br />"
				+ "   // postData(data);<br />"
				+ "}<br />";
	}

	@Override
	public void generateWIFIVariable() {
		// TODO Auto-generated method stub
		this.WIFIVariable = "<br />"
				+ "char* WIFI_SSID = YOUR_WIFI_SSID;<br />"
				+ "char* WIFI_PASSWORD = YOUR_WIFI_PASSWORD;<br /><br />";
	}

	@Override
	public void generateEthernetVariable() {
		// TODO Auto-generated method stub
		this.ethernetVariable = ""
				+ "EthernetClient client;<br />"
				+ "client.connect();<br /><br />";
	}

	@Override
	public void generateEndpointVariable() {
		// TODO Auto-generated method stub
		this.endpointVariable = "char* API_ENDPOINT = \"http://localhost:8080/plantlink/sensor/registersensor\";<br /><br />";
	}

	@Override
	public void generateWifiConnect() {
		// TODO Auto-generated method stub
		this.wifiConnect = ""
				+ "WiFiClient client;<br />"
				+ "client.connect(WIFI_SSID, WIFI_PASSWORD);<br /><br />";
	}

	@Override
	public void generateEthernetConnect() {
		// TODO Auto-generated method stub
		this.ethernetConnect = ""
				+ "EthernetClient client;<br />"
				+ "client.connect();<br /><br />";
	}

	@Override
	public void generateImportsWIFI() {
		// TODO Auto-generated method stub
		this.importsWIFI = "#include &ltWiFi.h&gt";
	}

	@Override
	public void generateImportsEthernet() {
		// TODO Auto-generated method stub
		this.importsEthernet = "#include &ltEthernetClient&gt client;";
	}

	@Override
	public SensorCode build() {
		// TODO Auto-generated method stub
		return new SensorCode(
			      this.APIVariable,
			      this.sendMethod,
			      this.structure,
			      this.WIFIVariable,
			      this.ethernetVariable,
			      this.endpointVariable,
			      this.wifiConnect,
			      this.ethernetConnect,
			      this.importsWIFI,
			      this.importsEthernet
			    );
	}

}

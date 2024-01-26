package com.plantlink.builder;

public class MicroPythonCodeBuilder extends CodeBuilder{
	private String APIVariable, sendMethod, structure, WIFIVariable, ethernetVariable, endpointVariable, wifiConnect, ethernetConnect, importsWIFI, importsEthernet;
	
	@Override
	public void generateVariableAPI(String APIKey) {
		// TODO Auto-generated method stub
		this.APIVariable = String.format("API_KEY = \"%s\" <br /><br />", APIKey);
	}

	@Override
	public void generateSendMethod() {
		// TODO Auto-generated method stub
		this.sendMethod = ""
				+ "def sendData(data):<br />"
				+ "   headers = { \"Content-Type\" : \"application/json\" }<br />"
				+ "   body = { \"apikey\": API_KEY, \"name\": SENSOR NAME HERE }<br />"
				+ "   response = urequests.post(API_ENDPOINT, headers=headers, data=body).json()<br /><br />";
	}

	@Override
	public void generateStructure() {
		// TODO Auto-generated method stub
		this.structure = ""
				+ "# enter setup here<br />"
				+ "<br />"
				+ "# loop throughout running<br />"
				+ "while True:<br />"
				+ "   # code here<br /><br />";
	}

	@Override
	public void generateWIFIVariable() {
		// TODO Auto-generated method stub
		this.WIFIVariable = ""
				+ "WIFI_SSID = YOUR_WIFI_SSID<br />"
				+ "WIFI_PASSWORD = YOUR_WIFI_PASSWORD<br /><br />";
	}

	@Override
	public void generateEthernetVariable() {
		// TODO Auto-generated method stub
		this.ethernetVariable = "";
	}

	@Override
	public void generateEndpointVariable() {
		// TODO Auto-generated method stub
		this.endpointVariable = ""
				+ "API_ENDPOINT = \"http://localhost:8080/sensor/registersensor\"  <br /><br />";
	}

	@Override
	public void generateWifiConnect() {
		// TODO Auto-generated method stub
		this.wifiConnect = ""
				+ "wlan = network.WLAN(network.STA_IF)<br />"
				+ "wlan.connect(WIFI_SSID, WIFI_PASSWORD)<br />"
				;
	}

	@Override
	public void generateEthernetConnect() {
		// TODO Auto-generated method stub
		this.ethernetConnect = ""
				+ "nic = network.WIZNET5K(pyb.SPI(1), pyb.Pin.Board.X5, pyb.Pin.board.X4)<br />"
				+ "print(nic.ifconfig())<br /><br />";
	}

	@Override
	public void generateImportsWIFI() {
		// TODO Auto-generated method stub
		this.importsWIFI = ""
				+ "import network, urequests";
	}

	@Override
	public void generateImportsEthernet() {
		// TODO Auto-generated method stub
		this.importsEthernet = ""
				+ "import network, urequests";
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

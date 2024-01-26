package com.plantlink.builder;

public class CircuitPythonCodeBuilder extends CodeBuilder{
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
				+ "   response = requests.post(url=API_ENDPOINT, headers=headers, data=body).json()<br /><br />";
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
		this.ethernetVariable = ""
				+ "cs = DigitalInOut(ENTER YOUR PIN HERE)<br />"
				+ "spi_bus = busio.SPI(board.sck, MOSI=board.MOSI, MISO=board.MISO)<br /><br />";
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
				+ "wifi.radio.connect(WIFI_SSID, WIFI_PASSWORD)<br />"
				+ "pool = socketpool.SocketPool(wifi.radio)<br />"
				+ "requests = adafruit_requests.Session(pool, ssl.create_default_context())<br /><br />";
	}

	@Override
	public void generateEthernetConnect() {
		// TODO Auto-generated method stub
		this.ethernetConnect = ""
				+ "eth = WIZNET5K(spi_bus, cs)<br />"
				+ "adafruit_requests.set_socket(socket, eth)<br /><br />";
	}

	@Override
	public void generateImportsWIFI() {
		// TODO Auto-generated method stub
		this.importsWIFI = ""
				+ "import ssl, wifi, socketpool, adafruit_requests";
	}

	@Override
	public void generateImportsEthernet() {
		// TODO Auto-generated method stub
		this.importsEthernet = ""
				+ "import board<br />"
				+ "import busio<br />"
				+ "from digitalio import DigitalInOut<br />"
				+ "from adafruit_wiznet5k.adafruit_wiznet5k import WIZNET5K<br />"
				+ "import adafruit_wiznet5k.adafruit_wiznet5k_socket as socket<br />"
				+ "import adafruit_requests as requests";
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

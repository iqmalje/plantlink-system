package com.plantlink.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.plantlink.builder.ArduinoCodeBuilder;
import com.plantlink.builder.CircuitPythonCodeBuilder;
import com.plantlink.builder.CodeBuilder;
import com.plantlink.builder.MicroPythonCodeBuilder;
import com.plantlink.builder.SensorCode;

//*******************************************************************************************
// FILE:           CodeGenerator.java
// 
// DESCRIPTION:    This file contains the implementation of the director class, CodeGenerator
//                 which is used to generate the SensorCode class, with set of conditions to 
//                 fit the user needs
//
// REVISION:       Revision 1.0
//
// CLASSIFICATION: Unclassified
//
// RESTRICTIONS:   None
//
// AUTHOR:         Iqmal Aizat
//
// HISTORY: 
//   PROBLEM #   INITIALS   DATE       DESCRIPTION
// -------------------------------------------------------------------------------------------
//   N/A         IA         15/1/2024  Initial coding for the CodeGenerator class
//   1.0         IA         15/1/2024  Applied MEDT to the logical code generation
//   2.0         IA         16/1/2024  Adhered to the standard convention of programming (PDL)
// -------------------------------------------------------------------------------------------
//
//********************************************************************************************

// Director class

@Controller
@RequestMapping("/code")
public class CodeGenerator {

	@RequestMapping(value="/generateCode", method = RequestMethod.POST)
	
	public ModelAndView generateCode( 
		@RequestParam("platform") String platform, 
		@RequestParam(value="iscustom", required=false) boolean isCustomImport, 
		@RequestParam("connection-method") String connectionMethod) {
		
		// The CodeBuilder declaration that will be used later
		CodeBuilder codeBuilder;

		String APIKey = generateUniqueAPIKey();
		if( platform.equals("arduino") )
		{
			// instantiate codeBuilder variable specific for Arduino platform
			codeBuilder = new ArduinoCodeBuilder();
			
			if( isCustomImport ) 
			{
				// If user intends to use a custom import, we will leave the import section blank
			}
			else
			{
				if( connectionMethod.equals("wifi") ) 
				{
					// Generate import module specifically for WiFi
					codeBuilder.generateImportsWIFI();
					
					// Generate variables that the WiFi connection uses
					codeBuilder.generateWIFIVariable();
					
					// Generate connection that using WiFi
					codeBuilder.generateWifiConnect();
				}
				else
				{
					// Generate import module specifically for Ethernet
					codeBuilder.generateImportsEthernet();
					
					// Generate variables that the Ethernet connection uses
					codeBuilder.generateEthernetVariable();
					
					// Generate connection that using Ethernet
					codeBuilder.generateEthernetConnect();
				}
			}
			
			// Generate REST API endpoint to POST data to
			codeBuilder.generateEndpointVariable();
			
			// Generate a method where the users can use to send the data to PlantLink
			codeBuilder.generateSendMethod();
			
			// Generate the structure where mainly the code will be written into
			codeBuilder.generateStructure();
			
			// Generate API_KEY variable to be used to add to PlantLink DB
			codeBuilder.generateVariableAPI(APIKey);
		}
		else if( platform.equals("micropython") )
		{
			// instantiate codeBuilder variable specific for MicroPython platform
			codeBuilder = new MicroPythonCodeBuilder();
			
			if( isCustomImport ) 
			{
				// If user intends to use a custom import, we will leave the import section blank
			}
			else
			{
				if( connectionMethod.equals("wifi") ) 
				{
					// Generate import module specifically for WiFi
					codeBuilder.generateImportsWIFI();
					
					// Generate variables that the WiFi connection uses
					codeBuilder.generateWIFIVariable();
					
					// Generate connection that using WiFi
					codeBuilder.generateWifiConnect();
				}
				else
				{
					// Generate import module specifically for Ethernet
					codeBuilder.generateImportsEthernet();
					
					// Generate variables that the Ethernet connection uses
					codeBuilder.generateEthernetVariable();
					
					// Generate connection that using Ethernet
					codeBuilder.generateEthernetConnect();
				}
			}

			// Generate REST API endpoint to POST data to
			codeBuilder.generateEndpointVariable();
			
			// Generate a method where the users can use to send the data to PlantLink
			codeBuilder.generateSendMethod();
			
			// Generate the structure where mainly the code will be written into
			codeBuilder.generateStructure();
			
			// Generate API_KEY variable to be used to add to PlantLink DB
			codeBuilder.generateVariableAPI(APIKey);
		}
		else 
		{
			// instantiate codeBuilder variable specific for CircuitPython platform
			codeBuilder = new CircuitPythonCodeBuilder();
			
			if( isCustomImport ) 
			{
				// If user intends to use a custom import, we will leave the import section blank
			}
			else
			{
				if( connectionMethod.equals("wifi") ) 
				{
					// Generate import module specifically for WiFi
					codeBuilder.generateImportsWIFI();
					
					// Generate variables that the WiFi connection uses
					codeBuilder.generateWIFIVariable();
					
					// Generate connection that using WiFi
					codeBuilder.generateWifiConnect();
				}
				else
				{
					// Generate import module specifically for Ethernet
					codeBuilder.generateImportsEthernet();
					
					// Generate variables that the Ethernet connection uses
					codeBuilder.generateEthernetVariable();
					
					// Generate connection that using Ethernet
					codeBuilder.generateEthernetConnect();
				}
			}

			// Generate REST API endpoint to POST data to
			codeBuilder.generateEndpointVariable();
			
			// Generate a method where the users can use to send the data to PlantLink
			codeBuilder.generateSendMethod();
			
			// Generate the structure where mainly the code will be written into
			codeBuilder.generateStructure();
			
			// Generate API_KEY variable to be used to add to PlantLink DB
			codeBuilder.generateVariableAPI(APIKey);
		}
		
		
		
		SensorCode code = codeBuilder.build();

		ModelAndView mv = new ModelAndView("DisplayCodeView");
		mv.addObject("isCustomImport", isCustomImport);
		mv.addObject("sensorcode", code);

		return mv;
	}

	protected String generateUniqueAPIKey() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}

/**
 * \file Server.java
 * \brief Defines the server constants and the rest paths, server rest call methods
 * 
 * This class defines the public methods the user should call with the minimal number of parameters
 * The java fields building (encoding and decoding) are in charge of the respective database collection models
 * Manager and Project
 * 
 * @version 1.0.0
 * @date April 2018
 * @author Enrico Miglino <enrico.miglino@gmail.com>
 */
package console.rest.client.lukasj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//! Server connection parameters and rest paths
public class Server {
	//! Server URI
	private String ServerURI = "http://192.168.185.181";
	//! Server port
	private String ServerPort = "3000";
	//! Project status enum list
	enum Status { pending, complete, progress, delayed, closed };
	//! Rest API calls enum list
	private enum Rest { master, project, login, register };
	//! Rest call return value
	String serverRetVal;
	
	//! Rest API Calls 
	private Rest[] rest = Rest.values();
	//! Project statuses
	private Status[] status = Status.values();
	
	/**
	 * \brief Constructor
	 * 
	 * Initialize the mapped arrays
	 */
	public Server() {
		super();
	}
	
	/**
	 * @brief Create a Rest server endPoint for a connection without parameters
	 * 
	 * @param r The Rest endpoint name
	 * @return The complete URI for the server connection in the format
	 * http://[Server IP address]:[Server port]/[Rest endpoint]
	 */
	private String buildEndPoint(Rest r) {
		
		return ServerURI + ":" + ServerPort + "/api/" + rest[r.ordinal()].name();
	}
	
	/**
	 * @brief Create a Rest server endPoint for a connection with a parameter
	 * 
	 * @param r The Rest endpoint name
	 * @param p The Rest parameter
	 * @return The complete URI for the server connection in the format
	 * http://[Server IP address]:[Server port]/[Rest endpoint]/[Parameter]
	 */
	private String buildEndPoint(Rest r, String p) {
		
		return ServerURI + ":" + ServerPort + "/api/" + rest[r.ordinal()].name() + "/" + p;
	}

	/**
	 * @brief Execute the server connection to the Rest endpoint and retrieve the
	 * returning value
	 * 
	 * This method is called by all the public rest methods to retrieve the endpoint result
	 * It manages the connection with the server, launch the call with the right rest endpoint
	 * and return the result.
	 * 
	 * @todo A more robust content and error checking should be implemented
	 * 
	 * @param endpoint The Enum rest endpoint name
	 * @param callParam The call parameter (optional)
	 * @param method The call method (GET, POST, DELETE, etc.)
	 * @param callBody The JSON formatted body for the call (optional)
	 * @param output If it is set to true, the connection calls a setOutput() to the server
	 */
	private void serverRest(Rest endpoint, String callParam, String method, String callBody, boolean output) throws MalformedURLException {
        HttpURLConnection connection = null;	///< Server URL connection object
        BufferedReader reader = null;			///< Data buffer
        String urlEndpointServerAddress;		///< The http:// ... endpoint string
        URL restEndpoint;						///< The server URL endpoint
        String agent = "Mozilla/4.0";			///< The user agent
        
        // Decide how to build the server URL with the rest endpoint and optional parameters 
    	if(callParam != null) {
    		urlEndpointServerAddress = buildEndPoint(endpoint, callParam);
    	} else {
    		urlEndpointServerAddress = buildEndPoint(endpoint);
    	}

		restEndpoint = new URL(urlEndpointServerAddress);
        String encodedData = callBody;
        
        try {
        	// Create URL endpoint with the optional body
            connection = (HttpURLConnection) restEndpoint.openConnection();
            // Set the connection to accept output
            connection.setDoOutput(output);
            // Set the request method as required from the API
            connection.setRequestMethod(method);
            // Set the application type
            connection.setRequestProperty("Content-Type", "application/json");
            // Set the data content length
            connection.setRequestProperty( "Content-Length", Integer.toString(encodedData.length()) );

            OutputStream os = connection.getOutputStream();

            if(callBody != null) {
            	byte[] osBytes = encodedData.getBytes();
            	os.write(osBytes);
            	os.flush();
            	os.close();
	        	}
            
            // Read the response in JSON format and create a JSON string
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
              jsonSb.append(line);
            }
            
            serverRetVal = jsonSb.toString();
       
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            // Clean up
            if (reader != null) {
              try {
                reader.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            // End the server connection
            if (connection != null) {
              connection.disconnect();
            }
          }
	}
	
	/**
	 * \brief send the rest login call to the server
	 * 
	 * @param name User name to register
	 * @param role User assigned role
	 * @return The register call server result
	 */
	String Register(String name, String role) {
		
		Manager manager = new Manager();
		
		manager.setName(name);
		manager.setRole(role);
		
		try {
			serverRest(Rest.register, null, "POST", manager.buildJsonRegister(), true);
		} catch (MalformedURLException e) {
			//! @todo Auto-generated catch block
			e.printStackTrace();
		}
		return  "Register endpoint : " + buildEndPoint(Rest.register) + "\nRegister body content : " + manager.buildJsonRegister() +
				"\nServer returned : " + serverRetVal;
	}
	
	/**
	 * \brief send the rest login call to the server
	 * 
	 * @param user User login
	 * @param password User password
	 * @return The login server result
	 */
	String Login(String user, String password) {
		
		Manager manager = new Manager();
		
		manager.setUser(user);
		manager.setPassword(password);
		
		try {
			serverRest(Rest.login, null, "POST", manager.buildJsonLogin(), true);
		} catch (MalformedURLException e) {
			//! @todo Auto-generated catch block
			e.printStackTrace();
		}
		return  "Login endpoint : " + buildEndPoint(Rest.login) + "\nLogin body content : " + manager.buildJsonLogin() +
				"\nServer returned : " + serverRetVal;
	}
}

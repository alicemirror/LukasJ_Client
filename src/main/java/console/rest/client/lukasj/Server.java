/**
 * \file Server.java
 * \brief Defines the server constants and the rest paths
 */
package console.rest.client.lukasj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
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
	enum Rest { master, project, login };
	
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
	 * http://<Server IP address>:<Server port>/<Rest endpoint>
	 */
	private String buildEndPoint(Rest r) {
		String ep;
		
		return ServerURI + ":" + ServerPort + "/" + rest[r.ordinal()].name();
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
		String ep;
		
		return ServerURI + ":" + ServerPort + "/" + rest[r.ordinal()].name() + "/" + p;
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
	 */
	private void serverRest(Rest endpoint, String callParam, String method, String callBody) {
        HttpURLConnection connection = null;	///< Server URL connection object
        BufferedReader reader = null;			///< Data buffer
        String retVal = null;					///< Call return value (string)
        String urlEndpointServerAddress;		///< The http:// ... endpoint string
        URL resetEndpoint;						///< The server URL endpoint
        
        // Decide how to build the server URL with the rest endpoint and optional parameters 
    	if(callParam != null) {
    		urlEndpointServerAddress = buildEndPoint(endpoint, callParam);
    	} else {
    		urlEndpointServerAddress = buildEndPoint(endpoint);
    	}

        
        try {
        	// Create URL endpoint with the optional body
    		resetEndpoint = new URL(urlEndpointServerAddress);

            connection = (HttpURLConnection) resetEndpoint.openConnection();
            // Set the request method as required from the API
            connection.setRequestMethod(method);
            // Set the application type
            connection.setRequestProperty("Content-Type", "application/json");
            
            // Fill the body, if needed
            if(callBody != null) {
	            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	        	out.write(callBody);
	        	out.close();
            }
        	
            // Read the response in JSON format and create a JSON string
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
              jsonSb.append(line);
            }
            retVal = jsonSb.toString();
       
            // print out the json response
            System.out.println(retVal);
       
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
	 * @param user
	 * @param password
	 * @return
	 */
	String Login(String user, String password) {
		
		return "Login successful";
	}
}

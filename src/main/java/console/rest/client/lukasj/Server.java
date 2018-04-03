/**
 * \file Server.java
 * \brief Defines the server constants and the rest paths
 */
package console.rest.client.lukasj;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

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
	 * http://<Server IP address>:<Server port>/<Rest endpoint>/<Parameter>
	 */
	private String buildEndPoint(Rest r, String p) {
		String ep;
		
		return ServerURI + ":" + ServerPort + "/" + rest[r.ordinal()].name() + "/" + p;
	}

	/**
	 * \brief Execute the server connection to the Rest endpoint and retrieve the
	 * returning value
	 * 
	 * This method is called by all the public rest methods to retrieve the endpoint result
	 */
	private void serverRest() {
        HttpURLConnection connection = null;	///< Server URL connection object
        BufferedReader reader = null;			///< Data buffer
        String retVal = null;					///< Call return valur (string)
        
        // To be continued ...

	}
}

/**
 * @file App.java
 * @brief Main application entry point
 * 
 * @version 1.0.0
 * @date April 2018
 * @author Enrico Miglino <enrico.miglino@gmail.com>
 */
package console.rest.client.lukasj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Application class. Program execution
 */
public class App 
{
    public static void main( String[] args )
    {
        //! Rest server class instance
    	Server restServer = new Server();
        
        System.out.println( "LukasJ Client 1.0.0" );

        System.out.println(restServer.Register("mj011", "lukeforever"));

        System.out.println(restServer.Login("jd001", "jdpasswd"));
    }
}

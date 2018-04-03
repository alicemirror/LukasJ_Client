/**
 * @file Login.java
 * @brief Login user/password on to the database manager collection
 * 
 * The /login rest call should only be used to log a user already existing 
 * in the database manager collection
 * 
 * The full set of fields in json format of the collection are the following
 * \code
    {
        "_id": "Generated ID",
        "manager": "Manager Name",
        "email": "Manager email",
        "user": "User login",
        "password": "Login password",
        "updatedAt": "Generated update timestamp",
        "createdAt": "Generated creation timestampt",
        "__v": Version number (int)
    },
 * \endcode
 * That are the same as defined in the Manager class
 * 
 * \note the Login class has been created considering that future versions of the 
 * application may need a different login procedure and to avoid confusion. 
 * At the actual version the login can be done also with the Manager class model
 * 
 * @version 1.0.0
 * @date April 2018
 * @author Enrico Miglino <enrico.miglino@gmail.com>
 */
package console.rest.client.lukasj;

/**
 * @brief Based on the Manager class model this class only 
 * should send the login call to the server
 */
public class Login {

	private String _id;			///< Data field
	private String manager;		///< Data field
	private String email;		///< Data field
	private String user;		///< Data field
	private String password;	///< Data field
	private String updatedAt;	///< Data field
	private String createdAt;	///< Data field
	private int __v;			///< Data field
	
	/**
	 * @brief Constructor
	 */
	public Login() {
		super();
	}

	/**
	 * @brief Constructor
	 * 
	 * @param user Manager login user name
	 * @param password Manager stored password
	 */
	public Login(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param user Manager login user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Manager login user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param password Manager login password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Manager login password
	 */
	public String getPassword() {
		return password;
	}
}

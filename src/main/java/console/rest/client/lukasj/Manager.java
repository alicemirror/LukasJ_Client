/**
 * @file Manager.java
 * @brief Manages the manager collection data model
 * 
 * Defines the fields, getters and setters of the object "manager"
 * The class includes also the json methods used to build the rest calls and to decode
 * the json object server responses
 * 
 * @page manager_detail Note on the Manager class
  * In addition to the database fields part of the collection and stored on 
 * the 'manager' set of the server MongoDB, there are the two extra fields
 * 'name' and 'role'. \n
 * Used by the restful endpoint /api/register to create the token for a new user. This action
 * is not related to the database and it is expected to refer to a name/role pair corresponding to 
 * a user/password pair of a database stored user. 
 * 
 * @version 1.0.0
 * @date April 2018
 * @author Enrico Miglino <enrico.miglino@gmail.com>
 */
package console.rest.client.lukasj;

import com.google.gson.Gson;

/**
 * @brief Defines the Manager model and the fields getters and setters
 */
public class Manager {

	private String _id;			///< Data field
	private String manager;		///< Data field
	private String email;		///< Data field
	private String user;		///< Data field
	private String password;	///< Data field
	private String updatedAt;	///< Data field
	private String createdAt;	///< Data field
	private int __v;			///< Data field
	private String name;		///< Data field (user registration only not saved on the database)
	private String role;		///< Data field (user registration only not saved on the database)
	
	/**
	 * @brief Constructor
	 */
	public Manager() {
		super();
	}

	/**
	 * @brief Defines the fields used for the rest login, serialized in json format
	 * 
	 * This class is used by the Gson library
	 */
	class LoginFields {
		  private String user;
		  private String password;

		  /**
		   * @brief Constructor. Assigns the parameters to the local variables
		   * 
		   * \note The local variable names MUST be the json key names
		   * 
		   * @param user The user parameter
		   * @param password The password parameter
		   */
		  LoginFields(String user, String password) {
			  this.user = user;
			  this.password = password;
		  }
		}
	
	/**
	 * @brief Create the json string used by the body of the rest call login
	 * 
	 * @return the JSon string serialized
	 */
	public String buildJsonLogin() {

		LoginFields fields = new LoginFields(user, password);
		
		// Serialization
		Gson gson = new Gson();
		return gson.toJson(fields);  
	}
	
	/**
	 * @brief Defines the fields used y the rest login, serialized in json format
	 * 
	 * This class is used by the Gson library
	 */
	class RegisterFields {
		  private String name;
		  private String role;

		  /**
		   * @brief Constructor. Assigns the parameters to the local variables
		   * 
		   * \note The local variable names MUST be the json key names
		   * 
		   * @param name The user parameter to register
		   * @param role The user role to verify
		   */
		  RegisterFields(String name, String role) {
			  this.name = name;
			  this.role = role;
		  }
		}
	
	/**
	 * @brief Create the json string used by the body of the rest call register
	 * for new user creation
	 * 
	 * @return the JSon string serialized
	 */
	public String buildJsonRegister() {

		RegisterFields fields = new RegisterFields(name, role);
		
		// Serialization
		Gson gson = new Gson();
		return gson.toJson(fields);  
	}
	
	/**
	 * @brief Constructor
	 * 
	 * @param _id Object generated when it is created on the database
	 * @param name Manager full name
	 * @param email Manager contact email
	 * @param user Manager login user name
	 * @param password Manager stored password
	 * @param updatedAt Last update time stamp
	 * @param createdAt Creation time stamp
	 * @param __v object version Object version number accordingly with the database collection settings
	 */
	public Manager(String _id, String manager, String email, 
			String user, String password, String updatedAt, 
			String createdAt, int __v) {
		super();
		this._id = _id;
		this.manager = manager;
		this.email = email;
		this.user = user;
		this.password = password;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.__v = __v;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param _id Unique ID generated when the object is created in the database
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Unique ID generated when the object is created in the database
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param manager Manager full name
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Manager full name
	 */
	public String getManager() {
		return manager;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param email Manager email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * return Manager email address
	 */
	public String getEmail() {
		return email;
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
	
	/**
	 * @brief Field setter
	 * 
	 * @param updatedAt Last update time stamp
	 */
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Last update time stamp
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param createdAt Creation time stamp
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Creation time stamp
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param __v Object version (assigned by the DB engine)
	 */
	public void set__v(int __v) {
		this.__v = __v;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Object version (assigned by the DB engine)
	 */
	public int get__v() {
		return __v;
	}
	
	
	/**
	 * @brief Field setter
	 * 
	 * @param User registration name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return User registration name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @brief Field setter
	 * 
	 * @param User registration role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return User registration role
	 */
	public String getRole() {
		return role;
	}
}

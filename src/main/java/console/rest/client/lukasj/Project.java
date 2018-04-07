/**
 * @file Project.java
 * @brief Manages the project collection data model
 * 
 * Defines the fields, getters and setters of the object "project"
 * 
 * @version 1.0.0
 * @date April 2018
 * @author Enrico Miglino <enrico.miglino@gmail.com>
 */
package console.rest.client.lukasj;

/**
 * @brief Defines the Project model and the fields getters and setters
 */
public class Project {

	private String _id;				///< Data field
	private String status;			///< Data field
	private String project;			///< Data field
	private String description;		///< Data field
	private String author;			///< Data field
	private String updatedAt;		///< Data field
	private String createdAt;		///< Data field
	private int __v;				///< Data field

	/**
	 * @brief Constructor
	 */
	public Project() {
		super();
	}

	/**
	 * @brief Constructor
	 * 
	 * @param _id Object generated when it is created on the database
	 * @param status Project status
	 * @param project Project name
	 * @param description Project description
	 * @param author Project author full name
	 * @param updatedAt Last update time stamp
	 * @param createdAt Creation time stamp
	 * @param __v object version, accordingly with the database collection settings
	 */
	public Project(String _id, String status, String project, 
			String description, String author, String updatedAt, 
			String createdAt, int __v) {
		super();
		
		this._id = _id;
		this.status = status;
		this.project = project;
		this.description = description;
		this.author = author;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.__v = __v;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param author Project author name
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return roject author name
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param description Project description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Project description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param project Project name
	 */
	public void setProject(String project) {
		this.project = project;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Project name
	 */
	public String getProject() {
		return project;
	}
	
	/**
	 * @brief Field setter
	 * 
	 * @param status Current project status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @brief Field getter
	 * 
	 * @return Current project status
	 */
	public String getStatus() {
		return status;
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
}

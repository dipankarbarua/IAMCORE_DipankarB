package epita.fr.dipankar.datamodel;

public class Identity {
	private int uid;
	private String FirstName;
	private String LastName;
	private String email;
	private int ContactNumber;
	public Identity(int uid, String firstName, String lastName, String email, int contactNumber) {
		super();
		this.uid = uid;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		ContactNumber = contactNumber;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(int contactNumber) {
		ContactNumber = contactNumber;
	}
	public String toString() {
		return "Identity [uid=" + uid + ", FirstName=" + FirstName + ",LastName=" +LastName + " ,email=" + email + ",number=" +ContactNumber  + "]";
	}

	
	 
	
}

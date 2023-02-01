package phonebook;

public class Contact {
	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;
	
	public Contact(){
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Contact(String name, String address, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public String toString(){
		return "ID:     "   + this.id      + "\n" +
			   "Name:   "   + this.name    + "\n" +
			   "Adress: "   + this.address + "\n" +
			   "Email:  "   + this.email   + "\n" +
			   "Phone:  "   + this.phone   + "\n";
	}
	
}

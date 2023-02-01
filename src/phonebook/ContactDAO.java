package phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
	/*SQL*/
	private final static String INSERT = "INSERT INTO contact (name,address,email,phone) VALUES (?,?,?,?)";
	private final static String DELETE = "DELETE FROM contact WHERE id=?";
	private final static String UPDATE = "UPDATE contact SET name=?,address=?,email=?,phone=? WHERE id=?";
	private final static String SELECT = "SELECT * FROM contact";
	
	/*DB variables*/
	private Connection con         = null;
	private ResultSet rs           = null;
	private PreparedStatement stmt = null;
	
	public ContactDAO() {
	}
	 
	public void insert(Contact contact) {
		 try{
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(INSERT);	
			stmt.setString(1,contact.getName());
			stmt.setString(2,contact.getAddress());
			stmt.setString(3,contact.getEmail());
			stmt.setString(4,contact.getPhone());
			stmt.execute();
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }finally{
			 try { if (stmt != null) stmt.close(); } catch (Exception e) {};
			 try { if (con  != null) con.close();  } catch (Exception e) {};
		 }
	}
	
	public void update(Contact contact){
		try{
			con  = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(UPDATE);	
			stmt.setString(1,contact.getName());
			stmt.setString(2,contact.getAddress());
			stmt.setString(3,contact.getEmail());
			stmt.setString(4,contact.getPhone());
			stmt.setLong(5,contact.getId());
			stmt.execute();
		}catch(SQLException e){
			 throw new RuntimeException(e);
		}finally{
			 try { if (stmt != null) stmt.close(); } catch (Exception e) {};
			 try { if (con  != null) con.close();  } catch (Exception e) {};
		}
	}
	
	public List<Contact> getAllContacts() {
	     try {
	         con  = new ConnectionFactory().getConnection();
	         stmt = con.prepareStatement(SELECT);
	    	 List<Contact> contacts = new ArrayList<Contact>();
	        
	    	 rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             Contact contact = new Contact();
	             contact.setId(rs.getInt("id"));
	             contact.setName(rs.getString("name"));
	             contact.setEmail(rs.getString("address"));
	             contact.setAddress(rs.getString("email"));
	             contacts.add(contact);
	         }
	         return contacts;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }finally{
	    	 try { if (rs   != null) stmt.close();   } catch (Exception e) {};
			 try { if (stmt != null) stmt.close();   } catch (Exception e) {};
			 try { if (con  != null) con.close();    } catch (Exception e) {};
		}
	 }
	
	public void delete(Contact contact) {
		try {
			con = new ConnectionFactory().getConnection();
		    stmt = con.prepareStatement(DELETE);
		    stmt.setLong(1, contact.getId());
		    stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
			try { if (con  != null) con.close();  } catch (Exception e) {};
		}
	}	 
}
	 
	  
	  


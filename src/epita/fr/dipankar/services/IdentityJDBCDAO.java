package epita.fr.dipankar.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import epita.fr.dipankar.datamodel.Identity;

public class IdentityJDBCDAO {
	
	private Connection currentConnection;
	private Connection getConnection() throws SQLException {
		try {
			this.currentConnection.getSchema();
		} catch (Exception e) {
			// TODO read those information from a file
			String user = "admin";
			String password = "admin";
			String connectionString = "jdbc:derby://localhost:1527/sample;create=true";
			this.currentConnection = DriverManager.getConnection(connectionString, user, password);
		}
		return this.currentConnection;
	}
public void show () throws SQLException {
	Connection connection = getConnection();
	PreparedStatement statement = connection.prepareStatement("select * from USERTABLE");
	ResultSet rs = statement.executeQuery();

	while (rs.next()) {
		int uid = rs.getInt("ID");
		String FirstName = rs.getString("FIRSTNAME");
		String LastName = rs.getString("LASTNAME");
		String email = rs.getString("EMAIL");
		int ContactNumber = rs.getInt("number");
		Identity identity = new Identity(uid,FirstName,LastName,email,ContactNumber);
		System.out.println(identity.toString());
	
	
}

}
public void insert(Identity identity) throws SQLException {
	Connection connection = getConnection();
	String insertStatement = "insert into USERTABLE (id, firstname, lastname,email,number) "
			+ "values(?, ?, ?,?,?)";
	PreparedStatement pstmt_insert = connection.prepareStatement(insertStatement);
	pstmt_insert.setString(2, identity.getFirstName());
	pstmt_insert.setString(3, identity.getLastName());
	pstmt_insert.setString(4, identity.getEmail());
	pstmt_insert.setInt(1, identity.getUid());
	pstmt_insert.setInt(5, identity.getContactNumber());
	
	

	pstmt_insert.execute();
	
}
public void update(Identity identity) throws SQLException {
	Connection connection = getConnection();
	String UpdateStatement = "update USERTABLE set firstname=?, lastname=?,email=?,number=? where id=?";
	PreparedStatement pstmt_update = connection.prepareStatement(UpdateStatement);
	pstmt_update.setString(1, identity.getFirstName());
	pstmt_update.setString(2, identity.getLastName());
	pstmt_update.setString(3, identity.getEmail());
	pstmt_update.setInt(5, identity.getUid());
	pstmt_update.setInt(4, identity.getContactNumber());
	
	pstmt_update.execute();
	
}
public void delete(Identity identity) throws SQLException {
	Connection connection = getConnection();
	String deleteStatement = "delete from USERTABLE where id=?";
	PreparedStatement pstmt_delete = connection.prepareStatement(deleteStatement);
	pstmt_delete.setInt(1, identity.getUid());
	pstmt_delete.execute();
	
}


}

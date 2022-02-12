package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.getConnection;

import pojo.User;

public class UserDaoImpl implements IUserDao {
	
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	
	public UserDaoImpl() throws SQLException{
		//connection
		cn = getConnection();
		
		pst1 = cn.prepareStatement("select * from users where email=? and password =?");
		
		pst2 = cn.prepareStatement("update users set password=? where email=? and password=?");
		
		pst3 = cn.prepareStatement("select name from topics");
		
		System.out.println("User Dao Created.....!!!!");
		
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		User user = new User();
		// set In params
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst = pst1.executeQuery())
		{
			while (rst.next()) {
				user = new User(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getString(4), 
						rst.getDouble(5), rst.getDate(6), rst.getString(7));
			}
		}		
		return user;
	}
	
	@Override
	public String changepassword(String email, String password, String newpassword) throws SQLException {
		// set IN parameters
		pst2.setString(1, newpassword);
		pst2.setString(2, email);
		pst2.setString(3, password);
		
		int change=pst2.executeUpdate();
		
		if(change ==1)
			return "New password updated Succesfully";
		
		return "Invalid credentials for password updatation";
		
	}
	
	@Override
	public List<String> displayAllTopics() throws SQLException {
		List<String> topicsList = new ArrayList<>();
		
		try(ResultSet rst = pst3.executeQuery())
		{
			while (rst.next()) {
				
				topicsList.add(rst.getString(1));				
			}
		}
		return topicsList;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		if(pst2!= null)
			pst2.close();
		if(pst3!=null)
			pst3.close();
		
		if(cn!=null)
			cn.close();
		
		System.out.println("User dao cleaned up....!!!!!!!!");
	}	

}

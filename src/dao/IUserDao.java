package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.User;

public interface IUserDao {

	//implementation method
	
	//to valid login
User authenticateUser(String email, String password) throws SQLException;

//change password
String changepassword(String email, String password, String newpassword) throws SQLException;

//Get List of all topics
List<String>displayAllTopics() throws SQLException;

}

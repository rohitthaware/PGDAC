package tester;

import java.util.Scanner;

import dao.UserDaoImpl;
import pojo.User;

public class TestUserAuthentication {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			// instance of UserImple
			UserDaoImpl dao = new UserDaoImpl();

			System.out.println("Enter email and password for authntication");

			User user = dao.authenticateUser(sc.next(), sc.next());

			if (user.getName() == null || user.getPassword() == null) {
				System.out.println("Invalid Credentials");
			}

			else {
				System.out.println("Login Successful....!!!!!!");
				System.out.println(user.toString());
			}
			
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

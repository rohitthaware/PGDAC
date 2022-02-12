package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class TestChangePassword {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			
			System.out.println("Enter emailId , old password and newPassword for updation");
			
			System.out.println(dao.changepassword(sc.next(), sc.next(), sc.next()));
			
			dao.cleanUp();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

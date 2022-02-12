package tester;

import java.util.Scanner;

import dao.UserDaoImpl;
import pojo.User;

public class TestProgram {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			boolean flag = false;

			while (!flag) {
				try {

					System.out.println(
							"Enter the choice \n 1. Authenticate User \n 2. Update Password \n 3. Display all topics\n  0. Exit");

					switch (sc.nextInt()) {
					case 1:// Autheticate User

						System.out.println("Enter email and password for authntication");

						User user = dao.authenticateUser(sc.next(), sc.next());

						if (user.getName() == null || user.getPassword() == null) {
							System.out.println("Invalid Credentials");
						}

						else {
							System.out.println("Login Successful....!!!!!!");
							System.out.println(user.toString());
						}
						System.out.println();
						break;

					case 2: // Update Password

						System.out.println("Enter emailId , old password and newPassword for updation");

						System.out.println(dao.changepassword(sc.next(), sc.next(), sc.next()));
						System.out.println();
						break;

					case 3: // Display all topic list
						System.out.println("List of all Topics :");
						dao.displayAllTopics().forEach(System.out::println);
						System.out.println();
						break;

					case 0: // Cleanup and Exit

						dao.cleanUp();
						flag = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

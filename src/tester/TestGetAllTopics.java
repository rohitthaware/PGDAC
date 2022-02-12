package tester;

import dao.UserDaoImpl;

public class TestGetAllTopics {

	public static void main(String[] args) {
		try {
			//instance of implementation class
			UserDaoImpl dao = new UserDaoImpl();
			
			dao.displayAllTopics().forEach(System.out::println);

			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

package crudProject.run;

import crudProject.service.TransportService;

public class ProjectRun {

	public static void main(String[] args) {

		TransportService service = new TransportService();
		service.displayMenu();
	}

}

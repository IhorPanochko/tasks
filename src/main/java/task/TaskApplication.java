package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import task.Entity.Department;
import task.Entity.Lector;
import task.Repository.DepartmentRepository;
import task.service.LectorService;

@SpringBootApplication
public class TaskApplication {

//@Autowired
//private  LectorService lectorService;

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);


//	public  void add(){
//		lectorService.add(new Lector("asas","asas"));
//	}


	}
}


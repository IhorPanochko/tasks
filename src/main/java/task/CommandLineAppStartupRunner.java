package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import task.Entity.Department;
import task.Entity.Lector;
import task.Enums.Degree;
import task.service.DepartmentService;
import task.service.LectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1 on 23.04.2019.
 */

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private LectorService lectorService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void run(String...args) throws Exception {
                Lector lector1=new Lector("name1","surname1",23.2,Degree.ASSISTANT);
                Lector lector2=new Lector("name2","surname2",232.2,Degree.PROFESSOR);
                Lector lector3=new Lector("name3","surname3",232.2,Degree.PROFESSOR);
                Lector lector4=new Lector("name4","surname4",242.2,Degree.PROFESSOR);
                Lector lector5=new Lector("name5","surname5",252.2,Degree.ASSOCIATEPROFESSOR);
                Lector lector6=new Lector("name6","surname6",262.2,Degree.ASSOCIATEPROFESSOR);
                Lector lector7=new Lector("name7","surname7",272.2,Degree.PROFESSOR);
                Lector lector8=new Lector("name8","surname8",282.2,Degree.ASSISTANT);
                Lector lector9=new Lector("name9","surname9",292.2,Degree.ASSISTANT);
                Lector lector10=new Lector("name10","surname10",242.2,Degree.PROFESSOR);
                Lector lector11=new Lector("name11","surname11",2242.2,Degree.ASSISTANT);
                Lector lector12=new Lector("name12","surname12",2242542.2,Degree.HEAD);
                Lector lector13=new Lector("name13","surname13",26542.2,Degree.HEAD);
                Lector lector14=new Lector("name14","surname14",2112.2,Degree.HEAD);
//        lectorService.add(lector1);
//        lectorService.add(lector2);
//        lectorService.add(lector3);
//        lectorService.add(lector4);
//        lectorService.add(lector5);
//        lectorService.add(lector6);
//        lectorService.add(lector7);
//        lectorService.add(lector8);
//        lectorService.add(lector9);
//        lectorService.add(lector10);
//        lectorService.add(lector11);

        Department department1=new Department("departmantname1",lector12);

        Department department2=new Department("departmantname2",lector14);

        Department department3=new Department("departmantname3",lector13);

//        departmentService.create(department1);
//        departmentService.create(department2);
//        departmentService.create(department3);
//
//        departmentService.addLectotToDepartment(department1,lector1);
//        departmentService.addLectotToDepartment(department1,lector2);
//        departmentService.addLectotToDepartment(department1,lector3);
//        departmentService.addLectotToDepartment(department1,lector4);
//
//        departmentService.addLectotToDepartment(department2,lector5);
//        departmentService.addLectotToDepartment(department2,lector6);
//        departmentService.addLectotToDepartment(department2,lector7);
//        departmentService.addLectotToDepartment(department2,lector8);
//
//        departmentService.addLectotToDepartment(department3,lector9);
//        departmentService.addLectotToDepartment(department3,lector10);
//        departmentService.addLectotToDepartment(department3,lector11);


//        System.out.println(lectorService.getHeadInDepart(department1.getDepartmentName())); 1 +

//        departmentService.showStatistic("departmantname3");

//        System.out.println(        departmentService.showavgSalaryInDepartmant("departmantname3")); 3+

//        System.out.println(departmentService.showCountEmployee("departmantname3"));





boolean exit=true;

while (exit){
    Scanner scanner=new Scanner(System.in);
    showmenu();
    int n=scanner.nextInt();
         if (n==1){
          System.out.println("input name of departmant");
          String departmantName = scanner.next();
             System.out.println(lectorService.getHeadInDepart(departmantName));

      }else
         if(n==2){
          System.out.print("input name of departmant");
          String departmantName = scanner.next();
          Lector lector=getHead();
          departmentService.create(new Department(departmantName,lector));
      }else
          if(n==3){
             Lector lector=getLector();
//             System.out.println("input name of departmant to add");
//             String departmantName=scanner.next();
//             departmentService.addLectotToDepartment(departmentService.getMtName(departmantName),lector);
              lectorService.add(lector);
          } else
           if(n==4){
               System.out.println("input name of departmant");
               String departmantName=scanner.next();
               departmentService.showStatistic(departmantName);
           }else
               if(n==5){
                   System.out.println("input name of departmant");
                   String departmantName=scanner.next();
                   System.out.println( departmentService.showavgSalaryInDepartmant(departmantName));
               }else
                   if(n==6){
                       System.out.println("input name of departmant");
                       String departmantName=scanner.next();
                       System.out.println(departmentService.showCountEmployee(departmantName));

                   }else
                       if(n==7){
                           System.out.println("input text");
                           String text=scanner.next();

                           System.out.println(lectorService.getText(text));


                       }else
                  if(n==8){
                     exit=false;
}
}
        System.out.println("exited");
    }

    public void showmenu(){
        System.out.println("1- head of department..");
        System.out.println("2- add department");
        System.out.println("3- add lector to department");
        System.out.println("4- Show department_name statistic.");
        System.out.println("5- average salary for department");
        System.out.println("6- count of employee for department");
        System.out.println("7- look for");
        System.out.println("8- exit");
    }

    public Lector getLector(){
        Lector lector=new Lector();
        Scanner scanner=new Scanner(System.in);
        System.out.println("input name");
        String name=scanner.next();
        System.out.println("input surname");
        String surname=scanner.next();
        System.out.println("input salary");
        double salary=scanner.nextDouble();

        lector.setName(name);
        lector.setSurname(surname);
        lector.setSalary(salary);

        System.out.println("input departmant name");
        String depname=scanner.next();

        List<Department>departments=new ArrayList<>();
        departments.add(departmentService.getMtName(depname));

        lector.setDepartments(departments);

        System.out.println("what degree ? ");
        System.out.println("1- ASSISTANT");
        System.out.println("2- PROFESSOR");
        System.out.println("3- ASSOCIATE PROFESSOR");
        int n;
        n=scanner.nextInt();
        if(n==1){
            lector.setDegree(Degree.ASSISTANT);
        }else
        if(n==2){
            lector.setDegree(Degree.PROFESSOR);
        }else
        if(n==3){
            lector.setDegree(Degree.ASSOCIATEPROFESSOR);
        }
return lector;
    }

    public Lector getHead(){
        Lector lector=new Lector();
        Scanner scanner=new Scanner(System.in);
        System.out.println("input name");
        String name=scanner.nextLine();
        System.out.println("input surname");
        String surname=scanner.nextLine();
        System.out.println("input salary");
        double salary=scanner.nextDouble();

        lector.setName(name);
        lector.setSurname(surname);
        lector.setSalary(salary);
        lector.setDegree(Degree.HEAD);
        return lector;
    }

}
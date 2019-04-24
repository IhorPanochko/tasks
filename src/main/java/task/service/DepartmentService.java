package task.service;

import task.Entity.Department;
import task.Entity.Lector;

/**
 * Created by 1 on 23.04.2019.
 */
public interface DepartmentService {

    void create(Department department);

    void delete(Department department);

    void delete(String departmentName);

    void addLectotToDepartment(Department department, Lector lector);

   void addHeadToDepartment(Department department, Lector lector);

    void showStatistic(String departmanetName);

    Double showavgSalaryInDepartmant(String departmanetName);

    Department getMtName(String name);

    int showCountEmployee(String departmanetName);

}

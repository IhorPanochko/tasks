package task.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.Entity.Department;
import task.Entity.Lector;
import task.Enums.Degree;
import task.Repository.DepartmentRepository;
import task.Repository.LectorRepository;
import task.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 1 on 23.04.2019.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectorRepository lectorRepository;

    @Override
    public void create(Department department) {
departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {

        departmentRepository.delete(department);

    }

    @Override
    public void delete(String departmentName) {
departmentRepository.delete(departmentRepository.findByDepartmentName(departmentName));
    }

    @Override
    public void addLectotToDepartment(Department department, Lector lector) {

        Department department1=departmentRepository.findByDepartmentName(department.getDepartmentName());
        List<Lector>list=department1.getLectors();
        list.add(lectorRepository.findByName(lector.getName()));
        department1.setLectors(list);
        departmentRepository.save(department1);
    }

    @Override
    public void addHeadToDepartment(Department department, Lector lector) {

        if(department.getHead()==null){
            department.setHead(lector);
        }

        departmentRepository.save(department);
    }

    @Override
    public Department getMtName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    @Override
    public void showStatistic(String departmanetName) {

        Department department=departmentRepository.findByDepartmentName(departmanetName);

        Long assistans= department.getLectors().stream().filter(lector -> lector.getDegree()==(Degree.ASSISTANT)).count();
        Long associate_professors= department.getLectors().stream().filter(lector -> lector.getDegree()==(Degree.ASSOCIATEPROFESSOR)).count();
        Long professors= department.getLectors().stream().filter(lector -> lector.getDegree()==(Degree.PROFESSOR)).count();

        System.out.println("assistans - "+ assistans);
        System.out.println("associate professors - "+ associate_professors);
        System.out.println("professors - "+ professors);
    }

    @Override
    public Double showavgSalaryInDepartmant(String departmanetName) {

        List<Lector>lectors=departmentRepository.findByDepartmentName(departmanetName).getLectors();
        lectors.add(departmentRepository.findByDepartmentName(departmanetName).getHead());

        return lectors.stream()
                .mapToDouble(Lector::getSalary)
                .average().orElse(0.0);
    }

    @Override
    public int showCountEmployee(String departmanetName) {
        int count=0;
        if(departmentRepository.findByDepartmentName(departmanetName).getHead()!=null){
            count=1;
        }
        return lectorRepository.countByDepartments(departmentRepository.findByDepartmentName(departmanetName))+count;
    }
}

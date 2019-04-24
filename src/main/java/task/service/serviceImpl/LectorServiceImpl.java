package task.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.Entity.Department;
import task.Entity.Lector;
import task.Enums.Degree;
import task.Repository.DepartmentRepository;
import task.Repository.LectorRepository;
import task.service.LectorService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by 1 on 23.04.2019.
 */
@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    private LectorRepository lectorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void add(Lector lector) {

        lectorRepository.save(lector);
    }


    @Override
    public Lector getHeadInDepart(String departmentname) {

Department department=departmentRepository.findByDepartmentName(departmentname);

        return department.getHead();
    }


   public Set<String> getText(String text){

        Set<String>strings=new HashSet<>();

        List<Department>departs=departmentRepository.findAll();
        List<Lector>lectors=lectorRepository.findAll();

        for (Department dep:departs) {
strings.addAll(dep.getStrings());
        }
for (Lector lec:lectors){
            strings.addAll(lec.getStrings());
}

        return strings.stream().filter(s -> s.contains(text)).collect(Collectors.toSet());


    }

}

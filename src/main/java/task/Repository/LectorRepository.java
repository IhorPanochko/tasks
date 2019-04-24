package task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import task.Entity.Department;
import task.Entity.Lector;
import task.Enums.Degree;

import java.util.List;

/**
 * Created by 1 on 23.04.2019.
 */
public interface LectorRepository extends JpaRepository<Lector,Long> {

    Lector findByName(String name);



    List<Lector> findByDepartments(Department department);

    List<Lector>findByDepartmentsAndAndDegree(Department department, Degree degree);



    int countByDepartments(Department department);


//    @Query(value = "SELECT avg(l.salary) from Lector  l where l.departments=:department and l.degree=:degree")
//    Lector getHead(@Param("department") Department department,@Param("degree") String degree);
//


}

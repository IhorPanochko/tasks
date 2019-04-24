package task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.Entity.Department;

/**
 * Created by 1 on 23.04.2019.
 */
public interface DepartmentRepository  extends JpaRepository<Department,Long>{



     Department findByDepartmentName(String name);



}

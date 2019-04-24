package task.service;

import task.Entity.Department;
import task.Entity.Lector;
import task.Enums.Degree;

import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 23.04.2019.
 */
public interface LectorService {

    void add(Lector lector);

    Lector getHeadInDepart(String departname);


    Set<String> getText(String text);
}

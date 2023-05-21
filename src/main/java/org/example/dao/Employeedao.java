package org.example.dao;

import java.util.ArrayList;
import java.util.List;

public interface Employeedao {
    ArrayList<employee> findall();
    employee findbyid(int id);
    void save(employee employee);
    void deletebyid(int id);
}

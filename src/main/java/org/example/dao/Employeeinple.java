package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employeeinple implements Employeedao{

    @Override
    public ArrayList<employee> findall() {
        Connection con=coonection.getCoonection();
        if(con==null) {
            return null;

        }
        ArrayList<employee>employees=new ArrayList<>();
        String quere="SELECT * FROM employee;";
        try(PreparedStatement s=con.prepareStatement(quere)) {
            ResultSet r=s.executeQuery();
            while (r.next()){
                employee e=new employee(r.getInt("id"),r.getString("name"),r.getBoolean("gender"),r.getDouble("salary"));
                employees.add(e);
            }
        }catch (SQLException w){
            w.printStackTrace();
        }
        return employees;
    }

    @Override
    public employee findbyid(int id) {
        Connection con=coonection.getCoonection();
        String q="SELECT * FROM employee WHERE id=?;";
        try (PreparedStatement r=con.prepareStatement(q)){
            r.setInt(1,id);
           ResultSet s= r.executeQuery();
           if(s.next()){
                employee e= new employee(s.getInt("id"),s.getString("name"),s.getBoolean("gender"),s.getDouble("salary"));
          return e;
           }
        }
        catch (SQLException e)
        {e.printStackTrace();}
    return null;
    }

    @Override
    public void save(employee employee) {
        Connection con= coonection.getCoonection();
if(con==null){return;}
if(employee.getId()>0){
String q="UPDATE employee SET name=? , gender=? , salary=? WHERE id=?";
    try(PreparedStatement p=con.prepareStatement(q)) {
    p.setString(1,employee.getName());
    p.setBoolean(2,employee.isGender());
    p.setDouble(3,employee.getSalary());
    p.setInt(4,employee.getId());
    p.executeUpdate();
    }catch (SQLException ex){
    ex.printStackTrace();}}
else{
String quere="INSERT INTO employee(name,gender,salary)VALUES("+"\'"+employee.getName()+"\'"+","+employee.isGender()+","+employee.getSalary()+")";
    System.out.println(quere);
    try {
     Statement s=con.createStatement();
     s.execute(quere);
    }catch (Exception ex){
ex.printStackTrace();
    }
}
    }

    @Override
    public void deletebyid(int id) {
Connection con=coonection.getCoonection();
if(con==null){
    return;
}
String q="DELETE FROM employee WHERE id=?;";
try(PreparedStatement s=con.prepareStatement(q)) {
    s.setInt(1,id);
    s.executeUpdate();
}
catch (SQLException e){e.printStackTrace();}

    }
}

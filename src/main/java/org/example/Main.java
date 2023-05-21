package org.example;

import org.example.dao.Employeedao;
import org.example.dao.Employeeinple;
import org.example.dao.coonection;
import org.example.dao.employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);coonection.getCoonection();
        boolean q=true;
        Employeedao e=new Employeeinple();
        employee r=new employee();
        System.out.println("---------main---------");
        System.out.println("ENTER [1] to add employee or update    ENTER[2] TO find employee by ID    ENTER[3] to find ALL    ENTER[4] to delete employee    ENTER[5] to EXIT ");
int choise= input.nextInt();
switch (choise){

    case 1:

        System.out.println("enter 1 to update enter 2 to add ");
        int c=input.nextInt();
        if(c==1){
            System.out.println("Enter ID");
            r.setId(input.nextInt());
            System.out.println("Enter New  name");
            r.setName(input.next());
            System.out.println("Enter New gender");
            r.setGender(input.nextBoolean());
            System.out.println("Enter New salary");
            r.setSalary(input.nextDouble());
            e.save(r);
        }
        else if(c==2){
        System.out.println("Enter the name");
        r.setName(input.next());
            System.out.println("Enter the gender write true if you male write false if you female");

            r.setGender(input.nextBoolean());
            System.out.println("Enter the salary");
            r.setSalary(input.nextDouble());
            e.save(r);
            break;
        }

    case 2:
        System.out.println("Enter the id");
        int d=input.nextInt();
        e.findbyid(d);
        break;
    case 3:
        e.findall().forEach(System.out::println);
break;
    case 4:
        System.out.println("Enter id which you want to delete it");
        int i=input.nextInt();

       if(e.findbyid(i)==null){
           System.out.println("There no ID with this name");
       }else {e.deletebyid(i);}
       break;
    case 5:
        q=false;
        break;
}


    }
}
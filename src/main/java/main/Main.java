package main;

import daoimpl.EmployeeDaoimpl;
import model.Employee;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EmployeeDaoimpl empDao = new EmployeeDaoimpl();
        List<Employee> listOfemps = new ArrayList<Employee>();
//        Gọi phương thức để trả về 1 danh sách nhân viên
        listOfemps = empDao.getAllEmployees();
        for(Employee employee : listOfemps) {
            System.out.println(employee);
        }
//
        System.out.println(empDao.getEmployeeById(2));

//
        System.out.println(empDao.getEmployeeByName("Minnnie Wilmut"));

//
        System.out.println(empDao.getNameById(2));
    }
}

package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee getEmployeeById(int id); //Dùng cho TRUY VẤN (SELECT)
    public Employee getEmployeeByName(String name); //Dùng cho TRUY VẤN (SELECT)
    public Employee getEmployeeByEmail(String email); //Dùng cho TRUY VẤN (SELECT)
    public String getNameById(int id); //Dùng cho TRUY VẤN (SELECT)
    public List<Employee> getAllEmployees(); //Dùng cho TRUY VẤN (SELECT)
    public void saveEmployee(Employee emp); //Dùng cho THÊM dữ liệu (INSERT INTO)
    public void updateEmployee(Employee emp); //Dùng cho SỬA dữ liệu (UPDATE)
    public void deleteEmployeeById(int id); //Dùng cho XÓA dữ liệu (DELETE FROM)
}

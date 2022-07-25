package daoimpl;

import dao.EmployeeDAO;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoimpl implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(int id) {
        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
            Connection conn = DriverManager.getConnection(dbURL, "root", "kit@2022A");

            String sql = "select * from employee where id = " + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Employee emp = new Employee();
            while (rs.next()) {

                emp.setId(rs.getInt("id"));
                emp.setFullName(rs.getString("fullName"));
                emp.setEmail(rs.getString("email"));
                emp.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                emp.setLongWork(rs.getInt("long_work"));
                emp.setFixedSalary(rs.getDouble("fixed_salary"));
                emp.setOutsideSeviceNumber(rs.getInt("outside_service_number"));
                emp.setTotalSalary(rs.getDouble("total_salary"));
            }
            conn.close();
            return emp;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String dbURL ="jdbc:mysql://localhost:3305/employeemanagement";
        try {

            Connection conn = DriverManager.getConnection(dbURL, "root","kit@2022A");
            String sql = "select * from employee where fullName = \"name\"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            Employee emp = new Employee();
            while (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setFullName(rs.getString("fullName"));
                emp.setEmail(rs.getString("email"));
                emp.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                emp.setLongWork(rs.getInt("long_work"));
                emp.setFixedSalary(rs.getDouble("fixed_salary"));
                emp.setOutsideSeviceNumber(rs.getInt("outside_service_number"));
                emp.setTotalSalary(rs.getDouble("total_salary"));
            }
            rs.close();
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getEmployeeByEmail(String email) {

    }

    @Override
    public String getNameById(int id) {
        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
            Connection conn = DriverManager.getConnection(dbURL,"root","kit@2022A");

            String sql = "select fullName from employee where id = " + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Employee emp = new Employee();
            while (rs.next()) {
                emp.setFullName(rs.getString("fullName"));
            }
            String emps = emp.getFullName();
            conn.close();
            return emps;
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> listOfEmps = new ArrayList<Employee>();
//        QUy trình 4 bước:
//        Bước 1: kết nối được vào database server

        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
            Connection conn = DriverManager.getConnection(dbURL,"root","kit@2022A");

//         Bước 2: Định nghĩa câu truy vấn và thực hiện truy vấn
            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//         Bước 3: Xử lý kết quả trả về
            while (rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFullName(rs.getString("fullName"));
                emp.setEmail(rs.getString("email"));
                emp.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                emp.setLongWork(rs.getInt("long_work"));
                emp.setFixedSalary(rs.getDouble("fixed_salary"));
                emp.setOutsideSeviceNumber(rs.getInt("outside_service_number"));
                emp.setTotalSalary(rs.getDouble("total_salary"));

//                Đưa đối tượng vào danh sách
                listOfEmps.add(emp);
            }
//         Bước 4: Đóng kết nối
            conn.close();
            return listOfEmps;

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveEmployee(Employee emp) {


    }

    @Override
    public void updateEmployee(Employee emp) {

    }

    @Override
    public void deleteEmployee(Employee emp) {

    }
}

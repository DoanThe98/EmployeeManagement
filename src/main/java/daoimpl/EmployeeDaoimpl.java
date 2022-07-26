package daoimpl;

import dao.EmployeeDAO;
import model.Employee;
import utils.DBConnection;

import javax.swing.*;
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
            if (rs.next()) {

                emp.setId(rs.getInt("id"));
                emp.setFullName(rs.getString("fullName"));
                emp.setEmail(rs.getString("email"));
                emp.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                emp.setLongWork(rs.getInt("long_work"));
                emp.setFixedSalary(rs.getDouble("fixed_salary"));
                emp.setOutsideSeviceNumber(rs.getInt("outside_service_number"));
                emp.setTotalSalary(rs.getDouble("total_salary"));
                return emp;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
            Employee emp = new Employee();

            Connection conn = DriverManager.getConnection(dbURL, "root", "kit@2022A");
            String sql = "select * from employee where fullName = '" + name + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, name);
            ResultSet rs = ps.executeQuery(sql);
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
    public Employee getEmployeeByEmail(String email) {
        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
            Employee emp = new Employee();

            Connection conn = DriverManager.getConnection(dbURL, "root", "kit@2022A");
            String sql = "select * from employee where email ='" + email + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getNameById(int id) {
//        String dbURL = "jdbc:mysql://localhost:3305/employeemanagement";
        try {
//            Connection conn = DriverManager.getConnection(dbURL,"root","kit@2022A");
            DBConnection dbc = new DBConnection();
            dbc.connectDB();
            String sql = "select fullName from employee where id = " + id;
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Employee emp = new Employee();
            while (rs.next()) {
                emp.setFullName(rs.getString("fullName"));
            }
            String emps = emp.getFullName();
            dbc.disconnectDB();
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
            Connection conn = DriverManager.getConnection(dbURL, "root", "kit@2022A");

//         Bước 2: Định nghĩa câu truy vấn và thực hiện truy vấn
            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//         Bước 3: Xử lý kết quả trả về
            while (rs.next()) {
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
//        QUy trình 4 bước:
//        Bước 1: kết nối được vào database server


        try {
            DBConnection dbc = new DBConnection();
            dbc.connectDB();

//         Bước 2: Định nghĩa câu truy vấn và thực hiện truy vấn
            String sql = "insert into employee(fullName, email) values (?,?)";
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, emp.getFullName());
            ps.setString(2, emp.getEmail());
            int numberOfRecords = ps.executeUpdate();

//         Bước 3: Xử lý kết quả trả về
            if (numberOfRecords > 0) {
                System.out.println("Ban ghi duoc luu thanh cong");
            } else {
                System.out.println("Ban ghi khong the luu");
            }
//         Bước 4: Đóng kết nối
            dbc.disconnectDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee emp) {
        //        QUy trình 4 bước:
//        Bước 1: kết nối được vào database server


        try {
            DBConnection dbc = new DBConnection();
            dbc.connectDB();

//         Bước 2: Định nghĩa câu truy vấn và thực hiện truy vấn
            String sql = "update employee set fullName = ?, email = ? where id = ?";
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, emp.getFullName());
            ps.setString(2, emp.getEmail());
            ps.setInt(3, emp.getId());
            int numberOfRecords = ps.executeUpdate();

//         Bước 3: Xử lý kết quả trả về
            if (numberOfRecords > 0) {
                System.out.println("Ban ghi duoc cap nhap thanh cong");
            } else {
                System.out.println("Ban ghi khong the luu");
            }
//         Bước 4: Đóng kết nối
            dbc.disconnectDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        //        QUy trình 4 bước:
//        Bước 1: kết nối được vào database server


        try {
            DBConnection dbc = new DBConnection();
            dbc.connectDB();

//         Bước 2: Định nghĩa câu truy vấn và thực hiện truy vấn
            String sql = "delete from employee where id = ?";
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ps.setInt(1, id);
            //Xac nhan tu nguoi dung
            int confirm = JOptionPane.showConfirmDialog(null, "ban co chac chan muon xoa nv co ma : " + id,"Xoa thong tin nv", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                int numberOfRecords = ps.executeUpdate();


//         Bước 3: Xử lý kết quả trả về
                if (numberOfRecords > 0) {
                    System.out.println("Ban da xoa thanh cong");
                } else {
                    System.out.println("xoa khong thanh cong");
                }
            }
//         Bước 4: Đóng kết nối
            dbc.disconnectDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

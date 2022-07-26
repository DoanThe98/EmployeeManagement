package main;

import daoimpl.EmployeeDaoimpl;
import daoimpl.UserDaoimpl;
import model.Employee;
import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;




public class Main {
    static boolean isEnding = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        logins();
    }



    private static void logins() {
        UserDaoimpl uimp = new UserDaoimpl();
        do{
            System.out.println("Đăng nhập:");
            System.out.println("email:");
            String email = sc.nextLine();
            System.out.println("password:");
            String password = sc.nextLine();
            if(uimp.getUserByEmailAndPassword(email,password) != null){
                User u = uimp.getUserByEmailAndPassword(email,password);
                System.out.println("Xin chao: "+ u.getFirstName() + " " + u.getLastName());
                isEnding = true;
                showMenu();
            } else {
                System.out.println("Dang nhap khong thanh cong");
                //        Ket thuc noi dung PT
                System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
                int answer = new Scanner(System.in).nextInt();
                if (answer == 0) {
                    isEnding = true;
                }
            }

        }while (!isEnding);
    }

    private static void showMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    Lua chon menu:
                    1. Lay employee theo id
                    2. Lay employee theo name
                    3. Lay employee theo email
                    4. Lay ten employee theo id
                    5. Lay danh sach employee
                    6. Them 1 employee
                    7. Sua 1 employee
                    8. Xoa 1 employee
                    9. Xuất ra file excel
                    Nhap so danh muc:
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhap id:");
                    int id = sc.nextInt();
                    displayEmployById(id);
                    break;
                case 2:
                    System.out.println("Nhap name:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    displayEmployByName(name);
                case 3:
                    System.out.println("Nhap email:");
                    String email = sc.nextLine();
                    displayEmployByName(email);
                    break;
                case 6:
                    addNewEmploy();
                    break;
                case 7:
                    updateEmploy();
                    break;
                case 8:
                    deleteEmploy();
                    break;
                    case 9:
                        export();
                        break;
                default:
                    System.out.println("Cam on hen gap lai");
                    System.exit(0);
                    isEnding = true;
            }
        } while (!isEnding);

    }

    public static void displayEmployById(int id) {
        EmployeeDaoimpl empDao = new EmployeeDaoimpl();
        Employee emp = empDao.getEmployeeById(id);
        System.out.println("Nhan vien co ma: " + id);
        System.out.println(emp.toString());

//        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }

    public static void displayEmployByName(String name) {
        EmployeeDaoimpl empDao = new EmployeeDaoimpl();
        Employee emp = empDao.getEmployeeByName(name);
        System.out.println("Nhan vien co ma: " + name);
        System.out.println(emp.toString());

        //        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }

    public static void displayEmployByEmail(String email) {
        EmployeeDaoimpl empDao = new EmployeeDaoimpl();
        Employee emp = empDao.getEmployeeByEmail(email);
        System.out.println("Nhan vien co ma: " + email);
        System.out.println(emp.toString());

        //        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }
    public static void addNewEmploy() {
        System.out.println("Them 1 nhan vien moi:");
        System.out.println("Ho va ten nhan vien:");
        String fullname = new Scanner(System.in).nextLine();
        System.out.println("email nhan vien:");
        String email = new Scanner(System.in).nextLine();

        Employee emp = new Employee(fullname, email);
        EmployeeDaoimpl edi = new EmployeeDaoimpl();
        edi.saveEmployee(emp);
        //        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }

    public static void updateEmploy() {

        System.out.println("sua 1 nhan vien:");
        System.out.println("id nhan vien:");
        EmployeeDaoimpl edi = new EmployeeDaoimpl();
        int id = new Scanner(System.in).nextInt();
        if (edi.getEmployeeById(id) != null) {

            System.out.println("Ho va ten nhan vien:");
            String fullname = new Scanner(System.in).nextLine();
            System.out.println("email nhan vien:");
            String email = new Scanner(System.in).nextLine();
            Employee emp = new Employee(id, fullname, email);
            edi.updateEmployee(emp);
        } else{
            System.out.println("Ma nhan vien khong ton tai");
        }
        //        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }

    public static void deleteEmploy() {
        System.out.println("Xoa 1 nhan vien:");
        System.out.println("ma nhan vien can xoa:");
        int empID = new Scanner(System.in).nextInt();


        EmployeeDaoimpl edi = new EmployeeDaoimpl();
        if (edi.getEmployeeById(empID) != null) {
            edi.deleteEmployeeById(empID);
        } else {
            System.out.println("ma nhan vien khong ton tai");
//            JOptionPane.showMessageDialog(null, "Ma nv: "+empID + "khong ton tai");
        }
        //        Ket thuc noi dung PT
        System.out.println("Ban co muon tiep tuc khong?(0: Dung - 1: Tiep tuc");
        int answer = new Scanner(System.in).nextInt();
        if (answer == 0) {
            isEnding = true;
        }
    }

    public static void export(){
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
//        2. Tạo ra 1 trang tính  mới (trống)
        XSSFSheet sheet = xssfWorkbook.createSheet("Employee Data");
//        3. Tạo đối tượng mảng muốn ghi
        EmployeeDaoimpl daoImpl = new EmployeeDaoimpl();
        List<Employee> listOfEmps = daoImpl.getAllEmployees();

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"ID", "FULLNAME", "EMAIL", "HOUR_WORK_PER_DAY", "LONG_WORK", "FIXED_SALARY", "OUTSIDE_SERVICE_NUMBER", "TOTAL_SALARY"});
        for (Employee e : listOfEmps) {
            data.put(String.valueOf(e.getId()), new Object[]{
                    e.getId(),
                    e.getFullName(),
                    e.getEmail(),
                    e.getHourWorkPerDay(),
                    e.getLongWork(),
                    e.getFixedSalary(),
                    e.getOutsideSeviceNumber(),
                    e.getTotalSalary()
            });
        }


        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) //Duyệt từng bản ghi thông qua key
        {
            Row row = sheet.createRow(rownum++);// CHỉ số hàng chạy trong excel
            Object[] objArr = data.get(key);// Thông qua key> lấy data tương ứng từng hàng
            int cellnum = 0;
            for (Object obj : objArr)//Duyệt cột để hiển thị ra từng ô
            {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)// Kiểm tra nếu dữ liệu là kiểu chuỗi
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj); // Kiểm tra nếu dữ liệu là kiểu số
            }

            try {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("D://Data_demo.xlsx"));
                xssfWorkbook.write(out);
                out.close();
                System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

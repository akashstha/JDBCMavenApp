package com.JDBCApp.JDBCApp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.akashshrestha.akashshrestha1.Employee;
import com.akashshrestha.akashshrestha1.ServiceImpl;
import com.akashshrestha.akashshrestha1.Services;

import static com.akashshrestha.akashshrestha1.EmployeeUtil.chooseOperation;
import static com.akashshrestha.akashshrestha1.EmployeeUtil.readEmployee;

public class EmployeeApplication {

    private Services employeeOperations = new ServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        System.out.println("************trng.Employee System**********");
        
        int choice;
        do {
            choice = chooseOperation();

            switch (choice) {
                case 1:
                    employeeApplication.add();
                    break;
                case 2:
                    employeeApplication.display();
                    break;
                case 3:
                    employeeApplication.displayAll();
                    break;
                case 4:
                    employeeApplication.update();
                    break;
                case 5:
                    employeeApplication.delete();
                    break;
                case 6:
                    employeeApplication.displayHRA();
                    break;
                case 7:
                    employeeApplication.displayGrossSalary();
                    break;
                case 8:
                	employeeApplication.sortbyid();
                	break;
                case 9:
                	employeeApplication.sortbysalary();
                	break;
                case 10:
                	employeeApplication.sortbyFirstname();
                	break;
               /* case 11:
                	employeeApplication.groupbyGender();*/
                case 12:
                	employeeApplication.groupbySalary();
                case 13:
                    break;
                
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 13);

        scanner.close();
    }

    private void displayGrossSalary() {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        int empNo = scanner.nextInt();
        System.out.println("Gross Salary of employee id " + empNo + " is : " + employeeOperations.calculateGrossSal(empNo));
    }

    private void displayHRA() {
        System.out.println("Enter the employee id to calculte hra of employee");
        int number = scanner.nextInt();
        System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
    }

    private void delete() {
        System.out.println("Enter the employee id to delete :");
        int empId = scanner.nextInt();
        boolean flag = employeeOperations.deleteEmployee(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
    }

    private void update() {
        System.out.println("Enter Employees data for update:");
        Employee employee = readEmployee();
        employeeOperations.updateEmployee(employee);
    }

    private void displayAll() {
        System.out.println("Employees in the system are :");
        List<Employee> employees = employeeOperations.findAll();
            System.out.println(employees);
        }
  

    private void display() {
        System.out.println("Enter the employee id to view employee info :");
        int empId = scanner.nextInt();
        Employee employee = employeeOperations.findEmployee(empId);
        System.out.println(employee);
    }

    private void add() {
        Employee employee = readEmployee();
        try {
			employeeOperations.createEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    private void sortbyid() {
    	List<Employee> temp = employeeOperations.sortbyid();
    	System.out.println(temp);
    }
    
    private void sortbysalary() {
    	List<Employee> temp = employeeOperations.sortbysalary();
    	System.out.println(temp);
    }
    
    private void sortbyFirstname() {
    	List<Employee> temp = employeeOperations.sortbyFirstname();
    	System.out.println(temp);
    }
    
   /* private void groupbyGender() {
    	 System.out.println(employeeOperations.groupbyGender());
    	
    }*/
    
    private void groupbySalary() {
    	System.out.println(employeeOperations.groupbyAverageSalary());
    }


}

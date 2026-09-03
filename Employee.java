package JavawithDSA;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;

	// Employee class
	class Employee {
	    int id;
	    String name;
	    String department;
	    String designation;
	    double salary;

	    Employee(int id, String name, String department,
	             String designation, double salary) {
	        this.id = id;
	        this.name = name;
	        this.department = department;
	        this.designation = designation;
	        this.salary = salary;
	    }

	    void display() {
	        System.out.printf("%-8d %-20s %-15s %-18s %.2f%n",
	                id, name, department, designation, salary);
	    }
	}

	// Main class
	public class EmployeeManagementSystem {

	    static ArrayList<Employee> employees = new ArrayList<>();
	    static Scanner sc = new Scanner(System.in);

	    // Add employee
	    static void addEmployee() {

	        System.out.println("\n===== ADD EMPLOYEE =====");

	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        // Check duplicate ID
	        for (Employee e : employees) {
	            if (e.id == id) {
	                System.out.println("Employee ID already exists!");
	                return;
	            }
	        }

	        System.out.print("Enter Employee Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Department: ");
	        String department = sc.nextLine();

	        System.out.print("Enter Designation: ");
	        String designation = sc.nextLine();

	        System.out.print("Enter Salary: ");
	        double salary = sc.nextDouble();

	        Employee emp = new Employee(
	                id, name, department, designation, salary);

	        employees.add(emp);

	        System.out.println("Employee added successfully!");
	    }

	    // Display employees
	    static void displayEmployees() {

	        System.out.println("\n================ EMPLOYEE LIST ================");

	        if (employees.isEmpty()) {
	            System.out.println("No employees found.");
	            return;
	        }

	        System.out.printf("%-8s %-20s %-15s %-18s %s%n",
	                "ID", "Name", "Department",
	                "Designation", "Salary");

	        System.out.println(
	                "---------------------------------------------------------------");

	        for (Employee e : employees) {
	            e.display();
	        }
	    }

	    // Search employee
	    static void searchEmployee() {

	        System.out.println("\n===== SEARCH EMPLOYEE =====");

	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();

	        boolean found = false;

	        for (Employee e : employees) {

	            if (e.id == id) {

	                System.out.println("\nEmployee Found!");

	                System.out.println("Employee ID   : " + e.id);
	                System.out.println("Name          : " + e.name);
	                System.out.println("Department    : " + e.department);
	                System.out.println("Designation   : " + e.designation);
	                System.out.println("Salary        : " + e.salary);

	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("Employee not found.");
	        }
	    }

	    // Update employee
	    static void updateEmployee() {

	        System.out.println("\n===== UPDATE EMPLOYEE =====");

	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        for (Employee e : employees) {

	            if (e.id == id) {

	                System.out.print("Enter New Name: ");
	                e.name = sc.nextLine();

	                System.out.print("Enter New Department: ");
	                e.department = sc.nextLine();

	                System.out.print("Enter New Designation: ");
	                e.designation = sc.nextLine();

	                System.out.print("Enter New Salary: ");
	                e.salary = sc.nextDouble();

	                System.out.println(
	                        "Employee details updated successfully!");

	                return;
	            }
	        }

	        System.out.println("Employee not found.");
	    }

	    // Delete employee
	    static void deleteEmployee() {

	        System.out.println("\n===== DELETE EMPLOYEE =====");

	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();

	        for (int i = 0; i < employees.size(); i++) {

	            if (employees.get(i).id == id) {

	                employees.remove(i);

	                System.out.println(
	                        "Employee deleted successfully!");

	                return;
	            }
	        }

	        System.out.println("Employee not found.");
	    }

	    // Sort employees by salary
	    static void sortBySalary() {

	        if (employees.isEmpty()) {
	            System.out.println("No employees available.");
	            return;
	        }

	        Collections.sort(employees,
	                Comparator.comparingDouble(e -> e.salary));

	        System.out.println("\nEmployees sorted by salary.");

	        displayEmployees();
	    }

	    // Sort employees by name
	    static void sortByName() {

	        if (employees.isEmpty()) {
	            System.out.println("No employees available.");
	            return;
	        }

	        Collections.sort(employees,
	                Comparator.comparing(e -> e.name.toLowerCase()));

	        System.out.println("\nEmployees sorted by name.");

	        displayEmployees();
	    }

	    // Calculate total salary
	    static void totalSalary() {

	        double total = 0;

	        for (Employee e : employees) {
	            total += e.salary;
	        }

	        System.out.println("\n===== SALARY INFORMATION =====");
	        System.out.println("Total Employees : " + employees.size());
	        System.out.println("Total Salary    : " + total);
	    }

	    // Main method
	    public static void main(String[] args) {

	        // Sample employee records
	        employees.add(new Employee(
	                101, "Rahul", "IT",
	                "Software Engineer", 50000));

	        employees.add(new Employee(
	                102, "Priya", "HR",
	                "HR Manager", 60000));

	        employees.add(new Employee(
	                103, "Arjun", "Finance",
	                "Accountant", 45000));

	        int choice;

	        do {

	            System.out.println("\n\n");
	            System.out.println("==============================================");
	            System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
	            System.out.println("==============================================");

	            System.out.println("1. Add Employee");
	            System.out.println("2. Display Employees");
	            System.out.println("3. Search Employee");
	            System.out.println("4. Update Employee");
	            System.out.println("5. Delete Employee");
	            System.out.println("6. Sort by Salary");
	            System.out.println("7. Sort by Name");
	            System.out.println("8. Total Salary");
	            System.out.println("9. Exit");

	            System.out.println("==============================================");

	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    addEmployee();
	                    break;

	                case 2:
	                    displayEmployees();
	                    break;

	                case 3:
	                    searchEmployee();
	                    break;

	                case 4:
	                    updateEmployee();
	                    break;

	                case 5:
	                    deleteEmployee();
	                    break;

	                case 6:
	                    sortBySalary();
	                    break;

	                case 7:
	                    sortByName();
	                    break;

	                case 8:
	                    totalSalary();
	                    break;

	                case 9:
	                    System.out.println(
	                            "Thank you for using Employee Management System!");
	                    break;

	                default:
	                    System.out.println(
	                            "Invalid choice! Please try again.");
	            }

	        } while (choice != 9);

	        sc.close();
	    }
	}






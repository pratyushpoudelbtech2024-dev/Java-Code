import java.util.*;


class Employee {
    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double finalSalary;

    
    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.finalSalary = 0;
    }

    
    public void calculateSalary() {
        switch (role.toLowerCase()) {
            case "manager":
                finalSalary = baseSalary + (0.20 * baseSalary);
                break;

            case "developer":
                finalSalary = baseSalary + (0.10 * baseSalary);
                break;

            case "designer":
                finalSalary = baseSalary + (0.05 * baseSalary);
                break;

            case "intern":
                finalSalary = 1000;
                break;

            default:
                System.out.println("Invalid role for employee " + name);
                finalSalary = baseSalary;
        }
    }

    
    public void applyDeduction(double amount) {
        if (amount > 0 && amount <= finalSalary) {
            finalSalary -= amount;
            System.out.println("Deduction of $" + amount + " applied to " + name);
        } else {
            System.out.println("Invalid deduction for " + name);
        }
    }

   
    public void displayEmployeeDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Role        : " + role);
        System.out.println("Final Salary: $" + finalSalary);
        System.out.println("-------------------------------");
    }

   
    public String getEmployeeId() {
        return employeeId;
    }
}


class Payroll {
    private List<Employee> employees = new ArrayList<>();

    
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getEmployeeId());
    }

    
    public void calculateAllSalaries() {
        System.out.println("\nEmployee Salary Details:");
        for (Employee emp : employees) {
            emp.calculateSalary();
            emp.displayEmployeeDetails();
        }
    }

    
    public Employee findEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }
}


public class second {
    public static void main(String[] args) {

        Payroll payroll = new Payroll();

        
        Employee e1 = new Employee("E101", "Alice", "Manager", 5000);
        Employee e2 = new Employee("E102", "Bob", "Developer", 4000);
        Employee e3 = new Employee("E103", "Charlie", "Designer", 3500);
        Employee e4 = new Employee("E104", "David", "Intern", 0);

        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);
        payroll.addEmployee(e4);

       
        payroll.calculateAllSalaries();

        
        System.out.println("\nApplying deduction to Bob...");
        Employee found = payroll.findEmployeeById("E102");

        if (found != null) {
            found.applyDeduction(300);
            found.displayEmployeeDetails();
        } else {
            System.out.println("Employee not found.");
        }
    }
}

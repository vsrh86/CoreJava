package com.sss.java.hackerrank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Category {
    InformationTechnologies,
    Accounting,
    Sales,
    Marketing,
    Legal
}
class CategoryNode {
    private Category category;
    private int totalPoint;

    public CategoryNode(Category category) {
        this.category = category;
        this.totalPoint = 0;
    }

    public Category getCategory() {
        return category;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
}
class EmployeeNode {
    private String employee;
    private int totalPoint;

    public EmployeeNode(String employee) {
        this.employee = employee;
        this.totalPoint = 0;
    }

    public String getEmployee() {
        return employee;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
}

class Employee {
    private String fullName;
    private int pointLevel;
    private List<Category> assignedCategories;

    public Employee(String fullName, int pointLevel, List<Category> assignedCategories) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategories = assignedCategories;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPointLevel() {
        return pointLevel;
    }

    public List<Category> getAssignedCategories() {
        return assignedCategories;
    }
}

class Ticket {
    private int point;
    private Category category;
    private String assignedEmployee;
    private boolean isCompleted;

    public Ticket(int point) {
        this.point = point;
        this.category = null;
        this.assignedEmployee = "";
        this.isCompleted = false;
    }

    public int getPoint() {
        return point;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

class HelpDesk {
    private List<Employee> employees;
    private List<Ticket> tickets;

    public HelpDesk() {
        employees = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void completeTicket(String employeeName, int ticketId) {
        for (Ticket ticket : tickets) {
            if (System.identityHashCode(ticket) == ticketId && !ticket.isCompleted()) {
                for (Employee employee : employees) {
                    if (employee.getFullName().equals(employeeName) && employee.getPointLevel() >= ticket.getPoint()) {
                        ticket.setCompleted(true);
                        ticket.setAssignedEmployee(employeeName);
                        break;
                    }
                }
            }
        }
    }

    public int getWaitingTicketCount() {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (!ticket.isCompleted()) {
                count++;
            }
        }
        return count;
    }

    public int getCompletedTicketsTotalPoint() {
        int totalPoint = 0;
        for (Ticket ticket : tickets) {
            if (ticket.isCompleted()) {
                totalPoint += ticket.getPoint();
            }
        }
        return totalPoint;
    }

    public List<CategoryNode> getTotalPointByCategory() {
        Map<Category, Integer> categories = new HashMap<>();
        for (Ticket ticket : tickets) {
            if (ticket.isCompleted()) {
                Category category = ticket.getCategory();
                int currentTotal = categories.getOrDefault(category, 0);
                categories.put(category, currentTotal + ticket.getPoint());
            }
        }

        List<CategoryNode> result = new ArrayList<>();
        for (Map.Entry<Category, Integer> entry : categories.entrySet()) {
            CategoryNode categoryNode = new CategoryNode(entry.getKey());
            categoryNode.setTotalPoint(entry.getValue());
            result.add(categoryNode);
        }

        return result;
    }

    public List<EmployeeNode> getTotalPointByEmployee() {
        Map<String, Integer> employeesMap = new HashMap<>();
        for (Ticket ticket : tickets) {
            if (ticket.isCompleted()) {
                String employee = ticket.getAssignedEmployee();
                int currentTotal = employeesMap.getOrDefault(employee, 0);
                employeesMap.put(employee, currentTotal + ticket.getPoint());
            }
        }

        List<EmployeeNode> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : employeesMap.entrySet()) {
            EmployeeNode employeeNode = new EmployeeNode(entry.getKey());
            employeeNode.setTotalPoint(entry.getValue());
            result.add(employeeNode);
        }

        return result;
    }
}

public class HelpDeskTicket {
    public static void main(String[] args) {
        // Create an instance of the HelpDesk class
        HelpDesk helpDesk = new HelpDesk();

        // Create employees and tickets
        Employee employee1 = new Employee("John Doe", 3, List.of(Category.InformationTechnologies, Category.Accounting));
        Employee employee2 = new Employee("Jane Smith", 4, List.of(Category.Sales, Category.Marketing));
        Ticket ticket1 = new Ticket(2);
        ticket1.setCategory(Category.Accounting);
        Ticket ticket2 = new Ticket(3);
        ticket2.setCategory(Category.Sales);

        // Add employees and tickets to the help desk
        helpDesk.addEmployee(employee1);
        helpDesk.addEmployee(employee2);
        helpDesk.addTicket(ticket1);
        helpDesk.addTicket(ticket2);

        // Complete a ticket
        helpDesk.completeTicket("John Doe", System.identityHashCode(ticket1));

        // Get the number of waiting tickets
        int waitingTicketCount = helpDesk.getWaitingTicketCount();
        System.out.println("Number of waiting tickets: " + waitingTicketCount);

        // Get the total points of completed tickets
        int completedTicketsTotalPoint = helpDesk.getCompletedTicketsTotalPoint();
        System.out.println("Total points of completed tickets: " + completedTicketsTotalPoint);

        // Get the total points by category
        List<CategoryNode> totalPointByCategory = helpDesk.getTotalPointByCategory();
        System.out.println("Total points by category:");
        for (CategoryNode categoryNode : totalPointByCategory) {
            System.out.println(categoryNode.getCategory() + ": " + categoryNode.getTotalPoint());
        }

        // Get the total points by employee
        List<EmployeeNode> totalPointByEmployee = helpDesk.getTotalPointByEmployee();
        System.out.println("Total points by employee:");
        for (EmployeeNode employeeNode : totalPointByEmployee) {
            System.out.println(employeeNode.getEmployee() + ": " + employeeNode.getTotalPoint());
        }
    }
}




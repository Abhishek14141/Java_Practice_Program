import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EmployeeManagement {

    private int empId;
    private String empName;
    private String department;
    private double salary;
    private Date joiningDate;

    public EmployeeManagement(int empId, String empName, String department,
                              double salary, Date joiningDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }
	
	public void setEmpId(int empId){
		this.empId=empId;
	}
	
	public void setEmpName(String empName){
		this.empName=empName;
	}
	
	public void setDepartment(String department){
		this.department=department;
	}
	

    public void setSalary(double salary) {
        this.salary = salary;
    }
	
	public void setJoiningDate(Date joiningDate){
		this.joiningDate=joiningDate;
	}

    public void displayEmployee() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        ArrayList<EmployeeManagement> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int choice;

        do {
            System.out.println("\nEMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee by ID");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Salary");
            System.out.println("5. Display All employees");
            System.out.println("6. Find Highest Paid Employee");
            System.out.println("7. Group Employees by Department");
            System.out.println("8. Sort by Salary");
			System.out.println("9. Sort by Joining Date");
			System.out.println("10. Count Employees Department Wise");
			System.out.println("11. Search Employee by DOJ");
			System.out.println("12. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

			try{
				
            switch (choice) {

            case 1: {
					System.out.print("Enter Employee ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					boolean idExists = false;

					for (EmployeeManagement e : employees) {
						if (e.getEmpId() == id) {
						idExists = true;
						break;
						}
					}

					if (idExists == true) {
						System.out.println("Employee with this ID already exists");
						break;
					}

					System.out.print("Enter Employee Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Department: ");
					String dept = sc.nextLine();

					System.out.print("Enter Salary: ");
					double sal = sc.nextDouble();
					sc.nextLine();

					System.out.print("Enter Joining Date (yyyy-MM-dd): ");
					Date doj = sdf.parse(sc.nextLine());

					employees.add(new EmployeeManagement(id, name, dept, sal, doj));
						System.out.println("Employee Added Successfully");
						break;
					}
                case 2:{
                   System.out.print("Enter Employee ID to remove");
				   int rid=sc.nextInt();
				   boolean removed=false;
				   
				   for(int i=0; i<employees.size(); i++){
					   if(employees.get(i).getEmpId()==rid){
						   employees.remove(i);
						   removed=true;
						   break;
					   }
				   }
				   
				   if(removed==false){
					   throw new EmployeeNotFoundException("Employee Not Found");
				   }
					   System.out.println("Employee Removed");
					   break;
				}
				
				
				case 3:{
                    System.out.print("Enter Employee ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (EmployeeManagement e : employees) {
                        if (e.getEmpId() == searchId) {
                            e.displayEmployee();
                            found = true;
                            break;
                        }
                    }

                    if (found==false){
						throw new EmployeeNotFoundException("Employee not found");
					}
                    
                    break;
				}
					
					case 4:{
                    System.out.print("Enter Employee ID to Update Salary: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (EmployeeManagement e : employees) {
                        if (e.getEmpId() == updateId) {
                            System.out.print("Enter New Salary: ");
                            e.setSalary(sc.nextDouble());
                            updated = true;
                            break;
                        }
                    }

                    if (updated==false){
						throw new EmployeeNotFoundException("Employee Not Found");
					}
                        System.out.println("Salary Updated Successfully..");
                    break;
			}
				
				case 5:{
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (EmployeeManagement e : employees) {
                            e.displayEmployee();
                        }
                    }
                    break;
				}
				

                case 6:{
                    if (employees.isEmpty()) {
                        throw new EmployeeNotFoundException("Employee Not Found");

                    }
					
                        EmployeeManagement highestPaid = employees.get(0);

                        for (EmployeeManagement e : employees) {
                            if (e.getSalary() > highestPaid.getSalary()) {
                                highestPaid = e;
                            }
                        }

                        highestPaid.displayEmployee();
                    break;
				}

                case 7:{
						sc.nextLine();
                        System.out.print("Enter Department Name: ");
                        String deptName = sc.nextLine();

                        boolean deptFound = false;

                        for (EmployeeManagement e : employees) {
                            if (e.getDepartment().equalsIgnoreCase(deptName)) {
                                e.displayEmployee();
                                deptFound = true;
                            }
                        }

                        if (deptFound==false) {
                            System.out.println("No employees found in this department.");
                        }
                    
                    break;
			}
					
				case 8:{
						for(int i=0; i<employees.size();i++){
							for(int j=i+1; j<employees.size(); j++){
								if(employees.get(i).getSalary()>employees.get(j).getSalary()){
									EmployeeManagement temp = employees.get(i);
									employees.set(i, employees.get(j));
								employees.set(j,temp);
								}
							}
						}
						System.out.println("Sorted by Salary");
						break;
			}
						
				case 9:{
						for(int i=0; i<employees.size();i++){
							for(int j=i+1; j<employees.size();j++){
								if(employees.get(i).getJoiningDate().compareTo(employees.get(j).getJoiningDate())>0){
									EmployeeManagement temp = employees.get(i);
									employees.set(i, employees.get(j));
									employees.set(j,temp);
								}
							}
						}
						System.out.println("Sorted by JoiningDate");
						break;
			}
						
				case 10:{
						ArrayList<String> counted = new ArrayList<>();
						
						for(EmployeeManagement e: employees){
							if(!counted.contains(e.getDepartment())){
								int count=0;
								
								for(EmployeeManagement x: employees){
									if(x.getDepartment().equals(e.getDepartment())){
										count++;
									}
								}
								
								System.out.println(e.getDepartment() + " : " +count);
								counted.add(e.getDepartment());
							}
						}
						break;
			}
						
				case 11:{
						sc.nextLine();
						System.out.println("Enter DOJ (yyyy-MM-dd): ");
						Date searchDate = sdf.parse(sc.nextLine());
						boolean dojFound= false;
						
						for(EmployeeManagement e: employees){
							if(e.getJoiningDate().equals(searchDate)){
								e.displayEmployee();
								dojFound=true;
							}
						}
						
						if(dojFound==false){
							throw new EmployeeNotFoundException("No Employee Found on this DOJ");
						}
						break;
			}

                case 12:{
                    System.out.println("Exiting Application. Thank you!");
                    break;
				}

                default:{
                    System.out.println("Invalid Choice. Try again.");
            }
		}
			}
		catch(EmployeeNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println("Invalid Input");
		}

		} while (choice != 12);

        sc.close();
		
    }
}

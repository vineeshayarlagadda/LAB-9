package streamsLabCaseStudy;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {
	public static void main(String[] args) {
		EmployeeService es=new EmployeeService();
		EmployeeRepository er=new EmployeeRepository();
		List<Employee> empList=er.getEmployees();
		List<Department> deptList=er.getDepartments();
		es.sumOfSalaries(empList);
//		es.empsInEachDept(empList, deptList);
		es.empDepNull(empList);
		es.displayEmployeeNewSalaries(empList);
		es.empWithNoManager(empList);
		es.empDetailsWithDayOfWeek(empList);
		es.empHiredOnFriday(empList);
		es.empDurationOfService(empList);
	}
	
	public void sumOfSalaries(List<Employee> empList) {
		
		double totalSalary=empList.stream().map(e -> e.getSalary()).reduce(0.0, (a,b) -> a+b);
		System.out.println("The sum of salaries of all the employees : "+totalSalary);
				
	}

//	public void empsInEachDept(List<Employee> empList,List<Department> deptList) {
//		
//	}

		
	public void empDepNull(List<Employee> empList){
	   	Stream<Employee> emp = empList.stream().filter((employee)->employee.getDepartment() == null);
	   	System.out.println();
	   	System.out.println("================================================================================================================================");
	   	System.out.println();
	   	emp.forEach((i)->System.out.println(i));
	    }
	
	
	public void displayEmployeeNewSalaries(List<Employee> empList){
		empList.stream().map((employee)->{
			double oldSalary = employee.getSalary();
			double newSalary = (oldSalary+oldSalary*0.15);
			employee.setSalary(newSalary);
			return employee;
		}).collect(Collectors.toList());
		System.out.println();
		System.out.println("================================================================================================================================");
		System.out.println();
		for(Employee e:empList) {
			System.out.println("Employee Name : "+e.getFirstName()+" "+e.getLastName()+", Employee new salary : "+e.getSalary());
		}
	}
	
	public void empWithNoManager(List<Employee> empList) {
		Stream<Employee> emp=empList.stream().filter((employee)->employee.getManagerId()==null);
		System.out.println();
		System.out.println("================================================================================================================================");
		System.out.println();
		emp.forEach((i)->System.out.println(i));
		
	}
	
	public void empDetailsWithDayOfWeek(List<Employee> empList) {
		System.out.println();
		System.out.println("================================================================================================================================");
		System.out.println();
		for(Employee e:empList) {
			System.out.println("Employee hiring date : "+e.getHireDate()+", Employee hiring day of the week : "+e.getHireDate().getDayOfWeek());
		}
	}
	
	public void empHiredOnFriday(List<Employee> empList) {
		System.out.println();
		System.out.println("================================================================================================================================");
		System.out.println();
		Stream<Employee> emp=empList.stream().filter((employee)->employee.getHireDate().getDayOfWeek().toString().equals("FRIDAY"));
		emp.forEach((i)->System.out.println(i));
	}
	
	public void empDurationOfService(List<Employee> empList) {
		System.out.println();
		System.out.println("================================================================================================================================");
		System.out.println();
		LocalDate currentDate=LocalDate.now();
		for(Employee e:empList) {
			LocalDate joiningDate=e.getHireDate();
			System.out.println("Employee Name : "+e.getFirstName()+" "+e.getLastName()+":");
			System.out.println("Employee duration of service in months : "+ChronoUnit.MONTHS.between(joiningDate, currentDate));
			System.out.println("Employee duration of service in days : "+ChronoUnit.DAYS.between(joiningDate, currentDate));
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		}
	}
	
	}

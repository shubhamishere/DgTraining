package dataguise1;
/*OUTPUT format of this code:-
 * 1.) Create entries of employees by selecting the type of employee (Total 4 types)
 *     a)-->first name, last name, email, employee ID [Common for all types]
 *     b)-->other fields depends upon the employee type selected during runtime.
 * 2.) Enter email id to search in employees
 * 3.) Enter the type of employee
 * 		If email match found
 * 			a) Calculate and display weekly salary/payout.
 * 		If email match not found
 * 			b) Display msg 'email not found'
 * 4.) Do you want to continue making employee entries?
 * 			a) if Yes, process execution goes to step 1
 * 			b) if No, program terminates with a Thank You note.
 * */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class Payroll {
	
	public static void main(String[] args) {
		ArrayList<Salaried> salariedList = new <Salaried>ArrayList();
		ArrayList<Commission> commissionList = new <Commission>ArrayList();
		ArrayList<SalariedCommission> salariedCommissionList = new <SalariedCommission>ArrayList();
		ArrayList<Hourly> hourlyList = new <Hourly>ArrayList();
		
		int searchFlag = 0;
		int input = 1;
		Scanner sc = new Scanner(System.in);
		
		while(input==1) {
			System.out.println("Select type of employee (select b/w 1-4 options ONLY!):\n1. Salaried\n2. Commission\n3. Salaried-commission\n4. Hourly");
			int choice = sc.nextInt();
			sc.nextLine();
			
			String empType;
			if(choice==1) {
				empType = "Salaried";
			}
			else if(choice==2) {
				empType = "Commission";
			}
			else if(choice==3) {
				empType = "Salaried-commission";
			}
			else if(choice==4) {
				empType = "Hourly";
			}
			else {
				System.out.println("Enter valid input! Try again.\n\n");
				continue;
			}
			
			//-------- [1].a ---------
			System.out.print("Enter first name of " + empType + " employee: ");
			String fname = sc.nextLine();
			
			System.out.print("Enter last name of " + empType + " employee: ");
			String lname = sc.nextLine();
			
			System.out.print("Enter email id of " + empType + " employee: ");
			String email = sc.nextLine();
			
			System.out.print("Enter employee ID of " + empType + " employee: ");
			String id = sc.nextLine();
			
			switch(choice) {
				case 1:
					//-------- [1].b ---------
					System.out.print("Enter this week salary: ");
					int salary = sc.nextInt();
					
					Salaried salariedEmp = new Salaried(salary);
					salariedEmp.setFirstName(fname);
					salariedEmp.setLastName(lname);
					salariedEmp.setEmail(email);
					salariedEmp.setEmployeeId(id);
					
					salariedList.add(salariedEmp);
					break;
				case 2:
					//-------- [1].b ---------
					System.out.print("Enter this week sale: ");
					int sale = sc.nextInt();
					
					Commission commissionEmp = new Commission(sale);
					commissionEmp.setFirstName(fname);
					commissionEmp.setLastName(lname);
					commissionEmp.setEmail(email);
					commissionEmp.setEmployeeId(id);
					
					commissionList.add(commissionEmp);
					break;
				case 3:
					//-------- [1].b ---------
					System.out.print("Enter this week salary: ");
					int salary2 = sc.nextInt();
					System.out.print("Enter this week sale: ");
					int sale2 = sc.nextInt();
					//System.out.print("Set increment % in weekly base salary: ");
					//int increment = sc.nextInt();
					
					SalariedCommission salariedCommissionEmp = new SalariedCommission(salary2, sale2);
					salariedCommissionEmp.setFirstName(fname);
					salariedCommissionEmp.setLastName(lname);
					salariedCommissionEmp.setEmail(email);
					salariedCommissionEmp.setEmployeeId(id);
					//salariedCommissionEmp.setIncrementInWeeklySalary(increment);
					
					salariedCommissionList.add(salariedCommissionEmp);
					break;
				case 4:
					//-------- [1].b ---------
					System.out.print("Enter hours worked: ");
					int hoursWorked = sc.nextInt();
					
					Hourly hourlyEmp = new Hourly(hoursWorked);
					hourlyEmp.setFirstName(fname);
					hourlyEmp.setLastName(lname);
					hourlyEmp.setEmail(email);
					hourlyEmp.setEmployeeId(id);
					
					hourlyList.add(hourlyEmp);
					break;
			}
			sc.nextLine();
			System.out.println("----------------------------");
			//-------- [2] ---------
			System.out.println("Enter an email ID to search in employees record: ");
			String searchEmail = sc.nextLine();
			
			//-------- [3] ---------
			System.out.println("Enter employee type to search in (enter b/w 1-4 ONLY):\n1. Salaried\n2. Commission\n3. Salaried-commission\n4. Hourly ");
			int typeOfEmployee = sc.nextInt();
			
			if(typeOfEmployee==1) {
				ListIterator<Salaried> it = salariedList.listIterator();
				while(it.hasNext()) {
					Salaried ob = it.next();
					//--------- [3].a ----------
					if(searchEmail.equalsIgnoreCase(ob.getEmail())) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("___________________");
						System.out.print("Full name: ");
						System.out.print(ob.getFirstName() + " ");
						System.out.println(ob.getLastName());
						System.out.println("Weekly salary: " + ob.getWeeklySalary());
					}
				}
			}
			else if(typeOfEmployee==2) {
				ListIterator<Commission> it = commissionList.listIterator();
				while(it.hasNext()) {
					Commission ob = it.next();
					//--------- [3].a ----------
					if(searchEmail.equalsIgnoreCase(ob.getEmail())) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("___________________");
						System.out.print("Full name: ");
						System.out.print(ob.getFirstName() + " ");
						System.out.println(ob.getLastName());
						System.out.println("This week commission amount: " + ob.getCommissonAmount());
						
					}
				}
			}
			else if(typeOfEmployee==3) {
				ListIterator<SalariedCommission> it = salariedCommissionList.listIterator();
				while(it.hasNext()) {
					SalariedCommission ob = it.next();
					//--------- [3].a ----------
					if(searchEmail.equalsIgnoreCase(ob.getEmail())) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("___________________");
						System.out.print("Full name: ");
						System.out.print(ob.getFirstName() + " ");
						System.out.println(ob.getLastName());
						System.out.println("This week sale: " + ob.getWeeklySales());
						System.out.println("This week commission amount: " + ob.getCommissonAmount());
						System.out.println("This week salary: " + ob.getWeeklySalary());
						System.out.println("Total amount payble(salary+commission): " + ob.getTotalSalary());
					}
				}
			}
			else if(typeOfEmployee==4) {
				ListIterator<Hourly> it = hourlyList.listIterator();
				while(it.hasNext()) {
					Hourly ob = it.next();
					//--------- [3].a ----------
					if(searchEmail.equalsIgnoreCase(ob.getEmail())) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("___________________");
						System.out.print("Full name: ");
						System.out.print(ob.getFirstName() + " ");
						System.out.println(ob.getLastName());
						System.out.println("Hours worked this week: " + ob.getWorkedHours());
						System.out.println("Payment for this week: " + ob.getPayment());
					}
				}
			}
			else {
				System.out.println("Invalid input!");
				System.exit(0);
			}
			//--------- [3].b ----------
			if(searchFlag==0) {
				System.out.println("Employee not found with your email query: " + "'" + searchEmail + "'");
			}
			
			//--------- [4] ----------
			if(input==1) {
				System.out.println("-----------------------------");
				System.out.println("Do you want to continue?\n1. Yes\n2. No");
				int choice2 = sc.nextInt();
				//--------- [4].a ----------
				if(choice2==1) {
					input = 1;
				}
				//--------- [4].b ----------
				else if(choice2==2) {
					System.out.println("Thank you");
					input = 0;
				}
				else {
					System.out.println("Wrong input.");
					System.exit(0);
				}
				
			}
		}
		
	}

}

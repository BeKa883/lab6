package view;

import java.util.Scanner;
import java.util.ArrayList;
import model.Student;
import control.School;


public class SchoolManagement extends Menu{
	private School schoolService = new School();
	public SchoolManagement() {
		super("School Management System", menu);
	}

	static String[] menu= {"List all student","Add student" ,"Search student", "Sort student", "Exit"};
	
	@Override
	public void execute(int n) {
		switch(n) {
		case 1: listAllStudent(); break;
		case 2: addStudent(); break;
		case 3: searchStudent(); break;
		case 4: sortStudent(); break;
		case 5: System.out.println("Program end! \nThank you for using my program");
		default: System.exit(0);
		}
	}
	
	private void listAllStudent() {
		schoolService.listAllStudent();
	}
	
	private void addStudent() {
		schoolService.addStudent();
	}
	
	private void searchStudent() {
		Scanner sc = new Scanner(System.in);
		String[] mSearch = {"Search by ID","Search by name"};
		Menu m = new Menu("Student searching", mSearch) {
			public void execute(int n) {
				ArrayList<Student> temp = null;
				switch(n) {
				case 1: 
					System.out.println("Enter Student ID:");
					String val = sc.nextLine();
					temp = schoolService.search(ls -> ls.getId().equals(val));
					break;
				case 2: 
					System.out.println("Enter name: ");
					val = sc.nextLine();
					temp = schoolService.search(ls -> ls.getName().contains(val));
					break;
				default:
					return;
				}
				schoolService.listAllStudent(temp);
			}
		};
		m.run();	
	}
	
	private void sortStudent() {
		Scanner sc = new Scanner(System.in);
		String[] mSort = {"Sort by name","Sort by ID","Sort by average score"};
		Menu m = new Menu("Student sort", mSort) {
			public void execute(int n) {
//				ArrayList<Student> temp = null;
				switch(n) {
				case 1:
					schoolService.sortByName();
					break;
				case 2:
					schoolService.sortByID();
					break;
				case 3:
					schoolService.sortByAverage();
				default:
					return;
				}
			}
		};
		m.run();
	}
	
	public static void main(String[] args) {
		SchoolManagement sm = new SchoolManagement();
		sm.run();
	}
}
		


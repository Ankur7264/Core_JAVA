//package com.cdac.acts.javamain;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class Tester {
//
//	public static void main(String[] args) throws MyException {
//
//		Scanner sc = new Scanner(System.in);
//		List<Employee> list = dataUtils.addData();
//		
//		
//		
//
//		int choice;
//		do {
//
//			System.out.println("******MENU******");
//			System.out.println("1.Add Contact");
//			System.out.println("2.Display Contact");
//			System.out.println("3.Sort By Name");
//			System.out.println("4.Update by NAME and DOB");
//			System.out.println("5.Remove >80");
//			System.out.println("0.Exit");
//
//			System.out.println("Enter Your Choice");
//			choice = sc.nextInt();
//
//			switch (choice) {
//			case 1: {
//
//				System.out.println("Enter Contact name :- ");
//				sc.nextLine();
//				String name = sc.nextLine();
//
//				System.out.println("Enter Count of Phone Number :- ");
//				int count = sc.nextInt();
//				List<Integer> list1 = new ArrayList<Integer>();
//				for (int i = 0; i < count; i++) {
//					System.out.println("Enter Contact Phone Number :- ");
//					Integer phno = sc.nextInt();
//					Integer phoneNumberValidation = Validation.phoneNumberValidation(phno, list);
//					list1.add(phoneNumberValidation);
//				}
//
//				System.out.println("Enter Date Of Birth :- ");
//				sc.nextLine();
//				String date1 = sc.nextLine();
//				LocalDate date = LocalDate.parse(date1);
//
//				System.out.println("Enter Contact Email :- ");
//				String email = sc.nextLine();
//
//				Employee employee = new Employee(list1, name, date, email);
//				list.add(employee);
//				System.out.println("Added successfully...!!");
//
//			}
//
//				break;
//
//			case 2: {
//				System.out.println("Display Contacts");
//				list.forEach(s -> System.out.println(s));
//
//			}
//				break;
//
//			case 3: {
//				Collections.sort(list, new sorbyname());
//				System.out.println("Sorted by name desc order...!!");
//				list.forEach(s -> System.out.println(s));
//			}
//
//				break;
//
//			case 4: {
//
//				System.out.println("ENter Name & DOB Of Contact ");
//				sc.nextLine();
//				String name = sc.nextLine();
//				LocalDate date = LocalDate.parse(sc.next());
//				for (Employee emp : list) {
//					if (emp.getName().equalsIgnoreCase(name) && emp.getDate().equals(date)) {
//						System.out.println("Enter New Name & New DOB :- ");
//						sc.nextLine();
//						String name1 = sc.nextLine();
//						LocalDate date1 = LocalDate.parse(sc.next());
//						emp.setName(name1);
//						emp.setDate(date1);
//						System.out.println("updated.......");
//
//					}
//				}
//
//			}
//
//				break;
//
//			case 5: {
//
//				List<Employee> ageValidation = Validation.ageValidation(list);
//				ageValidation.forEach(s -> System.out.println(s));
//
//			}
//
//				break;
//
//			
//
//			case 0: {
//				System.out.println("Exit Successfully");
//			}
//
//				break;
//
//			default:
//				System.out.println("Enter Valid Choice.....");
//
//				break;
//			}
//
//		} while (choice != 0);
//
//	}
//
//}
package com.cdac.acts.javamain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = dataUtils.addData();
        int choice;
        do {
            System.out.println("******MENU******");
            System.out.println("1.Add Contact");
            System.out.println("2.Display Contact");
            System.out.println("3.Sort By Name");
            System.out.println("4.Update by NAME and DOB");
            System.out.println("5.Remove >80");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice");
            choice = sc.nextInt();
            switch (choice) {
                
            case 1: {
                System.out.println("Enter Contact name :- ");
                sc.nextLine(); // Consume newline left-over
                String name = sc.nextLine();
                boolean duplicate = list.stream().anyMatch(emp -> emp.getName().equalsIgnoreCase(name));
                if (duplicate) {
                    System.out.println("Duplicate name found! Please enter a different name.");
                    break;
                }
                System.out.println("Enter Count of Phone Number :- ");
                int count = sc.nextInt();
                List<Integer> list1 = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    System.out.println("Enter Contact Phone Number :- ");
                    Integer phno = sc.nextInt();
                    if (phno.toString().length() == 10) {
                        if (!list1.contains(phno)) {
                            Integer phoneNumberValidation = Validation.phoneNumberValidation(phno, list);
                            list1.add(phoneNumberValidation);
                        } else {
                            System.out.println("Duplicate phone number! Please enter a different number.");
                            i--; // Decrease the counter to ensure the user can enter a new number
                        }
                    } else {
                        System.out.println("Phone number must be 10 digits! Please enter a valid number.");
                        i--; // Decrease the counter to ensure the user can enter a new number
                    }
                }
                System.out.println("Enter Date Of Birth :- ");
                sc.nextLine(); // Consume newline left-over
                String date1 = sc.nextLine();
                LocalDate date = LocalDate.parse(date1);
                System.out.println("Enter Contact Email (without @gmail.com) :- ");
                String email = sc.nextLine() + "@gmail.com";
                duplicate = list.stream().anyMatch(emp -> emp.getEmail().equalsIgnoreCase(email));
                if (duplicate) {
                    System.out.println("Duplicate email found! Please enter a different email.");
                    break;
                }
                Employee employee = new Employee(list1, name, date, email);
                list.add(employee);
                System.out.println("Added successfully...!!");
            }
            break;


                case 2: {
                    System.out.println("Display Contacts");
                    list.forEach(s -> System.out.println(s));
                }
                break;
                case 3: {
                    Collections.sort(list, new SortByName());
                    System.out.println("Sorted by name desc order...!!");
                    list.forEach(s -> System.out.println(s));
                }
                break;
                case 4: {
                    System.out.println("Enter Name & DOB Of Contact ");
                    sc.nextLine(); // Consume newline left-over
                    String name = sc.nextLine();
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    for (Employee emp : list) {
                        if (emp.getName().equalsIgnoreCase(name) && emp.getDate().equals(date)) {
                            System.out.println("Enter New Name & New DOB :- ");
                            String name1 = sc.nextLine();
                            LocalDate date1 = LocalDate.parse(sc.nextLine());
                            emp.setName(name1);
                            emp.setDate(date1);
                            System.out.println("updated.......");
                        }
                    }
                }
                break;
                case 5: {
                    List<Employee> ageValidation = Validation.ageValidation(list);
                    ageValidation.forEach(s -> System.out.println(s));
                }
                break;
                case 0: {
                    System.out.println("Exit Successfully");
                }
                break;
                default:
                    System.out.println("Enter Valid Choice.....");
                    break;
            }
        } while (choice != 0);
    }
}

package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitites.Department;
import entitites.HourContract;
import entitites.Worker;
import entitites.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.print("Enter department's name");
		String department = sc.nextLine();
		System.out.println("Enter worker data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		System.out.print("How many contracts  to this worker? ");
		int contracts = sc.nextInt();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department (department));
		
		for ( int i = 1 ; i <= contracts ; i ++ ) {
			System.out.println("Enter contract #" + 1 + "data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			double value = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(date, value, hours);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getDepartment());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}

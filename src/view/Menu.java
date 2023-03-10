package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Menu {
	private Scanner sc = new Scanner(System.in);
	private String title;
	private ArrayList<String> options = new ArrayList<>();
	
	public Menu(String title, String[] op) {
		this.title = title;
		this.options.addAll(Arrays.asList(op));
	}
	
	public void menuDisplay() {
		System.out.println("----------------------------");
		System.out.println(title);
		System.out.println("----------------------------");
		for (int i = 0; i<options.size(); i++) {
			System.out.println((i+1) + " - " + options.get(i));
		}
		System.out.println("----------------------------");
	}
	
	public int getChoice() {
		menuDisplay();
		int choice = sc.nextInt();
		return choice;
	}
	
	public void run() {
		while (true) {
			int choice = getChoice();
			execute(choice);
			if (choice>options.size()) break;
		}
	}
	public abstract void execute(int n);
}

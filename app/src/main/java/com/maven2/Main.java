package com.maven2;
import java.util.*;
import java.io.*;
public class Main {
	
	public static MenuService menu = new MenuService();
	public static FileIOService fileIO = new FileIOService();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
		String fileName = "";
		
        try {
            if (args.length > 0) {
                fileName = args[0];
				fileIO.readFile(fileName);
            }else {
				System.out.println("No selected File");
				menu.reset();
			}
			
        }
        catch (Exception e) {
			System.out.println("File not found!");
			menu.reset();
        }
		
		displayOptions();
    }
	
	public static void displayOptions() throws IOException{
		int option = 0;
		boolean isNotValid = true;

		System.out.print("\n");
		System.out.println("----------OPTIONS----------");
		System.out.println("\n");
		System.out.println("   (1)     Search");
		System.out.println("   (2)     Edit");
		System.out.println("   (3)     Print");
		System.out.println("   (4)     Add Row");
		System.out.println("   (5)     Sort Row");
		System.out.println("   (6)     Reset");
		System.out.println("   (7)     Exit");
		System.out.println("\n");
		System.out.print("Select from options 1-7: ");
		option = menu.checkIntegerInput(1, 7);
		
		System.out.println("\n");

		switch (option) {

		case 1:
			menu.search();
			displayOptions();
			break;
		case 2:
			try {
			menu.edit();
			}catch(Exception e) {}
			
			displayOptions();
			break;
		case 3:
			menu.print();
			displayOptions();
			break;
		case 4:
			menu.addRow();
			displayOptions();
			break;
		case 5:
			menu.sortRow();
			displayOptions();
			break;
		case 6:
			menu.reset();
			displayOptions();
			break;
		case 7:
			menu.exit();
			break;
		}
	}
}
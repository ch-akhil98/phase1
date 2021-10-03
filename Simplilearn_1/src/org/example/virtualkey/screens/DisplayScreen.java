package org.example.virtualkey.screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;

public class DisplayScreen implements Display {
	
	  private String welcomeintro = "Welcome to LockedMe.com";
	    private String developer = "Developed by: Ch Akhil";

	    private ArrayList<String> options = new ArrayList<>();


	    public DisplayScreen() {
	        options.add("1. Show Files");
	        options.add("2. Show File Options Menu");
	        options.add("3. Quit");

	    }
	    
	    public void intro() {
	    	System.out.println(welcomeintro);
	        System.out.println(developer);
	        System.out.println("\n");
	        Show();
	    }
	    
	    
	    
	    @Override
	    public void Show() {
	    	System.out.println("Main Menu");
	        for (String s : options)  {
	            System.out.println(s);
	        }

	    }
	     
	    @Override
	    public void GetUserInput() {
	        int selectedOption  = 0;
	        while ((selectedOption = this.getOption()) != 3) {
	            this.GoToOption(selectedOption);
	        }
	    }

	    @Override
	    public void GoToOption(int option) {
	        switch(option) {

	            case 1: // Show Files in Directory
	                this.ShowFiles();
	                this.Show();
	                break;
	                
	            case 2: // Show File Options menu
	            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
	                ScreenService.getCurrentScreen().Show();
	                ScreenService.getCurrentScreen().GetUserInput();
	                this.Show();
	                break;
	                
	            default:
	                System.out.println("Invalid Option");
	                break;
	        }
	        
	    }

	    public void ShowFiles() {
	        System.out.println("List of Files: ");
	    	DirectoryService.PrintFiles();
	    }
	    
	    private int getOption() {
	        Scanner in = new Scanner(System.in);
	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	            }
	        catch (InputMismatchException e) {
	          e.printStackTrace();
	          }
	        return returnOption;

	    }
	    

}

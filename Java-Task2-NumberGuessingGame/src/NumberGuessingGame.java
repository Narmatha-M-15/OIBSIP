//Narmatha M | Java Development | Task 2: Number Guessing Game

import java.util.ArrayList;


import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame {
   public static void main(String[] args) {
	   Scanner sc =new Scanner(System.in);
	   Random r=new Random();
	   ArrayList<String> roundSummary =new ArrayList<>();
	   int round=1;
	   boolean playagain=true;
	   
	   while(playagain) {
		   int max=100;
		   int maxAttempts=7;
		   int secret=r.nextInt(max)+1;
		
		   int attempts=0;
		   boolean won =false;
		   
		   System.out.println("==========Round :"+round+"==============");
		   System.out.println("Guess a number between 1 and " +max);
		 
		   while(attempts<maxAttempts) {
			   System.out.println("Attempt :"+(attempts +1)+"/"+maxAttempts+"---Enter guess:");
			   
			   try {
				  int  guess=Integer.parseInt(sc.nextLine());
				  attempts++;
				  if(secret>guess) {
					   System.out.println("is too low");
				   }if(secret<guess) {
					   System.out.println("is too high");
				   }else if(secret==guess){
					   System.out.println("yeah!!.it's correct you won!!!!");
					   won=true;
					   break;
				   }
			   }catch(NumberFormatException e) {
				   System.out.println("enter a valid number");
				   continue;
			   }
		   }
		   if(won) {
			   roundSummary.add("Round "+round+" guessed in "+attempts+" attempts");
			   
		   }else {
			   System.out.println("you Lost! the number was:"+secret);
			   roundSummary.add("Round"+round+" - Lost");
		   }
						 System.out.println("play again? (yes/no)");
						 playagain=sc.nextLine().trim().equalsIgnoreCase("yes");
						 round++;
					 }
			   System.out.println("==========Game summary============");
			   for(String s:roundSummary)
				   System.out.println(s);
			   System.out.println("thanks for playing!");
			   sc.close();   
		   
	   }
   }


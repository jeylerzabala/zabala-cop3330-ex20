package ex20;

/*

*  UCF COP3330 Summer 2021 Assignment 1 Solution
*  Copyright 2021 Jeyler Zabala

Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions,
so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state.
The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge.
For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the totalTax for
Wisconsin and Illinois residents but just the totalTax for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The totalTax is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double orderAmount, totalTax, salesTaxWis, salesTaxIll, additionalTax;
        salesTaxWis = .05;
        salesTaxIll = .08;

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the order amount? ");
        orderAmount = sc.nextInt();

        Scanner in = new Scanner(System.in);
        System.out.print("What state do you live in? ");
        String state = in.nextLine();

        if (state.equals("Wisconsin")) {
            totalTax = orderAmount * salesTaxWis;
            System.out.print("What county do you live in? ");
            String county = in.nextLine();
            if (county.equals("Eau Claire")) {
                additionalTax = 0.005;
            }
            else if (county.equals("Dunn")) {
                additionalTax = 0.004;
            } else {
                additionalTax = 0;
            }
            orderAmount =  totalTax + orderAmount + additionalTax;
        }
        else if(state.equals("Illinois")) {
            totalTax = (salesTaxIll * orderAmount);
            orderAmount =  totalTax + orderAmount;

        } else {
            totalTax = 0;
        }
        System.out.println("The tax is $" + Math.round(totalTax * 100.0) / 100.0 +
                ".\nThe total is $" + Math.round(orderAmount * 100.0) / 100.0 + ".");
    }
}

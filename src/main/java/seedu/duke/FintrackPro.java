package seedu.duke;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class FintrackPro {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = """
            +---------+
            |   HDB   |
            |  [ ][ ] |
            |_________|

          (•‿•)   <3  (•‿•)
           /|\\         /|\\
           / \\         / \\
      Secure the Keys, Secure the Dream
    """;
        System.out.println("Welcome to Fintrack Pro!\n" + logo);
        System.out.println("I am FinBro's brother, FinTrack Pro!");

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("Nice to meet you, " + name + "!");

        System.out.println("Hang tight... I have a few questions for you.");
        System.out.println("What is your total amount that you and your partner has to pay for the downpayment? (in dollars)");
        double goal = Double.parseDouble(in.nextLine());

        double legalFees = goal * 0.025;
        double totalRequired = goal + legalFees;

        System.out.println("Sweeeett. Including 2.5% legal fees, you will need $" + totalRequired);

        System.out.println("When do you need to save this money by? (Enter in format YYYY-MM-DD)");
        String deadlineInput = in.nextLine();
        LocalDate deadline = LocalDate.parse(deadlineInput);
        LocalDate today = LocalDate.now();

        Period period = Period.between(today, deadline);

        System.out.println("You have " + period.getYears() + " years and " + period.getMonths() + " months remaining.");

        System.out.println("\nYou can now type anything you want");
        System.out.println("Type 'bye' to exit! \n");

        while(true){
            String input = in.nextLine();
            if (input.equalsIgnoreCase("bye")){
                System.out.println("Goodbye " + name + ". Stay disciplines and get that house that you always wanted!");
                break;
            }
            System.out.println("You said: " + input);
        }
        in.close();
    }
}

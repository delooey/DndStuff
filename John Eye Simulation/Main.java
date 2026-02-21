import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);  // Create a Scanner object

    // Prompt User for Inputs
    System.out.println("Enter Number of Days to Fulfill Quest: ");
    // Initialize Day Variables
    int days = sc.nextInt();
    int dayCounter = 1;
    sc.nextLine();

    System.out.println("Enter John's Race (lowercase): ");
    // Initialize Race Variable
    String race = sc.nextLine();

    System.out.println("Enter John's Initial Weight: ");
    // Initialize Weight Variables
    int weightLost = 0;
    int initialWeight = sc.nextInt();
    sc.nextLine();
    
    System.out.println("Enter John's Initial Age: ");
    // Initialize Age Variables
    int initialAge = sc.nextInt();
    int ageCounter = 0;
    int maxAge = 0;
    sc.nextLine();

    System.out.println("Enter John's Con Save Modifier (Just Number): ");
    // Initialize John's Con Save Modifier
    int conSave = sc.nextInt();
    sc.nextLine();

    System.out.println("Does John have the Lucky Feat? (1 for No, 2 for Yes): ");
    // initialize the presence of the lucky feat or not
    int lucky = sc.nextInt();
    sc.nextLine();
    
    // Determine John's Max Age Depending on Race Selected
    if (race.matches("elf")) {
        maxAge = 1000;
    } 

    // Initialize the Attuned Variable
    boolean attuned = false;

    // Print out User Inputs
    System.out.println("Days Entered: " + days);
    System.out.println("Initial Age Entered: " + initialAge);
    System.out.println("Initial Weight Entered: " + initialWeight);

    // Run the Simulation!
    while (dayCounter <= days) { 
      if (attuned == false) {
        if (Helper.rolld20(1) + conSave < 10) {
          if (lucky == 2) {
              if (Helper.rolld20(1) + conSave < 10) {
                System.out.println("John has been Turned into a Wight on Day " + dayCounter + " of the Trial.  His Final Age was " + (ageCounter + initialAge) + ". And his Final Weight was " + (initialWeight - weightLost) + "."); // Stat Breakdown
                break;
              }
          } else {
            System.out.println("John has been Turned into a Wight on Day " + dayCounter + " of the Trial.  His Final Age was " + (ageCounter + initialAge) + ". And his Final Weight was " + (initialWeight - weightLost) + "."); // Stat Breakdown
            break;
          }
        } else {
          attuned = true; // Become Attuned
          ageCounter += (Helper.rolld10(3)); // Gain Age

          if (ageCounter + initialAge >= maxAge) { // John Dies of Old Age
              System.out.println("John has Died of Age on Day " + dayCounter + " of the Trial.  His Final Age was " + (ageCounter + initialAge) + ". And his Final Weight was " + (initialWeight - weightLost) + "."); // Stat Breakdown
              break;
          }

          if (Helper.flipCoin(1) == 1) { // Flip a Coin to Determine if Weight Loss is Permanent
              weightLost += ((Helper.rolld4(1)*10)); // Lose Weight
          }
        } 
      }
      if (dayCounter == days) { // Victory has been Reached
          System.out.println("John has Successfully Completed the Quest.  He has Lost " + weightLost + " Pounds for a Final Weight of " + (initialWeight - weightLost) + "lbs, and has been Aged by " + ageCounter + " Years for a Total Age of " + (initialAge + ageCounter) + ".");
          break;
      }
      if (Helper.rolld6(1) == 1) {
          attuned = false;
          dayCounter++; // Go to the Next Day
      } else {
        dayCounter++; // Go to the Next Day
      }
    } 
  }
}

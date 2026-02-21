import java.util.Random; // Import the Random Class

public final class Helper {

    private Helper() {}

    public static int flipCoin(int numberRolls) {
        int sides = 2;
        int totalResult = 0;
        int counter = 1;
        Random roll = new Random();

        while (counter <= numberRolls) { 
            totalResult += roll.nextInt(sides) + 1;
            counter++;
        }

        return totalResult;
    }

    public static int rolld4(int numberRolls) {
        int sides = 4;
        int totalResult = 0;
        int counter = 1;
        Random roll = new Random();

        while (counter <= numberRolls) { 
            totalResult += roll.nextInt(sides) + 1;
            counter++;
        }

        return totalResult;
    }

    public static int rolld6(int numberRolls) {
        int sides = 6;
        int totalResult = 0;
        int counter = 1;
        Random roll = new Random();

        while (counter <= numberRolls) { 
            totalResult += roll.nextInt(sides) + 1;
            counter++;
        }

        return totalResult;
    }

    public static int rolld10(int numberRolls) {
        int sides = 10;
        int totalResult = 0;
        int counter = 1;
        Random roll = new Random();

        while (counter <= numberRolls) { 
            totalResult += roll.nextInt(sides) + 1;
            counter++;
        }

        return totalResult;
    }

    public static int rolld20(int numberRolls) {
        int sides = 20;
        int totalResult = 0;
        int counter = 1;
        Random roll = new Random();

        while (counter <= numberRolls) { 
            totalResult += roll.nextInt(sides) + 1;
            counter++;
        }

        return totalResult;
    }
}

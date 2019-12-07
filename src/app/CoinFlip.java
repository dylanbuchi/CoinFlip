package app;

import java.util.Random;
import java.util.Scanner;

/**
 * CoinFlip
 */
public class CoinFlip {

    // fields
    private final Scanner in;
    private final Random random;

    private final String tails;
    private final String hail;
    private String hailOrTails;

    private int countHail;
    private int countTails;
    private int countGame;

    // constructor
    public CoinFlip() {

        // Objects
        in = new Scanner(System.in);
        random = new Random();

        // Strings
        tails = "tails";
        hail = "hail";
        hailOrTails = "";

        // Integers
        countHail = 0;
        countTails = 0;
        countGame = 0;

    }

    // starting the game
    public void start() {

        System.out.print("Hello, put flip to play: ");

        String input = in.next().toLowerCase();

        // start the game only if users input flip
        if (input.equals("flip")) {

            // 1st while loop for the game
            while (!input.equals("exit")) {

                /// 2nd while loop to be sure user inputs correct info
                while (!input.equals("exit")) {

                    System.out.println("Please select " + hail + " or " + tails);
                    hailOrTails = in.next().toLowerCase();

                    // when it's all correct break out
                    if (hailOrTails.equals("hail") || hailOrTails.equals("tails")) {
                        break;

                    }

                }

                System.out.println("You choose " + hailOrTails + " Good luck");

                // Counting the number of coins flipped
                countGame++;
                System.out.println("Flipping the coin...");
                System.out.println("...");
                System.out.println("...");

                // creating random numbers between 1 and 2 to do a 50/50
                int randomNumber = random.nextInt(2) + 1;

                if (randomNumber == 1) {

                    System.out.println("The coin is " + hail);

                    if (hail.equals(hailOrTails)) {

                        System.out.println("You won");

                    } else {
                        System.out.println("Better luck next time");
                    }

                    countHail++;

                } else if (randomNumber == 2) {
                    System.out.println("The coin is " + tails);

                    if (tails.equals(hailOrTails)) {

                        System.out.println("You won");

                    } else {
                        System.out.println("Better luck next time");
                    }
                    countTails++;

                }

                // end game stats and ask user if wants to restart or quit
                if (countGame == 1) {
                    System.out.println("Total of Hail: " + countHail + "\nTotal of Tails: " + countTails
                            + " \nYou flipped " + countGame + " coin do you want to play again Y|N");
                    input = in.next().toLowerCase();

                    if (input.equals("n")) {
                        System.out.println("Bye");
                        break;

                    } else if (input.contains("y")) {

                    } else {

                        // loop to check if user inputs correct info
                        while (!input.equals("y")) {

                            System.out.println("Error! Wrong input, do you want to play again Y|N");
                            input = in.next().toLowerCase();

                            if (input.equals("n")) {
                                input = "exit";
                                return;
                            }

                        }
                    }

                } else if (countGame > 1) {

                    System.out.println("Total of Hail: " + countHail + "\nTotal of Tails: " + countTails
                            + " \nYou flipped " + countGame + " coins do you want to play again Y|N");

                    input = in.next().toLowerCase();

                    if (input.equals("n")) {
                        System.out.println("Bye");
                        break;

                    } else if (input.contains("y")) {

                    } else {

                        // loop to check if user inputs correct info
                        while (!input.equals("y")) {

                            System.out.println("Error! Wrong input, do you want to play again Y|N");
                            input = in.next().toLowerCase();

                            if (input.equals("n")) {
                                System.out.println("Bye");
                                input = "exit";
                                return;

                            }
                        }

                    }

                }
            }
            // bye
        } else {
            System.out.println("Bye");
            return;
        }

    }
}
import java.util.Scanner;

//Nicholas Kato was here lab 11
class P1Random
{
    private long next;

    public P1Random()
    {
        next = 0;
    }

    private short nextShort()
    {
        return nextShort(Short.MAX_VALUE);
    }

    private short nextShort(short limit)
    {
        next = next * 1103515245 + 12345;
        return (short) Math.abs(((next / 65536) % limit));
    }

    private int nextInt()
    {
        return nextInt(Integer.MAX_VALUE);
    }

    public int nextInt(int limit)
    {
        return ((((int) nextShort()) << 16) | ((int) nextShort())) % limit;
    }

    private double nextDouble()
    {
        return (double) nextInt() / (double) Integer.MAX_VALUE;
    }
}



public class Blackjack {
    public static void main(String[] args) {
        // These are the variables for the game to work
        int startGame;
        startGame = 1;
        int cardAdded = 0;
        int totalHand;
        totalHand = 0;
        int dealerHand;
        int option = 1;
        int wins = 0;
        int dealerWins = 0;
        double percentWin;
        int tie = 0;
        int totalGame = 0;
        System.out.print("START GAME #" + startGame);
        // this is the system command to call for the random number generator
        P1Random rng = new P1Random();
        Scanner scnr = new Scanner(System.in);
        //This is the while loop allowing the game to continuously play until 4 is inputted
        while (option != 4) {
            if (option == 1) {
                cardAdded = rng.nextInt(13) + 1;
                // This switches 1 into ACES
                if (cardAdded == 1) {
                    totalHand = (cardAdded + totalHand);
                    System.out.print("\nYour card is a ACE!\n");
                    System.out.print("Your hand is: " + totalHand + "\n\n");
                    System.out.print("1.  Get another card\n");
                    System.out.print("2.  Hold hand\n");
                    System.out.print("3.  Print statistics\n");
                    System.out.print("4.  Exit\n\n");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                }
                //This makes sure every other card is what it is supposed to numerically as well as checks to see if it goes over 21
                if (cardAdded >= 2 && cardAdded <= 10) {
                    totalHand = (cardAdded + totalHand);

                    System.out.print("Your card is a " + cardAdded + "!\n");
                    System.out.print("Your hand is: " + totalHand + "\n\n");
                    if (totalHand > 21) {
                        System.out.print("You exceeded 21! You lose.");
                        dealerWins = dealerWins + 1;
                        startGame = startGame + 1;
                        totalGame = totalGame + 1;
                        totalHand = 0;
                        System.out.print("START GAME #" + startGame);
                        continue;
                    }
                    System.out.print("1. Get another card\n");
                    System.out.print("2.  Hold hand\n");
                    System.out.print("3.  Print statistics\n");
                    System.out.print("4.  Exit\n\n");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                }
                // This changes any number over 10 into 10 and displays king as well as tells if you reached BLACKJACK or if you went over 21
                if (cardAdded > 10) {
                    cardAdded = 10;
                    totalHand = (cardAdded + totalHand);
                    System.out.print("\nYour card is a KING!\n");
                    System.out.print("Your hand is: " + totalHand + "\n\n");
                    if (totalHand ==21) {
                        System.out.print("\nBLACKJACK! You win!");
                        wins = wins +1;
                        startGame = startGame +1;
                        totalGame = totalGame +1;
                        totalHand =0;
                        System.out.print("START GAME #" + startGame + "\n");
                        continue;
                    }
                    if (totalHand > 21) {
                        System.out.print("You exceeded 21! You lose.");
                        dealerWins = dealerWins + 1;
                        startGame = startGame + 1;
                        totalGame = totalGame + 1;
                        totalHand = 0;
                        System.out.print("START GAME #" + startGame);
                        continue;
                    }
                    System.out.print("1. Get another card\n");
                    System.out.print("2.  Hold hand\n");
                    System.out.print("3.  Print statistics\n");
                    System.out.print("4.  Exit\n\n");
                    System.out.print("Choose an option: ");
                    option = scnr.nextInt();
                }
                //This just checks if you went over 21
                if (totalHand ==21) {
                    System.out.print("\nBLACKJACK! You win!");
                    wins = wins +1;
                    startGame = startGame +1;
                    totalGame = totalGame +1;
                    totalHand =0;
                    System.out.print("START GAME #" + startGame);
                }
                if (totalHand > 21) {
                    System.out.print("You exceeded 21! You lose.");
                    dealerWins = dealerWins +1;
                    startGame = startGame +1;
                    totalGame = totalGame +1;
                    totalHand = 0;
                    System.out.print("START GAME #" + startGame);
                }
            }
            // This if inputted 2 displays the dealer's hand and compares it to your and see if you won
            if (option == 2) {
                dealerHand = rng.nextInt(11) + 16;
                System.out.print("\nDealer's hand: " + dealerHand + "\n");
                System.out.print("Your hand is: " + totalHand + "\n");
                // this checks to see if the dealer went over 21 and if he did says you win
                if (dealerHand > 21) {
                    System.out.print("You win!\n");
                    wins = wins + 1;
                    startGame = startGame + 1;
                    totalGame = totalGame + 1;
                    totalHand = 0;
                    option = 1;
                    System.out.print("START GAME #" + startGame);
                }
                // This checks to see if the dealer's hand is less than your and if it tells you win
                if (dealerHand < totalHand) {
                    System.out.print("You win!\n");
                    wins = wins + 1;
                    startGame = startGame + 1;
                    totalHand = 0;
                    totalGame = totalGame + 1;
                    option = 1;
                    dealerHand = 0;
                    System.out.print("START GAME #" + startGame);
                }
                //This checks to see if your hand is equal to the dealer's hand and if it tells you tied
                if (dealerHand == totalHand) {
                    System.out.print("It's a tie! No one wins!\n");
                    tie = tie + 1;
                    startGame = startGame + 1;
                    option = 1;
                    totalHand = 0;
                    totalGame = totalGame + 1;
                    System.out.print("START GAME #" + startGame);
                    //This checks to see if the dealer's hand is greater than yours and if it is tells you lost
                } else if (dealerHand > totalHand && dealerHand <= 21) {
                    System.out.print("Dealer wins!\n\n");
                    dealerWins = dealerWins + 1;
                    startGame = startGame + 1;
                    totalHand = 0;
                    totalGame = totalGame + 1;
                    option = 1;
                    System.out.print("START GAME #" + startGame);
                }
            }
            //This gives you your stats when you input the option 3
            if (option == 3) {
                System.out.print("Number of Player wins: " + wins + "\n");
                System.out.print("Number of Dealer wins: " + dealerWins + "\n");
                System.out.print("Number of tie games: " + tie + "\n");
                System.out.print("Total # of games played is: " + totalGame + "\n");
                percentWin = (double) wins / totalGame;
                percentWin = percentWin *100;
                System.out.print("Percentage of Player wins: " + percentWin + "%\n\n");
                System.out.print("1.  Get another card\n");
                System.out.print("2.  Hold hand\n");
                System.out.print("3.  Print statistics\n");
                System.out.print("4.  Exit\n\n");
                System.out.print("Choose an option: ");
                option = scnr.nextInt();
            }
            //This end the program
            if (option == 4) {
                System.exit(0);
            }
            //This tells you to input a different number because its not one of the choices on the menu
            if (option < 1 || option > 4) {
                System.out.print("Invalid input! \n" + "Please enter an integer value between 1 and 4.\n");
                System.out.print("1.  Get another card\n");
                System.out.print("2.  Hold hand\n");
                System.out.print("3.  Print statistics\n");
                System.out.print("4.  Exit\n\n");
                System.out.print("Choose an option: ");
                option = scnr.nextInt();
            }
        }
        }
    }

import java.util.Random;

/**
 * Question 1a
 *
 * This Class allows the user to play a game of rock paper scissors against
 * the computer. The winner is whoever wins three rounds first. The user is
 * prompted to input either rock, paper or scissors and the computer
 * uses a randomly generated number which is assigned to either rock, paper
 * or scissors. If the user inputs an invalid response the computer will win
 * that round.
 *
 * The rules:
 * rock beats scissors
 * paper beats rock
 * scissors beats paper
 *
 * @author Thomas Milton
 * @version 07/12/21
 */

public class RockPaperScissors
{
    // Question 1b

    // Used to get a response from the user.
    private final InputReader reader;
    // Keeps a tally of the users score.
    private int yourScore;
    // Keeps a tally of the computers score.
    private int computerScore;
    // Used to create a random number for the computers choice.
    private final Random ran;

    /**
     * Question 1c
     *
     * Creates a new RockPaperScissors and declares the users and computers
     * score to zero.
     */
    public RockPaperScissors()
    {
        reader = new InputReader();
        yourScore = 0;
        computerScore = 0;
        ran = new Random(1);
    }

    /**
     * Question 1d
     *
     * Prints a prompt for the user to enter there choice of either rock, paper
     * or scissors.
     */
    public void printPrompt()
    {
        System.out.println();
        System.out.println();
        System.out.print("Enter your choice, paper, rock or scissors > ");
    }

    /**
     * Question 1e
     *
     * Uses the inputReader class to get an input from the user which is then
     * converted to lower case and all leading and trailing space trimmed.
     * The users input is then returned.
     *
     * @return aString the users choice either rock paper or scissors.
     */
    public String userChoice()
    {
        String userInput = reader.getInput().toLowerCase().trim();
        return userInput;
    }

    /**
     * Question 1f
     *
     * Creates a computer responce of either rock, paper or scissors.
     * A randomly generated number from the Random Class is assighned with
     * a String responce, the responce is then returned.
     *
     * @return aString the computers choice either rock, paper or scissors.
     */
    public String computerChoice()
    {
        String computerHasChosen;

        int computerInput = ran.nextInt(3);
        switch(computerInput) {
            case 0: computerHasChosen = "rock";
                break;
            case 1: computerHasChosen = "paper";
                break;
            case 2: computerHasChosen = "scissors";
                break;
            default: computerHasChosen = "invalid input";
        }

        return computerHasChosen;
    }

    /**
     * Question 1g
     *
     * The winner of a round is calucated by the rules of the game, the winner
     * is returned as a String and there score is incremented by one. If the game is a draw
     * then the String draw is returned and no score is incremented.
     *
     * @param yourChoice yourChoice the users choice either rock paper or scissors.
     * @param computerChoice computerChoice The computers choice either rock, paper or scissors.
     * @return String the winner of the round or a draw.
     */
    public String findWinner(String yourChoice, String computerChoice)
    {
        if(yourChoice.equals(computerChoice)) {
            return "draw";
        }
        else if(yourChoice.equals("rock") && computerChoice.equals("scissors")
                || yourChoice.equals("scissors") && computerChoice.equals("paper")
                || yourChoice.equals("paper") && computerChoice.equals("rock")) {
            yourScore++;
            return "you";
        }
        else{
            computerScore++;
            return "computer";
        }
    }

    /**
     * Question 1h
     *
     * Allows the user and the computer to play a single round, the users and
     * computers choice is printed out and the winner is calcuated using the
     * findWinner method and the return is assighned with a String responce
     * and this is printed out to the user aswell as the updated scores.
     */
    public void playRound()
    {
        printPrompt();
        String userChoice = userChoice();
        String computerChoice = computerChoice();
        System.out.println();
        System.out.println("You have chosen "+userChoice+
                " and the computer has chosen "+computerChoice);

        String winner = findWinner(userChoice, computerChoice);
        switch(winner) {
            case "draw": System.out.println("This game is a draw");
                break;
            case "you": System.out.println("You are the winner");
                break;
            case "computer": System.out.println("The computer is the winner");
                break;
            default: System.out.println("Invalid game");
        }

        System.out.println("You have "+yourScore+
                " and the computer has "+computerScore);
    }

    /**
     * Question 1i
     *
     * The user plays a game with the computer, the game contines to call the
     * playRound method until either the user score or the computer score
     * reaches three. Whichever score reaches three first, they are deemed the
     * winner and a String is printed to the user of the winner.
     */
    public void playGame()
    {
        while(yourScore < 3 && computerScore < 3) {
            playRound();
        }

        if(yourScore == 3) {
            System.out.println("The overall winner is you");
        }
        else {
            System.out.println("The overall winner is the computer");
        }
    }
}


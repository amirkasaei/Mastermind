import java.util.Scanner;

public class Mastermind {

    //show colors for a sec
    static void showcolors(String colors){
        //print random colors
        System.out.print(colors);
        //wait
        try
        {
            Thread.sleep(800);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        //erase
        for (int k = 0; k < 5; k++) {
            System.out.print("\b");
        }
    }

    //header print
    static void header(){
        System.out.println("\t\t\t\t\t*MasterMind*");
        System.out.println("--------------------------------------------------\n");
    }

    //return random color buffer
    static String RandomColors() {

        // colors
        String colors = "RBPYOPGW";

        // create random colors
        String randomcolor = new String();

        for (int i = 0; i < 5; i++) {

            // generate a random index of colors
            int index = (int)(8 * Math.random());

            // add characters one by one in end of randomcolor
            randomcolor = randomcolor.concat(String.valueOf(colors.charAt(index)));
        }

        return randomcolor;
    }

    //game process
    static void game(String name){
        Scanner scanner = new Scanner(System.in);
        String colors = RandomColors();

        //scanner for guess string
        System.out.print("\nPlease Enter The Limit Number Of Your Guesses: ");
        int guessnumber = scanner.nextInt();
        System.out.println("\n\n");
        header();
        System.out.println("...... -----");
        boolean guesscheck = false;

        //player's guess
        String guess;

        //check if player is right
        do {
            System.out.print("Guess: ");
            guess = scanner.next();
            guessnumber--;
            switch (guess){

                //play again
                case "0":
                    menu();

                //string look 1 sec
                case "1":
                    showcolors(colors);
                    break;

                //help sign creator
                default:
                    //default wrong color
                    char[] help = {'-','-','-','-','-'};

                    if (guess.equals(colors))
                        guesscheck = true;

                    for (int i = 0; i < 5; i++) {

                        for (int j = 0; j < 5; j++) {
                            if (guess.charAt(i) == colors.charAt(j)) {
                               help[i] = '+';
                            }
                        }
                        //Right color
                        if (guess.charAt(i) == colors.charAt(i)) {
                            help[i] = '#';
                        }
                    }
                    System.out.println("...... " + new String(help));
            }
        }while (!guesscheck && guessnumber!=0);

        //player win
        if (guesscheck && guessnumber!=0) {
            System.out.println("That's Right " + name + "!!");
        }

        //player lose
        else if (guessnumber==0) {
            System.out.println("\n\tOut Of Limit!");
        }
    }

    //menu
    static void menu(){
        Scanner scanner = new Scanner(System.in);
        header();
        System.out.println("\t\t1.Start\t\t\t\t\t2.Exit");
        System.out.print("\nPlease Enter The Number You Want: ");
        byte menu = scanner.nextByte();

        switch (menu){
            //start game
            case 1:
                //player name
                System.out.print("\nEnter Your Name Please: ");
                String name = scanner.next();
                //game process
                game(name);
                break;

            //exit game
            case 2:
                return;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
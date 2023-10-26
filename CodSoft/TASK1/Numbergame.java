import java.util.*;
public class Numbergame{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Random r = new Random();
        int number,min_value=0, max_value=100,no_of_rounds=0,no_of_attempts=8,score=0;

        System.out.println("Please enter number between 0 and 100");

        boolean continueplaying = true;
        while(continueplaying){
            number= r.nextInt(max_value - min_value + 1) + min_value;
            int attempts = 0;
            boolean Win = false;
            System.out.println("Round"+ (no_of_rounds + 1));
            while(attempts < no_of_attempts){
                System.out.print("Attempt"+ (attempts +1)+ "\nEnter your number= ");
                int guess = sc.nextInt();
                if(guess < min_value || guess > max_value){
                    System.out.println("Your number is out of range\nTry Again");
                }
                else if(guess < number){
                    System.out.println("Number is too low");
                }
                else if(guess > number){
                    System.out.println("Number is too high");
                }
                else{
                    System.out.println("Congratulations You Won");
                    Win = true;
                    score++;
                    break;
                }
                attempts++;
            }
            if(!Win){
                System.out.println("Your attempts are over\nThe correct number is= "+ number);
            }
            System.out.println("Your Score= "+ score);
            System.out.println("Do you want to play another round? (y/n)= ");
            String anotherround = sc.next();
            if(!anotherround.equals("y")){
                continueplaying = false;
            }
            no_of_rounds++;
        }
        System.out.println("Your Final Score= "+ score);
    }
}
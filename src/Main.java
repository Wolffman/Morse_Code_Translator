/**
 * Created by student on 10/17/17.
 */
import java.util.Scanner;
public class Main {
    public static String getString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter english or morse code to translate");
        String ans = sc.nextLine();
        sc.close();
    return ans;
    }
    public static void main(String[] args) {

    }

}

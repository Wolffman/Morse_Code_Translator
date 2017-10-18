/**
 * Created by student on 10/17/17.
 */
import java.util.Scanner;
import java.io.*;
import sun.audio.*;

import javax.swing.*;

public class Main extends JPanel{
    public static String getString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter english or morse code to translate");
        String ans = sc.nextLine();
        sc.close();
    return ans;
    }

    String[][] arrays = new String[][]
            {       {"a", ".-"},
                    {"b", "-..."},
                    {"c", "-.-."},
                    {"d", "-.."},
                    {"e", "."},
                    {"f", "..-."},
                    {"g", "--."},
                    {"h", "...."},
                    {"i", ".."},
                    {"j", ".---"},
                    {"k", "-.-"},
                    {"l", ".-.."},
                    {"m", "--"},
                    {"n", "-."},
                    {"o", "--"},
                    {"p", ".--."},
                    {"q", "--.-"},
                    {"r", ".-."},
                    {"s", "..."},
                    {"t", "-"},
                    {"u", "..-"},
                    {"v", "...-"},
                    {"w", ".--"},
                    {"x", "-..-"},
                    {"y", "-.--"},
                    {"z", "--."}
            };


    public static void main(String[] args) {

            JFrame window = new JFrame("Morse Code Translator");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBounds(0, 0, 1000, 800); //(x, y, w, h)
            Main panel = new Main();
            panel.setFocusable(true);
            panel.grabFocus();
            window.add(panel);
            window.setVisible(true);

    }

}

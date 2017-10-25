/**
 * Created by student on 10/17/17.
 */
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.RunnableFuture;

public class Main {

    public static BTreeNode letterTree, codeTree;
   // public static String  input;

    public static String[][] data = new String[][]{
            {"0", " ", "/"},
            {"1", "a", ".-"},
            {"2", "b", "-..."},
            {"3", "c", "-.-."},
            {"4", "d", "-.."},
            {"5", "e", "."},
            {"6", "f", "..-."},
            {"7", "g", "--."},
            {"8", "h", "...."},
            {"9", "i", ".."},
            {"10", "j", ".---"},
            {"11", "k", "-.-"},
            {"12", "l", ".-.."},
            {"13", "m", "--"},
            {"14", "n", "-."},
            {"15", "o", "---"},
            {"16", "p", ".--."},
            {"17", "q", "--.-"},
            {"18", "r", ".-."},
            {"19", "s", "..."},
            {"20", "t", "-"},
            {"21", "u", "..-"},
            {"22", "v", "...-"},
            {"23", "w", ".--"},
            {"24", "x", "-..-"},
            {"25", "y", "-.--"},
            {"26", "z", "--."},
            {"27", "1", ".----"},
            {"28","2", "..---"},
            {"29", "3","...--"},
            {"30", "4","....-"},
            {"31", "5", "....."},
            {"32","6", "-...."},
            {"33", "7", "--..."},
            {"34","8","---.."},
            {"35","9","----."},
            {"36","0","-----"}};

    public static void main(String[] args,String input) {

    }
    public static void translate(String input){
        setup();
//        drawTree(codeTree);
        System.out.println(input);
        if (input.contains(".") || input.contains("-")) {
            try {
                System.out.println(translateToLetter(input));
            } catch (InvalidException e) {
                System.out.println("Invalid characters! Only use dots, dashes, and slashes");
            }
        } else {
            try {
                String temp = translateToCode(input);
                System.out.println(temp);
                playSound(toSoundList(temp));
            } catch (InvalidException e) {
                System.out.println("Invalid characters! Only use A-Z and spaces");
            }
        }

    }

    public static void setup() {
        String[][] temp = data.clone();
        Arrays.sort(temp, (o1, o2) -> o1[1].compareTo(o2[1]));
        letterTree = new BTreeNode(temp, 1);

        Arrays.sort(temp, (o1, o2) -> o1[2].compareTo(o2[2]));
        codeTree = new BTreeNode(temp, 2);
    }

    public static void drawTree(BTreeNode head) {
        int maxLength = head.getMaxStringLength();
        int treeHeight = head.getHeight();

        for (int i = 0; i < treeHeight; i++) {
            ArrayList<String> temp = head.getLevel(i);
            int length = (int) (Math.pow(2, treeHeight - i - 1)) - 1;
            String spaces = createSpaces(length * maxLength);
            String tempString = "";
            for (int j = 0; j < temp.size(); j++) {
                tempString += spaces + appendSpaces(temp.get(j) + "", maxLength) + spaces + createSpaces(maxLength);
            }
            System.out.println(tempString);
        }
    }

    public static String appendSpaces(String string, int target) {
        int numbSpacesToAdd = target - string.length();
        String returnString = string + createSpaces(numbSpacesToAdd);
        return returnString;
    }

    public static String createSpaces(int numbSpacesToAdd) {
        String returnString = "";
        for (int i = 0; i < numbSpacesToAdd; i++) {
            returnString += " ";
        }
        return returnString;
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter english or morse code to translate:");
        String ans = sc.nextLine();
        sc.close();
        return ans;
    }

    public static String translateToCode(String string) throws InvalidException {
        String[] temp = string.toLowerCase().split("");
        String returnString = "";
        for (int i = 0; i < temp.length; i++) {
            int tempIndex = letterTree.find(temp[i]);
            if (tempIndex != -1) {
                returnString += data[tempIndex][2] + " ";
            } else {
                throw new InvalidException();
            }
        }
        returnString = returnString.substring(0, returnString.length() - 1);

        return returnString;
    }

    public static String translateToLetter(String string) throws InvalidException {
        String[] temp = string.toLowerCase().split(" ");
        String returnString = "";
        for (int i = 0; i < temp.length; i++) {
            int tempIndex = codeTree.find(temp[i]);
            if (tempIndex != -1) {
                returnString += data[tempIndex][1];
            } else {
                throw new InvalidException();
            }
        }
        return returnString;
    }

    private static ArrayList<String> toSoundList(String string) {
        String[] temp = string.split("");
        ArrayList<String> returnList = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals(".")) {
                returnList.add("dot_sound");
            } else if (temp[i].equals("-")) {
                returnList.add("dash_sound");
            } else {
                returnList.add("empty");
                returnList.add("empty");
            }
        }
        return returnList;
    }

    public static void play(ArrayList<String> files) {
        byte[] buffer = new byte[4096];
        for (String filePath : files) {
            File file = new File("res/" + filePath + ".wav");
            try {
                AudioInputStream is = AudioSystem.getAudioInputStream(file);
                AudioFormat format = is.getFormat();
                SourceDataLine line = AudioSystem.getSourceDataLine(format);
                line.open(format);
                line.start();
                while (is.available() > 0) {
                    int len = is.read(buffer);
                    line.write(buffer, 0, len);
                }
                line.drain();
                line.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void playSound(ArrayList<String> files) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                play(files);

            }
        };
        Thread thread1 = new Thread(r);
        thread1.start();
    }


}

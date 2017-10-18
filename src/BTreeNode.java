import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by student on 10/17/17.
 */
public class BTreeNode {
    private String key;
    private int value;
    private BTreeNode left, right;
    private BTreeNode(String key, int value){
        this.key = key;
        this.value = value;
    }

    private void insert(String key, int value){
        if(this.key.compareTo(key) < 0){
            if(left != null){
                left.insert(key, value);
            }else{
                left = new BTreeNode(key, value);
            }
        }else{
            if(left != null){
                right.insert(key, value);
            }else{
                right = new BTreeNode(key, value);
            }
        }
    }

    public BTreeNode(String[][] array, int dataIndex){
        int splitIndex = array.length/2;
        if(splitIndex != 0) {
            String[][] tempLeftArray = Arrays.copyOfRange(array, 0, splitIndex);
            this.left = new BTreeNode(tempLeftArray, dataIndex);
        }

        if(array.length !=  splitIndex + 1){
            String[][] tempRightArray = Arrays.copyOfRange(array, splitIndex + 1, array.length);
            this.right = new BTreeNode(tempRightArray, dataIndex);
        }

        this.key = array[splitIndex][dataIndex];
        this.value = Integer.parseInt(array[splitIndex][0]);
    }

    public int getValue() {
        return value;
    }

    public int find(String key){
        if(this.key.compareTo(key) > 0){
            if(left != null){
                return left.find(key);
            }
        }else if(this.key.compareTo(key) < 0){
            if(right != null){
                return right.find(key);
            }
        }else{
            return value;
        }
        return -1;
    }

    public int getMaxStringLength(){
        int tempLength = 0;
        int currentMax = 0;
        if(left != null){
            tempLength = left.getMaxStringLength();
            if(tempLength > currentMax){
                currentMax = tempLength;
            }
        }
        if(right != null){
            tempLength = right.getMaxStringLength();
            if(tempLength > currentMax){
                currentMax = tempLength;
            }
        }
        tempLength = ("{" + this.key + " " + this.value + "}").length();
        if(tempLength > currentMax){
            currentMax = tempLength;
        }
        return currentMax;
    }

    public ArrayList<String> getLevel(int target){
        ArrayList<String> returnList = new ArrayList<>();
        if(target == 0){
            returnList.add("{" + this.key + " " + this.value + "}");
            return returnList;
        }else{
            if(left != null) {
                returnList.addAll(left.getLevel(target - 1));
            }else if(target == 1){
                returnList.add(" ");
            }
            if(right != null) {
                returnList.addAll(right.getLevel(target - 1));
            }else if(target == 1){
                returnList.add(" ");
            }
            return returnList;
        }
    }

    public int getHeight(){
        int tempLeft = 0;
        int tempRight = 0;

        if(left != null){
            tempLeft += left.getHeight();
        }

        if(right != null){
            tempRight += right.getHeight();
        }

        if(tempLeft > tempRight){
            return tempLeft + 1;
        }else{
            return tempRight + 1;
        }
    }
}

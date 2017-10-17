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

    public int getValue() {
        return value;
    }

    public int find(String key){
        if(this.key.compareTo(key) < 0){
            if(left != null){
                left.find(key);
            }else{
                return this.value;
            }
        }else if(this.key.compareTo(key) > 0){
            if(left != null){
                right.insert(key, value);
            }else{
                return this.value;
            }
        }
        return -1;
    }
}

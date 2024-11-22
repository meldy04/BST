import java.util.Objects;

/**
 * A minimal implementation of a binary search tree storing Integers.
*/
public class BST {
    private Integer root;

    private BST left;
    private BST right;

    public BST(Integer root) {
        if (root != null) { // check to ensure we don't accidentally try to store null at the root!
            this.root = root;
            this.left = new BST();
            this.right = new BST();
        }
        // Note: each of the attributes will default to null if root == null
    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public BST() {
        this(null);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(Integer item) {
        if (this.isEmpty()) {
            return false;
        } else if (item.equals(this.root)) {
            return true;
        } else if (item.compareTo(this.root) < 0) {
            return this.left.contains(item);
        }
        return this.right.contains(item);

    }

    public void insert(Integer item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = null;
            this.right = null;
        }
        else if (item.compareTo(this.root) <= 0) {
            if (this.left == null) {
                this.left = new BST();
            }
            this.left.insert(item);
        }
        else {
            if (this.right == null) {
                this.right = new BST();
            }
            this.right.insert(item);
        }

    }

    public void delete(Integer item) {
        if (this.isEmpty()) {
            return;
        }

        if (Objects.equals(this.root, item)) {
            this.deleteRoot();
        }

        else if (item.compareTo(this.root) < 0) {
            if (this.left != null) {
                this.left.delete(item);
            }
        }

        else {
            if(this.right != null) {
                this.right.delete(item);
            }
        }
    }

    private void deleteRoot() {
        if (this.left == null && this.right == null) {
            this.root = null;
        }

        else if (this.left == null) {
            this.root = this.right.root;
            this.left =  this.right.left;
            this.right = this.right.right;
        }

        else if (this.right == null) {
            this.root = this.left.root;
            this.left = this.left.left;
            this.right = this.left.right;
        }
        else if (this.root == null) {
            return;
        }

        else {
            this.root = this.left.extractMax();
        }
    }

    private Integer extractMax() {
        if (this.right == null) {
            int maxItem = this.root;
            this.root = (this.left != null) ? this.left.root : null;
            this.left = (this.left != null) ? this.left.left : null;

            return maxItem;
        }
        return this.right.extractMax();
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        }
        int LH = (this.left != null) ? this.left.height() : 0;
        int RH = (this.right != null) ? this.right.height() : 0;
        return Math.max(LH, RH) + 1;
    }

    public int count(Integer item) {
        if (this.isEmpty()) {
            return 0;
        }
        else if (this.root.compareTo(item) > 0) {
            return (this.left != null) ? this.left.count(item) : 0;
        }
        else if (this.root.equals(item)) {
            return 1 + ((this.left != null) ? this.left.count(item) : 0) + ((this.right != null) ? this.right.count(item) : 0);
        }
        return (this.right != null) ? this.right.count(item) : 0;
    }

    public int getLength() {
        if (this.isEmpty()) {
            return 0;
        }
        int LHS = (this.left != null) ? this.left.getLength() : 0;
        int RHS = (this.right != null) ? this.right.getLength() : 0;
        return 1 + LHS + RHS;
    }

    public static void main(String[] args) {
    }

}

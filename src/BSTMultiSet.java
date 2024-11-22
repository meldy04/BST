public class BSTMultiSet extends MultiSet {

    // a multiset always starts empty, so directly instantiate our private attribute
    private final BST bst = new BST();

    @Override
    void add(Integer item) {
        this.bst.insert(item);
    }

    @Override
    void remove(Integer item) {
        // self._tree.delete(item)
        this.bst.delete(item);
    }

    @Override
    boolean contains(Integer item) {
        return this.bst.contains(item);
    } // return item in self._tree

    @Override
    boolean isEmpty() {
        return this.bst.isEmpty();
    }

    @Override
    int count(Integer item) {
        return this.bst.count(item);
    }

    @Override
    int size() {
        return this.bst.getLength();
    }

}

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by whobby on 11/16/17.
 */
public class Tree<T extends Comparable<T>> extends Structure implements Iterable<T>{

    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public int compareTo(Structure structure) {
        return 0;
    }

    @Override
    public boolean equals(Structure structure) {
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        ArrayList<T> list = traverse(root);
        return list.iterator();
    }

    private ArrayList<T> traverse(TreeNode<T> current){
        ArrayList<T> list = new ArrayList<>();
        if (current != null){
            list.addAll(traverse(current.getLeft()));
            list.add(current.getData());
            list.addAll(traverse(current.getRight()));
        }
        return list;
    }

    private void balance(TreeNode<T> current){

    }

    public void insert(T data){
        setRoot(recInsert(data, root));
    }

    private TreeNode<T> recInsert(T data, TreeNode<T> current){
        if (current.compareTo(data) < 0){
            if (current.getLeft() == null)
                current.setLeft(new TreeNode<>(data));
            else current.setLeft(recInsert(data, current.getLeft()));
        }
        else if (current.compareTo(data) > 0){
            if (current.getRight() == null)
                current.setRight(new TreeNode<>(data));
            else current.setRight(recInsert(data, current.getRight()));
        }
        return current;
    }

    public T find(T data){
        TreeNode<T> node = recFind(data, root);
        return node != null ? node.getData() : null;
    }

    private TreeNode<T> recFind(T data, TreeNode<T> current){
        if (current.equals(data))
            return current;
        else if (current.compareTo(data) > 0)
            return recFind(data, current.getRight());
        else if (current.compareTo(data) < 0)
            return recFind(data, current.getLeft());
        else return null;
    }

    /**
     * Created by whobby on 11/16/17.
     */
    private class TreeNode<E extends Comparable<E>> {

        /*
        * Variables
        * */
        private E data;
        private TreeNode<E> left;
        private TreeNode<E> right;

        /*
        * Accessors/Mutators
        * */
        private E getData() {
            return data;
        }

        private void setData(E data) {
            this.data = data;
        }

        private TreeNode<E> getLeft() {
            return left;
        }

        private void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        private TreeNode<E> getRight() {
            return right;
        }

        private void setRight(TreeNode<E> right) {
            this.right = right;
        }

        /*
        * Constructors
        * */
        TreeNode(){
        }

        TreeNode(E data){
            this.setData(data);
        }

        /*
        * Methods
        * */

        int compareTo(TreeNode<E> other){
            return this.getData().compareTo(other.getData());
        }

        int compareTo(E otherData){
            return this.getData().compareTo(otherData);
        }

        boolean equals(TreeNode<E> other){
            return this.getData().equals(other.getData());
        }

        boolean equals(E otherData){
            return this.getData().equals(otherData);
        }
    }
}

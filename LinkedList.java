import java.util.ArrayList;

/**
 * Created by Christian on 03.05.2017.
 * example on a single linked list
 */
public class LinkedList <E>{

    private Node firstElement = null;
    private Node lastElement = null;
    private int size = 0;

    public void add(E data) {
        Node<E> node = new Node<>(data);
        if (firstElement == null) {
            this.firstElement = node;
            this.firstElement.nextElement = node;
            this.lastElement = node;
        }else {
            this.lastElement.nextElement = node;
            this.lastElement = node;
        }
        size ++;
    }

    public void printList() {
        Node onElement = firstElement;
        while (onElement != null) {
            System.out.println(onElement.data);
            onElement = onElement.nextElement;

        }
    }

    private class Node <E>{
        E data;
        Node nextElement;

        public Node(E data) {
            this.data = data;
            nextElement = null;
        }
    }

    /**
     * get element on index
     * @param index     index of item
     * @return          element on the selected index
     * @throws Exception
     */
    public E get(int index) throws Exception {
        int count = 0;
        Node onElement = firstElement;

        // possible errors by the user.
        if (index > size) throw new Exception("Array out of index");
        if (index < 0) throw new Exception("No negative index's allowed");

        // start searching for the element.
        if (index == 0 && onElement != null) return (E) onElement.data;

        // okay, now we need to loop trough the whole list to get the requested index
        while (onElement != null) {
            if (index == count) return (E) onElement.data;
            count++;
            onElement = onElement.nextElement;
        }

        return null; // this will never happen
    }

    /**
     * Remove items by index
     * @param index
     * @return
     * @throws Exception
     */
    public boolean remove(int index) throws Exception{
        int count = 0;
        // possible errors by the user.
        if (index > size) throw new Exception("Array out of index");
        if (index < 0) throw new Exception("No negative index's allowed");

        if (index == 0)  {
            firstElement = firstElement.nextElement;    // now the first element will be removed by the garbage collector
            return true;
        }
        Node onElement = firstElement;
        while (onElement != null) {
            if (index == count + 1 && onElement.nextElement != null) {
                // get current element to point over the next element
                onElement.nextElement = onElement.nextElement.nextElement;
                size --;

                // since now there is no pointers, there is no way to reach the object -> therefor the garbage collector
                // will collect it.
                return true;
            }
            count ++;
        }

        return false;

    }

    public ArrayList<E> toArrayList() throws Exception{
        ArrayList<E> output = new ArrayList<E>();
        for (int i = 0; i < size; i++) output.add(get(i));
        return output;
    }

    public void fromArrayListToLinkedList(ArrayList<E> arrayList) {
        for (E obj : arrayList) add(obj);
    }

    public int getSize() {
        return size;
    }

}

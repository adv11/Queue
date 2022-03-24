package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeInJava {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Akash");
        deque.addLast("Abhishek");
        deque.addFirst("Deepak");
        deque.addFirst("Anurag");
        deque.addLast("Pawan");
        deque.addLast("Varun");

        // traversing without using iterator from front
        for (String name : deque) {
            System.out.println(name);
        }
        System.out.println("-----------------------------------");
        // iterator for traversing from front
        for(Iterator<String> itr = deque.iterator(); itr.hasNext();){
            System.out.println(itr.next());
        }
        System.out.println("-----------------------------------");
        // iterator for traversing from back
        for(Iterator<String> itr = deque.descendingIterator() ; itr.hasNext();){
            System.out.println(itr.next());
        }

        // for checking if element is present or not in the Deque
        System.out.println(deque.contains("Deepak"));
        System.out.println(deque.contains("Vivekananda"));

        // for checking size of the deque
        System.out.println(deque.size());

        // for retrieving head of the deque but not removing it
        System.out.println(deque.element());

        // for getting elements
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        // for adding elements
        // offer() method is preferable than add() because it does not give exception if the deque is full
        deque.offer("Ram");
        deque.offerFirst("Shyam");
        deque.offerLast("Sarvesh");
    }
}

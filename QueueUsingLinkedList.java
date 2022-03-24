package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// creating node for the linked list
class Node{
    int data;
    Node next;
    public Node(int key){
        data = key;
        next = null;
    }
}
public class QueueUsingLinkedList {
    static Node front;
    static Node rear;
    //constructor
    QueueUsingLinkedList(){
        front = null; rear = null;
    }
    // method for enqueuing element
    static void enqueue(int element){
        Node newNode = new Node(element);
        newNode.data = element;
        if(rear == null){
            front = rear = newNode;
            System.out.println("Enqueued operation done at : " + rear.data);
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Enqueued operation done at : " + rear.data);
    }
    // method for dequeue operation
    static int dequeue(){
        if(front == null){
            return -1;
        }
        Node temp = front;
        front = front.next;
        if(front == null){  // if we deleted last node
            rear = null;
        }
        return temp.data;
    }
    // method for finding peek value
    static int peek(){
        if(front == null)
            return -1;
        return front.data;
    }
    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        enqueue(11);
        enqueue(12);
        enqueue(13);
        System.out.println(dequeue());
        System.out.println(peek());
    }
}

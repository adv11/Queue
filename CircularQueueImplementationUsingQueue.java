package Queue;

import java.util.Scanner;
/*
* We have to implement the queue data structure using array.
*/
public class CircularQueueImplementationUsingQueue {
    static int size = 10, front, rear;
    static int[] queue = new int[size];
    // constructor
    CircularQueueImplementationUsingQueue(){
        front = -1;
        rear = -1;
    }
    // method for checking is the queue is full or not
    static boolean isFull(){
        if((front==0 && rear==size-1) || (front == rear+1)){
            return true;
        }
        return false;
    }
    // method for checking is the queue is empty or not
    static boolean isEmpty(){
        if(front == -1)
            return true;
        return false;
    }
    // method for storing elements
    static void enqueue(int element){
        if(isFull()){
            System.out.println("Queue is full");
        }else{
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            queue[rear] = element;
            System.out.println("Enqueue operation done, rear is at : " + element);
        }
    }
    // method for removing element
    static int dequeue(){
        int dequeuedElement;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            dequeuedElement = queue[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front = (front + 1)%size;
            }
            return dequeuedElement;
        }
    }
    // method for checking peek element
    static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else{
            return queue[front];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to perform some operations on Queue?" +
                "Press 1 for YES and 0 for NO");
        int press = sc.nextInt();
        if(press == 1){
            while (press != -1) {
                System.out.println("What do you want to perform?");
                System.out.println("""
                        1 : Add element
                        2 : Remove element
                        3 : Check peek element
                        4 : Check queue is full?
                        5 : Check queue is empty?
                        Press -1 to exit.
                        """);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        CircularQueueImplementationUsingQueue q = new CircularQueueImplementationUsingQueue();
                        System.out.println("Enter element:");
                        int element = sc.nextInt();
                        enqueue(element);
                        break;
                    case 2:
                        System.out.println("Dequeued element : " + dequeue());
                        break;
                    case 3:
                        System.out.println(peek());
                        break;
                    case 4:
                        if (isFull())
                            System.out.println("Queue is full");
                        else
                            System.out.println("Queue is not full");
                        break;
                    case 5:
                        if (isEmpty())
                            System.out.println("Queue is empty");
                        else
                            System.out.println("Queue is not empty");
                        break;
                    default:
                        System.out.println("Invalid choice, please press again.");
                }
                System.out.println("Do you want to continue : press 1 to continue");
                press = sc.nextInt();
            }
        }
    }
}

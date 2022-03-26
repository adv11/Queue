package Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
* LeetCode Link : https://leetcode.com/problems/sliding-window-maximum/
Problem Statement:
You are given an array of integers nums, there is a sliding window of size k which is moving from the very
left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/

public class SlidingWindowMaximum_LeetCode239 {
    // TC : O(N*K) SC : O(1)
    public static void BruteForce(int[] array, int k){
        for(int i=0 ; i<=array.length-k ; i++){
            int maxEle = -1;
            for(int j=0 ; j<i+k ; j++){
                maxEle = Math.max(maxEle, array[j]);
            }
            System.out.print(maxEle + " ");
        }
    }
    // Optimised Approach using deque data structure
    public static void Optimised_usingDeque(int[] array, int k, int[] ans){
        // creating deque
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        // firstly filling the deque according to the first k size window
        for(int i=0 ; i<k ; i++){
            while(!deque.isEmpty() && array[i]>=array[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        // for processing the whole array from index k to array.size()-1
        for(int i=k ; i<array.length ; i++){
            ans[index++] = array[deque.getFirst()]; // storing the max element present at first of deque
            while(!deque.isEmpty() && deque.getFirst()<=(i-k)){ // condition if some element is out of bound of current window
                deque.removeFirst();    // then remove that index
            }
            while(!deque.isEmpty() && array[i]>=array[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        ans[index] = array[deque.getFirst()];
    }
    public static <deque> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter t:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();
            System.out.println("Enter the elements of the array:");
            int[] array = new int[size];
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }
            System.out.println("Enter the value of K:");
            int k = sc.nextInt();

            // brute force method calling
            System.out.println("Brute force approach");
            BruteForce(array, k);
            System.out.println();

            // Optimised
            // storing the max element of each window in ans array
            System.out.println("Optimised approach");
            int[] ans = new int[size-k+1];
            Optimised_usingDeque(array, k, ans);
            // printing the ans array
            for(int i : ans){
                System.out.print(i + " ");
            }
        }
    }
}

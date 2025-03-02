import java.util.*;
/*
time complexity: O(n)
space complexity: O(k)
 */
public class SlidingWindowMaximum {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        int n = arr.length;
        int i=0;
        int j=0;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        while(j<n){
            while(!deque.isEmpty() && deque.peekLast()<arr[j]){
                deque.removeLast();
            }
            deque.add(arr[j]);
            if(j-i+1==k){
                list.add(deque.peek());
                if(arr[i]==deque.peek()){
                    deque.pollFirst();
                }
                i++;
            }
            j++;
        }
        return list;
    }
}

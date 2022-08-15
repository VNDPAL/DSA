package priorityQueueAndHeaps.TopDown;

import java.util.ArrayList;

public class TopDown {
    public static void main(String[] args) {

    }
    public static void heapify(ArrayList<Integer> arr, int n, int i)
    {

        // Initializing largest with root
        int largest = i;

        // Left child of current node
        int left = 2 * i + 1;

        // Right child of current node
        int right = 2 * i + 2;

        // If left child is greater than the current node
        if(left < n && arr.get(left) > arr.get(largest))
        {

            // update largest
            largest = left;
        }

        // If right child is greater than current node
        if(right < n && arr.get(right) > arr.get(largest))
        {

            // update largest
            largest = right;
        }

        // If the current node is not the largest
        if(largest != i)
        {

            // swap the values
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            // and recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static ArrayList<Integer> buildHeap(ArrayList<Integer> arr, int n)
    {

        // The last non - leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal from last non-leaf node and heapify each node
        for (int i = startIdx; i >= 0; i--)
        {
            heapify(arr, n, i);
        }

        return arr;
    }
}

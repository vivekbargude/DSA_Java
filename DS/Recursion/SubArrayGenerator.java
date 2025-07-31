package DS.Recursion;

import java.util.*;

public class SubArrayGenerator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> subarrays = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            List<Integer> current = new ArrayList<>();
            for (int end = start; end < arr.length; end++) {
                current.add(arr[end]);
                subarrays.add(new ArrayList<>(current)); // store the current subarray
            }
        }

        System.out.println("All subarrays:");
        for (List<Integer> sub : subarrays) {
            System.out.println(sub);
        }
    }
}


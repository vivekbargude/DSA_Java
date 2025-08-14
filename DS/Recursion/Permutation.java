package DS.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        //boolean[] freq = new boolean[n];

        //generatePermutations(n, arr, new ArrayList<>(), ans, freq);
        generatePermutationsBySwapping(0, n, arr, ans);

        for(List<Integer> list : ans){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void generatePermutations(int n, int[] arr, List<Integer> ds,List<List<Integer>> ans,boolean[] freq){

        //if ds has reached the size then permutation is generated
        if(ds.size()==n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //iterate through all the choices
        for(int i=0;i<arr.length;i++){
            //check if already taken or not if taken skip
            if(!freq[i]){
                //take it 
                freq[i]=true;
                //add it to ds
                ds.add(arr[i]);
                generatePermutations(n, arr, ds, ans, freq);

                //remove it from ds 
                ds.remove(ds.size()-1);
                //mark it not taken
                freq[i]=false;
            }
        }

    }

    public static void generatePermutationsBySwapping(int idx, int n, int[] arr, List<List<Integer>> ans){
        //if all index are taken 
        if(idx>=n){
            List<Integer> ds = new ArrayList<>();
            for(int num : arr){
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }


        //loop and give each element a chance by swapping them with current element at current index

        for(int i = idx; i<n; i++ ){
            //give the ith element the chance to be the curr index the permutation
            swap(idx, i, arr);

            generatePermutationsBySwapping(idx+1, n,arr, ans);

            //keep the element at its place for next round of permutations
            swap(idx, i, arr);
            
        }
    }

    public static void swap(int i, int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

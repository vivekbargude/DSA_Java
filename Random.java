import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Random{
    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(4,73, 67, 38, 33);
        List<Integer> ans = gradingStudents(grades);
        for(Integer num : ans)
        System.out.println(num);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
      
         List<Integer> ans = new ArrayList<>();
    
    
         int n = grades.size();
    
    for(int i=0;i<n;i++){
        int grade = grades.get(i);
        if(grade>=38){
        int nextMultiple = grade-grade%5+5;
        if(nextMultiple-grade<3){
            ans.add(nextMultiple);
        }else{
            ans.add(grade);
        }
        }
        else{
            ans.add(grade);
        }
    }
    
    return ans;


    } 
}
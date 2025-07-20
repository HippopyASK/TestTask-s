import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Не верно");
            return;
        }
        List<Integer> numsList = new ArrayList<>();

        
        try {
            File F = new File(args[0]);
            Scanner s = new Scanner(F);
            while (s.hasNextInt()){
                numsList.add(s.nextInt());
            }
            
        } catch (IOException e) {
            System.err.println( e.getMessage());
            return;
        } 

        if (numsList.isEmpty()) {
            System.out.println(0);
            return;
        }

        int[] nums = numsList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(nums);

        int median;
        int n = nums.length;
        if(n % 2 == 1) median = nums[n/2];
        else median = (nums[n/2-1]+nums[n/2]/2);

        int moves = 0;
        for (int i:nums) moves += Math.abs(i - median);

        System.out.println(moves);
    }
}
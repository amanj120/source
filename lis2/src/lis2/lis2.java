package lis2;
import java.io.*;
import java.util.*;
public class lis2 {   
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("lis2.in"));
        int[][] seq = new int[input.nextInt()][2];
        int max = 0;
        for (int i = 0; i < seq.length; i++) {
        	seq[i][0] = input.nextInt();
            for (int j = 0; j < i; j++) {
                if(seq[j][0] < seq[i][0]){
                    seq[i][1] = Math.max(seq[i][1], seq[j][1] + 1);
                }
            }
            max = Math.max(max, seq[i][1]);
        }
        System.out.println(max + 1);
        input.close();
    }   
}
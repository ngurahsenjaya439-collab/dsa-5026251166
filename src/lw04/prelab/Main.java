package lw04.prelab;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("Branches.txt"));
        int n = sc.nextInt();
        sc.nextLine();
        int[] originalOrder = new int[n];
        for(int i = 0; i<n; i++){
            originalOrder[i]= sc.nextInt();
        }
        int m = sc.nextInt();
        int[] targetStability = new int[m];
        for(int l = 0; l < m; l++){
            targetStability[l] = sc.nextInt();
        }
        sc.close();
        int passes = 3;
        for(int j = 1; j <= passes; j++){
            int key = originalOrder[j];
            int k = j - 1;
            while(k>=0 && originalOrder[k] < key){
                originalOrder[k + 1] = originalOrder[k];
                k--;
            }
            originalOrder[k+1] = key;
            
        }

        for(int i = 0; i < n; i++){
            if(i>0){
                System.out.print(" ");
            }
            System.out.print(originalOrder[i]);
        }
        System.out.println();

        for(int j = 0; j < m; j++){
            int found = -1;
            for(int k = 0; k < n; k++){
                if(originalOrder[k] == targetStability[j]){
                    found = k;
                    break;
                }
            }
            if(found != -1){
                System.out.println(targetStability[j] + " : FOUND at index " + found);
            } else {
                System.out.println(targetStability[j] + " : NOT FOUND");
            }
        }
        
        
    }
}
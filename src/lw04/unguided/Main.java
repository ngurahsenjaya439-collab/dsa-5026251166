package lw04.unguided;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = sc.nextInt();
        sc.nextLine();
        int[] originalOrder = new int[n];
        for(int i = 0; i<n; i++){
            originalOrder[i]= sc.nextInt();
        }
        int m = sc.nextInt();
        sc.nextLine();
        int[] targetCards = new int[m];
        for(int l = 0; l < m; l++){
            targetCards[l] = sc.nextInt();
        }
        sc.close();
        int passes = 2;
        int len = originalOrder.length;
        for(int c = 0; c < passes; c++){
            int posMin = c;
            for(int d = c + 1; d < len; d++){
                if(originalOrder[d] < originalOrder[posMin]){
                    posMin = d;
                }
            }
            int temp = originalOrder[c];
            originalOrder[c] = originalOrder[posMin];
            originalOrder[posMin] = temp;

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
                if(originalOrder[k] == targetCards[j]){
                    found = k;
                    break;
                }
            }
            if(found != -1){
                System.out.println(targetCards[j] + " : FOUND at index " + found);
            } else {
                System.out.println(targetCards[j] + " : NOT FOUND");
            }
        }
    }
}

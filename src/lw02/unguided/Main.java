package lw02.unguided;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> borrowing = new LinkedList<>();
        LinkedList<String[]> stocks = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedStack = new Stack<>();
        LinkedList<String[]> successfulRequests = new LinkedList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] transaction = line.split(" ");
            borrowing.add(transaction);
        }
        sc.close();
        while (!borrowing.isEmpty()) {
            queue.add(borrowing.removeFirst());
        }

        for(String[] t : queue){
            String name = t[0];
            boolean found = false;
            for(String[] c : customers){
                if(c[0].equals(name)){
                    found = true;
                    break;
                }
            }
            if(!found){
                customers.add(new String[]{name, "0"});
            }
        }
        String[] kalkulus = {"Kalkulus", "2"};
        String[] fisika = {"Fisika", "1"}; 
        String[] statistika = {"Statistika", "2"};
        stocks.add(kalkulus);
        stocks.add(fisika);
        stocks.add(statistika);
        while (!queue.isEmpty()) {
            String[] t = queue.poll();
            String name = t[0];
            String book = t[1];
            for(String[] c : customers){
                if(c[0].equals(name)){
                    for(String[] s : stocks){
                        if(s[0].equals(book)){
                            int stockAmount = Integer.parseInt(s[1]);
                            int borrowedAmount = Integer.parseInt(c[1]);
                            if(stockAmount>0 && borrowedAmount < 2){
                                stockAmount--;
                                borrowedAmount++;
                                s[1] = String.valueOf(stockAmount);
                                c[1] = String.valueOf(borrowedAmount);
                                successfulRequests.add(t);
                            } else {
                                failedStack.push(t);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("=== Successful Processed Requests ===");
        for (String[] s : successfulRequests) {
            System.out.println(s[0] + " " + s[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===");
        for (String[] b : stocks) {
            System.out.println(b[0] + " : " + b[1]);
        }

        System.out.println("\n=== Failed Requests ===");
        while (!failedStack.isEmpty()) {
            String[] f = failedStack.pop();
            System.out.println(f[0] + " " + f[1]);
        }
        
        
        
        
    }
}

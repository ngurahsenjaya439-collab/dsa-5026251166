package lw03.prelab;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;
public class Main {
    public static void main(String[] args){
        List<String> playlist = new ArrayList<>();
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String operation = parts[0];
            if(operation.equals("ADD")){
                String song = parts[1];
                playlist.add(song);
            } else if(operation.equals("REMOVE")){
                String songName = parts[1];
                playlist.remove(songName);
            } else if(operation.equals("INSERT")){
                String[] insertParts = line.split(" ", 3);

                int index = Integer.parseInt(insertParts[1]);
                String song = insertParts[2];
                playlist.add(index, song);
            }
            
        }
        sc.close();
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;
        Scanner input = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(participants.contains(line)){
                duplicateCount++;
            } else {
                participants.add(line);
            }
        }
        input.close();
        System.out.println("===== Problem 2 =====");
        System.out.println("Total participants: " + participants.size());
        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate participants: " + duplicateCount);

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 3);
            String typeName = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            if(typeName.equals("ADD")){
                if(inventory.containsKey(product)){
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if(typeName.equals("SELL")){
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                    int currentStock = inventory.get(product);
                    if(currentStock >= quantity){
                        inventory.put(product, currentStock - quantity);
                    } else {
                        failedSales++;
                    }
                } else {
                    failedSales++;
                }
            }

    }
    
        scanner.close();
        System.out.println("===== Problem 3 =====");
        System.out.println("Final Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + ": " + quantity);
        }
        System.out.println("Failed sales: " + failedSales);
}
}
        


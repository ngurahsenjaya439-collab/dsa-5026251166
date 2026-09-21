package lw01.unguided;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("rental.txt"));
            int totalData = scanner.nextInt();
            Rental[] rentals = new Rental[totalData];
            int[] unit = new int[totalData];
            
            for (int i = 0; i < totalData; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            unit[i] = scanner.nextInt();
               
            if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days);
                
            } else if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
            }
        }
        for(int i = 0; i < totalData; i++){
            Rental rental = rentals[i];
            System.out.println(rental.getId() + " | " + rental.label()+ " | "  + rental.calculateCharge(unit[i]));
        }
        scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
    }
}

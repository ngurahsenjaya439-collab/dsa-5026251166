package lw03.unguided;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registration.txt"));
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Set<String> registeredParticipants = new HashSet<>();
        Set<String> checkedInParticipants = new HashSet<>();
        Map<String, String> results = new HashMap<>(); 
        int rejectedCount = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            registeredParticipants.add(line);
        }
        sc.close();
        System.out.println("====Event Checked in Results====");
        
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
        
            if(!registeredParticipants.contains(line)){
                results.put(line, "Rejected (does not registered)");
                System.out.println(line + ": Rejected (does not registered)" );
                rejectedCount++;
            } else if(checkedInParticipants.contains(line)){
                results.put(line, "Rejected (already checked in)");
                System.out.println(line + ": Rejected (already checked in)" );
                rejectedCount++;
            } else {
                results.put(line, "Checked in");
                System.out.println(line + ": Checked in" );
                checkedInParticipants.add(line);
            }
        }
    
    
        sc2.close();
        System.out.println("===== Final Summary =====");
        int absentStudentsCount = registeredParticipants.size() - checkedInParticipants.size();
        System.out.println("Total Registered Participants: " + registeredParticipants.size());
        System.out.println("Successful Checked in : " + checkedInParticipants.size());
        System.out.println("Total Absent Students: " + absentStudentsCount);
        System.out.println("Rejected : " + rejectedCount);
    }
}






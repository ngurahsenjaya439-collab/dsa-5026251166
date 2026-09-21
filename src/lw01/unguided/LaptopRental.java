package lw01.unguided;

public class LaptopRental extends Rental {
    
    
    public LaptopRental(String id, int days) {
        super(id, days);
        
    }

    @Override
    public int calculateCharge() {
        if(getDays() <= 0){
            throw new IllegalArgumentException("The days must be more than 0");
        } else {
            return getDays() * 40000 + 10000;
        }
        
    }

    public String label(){
        return "Laptop";
    }
    
    
}

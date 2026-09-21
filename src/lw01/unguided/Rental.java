package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;
    protected Rental(String id, int days){
        if(days<=0){
            throw new IllegalArgumentException("The days must be more than 0");
        } else{
            this.id = id;
            this.days = days;
        };

        
    }
    public String getId(){
            return id;
        };

        public int getDays(){
            return days;
        };
    
    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int unit){
        if(unit <= 0){
            throw new IllegalArgumentException("The unit must above 0");
        } else {
            return unit * calculateCharge();
        }
        
    }
    public String label(){
        return "Rental";
    }
    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}

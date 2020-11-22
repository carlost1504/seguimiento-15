package model;
public class DVD extends Movie implements Rentable {
    private final static double TAX_DVD = 0.03;

    private int length;

    public DVD(int id, int basePrice, String title, boolean sale, int length) {
        super(id,basePrice,title,sale);
        this.length = length;
    }

    public DVD(int id, int basePrice, String title, boolean sale, String genre, int length) {
        super(id,basePrice,title,sale,genre);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

     @Override
    public String description() {
        String info = super.description()+"\nLargo: "+getLength()+"\nPrecio total de renta por día: "+rentPrice(1)+"\n";
        return info;
    }

    @Override
    public double getTax() {
        double result = getBasePrice() * TAX_DVD;
        return result;
    }

    @Override
    public double rentPrice(int days) {
        double result = (getBasePrice() + getTax())/4 * days;
        return result;
    }
}

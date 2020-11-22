package model;
public class Magazine extends Literature implements Salable {
    private final static double TAX_MAGAZINE = 0.05;
    private int week;

    public Magazine(int id, int basePrice, String title, boolean sale, int numberPages, int week) {
        super(id,basePrice,title,sale,numberPages);
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setWeak(int week) {
        this.week = week;
    }

    @Override
    public String description() {
        String info = super.description()+"\nSemana: "+getWeek()+"\nPrecio total de venta: "+salePrice()+"\n";
        return info;
    }

    @Override
    public double getTax() {
        double result = getBasePrice() * TAX_MAGAZINE;
        return result;
    }

    @Override
    public double salePrice() {
        double result = getBasePrice() + getTax();
        return result;
    }
}

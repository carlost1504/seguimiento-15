package model;
public class Book extends Literature implements Rentable, Salable {
    private final static double TAX_BOOK = 0.09;
    private int year;

    public Book(int id, int basePrice, String title, int numberPages, int year, boolean sale) {
        super(id,basePrice,title,sale,numberPages);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String description() {
        String info = super.description()+"\nAño: "+getYear()+"\nPrecio total de renta por día: "+rentPrice(1)+"\nPrecio total de venta: "+salePrice()+"\n";
        return info;
    }

    @Override
    public double getTax() {
        double result = getBasePrice() * TAX_BOOK;
        return result;
    }

    @Override
    public double rentPrice(int days) {
        double result = (getBasePrice() + getTax())/5 * days;
        return result;
    }

    @Override
    public double salePrice() {
        double result = getBasePrice() + getTax();
        return result;
    }
}

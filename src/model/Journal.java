package model;
public class Journal extends Literature implements Salable {
    private final static double TAX_JOURNAL = 0.02;
    private String date;

    public Journal(int id, int basePrice, String title, boolean sale, int numberPages, String date) {
        super(id,basePrice,title,sale,numberPages);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String description() {
        String info = super.description()+"\nFecha: "+getDate()+"\nPrecio total de venta: "+salePrice()+"\n";
        return info;
    }

    @Override
    public double getTax() {
        double result = getBasePrice() * TAX_JOURNAL;
            return result;
  }

    @Override
    public double salePrice() {
        double result = getBasePrice() + getTax();
        return result;
    }
}

package model;
public abstract class Product {
    private int id;
    private int basePrice;
    private String title;
    private boolean sale;

    public Product(int id, int basePrice, String title, boolean sale) {
        this.id = id;
        this.basePrice = basePrice;
        this.title = title;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setbasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public String description() {
        String info = "Identificador: "+getId()+"\nPrecio base: "+getBasePrice()+"\nTítulo: "+getTitle();
        return info;
    }

  public abstract double getTax();

}

package model;
public class DownloadableMovie extends Movie implements Salable {
    private final static double TAX_DMOVIE = 0.01;

    private String link;

    public DownloadableMovie(int id, int basePrice, String title, boolean sale, String link) {
        super(id,basePrice,title,sale);
        this.link = link;
    }

    public DownloadableMovie(int id, int basePrice, String title, boolean sale, String genre, String link) {
        super(id,basePrice,title,sale,genre);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String description() {
        String info = super.description()+"\nEnlace: "+getLink()+"\nPrecio total de venta: "+salePrice()+"\n";
        return info;
    }

    @Override
    public double getTax() {
        double result = getBasePrice() * TAX_DMOVIE;
        return result;
    }

    @Override
    public double salePrice() {
        double result = getBasePrice() + getTax();
        return result;
    }

}

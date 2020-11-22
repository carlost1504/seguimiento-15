package model;
public abstract class Movie extends Product {
    private String genre;

    public Movie(int id, int basePrice, String title, boolean sale) {
        super(id,basePrice,title,sale);
        genre = "";
    }

    public Movie(int id, int basePrice, String title, boolean sale, String genre) {
        super(id,basePrice,title,sale);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String description() {
        String info = super.description()+"\nGénero: "+getGenre();
        return info;
    }
}

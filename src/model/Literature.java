package model;
public abstract class Literature extends Product {
    private int numberPages;

    public Literature(int id, int basePrice, String title, boolean sale, int numberPages) {
        super(id,basePrice,title,sale);
        this.numberPages = numberPages;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    @Override
    public String description() {
        String info = super.description()+"\nNúmero de páginas: "+getNumberPages();
        return info;
    }
}

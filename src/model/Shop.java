package model;
import java.util.*;
public class Shop {
    private String name;
    private int id;
    ArrayList<Product> invantario =new ArrayList<Product>();
    public Product[][] product=new Product[5][8];
    public int POSITION_DVD=10;
    public int POSITION_download=5;
    public Movie[][] movie=new Movie[15][15];
    public int POSITION_BOOK=5;
    public int POSITION_MAGAZINE=3;
    public int POSITION_JOURNAL=2;
    public Literature[][] literature=new Literature[10][15];

    public Shop(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
  }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<Product> getInvantario() {
        return invantario;
    }

    public void setInvantario(ArrayList<Product> invantario) {
        this.invantario = invantario;
    }
    
    
    
    
    public Product searching (int id){
        Product p1=null;
        for (int i = 0; i < invantario.size(); i++) {
            if(invantario.get(i).getId()==id){
               p1= invantario.get(i);
            }
        }
        return p1;
    }
    public void addProduct(Product productt){
        boolean exit=true;
        for (int i = 0; i < 5&&exit==true; i++) {
            for (int j = 0; j < 8&&exit==true; j++) {
                if(product[i][j]==null){
                    product[i][j]=productt;
                    product[i][j].setSale(true);
                    exit=false;
                }
            }  
        }
        for (int i = 0; i < 15&&exit==true; i++) {
            for (int j = 0; j < 15&&exit==true; j++) {
                if(movie[i][j]==productt){
                    movie[i][j]=null;
                    exit=false;
                }
            }  
        }
        for (int i = 0; i < 15&&exit==true; i++) {
            for (int j = 0; j < 10&&exit==true; j++) {
                if(literature[i][j]==productt){
                    literature[i][j]=null;
                    exit=false;
                }
            }  
        }
    }
    //add product movie DVD
    public void addProduct(int id, int basePrice, String title, boolean sale, int length) {
        boolean salir=false;
        for (int i = 0; i < 10&&salir==false; i++) {
            for (int j = 0; j < 15&&salir==false; j++) {
                if(movie[i][j]==null){
                    movie[i][j]=new DVD(id, basePrice, title, sale,length);
                    Product p=new DVD(id,basePrice, title, sale, length);
                    invantario.add(p);
                    salir=true;
                }
            }
        }
        
    }
    //add product movie downloadableMovie
    public void addProduct(int id, int basePrice, String title, boolean sale, String link) {
        boolean salir=false;
        for (int i = 10; i < 15&&salir==false; i++) {
            for (int j = 0; j < 15&&salir==false; j++) {
                if(movie[i][j]==null){
                    movie[i][j]=new DownloadableMovie(id, basePrice, title, sale, link);
                    Product p=new DownloadableMovie(id, basePrice, title, sale, link);
                    invantario.add(p);
                    salir=true;
                }
            }
        } 
    }
    //addproduct literature book
    public void addProduct(int id, int basePrice, String title,  int numberPages, int year, boolean sale) {
        boolean salir=false;
        for (int i = 0; i < 5&&salir==false; i++) {
            for (int j = 0; j < 15&&salir==false; j++) {
                if(literature[i][j]==null){
                    literature[i][j]=new Book(id, basePrice, title, numberPages, year, sale);
                    Product p=new Book(id,basePrice,title,numberPages,year,sale);
                    invantario.add(p);
                    salir=true;
                }
            }
        } 
    }
    //add product literature journal
    public void addProduct(int id, int basePrice, String title, boolean sale, int numberPages, String date) {
        boolean salir=false;
        for (int i = 8; i < 10&&salir==false; i++) {
            for (int j = 0; j < 15&&salir==false; j++) {
                if(literature[i][j]==null){
                    literature[i][j]=new Journal(id, basePrice, title, sale, numberPages, date);
                    Product p=new Journal(id, basePrice, title, sale, numberPages, date);
                    invantario.add(p);
                    salir=true;
                }
            }
        }
    }
    //add product literature magazine
    public void addProduct(int id, int basePrice, String title, boolean sale, int numberPages, int week) {
        boolean salir=false;
        for (int i = 5; i < 8&&salir==false; i++) {
            for (int j = 0; j < 15&&salir==false; j++) {
                if(literature[i][j]==null){
                    literature[i][j]=new Magazine(id, basePrice, title, sale, numberPages, week);
                    Product p=new Magazine(id,basePrice, title, sale, numberPages, week);
                    invantario.add(p);
                    salir=true;
                }
            }
        }
    }
    

    public String infoProductsPro() {
        String into="get into product in promocion ";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(product[i][j]!=null){
                    if(product[i][j] instanceof DVD){
                        DVD pl_1=(DVD)product[i][j];
                        into+= "-DVD "+pl_1.description()+"   -";
                    }
                    if(product[i][j] instanceof Book){
                        Book pl_2=(Book)product[i][j];
                        into+= "-Book "+pl_2.description()+"   -";
                    }
                    if(product[i][j] instanceof DownloadableMovie){
                        DownloadableMovie pl_3=(DownloadableMovie)product[i][j];
                        into+= "-DownloadableMovie "+pl_3.description()+"   -";
                    }
                    if(product[i][j] instanceof Journal){
                        Journal pl_4=(Journal)product[i][j];
                        into+= "-Journal "+pl_4.description()+"   -";
                    }
                    if(product[i][j] instanceof Magazine){
                        Magazine pl_4=(Magazine)product[i][j];
                        into+= "-Magazine "+pl_4.description()+"   -";
                    }
                    
                }else into+="|              |";
            } into+="\n";
        }
  
        return into;
    }
    public String infoProductsLit() {
        String into="get into product the Literature ";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if(literature[i][j]!=null){
                    if(literature[i][j] instanceof Book){
                        Book pl_2=(Book)literature[i][j];
                        into+= "-Book "+pl_2.description()+"   -";
                    }
                    if(literature[i][j] instanceof Journal){
                        Journal pl_4=(Journal)literature[i][j];
                        into+= "-Journal "+pl_4.description()+"   -";
                    }
                    if(literature[i][j] instanceof Magazine){
                        Magazine pl_4=(Magazine)literature[i][j];
                        into+= "-Magazine "+pl_4.description()+"   -";
                    }
                }else into+="|              |";
            }into+="\n";
        }
        return into;
    }
    public String infoProducts() {
        String into="get into product the movie ";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if(movie[i][j]!=null){
                    
                    if(movie[i][j] instanceof DVD){
                        DVD pl_1=(DVD)movie[i][j];
                        into+= "-DVD "+pl_1.description()+" \n";
                    }
                    if(movie[i][j] instanceof DownloadableMovie){
                        DownloadableMovie pl_3=(DownloadableMovie)movie[i][j];
                        into+= "-DownloadableMovie "+pl_3.description()+" \n";
                    }
                }else into+="|              |";
            }into+="\n";
        }
        return into;
    }
    
    public int[] quantityOfProducts(){
        int[] quantinty=new int[6];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if(movie[i][j]!=null){
                   quantinty[0]++; 
                }
            }
        }
        for (int i = 10; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(movie[i][j]!=null){
                    quantinty[1]++; 
                }
            }
        } 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                if(literature[i][j]!=null){
                    quantinty[2]++; 
                }
            }
        }
        for (int i = 8; i < 8; i++) {
            for (int j = 0; j < 15; j++) {
                if(literature[i][j]!=null){
                    quantinty[3]++; 
                }
            }
        }
        for (int i = 8; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if(literature[i][j]!=null){
                    quantinty[4]++; 
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if(product[i][j]!=null){
                    quantinty[5]++; 
                }
            }  
        }
        return quantinty;
    }
}

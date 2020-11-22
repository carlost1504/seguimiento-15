package ui;
import java.util.*;
import model.*;
public class Main {
    public static Shop shop;
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("store's name");
        String name=sc.nextLine();
        System.out.println("Store id ");
        int id=sc.nextInt();
        shop=new Shop(name, id);
        boolean salir=false;
        do {
            System.out.println("what you want to do 1. add product 2. view store information 3. number of products on each shelf");
            int num=sc.nextInt();
            switch(num){
            case 1:
                addproduct();
            break;
            case 2:
                getInf();
            break;
            case 3:
                getQuantityOfProducts();
            break;
            }
            System.out.println("exit = si or continue = no");
            String next=sc.nextLine();
            if(next.equalsIgnoreCase("si")){
               salir=true; 
            }
            next="";
        } while (salir==false);
    }
    
    public static void getQuantityOfProducts(){
        int[] quantuty=shop.quantityOfProducts();
        System.out.println("quantity Of Products in movie of DVD is ="+quantuty[0]);
        System.out.println("quantity Of Products in movie of download is ="+quantuty[1]);
        System.out.println("quantity Of Products in Literature of book is ="+quantuty[2]);
        System.out.println("quantity Of Products in Literature of magazine is ="+quantuty[3]);
        System.out.println("quantity Of Products in Literature of journal is ="+quantuty[4]);
        System.out.println("quantity Of Products in promotion is ="+quantuty[5]);
    }
    
    public static void addproduct(){
        System.out.println("what do you want to add");
        System.out.println("1. literature \n 2. movie \n 3. promotional products");
        int num=sc.nextInt();
        sc.nextLine();
        switch(num){
            case 1:
                addLiterature();
            break;
            case 2:
                addMovie();
            break;
            case 3:
                addPromocion();
            break;    
        }
    }
    public static void addLiterature(){
        System.out.println("1. book \n 2. magazine \n 3. journal");
        int num=sc.nextInt();
        switch(num){
            case 1:
                System.out.println("book id");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("base price");
                int basePrice=sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String title=sc.nextLine();
                System.out.println("number of pages");
                int numberPages=sc.nextInt();
                sc.nextLine();
                System.out.println("Release year");
                int year=sc.nextInt();
                sc.nextLine();
                boolean sale=false;
                shop.addProduct(id, basePrice, title, numberPages, year, sale);
            break;
            case 2:
                System.out.println("book id");
                int iid=sc.nextInt();
                sc.nextLine();
                System.out.println("base price");
                int baseprice=sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String tiitle=sc.nextLine();
                boolean salee=false;
                System.out.println("number of pages");
                int numberPagess=sc.nextInt();
                sc.nextLine();
                System.out.println("week");
                int week=sc.nextInt();
                sc.nextLine();
                shop.addProduct(iid, baseprice, tiitle, salee, numberPagess, week);
            break;
            case 3:
                System.out.println("book id");
                int Id=sc.nextInt();
                sc.nextLine();
                System.out.println("base price");
                int basepriice=sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String tiiitle=sc.nextLine();
                boolean saleee=false;
                System.out.println("number of pages");
                int numberPagesss=sc.nextInt();
                sc.nextLine();
                System.out.println("date");
                int date=sc.nextInt();
                sc.nextLine();
                shop.addProduct(Id, basepriice, tiiitle, saleee, numberPagesss, date);
            break;    
        }
    }
    public static void addMovie(){
        System.out.println("1. DVD \n 2. Downloadable");
        int num=sc.nextInt();
        switch(num){
            case 1://int id, int basePrice, String title, boolean sale, 
                System.out.println("movie id");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("base price");
                int basePrice=sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String title=sc.nextLine();
                boolean sale=false;
                System.out.println("weather");
                int length=sc.nextInt();
                sc.nextLine();
                shop.addProduct(id, basePrice, title, sale, length);
            break;
            case 2:
                System.out.println("book id");
                int iid=sc.nextInt();
                sc.nextLine();
                System.out.println("base price");
                int baseprice=sc.nextInt();
                sc.nextLine();
                System.out.println("name");
                String tiitle=sc.nextLine();
                boolean saale=false;
                System.out.println("link");
                String link=sc.nextLine();
                shop.addProduct(iid, baseprice, tiitle, saale, link);
            break;
               
        }
    }
    
    public static void addPromocion(){
        System.out.println("to add a product to the place of descuaneto enter your id");
        for (int i = 0; i <shop.getInvantario().size() ; i++) {
            System.out.println( "\n"+shop.getInvantario().get(i)); 
        }
        System.out.println("enter the id of the product you want to add");
        int addProdut=sc.nextInt();
        Product product =shop.searching(addProdut);
        shop.addProduct(product);
        
    }
   
    public static void getInf(){
        String into="";
        System.out.println("what information do you want \n 1. promotion \n 2. literature \n 3. movies");
        int num=sc.nextInt();
        switch(num){
            case 1:
               into=shop.infoProductsPro();
            break;
            case 2:
                into=shop.infoProductsLit();
            break;
            case 3:
                into=shop.infoProducts();
            break;    
        }
        System.out.println(into);
        into="";
        
    }
}

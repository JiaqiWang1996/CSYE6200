//package edu.neu.csye6200;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//
//public class Shopper extends Person{
//	int id;
//	int age;
//	String firstName;
//	String lastName;
//	private int                                shopperId;
//    private double                             budget;
//    private AbstractItemFactory                itemFactory = null;
//    private AbstractCartFactory                cartFactory = null;
//    private Cart                          cart = null;
//    public Shopper(int id,int age,String firstName,String lastName, int  shopperId, double budget) {
//		this.id=id;
//		this.age=age;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.shopperId=shopperId;
//		this.budget=budget;
//		
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public int getShopperId() {
//		return shopperId;
//	}
//	public void setShopperId(int shopperId) {
//		this.shopperId = shopperId;
//	}
//	public double getBudget() {
//		return budget;
//	}
//	public void setBudget(double budget) {
//		this.budget = budget;
//	}
//    
//
//	public static void demo() {
//		CartFactory Shoppercart=new CartFactory();
//		HiTechItemFactory shoppertask=new HiTechItemFactory(); 
//
//		List<Cart> Shoppercarts = new ArrayList<>();
//		List<HiTechItem> shoppertasks = new ArrayList<>();
//		
//		
//		Shoppercart shoppercart1=CartFactory.getObject(1,150,"HDTV","32 inch HD TV¡±);
//		Shoppercart shoppercart2=CartFactory.getObject(2,400,"4KTV","53 inch 4k UHD Smart TV");
//        Shoppercart shoppercart3=CartFactory.getObject(3,100,"Monitor","Computer Monitor");
//        Shoppercart shoppercart4=CartFactory.getObject(4,1500,"OLEDTV","55 inch OLED Smart TV");
//	    Shoppercarts.add(shoppercart1);
//	    Shoppercarts.add(shoppercart2);
//	    Shoppercarts.add(shoppercart3);
//	    Shoppercarts.add(shoppercart4);
//	   
//	
//	    System.out.println("\n\t" + Shopper.class.getName() + ".demo()...");
//	       
//	    Shopper obj = new Shopper("1,17,Dan,Peters,101,2000.0");
//	    System.out.println(obj);
//
//	    // add shopper cart Factory (CartFactory) to Shopper object
//	    
//	    // use Cart Factory to add shopper Cart to Shopper object
//
//	    // add shopper Item Factory  (HiTechItemFactory) to Shopper object
//	    // use shopper Item factory to add all items to Shopper Cart
//
//	    // show shopper cart
//	    
//
//	    // remove Monitor item from cart
//
//	    // show shopper cart
//
//	    // show shopper shopping results
//
//	    System.out.println("SHOPPING BUDGET: " + shoppingBudget);
//	    System.out.println("SHOPPING CART TOTAL: " + totalCartDollars);
//	    System.out.println("SHOPPING BALANCE: $" + (shoppingBudget - totalCartDollars));
//
//	    System.out.println("\n\t" + Shopper.class.getName() + ".demo()... done!");
	
	
	

//			
//}
//}
 package edu.neu.csye6200;

import java.util.Scanner;

public class Shopper extends Person {

    private int shopperId;
    private double budget;
    private AbstractItemFactory itemFactory = null;
    private AbstractCartFactory cartFactory = null;
    private Cart cart = null;

    public Shopper() {
    }

    public Shopper(String csvData) {
        try {
            Scanner input = new Scanner(csvData);
            input.useDelimiter(",");

            super.setId(input.nextInt());
            super.setAge(input.nextInt());
            super.setFirstName(input.next());
            super.setLastName(input.next());
            this.shopperId = input.nextInt();
            this.budget = input.nextDouble();
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getShopperId() {
        return shopperId;
    }

    public void setShopperId(int shopperId) {
        this.shopperId = shopperId;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public AbstractItemFactory getItemFactory() {
        return itemFactory;
    }

    public void setItemFactory(AbstractItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    public AbstractCartFactory getCartFactory() {
        return cartFactory;
    }

    public void setCartFactory(AbstractCartFactory cartFactory) {
        this.cartFactory = cartFactory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return super.toString() + ", shopperId:" + shopperId + ", budget:" + budget;
    }

    public static void demo(){

        System.out.println("\n\t" + Shopper.class.getName() + ".demo()...");

        Shopper obj = new Shopper("1,17,Dan,Peters,101,2000.0");
        System.out.println(obj);

        obj.setCartFactory(new CartFactory());
        obj.setCart(obj.getCartFactory().getObject());

        obj.setItemFactory(new HiTechItemFactory());
        obj.cart.add(obj.itemFactory.getObject("1,150,HDTV,32 inch HD TV"));
        obj.cart.add(obj.itemFactory.getObject("2,400,4KTV,53 inch 4k UHD Smart TV"));
        obj.cart.add(obj.itemFactory.getObject("3,100,Monitor,Computer Monitor"));
        obj.cart.add(obj.itemFactory.getObject("4,1500,OLEDTV,55 inch OLED Smart TV"));

        obj.cart.show();

        obj.cart.remove("Monitor");

        obj.cart.show();

        Double shoppingBudget = obj.getBudget();
        Double totalCartDollars = obj.cart.getTotalDollars();

        System.out.println("SHOPPING BUDGET: " + shoppingBudget);
        System.out.println("SHOPPING CART TOTAL: " + totalCartDollars);
        System.out.println("SHOPPING BALANCE: $" + (shoppingBudget - totalCartDollars));

        System.out.println("\n\t" + Shopper.class.getName() + ".demo()... done!");
    }
}

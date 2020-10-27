//package edu.neu.csye6200;
//
//public class MobileShopperCart extends Cart{
//
//	@Override
//	public void add(AbstractItem t) {
//		// TODO Auto-generated method stub
//		super.add(t);
//	}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		super.clear();
//	}
//
//	@Override
//	public void remove(String taskName) {
//		// TODO Auto-generated method stub
//		super.remove(taskName);
//	}
//
//	@Override
//	public void remove(AbstractItem task) {
//		// TODO Auto-generated method stub
//		super.remove(task);
//	}
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		super.show();
//	}
//	
//
//}
package edu.neu.csye6200;

import java.util.Scanner;

public class MobileShopperCart extends Cart {

    private static Cart instance = null;

    private MobileShopperCart() {
    }

    private MobileShopperCart(String csvData) {
        try {
            Scanner input = new Scanner(csvData);
            input.useDelimiter(",");
            this.setId(input.nextInt());
            this.setTotalDollars(input.nextDouble());
            this.setName(input.next());
            this.setDescription(input.next());
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Cart getObject(){
        if (instance == null){
            return new MobileShopperCart();
        }
        else
            return instance;
    }

    public static Cart getObject(String csvData){
        if (instance == null){
            return new MobileShopperCart(csvData);
        }
        else
            return instance;
    }
}


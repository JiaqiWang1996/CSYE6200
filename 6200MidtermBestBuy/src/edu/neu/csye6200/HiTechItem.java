//package edu.neu.csye6200;
//
//public class HiTechItem extends Item{
//
//	@Override
//	public int getId() {
//		// TODO Auto-generated method stub
//		return super.getId();
//	}
//
//	@Override
//	public void setId(int id) {
//		// TODO Auto-generated method stub
//		super.setId(id);
//	}
//
//	@Override
//	public double getPrice() {
//		// TODO Auto-generated method stub
//		return super.getPrice();
//	}
//
//	@Override
//	public void setPrice(double price) {
//		// TODO Auto-generated method stub
//		super.setPrice(price);
//	}
//
//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return super.getName();
//	}
//
//	@Override
//	public void setName(String name) {
//		// TODO Auto-generated method stub
//		super.setName(name);
//	}
//
//	@Override
//	public String getDescription() {
//		// TODO Auto-generated method stub
//		return super.getDescription();
//	}
//
//	@Override
//	public void setDescription(String description) {
//		// TODO Auto-generated method stub
//		super.setDescription(description);
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
//
//}
package edu.neu.csye6200;

import java.util.Scanner;

public class HiTechItem extends Item {
    private static AbstractItem instance = null;

    private HiTechItem() {
    }

    private HiTechItem(String csvData) {
        try {
            Scanner input = new Scanner(csvData);
            input.useDelimiter(",");
            this.setId(input.nextInt());
            this.setPrice(input.nextDouble());
            this.setName(input.next());
            this.setDescription(input.next());
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static AbstractItem getObject(){
        if (instance == null){
            return new HiTechItem();
        }
        else
            return instance;
    }

    public static AbstractItem getObject(String csvData){
        if (instance == null){
            return new HiTechItem(csvData);
        }
        else
            return instance;
    }
}


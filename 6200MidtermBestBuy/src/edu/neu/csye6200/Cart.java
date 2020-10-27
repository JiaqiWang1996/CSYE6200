//package edu.neu.csye6200;
//
//import java.util.List;
//
//public class Cart extends AbstractCart{
//	private List<AbstractItem> items = null;
//
//	@Override
//	public void add(AbstractItem t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void remove(String taskName) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void remove(AbstractItem task) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		
//	}
//	 
//}
package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AbstractCart {

    private List<AbstractItem> items = new ArrayList<>();

    @Override
    public void add(AbstractItem t) {
        this.items.add(t);
        Double total = this.getTotalDollars();
        total += t.getPrice();
        this.setTotalDollars(total);
    }

    @Override
    public void clear() {
        this.items.clear();
        this.setTotalDollars(0.0);
    }

    @Override
    public void remove(String taskName) {
        Double total = this.getTotalDollars();
        for (AbstractItem item : items){
            if (item.getName().equals(taskName)){
                total -= item.getPrice();
                this.setTotalDollars(total);
                items.remove(item);
                break;
            }
        }
    }

    @Override
    public void remove(AbstractItem task) {
        this.items.remove(task);
    }

    @Override
    public void show() {
        System.out.println("Total dollars: " + this.getTotalDollars());
        items.forEach(i->{
            System.out.println(i);
        });
    }
}

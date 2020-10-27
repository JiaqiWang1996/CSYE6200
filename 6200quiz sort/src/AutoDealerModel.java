import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AutoDealerModel extends AbstractVehicleModel {
		
		List<AbstractVehicle> vehicles = new ArrayList<AbstractVehicle>();

	    @Override
	    public void add( AbstractVehicle   e) {
	        this.vehicles.add(e);
	    }

	    @Override
	    public void sort(Comparator< AbstractVehicle > comparator) {
	        this.vehicles.sort(comparator);
	       
	    }
	   
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	       
	        System.out.println("\n\t" + this.vehicles.size() + " vehicles in dealer.");
	        for ( AbstractVehicle   v : vehicles) {
	            sb.append(v.toString()).append("\n");
	        }
	        return sb.toString();
	    }
	    public static void demo() {
	        AutoDealerModel obj = new AutoDealerModel();
	       
	        obj.add(new BMW(1, 4399.0, "Silver BMW sedan"));
	        obj.add(new BMW(2, 4799.0, "Black BMW convertable"));
	        obj.add(new BMW(3, 4499.0, "Red BMW coupe"));
	        obj.add(new Audi(4,120000.0,"RS7"));
	        obj.add(new Audi(5,100000.0,"RS6"));
	        obj.add(new Audi(6,80000.0,"RS4"));
	        obj.add(new MIniCooper(7,25000.0,"Begger Edition"));
	        obj.add(new MIniCooper(8,45000.0,"Clubman"));
	        obj.add(new MIniCooper(9,60000.0,"MInicooperS"));
	       
	        obj.showAllVehicles();
	       
	        System.out.println("SORT by ID...");
	       
	        obj.sort(new Comparator<AbstractVehicle>() {
	            @Override
	            public int compare( AbstractVehicle o1, AbstractVehicle o2) {
	                return Integer.compare(o1.getVehicleId(), o2.getVehicleId());
	            }
	        });
	      
	        obj.showAllVehicles();
	       
	        System.out.println("SORT by MOST EXPENSIVE PRICE...");
	        obj.sort(Comparator.comparing(  AbstractVehicle  ::  getVehiclePrice ).reversed() );
	        obj.showAllVehicles();
	       
	        System.out.println("SORT by NAME...");
	        obj.sort(Comparator.comparing(  AbstractVehicle  ::  getVehicleName  ) );
	        obj.showAllVehicles();
	       
	    }

	    public void showAllVehicles() {
	        System.out.println( this );  // PLEASE NOTE: FILL IN BLANK WITH CODE ENDING IN LETTER 's'
	    }

	}



	

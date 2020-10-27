
import java.util.Comparator;

/**
 * AbstractVehicleModel
 * 
 * API used by all derived dealer models.
 * 
 * Derive AutoDealerModel from this class.
 * 
 * @author dpeters
 *
 */
public abstract class AbstractVehicleModel {
	/**
	 * add one vehicle to the model
	 * @param e
	 */
	public abstract void add(AbstractVehicle e);
	
	/**
	 * sort vehicles in the model
	 * @param e			Comparator for sort order
	 */
	public abstract void sort(Comparator<AbstractVehicle> c);

}
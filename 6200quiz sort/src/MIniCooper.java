
public class MIniCooper extends AbstractVehicle{
	MIniCooper MIniCooper;
	private int VehicleId;
	private double VehiclePrice;
	private String VehicleName;
	public MIniCooper(int VehicleId, double VehiclePrice, String VehicleName) {
		super(VehicleId, VehiclePrice, VehicleName);
		this.VehicleId = VehicleId;
		this.VehiclePrice =VehiclePrice;
		this.VehicleName = VehicleName;
	}
	public int getVehicleId() {
		return VehicleId;
	}
	public void setVehicleId(int vehicleId) {
		VehicleId = vehicleId;
	}
	public double getVehiclePrice() {
		return VehiclePrice;
	}
	public void setVehiclePrice(double vehiclePrice) {
		VehiclePrice = vehiclePrice;
	}
	public String getVehicleName() {
		return VehicleName;
	}
	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}
	
}

	/**
	 * API used by all derived vehicles.
	 * @author dpeters
	 *
	 */
	public abstract class AbstractVehicle {
//		/**
//		 * get the vehicle ID
//		 * @return		Vehicle ID
//		 */
//		public abstract int getVehicleId();
//
//		/**
//		 * get the vehicle Price
//		 * @return		Vehicle Price
//		 */
//		public abstract double getVehiclePrice();
//
//		/**
//		 * get the vehicle Name
//		 * @return		Vehicle Name
//		 */
//		public abstract String getVehicleName();
		private int VehicleId;
		private double VehiclePrice;
		private String VehicleName;
		public AbstractVehicle() {}
		public AbstractVehicle(int VehicleId, double VehiclePrice, String VehicleName) {
			
			this.VehicleId = VehicleId;
			this.VehiclePrice =VehiclePrice;
			this.VehicleName = VehicleName;
	}
		public String toString() {
			return "AbstractVehicle [VehicleId" + VehicleId + ", VehiclePrice=" + VehiclePrice + ", VehicleName=" + VehicleName + "]";
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


class Vehicle{
	private String licensePlate;
	private String ownername;
	private int hoursParked;
	
	Vehicle(String licensePlate,String ownername,int hoursParked){
		this.licensePlate=licensePlate;
		this.ownername=ownername;
		this.hoursParked=hoursParked;
	}
	
	public String getlicensePlate(){
		return licensePlate;
	}
	public String getownerName(){
		return ownername;
	}
	public int gethoursParked(){
		return hoursParked;
	}
	
	public void setlicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	public void setownername(String ownername){
		this.ownername=ownername;
	}
	public void sethoursParked(int hoursParked){
		this.hoursParked=hoursParked;
	}
}

class ParkingLot{
    Vehicle[] vehicles=new Vehicle[5];
    int vehicleCount=0;
    public void addVehicle(Vehicle vehicle){
        if(vehicleCount<vehicles.length){
            vehicles[vehicleCount]=vehicle;
            vehicleCount++;
        }else{
            System.out.println("Parking lot is full");
        }
    }
    public void removeVehicle(String licensePlate){
        for(int i=0;i<vehicleCount;i++){
            if(vehicles[i].getlicensePlate().equals(licensePlate)){
                vehicles[i]=vehicles[vehicleCount-1];
                vehicles[vehicleCount-1]=null;
                vehicleCount--;
                return;
            }
        }
        System.out.println("Vehicle not found");
    }
    public void displayVehicles(){
        for(int i=0;i<vehicleCount;i++){
            System.out.println("License Plate: "+vehicles[i].getlicensePlate());
            System.out.println("Owner Name: "+vehicles[i].getownerName());
            System.out.println("Hours Parked: "+vehicles[i].gethoursParked());
            System.out.println();
        }
    }
}
class VehicleDemo{
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot();
        Vehicle vehicle1=new Vehicle("ABC123", "John Doe", 2);
        Vehicle vehicle2=new Vehicle("XYZ456", "Jane Smith", 4);
        Vehicle vehicle3=new Vehicle("LMN789", "Bob Brown", 1);
        
        parkingLot.addVehicle(vehicle1);
        parkingLot.addVehicle(vehicle2);
        parkingLot.addVehicle(vehicle3);
        parkingLot.removeVehicle("XYZ456");
        parkingLot.displayVehicles();
    }
}
package dataguise1;

public class Commission extends Employee{
	private int weeklySales;
	
	Commission(){
		
	}
	
	Commission(int sale){
		weeklySales = sale;
	}
	
	//set weekly sales.
	void setWeeklySales(int sale) {
		weeklySales = sale;
	}
	//get weekly sales.
	int getWeeklySale() {
		return weeklySales;
	}
	//get Commission amount.
	double getCommissonAmount() {
		//commission amount = 15% of weekly sales.
		double commission_percent = 15;
		return (commission_percent/100)*weeklySales;
	}
}

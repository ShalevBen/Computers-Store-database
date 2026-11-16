package computers_store_project;

public class Customer 
{
	private String name;
	private int id;
	private double amount_paid;
	private boolean is_vip;

public Customer()
{
	 name ="";
	 id =0;
	 amount_paid = 0.0;
	 is_vip = false;

	
}


public Customer(Customer given_customer)
{
	name = given_customer.name;
	 id =given_customer.id;
	 amount_paid = given_customer.amount_paid;
	 is_vip = given_customer.is_vip;
}



//constructor with params
public Customer(String given_name,int given_id,double given_payment,boolean given_vip)
{
	name = given_name;
	id = given_id;
	amount_paid = given_payment;
	is_vip = given_vip;

}

//will get the name
public String getName()
{
	return name;
}

//will get the id
public int getId()
{
return id;	
}

//setter and getter for the amount_paid
public void setAmount_paid(double given_pay)
{
		amount_paid = given_pay;
}
public double getAmount_paid()
{
	return amount_paid;	
}

//setter and getter for is_vip
public void setIs_vip(boolean given_status)
{
	is_vip = given_status;
}

public boolean getIs_vip()
{
	return is_vip;	
}

public String toString()
{
	String ans;
	ans = "name: " + name +"\n" + "Id: " + id +"\n" +"amount_paid: " +amount_paid + "\n"+ "is vip? : " +is_vip +"\n";
	return ans;
}

/**
 * Applies a 30% discount to the customer's total paid amount if they hold VIP status.
 * If the customer is not a VIP, prints a notification and leaves the amount unchanged.
 */
public void ApplyDisc()
{
	double percentage = 30;
	double amount_discounted = (percentage/100)*amount_paid;
	
	if(is_vip == true)
	{
		setAmount_paid(amount_paid-amount_discounted);
	}
	else
	System.out.println("Discount wasn't given to: \n" + id +"\n");
}


}


package computers_store_project;

public class Employee 
{

	private String name;
	private int id;
	private double salary;
	private LinkedQueue customer_line;
	//a queue implemented as a linked list of customers he gave service to.
	
public Employee()
{
	name= null;
	id = 0;
	salary = 0;
	customer_line = new LinkedQueue();
	customer_line = null;
}


public Employee(String given_name,int given_id,double given_salary,Customer given_customer)
{
		
		name = given_name;
		id = given_id;
		salary = given_salary;
		customer_line = new LinkedQueue();
		customer_line.Enqueue(given_customer);
}
 /*
  * a constructor that will build a basic employee */
public Employee(int given_id,String given_name)
{
		
		name = given_name;
		id = given_id;
		salary = 0;
		customer_line = new LinkedQueue();
}

public Employee (Employee given_employee)
{
	name = given_employee.get_name();
	id = given_employee.get_id();
	salary = given_employee.get_salary();
	customer_line = given_employee.getLine();

}
	
// name and id getters. setters not needed.
public String get_name()
{
		
		return name;
}


public int get_id() 
{
		return id;		
}
	
//other stuff
public double get_salary()

{
		return salary;	
}

public void set_salary(double given_salary)
{
		
		salary = given_salary;
}

public LinkedQueue getLine()
{
	return customer_line;
}
	
public String toString()
{
	String ans = "";
	 ans = "name: " + name + "\n" +"Id: " + id +"\n" +"salary: " + salary + "\n" +
		   "\n" + "the queue of customers for the employee is:" + "\n" + customer_line.printLinkedQueue() + "\n";
	return ans;
}

/**
 * Checks if the employee is currently serving customers (queue is not empty).
 *
 * @return True if there are customers waiting; false if queue is empty.
 */
public boolean Is_customers_getting_served()
{
	return !(customer_line.isQueueEmpty());
}

/**
 * Checks if a specific customer is currently in this employee's queue.
 *
 * @param given_id The ID of the customer to search for.
 * @return True if customer is in line; false otherwise.
 */
public boolean Is_customer_in_line(int given_id)
{
	if(customer_line.isQueueEmpty())
	{
		return false;
	}
	
	Link node = customer_line.getList().getNode();
	
	Customer temp = null;
	
	while(node != null)
	{
		temp = (Customer) node.getData();
		if(temp.getId() == given_id)
		{
			return true;
		}
		node = node.getNext();
	}
	return false;
	
	
}
	
/**
 * Adds a customer to the end of the employee's service queue if they are not already in it.
 *
 * @param given_customer The Customer to add.
 */
public void enqueue_line(Customer given_customer)
{
	if(Is_customer_in_line(given_customer.getId()))
	{
		return;
	}
//inserting the customer to the queue
	customer_line.Enqueue(given_customer);
}


/**
 * Searches for a customer in the queue by ID without removing them.
 * Cycles through the queue and restores original FIFO order.
 *
 * @param given_id The ID of the customer to find.
 * @return The Customer object if found; null otherwise.
 */
public Customer search_customer(int given_id)
{
	LinkedQueue temp_q = new LinkedQueue();
	Customer temp_c = null;
	Customer temp_c1 = null;
	int counter = 0;
	
	/* 
	 * after you find the customer you need
	 * you need to dequeue the whole queue and requeue it back
	 * to save the order of the queue
	 * */
	while(!(customer_line.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = customer_line.Dequeue();
		if(temp_c.getId() == given_id)
		{
			temp_c1 = temp_c;
			//you found him and you are making sure he is getting sent to the temp queue
			counter++;
			temp_q.Enqueue(temp_c);
		}
		else 
		{
			counter++;
			temp_q.Enqueue(temp_c);
		}	
	}
	
	/*
	 * gets the queue back in order.
	 * */
		for(int i = 0; i< counter ;i++)
		{
			customer_line.Enqueue(temp_q.Dequeue());
		}
		return temp_c1;
}

/**
 * Removes and returns a specific customer from the queue by ID while
 * maintaining the relative order of all other customers.
 *
 * @param given_id The ID of the customer to remove.
 * @return The removed Customer instance, or null if not found.
 * @throws Exception If the queue is empty.
 */
public Customer dequeue_line(int given_id) throws Exception
{
	
// make sure the queue isn't empty when you try to dequeue a customer
	if(customer_line.isQueueEmpty())
	{
		throw new Exception("The queue is empty! can't dequeue a customer!" + "\n");
	}
	
	
	// making sure first the customer is in the queue
	if(!(Is_customer_in_line(given_id)))
	{
		System.out.println("the customer is not in the queue");
		return null;
	}
	
	LinkedQueue temp_q = new LinkedQueue();
	Customer temp_c = null;
	Customer temp_c_2 = null;
	int counter = 0;
	
	/* 
	 * after you find the customer you need
	 * you need to dequeue the whole queue and requeue it back
	 * to save the order of the queue
	 * */
	while(!(customer_line.isQueueEmpty()))
	{
		//holds the first person in the OG q
		temp_c = customer_line.Dequeue();
		if(temp_c.getId() == given_id)
		{
			temp_c_2 = temp_c;
		}
		else 
		{
			counter++;
			temp_q.Enqueue(temp_c);
		}	
	}
	
	// requeuing the OG queue in order
	for(int i = 0; i< counter ;i++)
	{
		customer_line.Enqueue(temp_q.Dequeue());
	}
	return temp_c_2;
}
	
/**
 * Prints all customers currently waiting in the employee's line to the console.
 */
public void PrintLine()
{
	System.out.println(customer_line.printLinkedQueue());
}

}
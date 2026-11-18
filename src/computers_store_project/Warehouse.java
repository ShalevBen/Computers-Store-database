package computers_store_project;

public class Warehouse 
{
	private Employee[] warehouse_employees;
	private Supplier[] warehouse_suppliers;
	private MyLinkedStack item_stack; // stack of products

	public Warehouse()
	{
		warehouse_employees = new Employee[10];
		warehouse_suppliers = new Supplier[10];
		item_stack = new MyLinkedStack();
	}

	public 	Warehouse( Product given_product,Employee given_employee,Supplier given_supplier)
	{
	/* creating a warehouse with default amount of suppliers and employees*/
		warehouse_employees = new Employee[10];
		warehouse_suppliers = new Supplier[10];

	/*initializing the warehouse so it won't be empty ever.
	 an empty warehouse at the start doesn't make sense. */
		warehouse_employees[0] = given_employee;
		warehouse_suppliers[0] = given_supplier;
		item_stack = new MyLinkedStack(given_product);
	}
	
	public 	Warehouse( Employee given_employee,Supplier given_supplier)
	{
		/* creating a warehouse with default amount of suppliers and employees*/
		warehouse_employees = new Employee[10];
		warehouse_suppliers = new Supplier[10];

		/*initializing the warehouse so it won't be empty ever.
	 an empty warehouse at the start doesn't make sense. */
		warehouse_employees[0] = given_employee;
		warehouse_suppliers[0] = given_supplier;
		item_stack = new MyLinkedStack();
	}

	public MyLinkedStack get_Stack()
	{
		return item_stack;
	}

	public String toString()
	{
		return "the number of Employees that can work in the warehouse is: \n" 
				+warehouse_employees.length +"\n" 
				+ "the Employees are: " + "\n" 
				+ Show_employees() + "\n"
				+"the number of suppliers that can work in the warehouse is: \n"
				+warehouse_suppliers.length +"\n"
				+ "the suppliers are: " + "\n"
				+ Show_suppliers() + "\n"
				+ "the items in the warehouse are: \n"
				+ item_stack.toString() + "\n";
	}

	/**
	 * Counts the number of non-null elements currently stored in an array.
	 *
	 * @param given_array Array of objects to inspect.
	 * @return The count of occupied slots.
	 */
	public int CountArraySlots(Object[] given_array)
	{
		int count = 0;
		if(given_array[0] == null)
			return count;


		for(int i = 0;i < given_array.length; i++)
		{

			if(given_array[i] != null)
				count++;
		}

		return count;
	}
 
	/**
	 * Creates a new Employee with the provided name and ID, and adds them to the 
	 * first empty slot in the employee array if not already present.
	 *
	 * @param given_name Name of the new employee.
	 * @param given_id   Unique ID of the new employee.
	 */
	public void Add_New_employee(String given_name , int given_id)
	{
		Employee given_employee = new Employee(given_id,given_name); // create an employee
		// notice this employee has no salary and his list is empty.

		if(warehouse_employees[0] == null)
		{
			warehouse_employees[0] = given_employee;
			System.out.println("added: \n" + given_name + "\n" + given_id + "\n" + "to the Warehouse \n");
			return;
		}

		if(Is_employee_in_array(given_employee.get_id()))
		{
			System.out.println("the employee already in the array!" + "\n");
			return;
		}

		// goes over the whole array and looks for an empty slot to insert.
		for(int i = 0; i <warehouse_employees.length ; i++)
		{
			if(warehouse_employees[i] == null)
			{
				warehouse_employees[i] = given_employee;
				System.out.println("added: \n" + given_name + "\n" + given_id + "\n" + "to the Warehouse \n");
				return;
			}
		}

		System.out.println("the array is full and can't add this employee!" + "\n");
		return;
	}

	/**
	 * Adds an existing Employee object to the first available slot in the warehouse 
	 * employee array.
	 *
	 * @param given_employee The Employee instance to add.
	 * @throws RuntimeException If the employee array is full.
	 */
	public void Add_employee(Employee given_employee)
	{

		if(warehouse_employees[0] == null)
		{
			warehouse_employees[0] = given_employee;
			return;
		}

		if(Is_employee_in_array(given_employee.get_id()))
		{
			System.out.println("the employee already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < warehouse_employees.length; i++)
		{
			if(warehouse_employees[i] == null)
			{
				warehouse_employees[i] = given_employee;
				return;
			}
		}

		throw new RuntimeException("the array is full and can't add this employee!" + "\n");

	}
	
	/**
	 * Searches for an employee in the employee array by their unique ID.
	 *
	 * @param given_id The ID of the employee to look up.
	 * @return The Employee object if found; null otherwise.
	 */
	public Employee Search_employee(int given_id) 
	{
		for(int i = 0; i< CountArraySlots(warehouse_employees); i++)
		{
			if(warehouse_employees[i].get_id() == given_id)
			{
				return warehouse_employees[i];
			}
		}

		return null; // we didn't find the employee


	}
	
	/**
	 * Checks whether a specific employee exists in the warehouse employee array by matching ID.
	 *
	 * @param given_employee The employee to search for.
	 * @return true if the employee is found; false otherwise.
	 */
	public boolean Is_employee_in_array(int given_id)
	{
		if(warehouse_employees[0] == null)
		{
			return false;
		}

		for(int i = 0; i < warehouse_employees.length; i++)
		{
			if(warehouse_employees[i] != null)
			{
				if(warehouse_employees[i].get_id() == given_id)
				{
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Removes an employee matching the given name and ID, shifting all subsequent
	 * elements to the left to maintain continuous array order without gaps.
	 *
	 * @param given_name Name of the employee to remove.
	 * @param given_id   ID of the employee to remove.
	 */
	public void Remove_employee(String given_name , int given_id)
	{

		int index = 0;
		Employee temp = new Employee(given_id,given_name);

		if(!Is_employee_in_array(temp.get_id()))
		{
			System.out.println("The requested employee is not in the warehouse ! \n");
			return;
		}

		if(CountArraySlots(warehouse_employees)== 0)
		{
			System.out.println("Can't remove the requested Employee the array is empty! \n");
			return;	
		}

		// we can use this way,find the  index of the correct object,
		//then after that make a shift for all the other 
		//or go with the approach below which does the finding the right object and sorting the array both in the same loop
		for(int i = 0; i < warehouse_employees.length ; i++)
		{

			if(warehouse_employees[i] != null) 
			{

				if(warehouse_employees[i].get_id() == given_id && warehouse_employees[i].get_name().equals(given_name))
				{
					warehouse_employees[i] = null;
					index =i;
					break;
				}
			}
		}

		for(int i = index; i < warehouse_employees.length-1; i++)
		{
			if(warehouse_employees[i] == null && warehouse_employees[i+1] != null)
			{
				warehouse_employees[i] = warehouse_employees[i+1];
				warehouse_employees[i+1] = null;
			}
		}
		if(Is_employee_in_array(temp.get_id()))
		{
			System.out.println("The requested Employee: \n" + given_id + "\n" + given_name
			+"\n" +"was not removed from the warehouse! \n");
			return;
		}
		System.out.println("The requested Employee: \n" + given_id + "\n" + given_name
				+"\n" +"was removed from the warehouse! \n");
		return;
	}

	/**
	 * Generates a string listing all registered employees in the warehouse.
	 *
	 * @return A string containing all employee details, or a message if empty.
	 */
	public String Show_employees()
		{

			if(warehouse_employees[0] == null)
			{
				return "No employees in the warehouse still!" + "\n";
			}
			String ans = "";

			for(int i = 0; i <CountArraySlots(warehouse_employees) ; i++)
			{

				if(warehouse_employees[i] != null)
				{
					ans += warehouse_employees[i].toString();
				} 
				else
				{

					ans += "null";
				}

			}
			return ans;
		}
	
	/**
	 * Creates and adds a new Supplier (without an initial product) into the first available 
	 * slot in the suppliers array.
	 *
	 * @param given_name    Name of the supplier.
	 * @param given_phone   Phone number of the supplier.
	 * @param given_company Company name of the supplier.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_New_supplier(String given_name,String given_phone,String given_company)
	{
		Supplier given_supplier = new Supplier(given_name,given_phone,given_company); // create an employee
		// notice this employee has no salary and his list is empty.

		if(warehouse_suppliers[0] == null)
		{
			warehouse_suppliers[0] = given_supplier;
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < warehouse_suppliers.length; i++)
		{
			if(warehouse_suppliers[i] == null)
			{
				warehouse_suppliers[i] = given_supplier;
				return;
			}
		}

		throw new RuntimeException("the array is full and can't add this supplier!" + "\n");

	}

	/**
	 * Creates and adds a new Supplier (without an initial product) into the first available 
	 * slot in the suppliers array.
	 *
	 * @param given_name    Name of the supplier.
	 * @param given_phone   Phone number of the supplier.
	 * @param given_company Company name of the supplier.
	 * @param given_Product the product that the supplier supplies.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_New_supplier(String given_name,String given_phone,String given_company,Product given_Product)
	{
		Supplier given_supplier = new Supplier(given_name,given_phone,given_company,given_Product); // create an employee
		// notice this employee has no salary and his list is empty.

		if(warehouse_suppliers[0] == null)
		{
			warehouse_suppliers[0] = given_supplier;
			System.out.println("Added: \n" + given_name + "\n" + given_phone + "\n" + given_company + "\n" + given_Product.toString()+"\n" + "to the warehouse! \n");
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < warehouse_suppliers.length; i++)
		{
			if(warehouse_suppliers[i] == null)
			{
				warehouse_suppliers[i] = given_supplier;
				System.out.println("Added: \n" + given_name + "\n" + given_phone + "\n" + given_company + "\n" + given_Product.toString()+"\n" + "to the warehouse! \n");
				return;
			}
		}

		throw new RuntimeException("the array is full and can't add this supplier!" + "\n");


	}

	/**
	 * Adds an existing Supplier object into the warehouse suppliers array if not already present.
	 *
	 * @param given_supplier The Supplier instance to add.
	 * @throws RuntimeException If the suppliers array is full.
	 */
	public void Add_supplier(Supplier given_supplier)
	{


		if(warehouse_suppliers[0] == null)
		{
			warehouse_suppliers[0] = given_supplier;
			return;
		}

		if(Is_supplier_in_array(given_supplier.getPhone()))
		{
			System.out.println("the supplier already in the array!" + "\n");
			return;
		}

		for(int i = 0; i < warehouse_suppliers.length; i++)
		{
			if(warehouse_suppliers[i] == null)
			{
				warehouse_suppliers[i] = given_supplier;
				return;
			}
		}

		throw new RuntimeException("the array is full and can't add this supplier!" + "\n");

	}

	/**
	 * Checks whether a supplier exists in the warehouse supplier array by matching their phone number.
	 *
	 * @param given_phone Unique phone number of the supplier.
	 * @return true if the supplier is present; false otherwise.
	 */
	public boolean Is_supplier_in_array(String given_phone)
	{
		if(warehouse_suppliers[0] == null)
		{
			System.out.println("The array is empty so no employee is in it! \n");
			return false;
		}

		for(int i = 0; i < CountArraySlots(warehouse_suppliers); i++)
		{
			if(warehouse_suppliers[i] != null) 
			{
				if(warehouse_suppliers[i].getPhone().equals(given_phone))
				{
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Removes a supplier by their phone number and shifts subsequent array elements 
	 * left to prevent null gaps.
	 *
	 * @param given_phone Phone number of the supplier to remove.
	 */
	public void Remove_supplier(String given_phone)
	{
		int index =0;
		if(!Is_supplier_in_array(given_phone))
		{
			System.out.println("The supplier is not in the array! can't remove him ! \n");
			return;

		}

		if(warehouse_suppliers[0] == null)
		{
			System.out.println("Can't remove the requested Supplier the array is empty! \n");
			return;	
		}

		// will remove the employee and sort the array back in order.
		for(int i = 0; i < warehouse_suppliers.length ; i++)
		{

			if(warehouse_suppliers[i] != null) 
			{

				if(warehouse_suppliers[i].getPhone().equals(given_phone))
				{
					warehouse_suppliers[i] = null;
					index = i;
					break;
				}
			}
		}

		for(int i = index; i< warehouse_suppliers.length-1; i++)
			if(warehouse_suppliers[i] == null && warehouse_suppliers[i+1] != null)
			{
				warehouse_suppliers[i] = warehouse_suppliers[i+1];
				warehouse_suppliers[i+1] = null;
			}
		
		
		if(Is_supplier_in_array(given_phone))
		{
			System.out.println("The requested Supplier: \n" + given_phone + "\n"
					+"\n" +"was not removed from the warehouse! \n");
					return;
				}
				System.out.println("The requested Supplier: \n" + given_phone 
						+"\n" +"was removed from the warehouse! \n");
				return;
		}

	/**
	 * Generates a string listing all registered suppliers in the warehouse.
	 *
	 * @return A string containing all supplier details, or a message if empty.
	 */
	public String Show_suppliers()
	{
		if(warehouse_suppliers[0] == null)
		{
			return "No suppliers in the warehouse still!" + "\n";
		}

		String ans = "";

		for(int i = 0; i < CountArraySlots(warehouse_suppliers); i++)
		{
			if(warehouse_suppliers[i] != null) 
			{
				ans += warehouse_suppliers[i].toString();
			}
			else
			{

				ans += "null";
			}
		}
		return ans;
	}

	/**
	 * Transfers a product from a specific supplier's inventory into the warehouse.
	 * Removes the product from the supplier's list and pushes it onto the warehouse stack.
	 *
	 * @param given_phone   The phone number identifying the supplier.
	 * @param given_item_id The product ID to receive from the supplier.
	 * @throws Exception If the item is not found or cannot be supplied.
	 */
	public void Add_to_warehouse_from_supplier(String given_phone,int given_item_id) throws Exception
	{

		if(warehouse_suppliers[0] == null)
		{
			System.out.println("The suppliers array is empty! \n");
			return;
		}

		if(!(Is_supplier_in_array(given_phone)))
		{
			System.out.println("The requested supplier is not in the supplier array! \n");
			return;
		}
		ProductLink temp = new ProductLink();

		for(int i = 0; i < warehouse_suppliers.length; i++)
		{
			if(warehouse_suppliers[i] == null)
			{
				continue;
			}

			if(warehouse_suppliers[i].getPhone().equals(given_phone))
			{
				if(warehouse_suppliers[i].Is_Product_in_the_list(given_item_id))
				{
					//this is the BOX not the PRODUCT
					if(!(Is_product_in_warehouse(given_item_id))) {
						temp = warehouse_suppliers[i].removeProduct(given_item_id);
						if(temp != null)
						{
							item_stack.push(temp.getProduct());
							System.out.println(temp + "\n" + "was added to the stack.");
							return;
						}
					}
					else
					{
						System.out.println("The item is already in the warehouse !\n");
						return;
					}


				}

			}

		}

		throw new Exception("The requested item from the specific supplier \n" + "can not be found! \n");



	}

	/**
	 * Checks whether a product with the specified ID currently exists in the warehouse stack.
	 *
	 * @param given_id The product ID to search for.
	 * @return true if the product exists in the warehouse; false otherwise.
	 */
	public boolean Is_product_in_warehouse(int given_id) 
	{
		if(item_stack.isStackEmpty())
		{
			return false;
		}

		Link p = item_stack.getNode();
		Product p1 = null;
		while(p != null)
		{
			p1 = (Product) p.getData();
			if(p1.getId() == given_id)
			{
				return true;
			}
			else 
			{
				p = p.getNext();

			}
		}
		return false;
	}

	/**
	 * Traverses the warehouse product stack to find and return the product with the given ID
	 * without removing it.
	 *
	 * @param given_id ID of the product to find.
	 * @return The matching Product instance.
	 * @throws Exception If the product ID is not present in the warehouse.
	 */
	public Product search_product(int given_id)
	{
		if(!(Is_product_in_warehouse(given_id)))
		{
			//returns null as an indicator that the item is not in the warehouse.
			return null;
		}

		Link temp = item_stack.getNode();
		Product temp1 = (Product)item_stack.getNode().getData();
		while(temp != null)
		{
			temp1 = (Product)temp.getData();
			if (temp1.getId() == given_id)
			{
				return temp1;
			}
			else 
			{
				temp = temp.getNext();
			}
		}
		//if we iterated over the whole stack and for some reason we didnt find
		// the iteam that was looked for, we will return null which would indicate , we didnt find the item.
		return null;
	}

	/**
	 * Searches for and removes a product by ID from the warehouse stack using a temporary stack 
	 * to preserve the original order of the remaining items.
	 *
	 * @param given_id ID of the product to remove.
	 * @return The removed Product object, or null if not found.
	 * @throws NullPointerException If the warehouse stack is empty.
	 */
	public Product remove_product_from_warehouse(int given_id) 
	{
		if(item_stack.isStackEmpty())
		{
			throw new NullPointerException("can't remove because the warehouse is empty!" +"\n");
		}

		MyLinkedStack temp_stack = new MyLinkedStack();
		Product temp_p = null;


		//if the stack is not empty we pop an item to check
		//if the item is matching with the id, then we go and return all the items
		// that we popped out back into the og stack.
		while(!item_stack.isStackEmpty())
		{
			temp_p = item_stack.pop();

			if(temp_p.getId() == given_id)
			{
				while(!temp_stack.isStackEmpty())
				{
					item_stack.push(temp_stack.pop());

				}
				return temp_p;
			}
			temp_stack.push(temp_p);
		}

		//if we don't find the requested item we return the stack to place.
		temp_p = temp_stack.pop();
		while(temp_p != null)
		{
			item_stack.push(temp_p);
			temp_p = temp_stack.pop();
		}



		System.out.println("We didn't find the requested product! \n");
		return temp_p;
	}



	

}

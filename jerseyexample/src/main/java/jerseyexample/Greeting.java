package jerseyexample;

/**
 *  Class representing a JSON-convertible greeting.
 *
 */
public class Greeting
{
	/** The greeting text. */
	protected String greeting;
	
	/** The greeting ID. */
	protected int id;
	
	/**
	 *  Empty bean constructor.
	 */
	public Greeting()
	{
		greeting = null;
		id = -1;
	}
	
	/**
	 *  Creates a ready-to-use greeting.
	 *  
	 *  @param greeting The greeting text.
	 *  @param id The greeting ID.
	 */
	public Greeting(String greeting, int id)
	{
		this.greeting = greeting;
		this.id = id;
	}

	/**
	 *  Gets the greeting text.
	 *
	 *  @return The greeting text.
	 */
	public String getGreeting()
	{
		return greeting;
	}

	/**
	 *  Sets the greeting text.
	 *  
	 *  @param greeting The greeting text.
	 */
	public void setGreeting(String greeting)
	{
		this.greeting = greeting;
	}

	/**
	 *  Gets the ID.
	 *
	 *  @return The ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 *  Sets the ID.
	 *  
	 *  @param id The ID to set.
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	
}

package jerseyexample;

/**
 *  Class representing a JSON-convertible greeting.
 *
 */
public class Post
{
	/** The greeting text. */
	protected String post;
	
	/** The greeting ID. */
	protected int id;
	
	/**
	 *  Empty bean constructor.
	 */
	public Post()
	{
		post = null;
		id = -1;
	}
	
	/**
	 *  Creates a ready-to-use greeting.
	 *  
	 *  @param post The greeting text.
	 *  @param id The greeting ID.
	 */
	public Post(String post, int id)
	{
		this.post = post;
		this.id = id;
	}

	/**
	 *  Gets the greeting text.
	 *
	 *  @return The greeting text.
	 */
	public String getPost()
	{
		return post;
	}

	/**
	 *  Sets the greeting text.
	 *  
	 *  @param greeting The greeting text.
	 */
	public void setPost(String post)
	{
		this.post = post;
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

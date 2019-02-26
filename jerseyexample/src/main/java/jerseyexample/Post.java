package jerseyexample;

/**
 *  Class representing a JSON-convertible Post.
 *
 */
public class Post
{
	/** The Post text. */
	protected String post;
	
	/** The Post ID. */
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
	 *  Creates a ready-to-use Post.
	 *  
	 *  @param post The Post text.
	 *  @param id The Post ID.
	 */
	public Post(String post, int id)
	{
		this.post = post;
		this.id = id;
	}

	/**
	 *  Gets the Post text.
	 *
	 *  @return The Post text.
	 */
	public String getPost()
	{
		return post;
	}

	/**
	 *  Sets the Post text.
	 *  
	 *  @param Post The Post text.
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

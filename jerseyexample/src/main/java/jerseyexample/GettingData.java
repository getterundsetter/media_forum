package jerseyexample;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;


@Singleton
@Path("feed")
public class GettingData {
	

	protected List<Post> posts = Collections.synchronizedList(new ArrayList<Post>());


	@GET
	@Produces(MediaType.TEXT_HTML )
	public String message()
	{
		//InputStream is = jerseytest.class.getClassLoader().getResourceAsStream("/jerseyexample/test.html");
		// public static String read(InputStream input) throws IOException {
		//        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
		//            return buffer.lines().collect(Collectors.joining("\n"));
		//        }
		//    }
		
		
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h3>TEST</h3>\r\n" + 
				"\r\n" + 
				"JSON-Objekt<br>\r\n" + 
				"<textarea id=\"myTextarea\">\r\n" + 
				"schreibe hier was rein....</textarea>\r\n" + 
				"\r\n" + 
				"<button type=\"button\" onclick=\"myFunction()\">Try it</button>\r\n" + 
				"\r\n" + 
				"<p id=\"demo\"></p>\r\n" + 
				"\r\n" + 
				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js\"></script>\r\n" + 
				"<script>\r\n" + 
				"function myFunction() {\r\n" + 
				"  var contentvar = document.getElementById(\"myTextarea\").value;\r\n" + 
				"//  var myObj = { content: contentvar};\r\n" + 
				"//  var myJSON = JSON.stringify(myObj);\r\n" + 
				"//  document.getElementById(\"demo\").innerHTML = myJSON;\r\n" + 
				"\r\n" + 
				"  axios.post('/jerseyexample/message', {\r\n" + 
				"	    content: contentvar,\r\n" +  
				"	  })\r\n" + 
				"	  .then(function (response) {\r\n" + 
				"	    console.log(response);\r\n" + 
				"	  })\r\n" + 
				"	  .catch(function (error) {\r\n" + 
				"	    console.log(error);\r\n" + 
				"	  });\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>"
				;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String postMessage (String content) {
		Post post = null;
		synchronized(posts) {
			int id = posts.size();
			post = new Post(content, id);
			posts.add(post);
			
			//System.out.println(posts.get(id));
			//System.out.println(id);
		}
		
		
		
		Gson gson = new Gson();		
		//System.out.println(content);
		System.out.println(gson.toJson(post));
		//System.out.println("_______________________________________________________________________________________");
		return gson.toJson(post);

		
		
		/*JsonObject posttext = new JsonObject();
		String message = posttext.toString();
		
		System.out.println(message);*/
		
		
	} 	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/posts")
	public String getPlainTextGreetin(@PathParam("id") int id)
	{
		
		List<Post> dummylist = new ArrayList<Post>();
		
		Post post = null;
		Gson gson = new Gson();		
		//System.out.println(content);
		for (int i = 0; i < posts.size(); ++i) {
			post = posts.get(id);
			System.out.println(gson.toJson(post));
			
			Post templist = new Post();
			templist = posts.get(id++);
			dummylist.add(templist);
		}
		
		
		//Gson gson = new Gson();
		return gson.toJson(dummylist);
		//System.out.println("_______________________________________________________________________________________");
		//return gson.toJson(post);
		
		
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/posts/{id}")
	public String getJsonGreeting(@PathParam("id") int id, String content)
	{
		String greetingtext = GREETINGS[id];
		Post greeting = new Post(greetingtext, id);
		Gson gson = new Gson();
		return gson.toJson(greeting);
	}*/
	
	
	
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	
	public String getGreetings()
	{
		posts.get(pos);
		List<Greeting> greetinglist = new ArrayList<>();
		
		for (int i = 0; i < GREETINGS.length; ++i)
			greetinglist.add(new Greeting(GREETINGS[i], i));
		
		Gson gson = new Gson();
		return gson.toJson(greetinglist.toArray(new Greeting[greetinglist.size()]));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String getJsonGreeting(@PathParam("id") int id, String content)
	{
		String greetingtext = GREETINGS[id];
		Greeting greeting = new Greeting(greetingtext, id);
		Gson gson = new Gson();
		return gson.toJson(greeting);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String getPlainTextGreeting(@PathParam("id") int id)
	{
		String greeting = GREETINGS[id];
		return greeting;
	}*/
}

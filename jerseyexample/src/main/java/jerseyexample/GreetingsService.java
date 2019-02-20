package jerseyexample;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Request;

import com.google.gson.Gson;

@Path("/greetings")
public class GreetingsService
{
	
	
	/*public void holeEingabe() {
		for ( int faktor = 1; faktor <= 9; faktor ++ ) {
		      System.out.println("3 x " + faktor + " = " + 3*faktor );
		}
	}*/
	
	/*String eingabe = JOptionPane.showInputDialog(null,"Ihr Post","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE);
	String eingabe2 = JOptionPane.showInputDialog(null,"Ihr Post","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE);
	String eingabe3 = JOptionPane.showInputDialog(null,"Ihr Post","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE);*/
	/** The available greetings. */
	
	
	String[] GREETINGS = /*{eingabe,eingabe2,eingabe3};*/ { "Hello World.", "Hello Jersey.", "Hello Kamill." };
		
		

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getGreetings()
	{
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
	}
}
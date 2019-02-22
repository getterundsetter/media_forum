package jerseyexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
	// JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:C:\\Users\\getterundsetter\\Desktop\\db";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	   protected Connection conn = null;
	public PostDao() {
		 
	      Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	        
	         conn = DriverManager.getConnection(DB_URL);  
	         
	         //STEP 3: Execute a query 
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
	         String sql = "CREATE TABLE IF NOT EXISTS POSTS " + 
	                 "(id INTEGER not NULL AUTO_INCREMENT, " + 
	                 " content VARCHAR, " +
	                 " PRIMARY KEY ( id ))";  
	        		 
	       		
	         stmt.executeUpdate(sql);
	       	         
	         // STEP 4: Clean-up environment 
	         stmt.close(); 	      
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	        
	      } //end try 
	  
	   } 
		
	
	
	
	public Post insertPost(String content) {
		Post ret =null;
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO POSTS (content) VALUES (?)",Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, content);
			
			int lines = stmt.executeUpdate();
			System.out.println("lines: " + lines);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			ret = new Post(content, id);
			conn.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	//read one post
	public Post readPost(int id) {
		Post ret =null;
		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM POSTS WHERE id=?")){
			stmt.setInt(1, id);
			ResultSet dummy = stmt.executeQuery();
			dummy.next();
			String content = dummy.getString(2);
			ret = new Post(content, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}
	
	public List<Post> readPosts() {
		List<Post> ret = new ArrayList<Post>();
		
		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM POSTS")){
			ResultSet dummy = stmt.executeQuery();
			while(dummy.next()) {
				int id = dummy.getInt(1);
				String content = dummy.getString(2);
				Post post = new Post(content, id);
				ret.add(post);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;	
	}
}


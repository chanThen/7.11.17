package com.BookWorld.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64; 

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONObject;

import com.BookWorld.model.User;
import com.BookWorld.service.UserService;
import com.BookWorld.service.UserServiceImpl;


@Path("/user")
public class UserController {
	UserService userService = new UserServiceImpl();
	
	@Path("/auth")
	@POST
	@Produces("application/json")
	public String authUserByEmail( User user1) throws Exception
	{
		String email = user1.getEmail();
		String pwd = user1.getPwd();
		
		/*byte[] asBytes = Base64.getDecoder().decode(pwd);
		String decodedpassword = new String(asBytes);*/
		
		
		User user = userService.findUserByEmail(email,pwd);
		
		String response="";
		JSONObject jsonObject = new JSONObject();
		
		//Decrypting the Password that is stored in Db as a encrypted format using decoder Base 64
		
		if(email.equalsIgnoreCase(user.getEmail()) && pwd.equalsIgnoreCase(user.getPwd())) {
			
			jsonObject.put("Status", "Success");
			jsonObject.put("name", user.getName());
			jsonObject.put("email", user.getEmail());
			jsonObject.put("userid", user.getUserid());
			
			response = jsonObject.toString().replace("\\", " ");
			
		}
		
		else {
			jsonObject.put("Status", "Failure");
			response = jsonObject.toString().replace("\\", " ");
		}
		return response;
	}
	
	// The add service is called in order to Add the new user 
	@Path("/add")
	@POST
	@Produces("application/json")
	public String addUser( User user
			) throws UnsupportedEncodingException
	{
		  
		    
		    //Encrypting the given given password and storing it in the Db using Base64
		    
			/*String encryptedpassword = Base64.getEncoder().encodeToString(user.getPwd().getBytes("utf-8"));
			user.setPwd(encryptedpassword);*/
			return userService.addUser(user);	
			
		
	}
}

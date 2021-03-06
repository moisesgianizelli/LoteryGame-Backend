package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.validator.Validator;

@Path("register")
@Controller
public class RegisterController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject Validator validator;
	
	@Get("")
	public void register() {
		
	}
	
	@Post("saveuser")
	public void saveUser(@Valid User user) {
		validator.onErrorRedirectTo(this).register();
		// validate user
		// save in database
		em.persist(user);
		// send to dashboard 
		result.redirectTo(DashboardController.class).dashboard();
		
		
	}
	
	

}

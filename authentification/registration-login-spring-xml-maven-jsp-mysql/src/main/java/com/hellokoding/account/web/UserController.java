package com.hellokoding.account.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.account.model.Topo;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.SecurityService;
import com.hellokoding.account.service.TopoService;
import com.hellokoding.account.service.UserService;
import com.hellokoding.account.validator.TopoValidator;
import com.hellokoding.account.validator.UserValidator;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private TopoService topoService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @Autowired
    private TopoValidator topoValidator;
    
    
    
    @InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
	}
    
    @RequestMapping("/index")
	public String index(Model model) {

		return "index";
	}
    
    @RequestMapping("/home")
   	public String home(Model model) {

   		return "home";
   	}
    
    @RequestMapping("/about")
   	public String about(Model model) {

   		return "about";
   	}
    
 
    
    @RequestMapping("/formUser")
   	public String formUser(Model model) {

   		return "formUser";
   	}
    
    @RequestMapping("/contact")
   	public String contact(Model model) {

   		return "contact";
   	}
    
    
    @RequestMapping("/blog")
   	public String blog(Model model) {

   		return "blog";
   	}
    
    @RequestMapping("/articles")
   	public String articles(Model model) {

   		return "articles";
   	}
    
	@RequestMapping("/infos")
	public String infos(Model model) {

		return "infos";
	}
    
    @RequestMapping(value = "/topoForm", method = RequestMethod.GET)
    public String topoForm(Model model) {
        model.addAttribute("userForm", new Topo());

        return "topoForm";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    
    
    
    
	  @RequestMapping(value = "/topoList", method = RequestMethod.GET) public
	  String topoList(Model model) { List<Topo> list = topoService.listTopoInfos();
	  model.addAttribute("topoInfos", list);
	  
	  return "topoList"; }
	  
	  
	  @RequestMapping(value = "/userList", method = RequestMethod.GET) public
	  String userList(Model model) { List<User> list = userService.listUserInfos();
	  model.addAttribute("userInfos", list);
	  
	  return "userList"; }
	 

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.saveUser2(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
    
    
    @RequestMapping(value = "/saveTopo", method = RequestMethod.POST)
    public String saveTopo(@ModelAttribute("userForm") Topo userForm, BindingResult bindingResult, Model model) {
        topoValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "topoForm";
        }

        topoService.saveTopo(userForm);

       
        return "topoList";
    }
    
	@RequestMapping("/editTopo")
	public String editTopo(Model model, @RequestParam("id") Long id) {
		Topo topo = null;
		if (id != 0) {
			topo = this.topoService.findTopo(id);
		}
		if (topo == null) {
			return "redirect:/topoList";
		}

		return this.topoForm(model);
	}

	@RequestMapping("/deleteTopo")
	public String deleteTopo(Model model, @RequestParam("id") Long id) {
		if (id != 0) {
			this.topoService.deleteTopo(id);
		}
		return "redirect:/topoList";
	}
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(Model model, //
			@ModelAttribute("userForm") @Validated User user, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return this.formUser(model);
		}

		this.userService.saveUser(user);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save User Successful");

		return "redirect:/userList";

	}
	
	@RequestMapping(value = "/saveUser2", method = RequestMethod.POST)
	public String saveUser2(Model model, //
			@ModelAttribute("userForm") @Validated User user, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return this.registration(model);
		}

		this.userService.saveUser2(user);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save User Successful");

		return "redirect:/welcome";

	}
}

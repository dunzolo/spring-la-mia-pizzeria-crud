package org.lessons.java.contr;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pojo.Pizza;
import org.lessons.java.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PizzaController {
	@Autowired
	private PizzaService pizzService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Pizza> pizza_list = pizzService.findAllPizza();
		
		model.addAttribute("pizzaList", pizza_list);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model,
			@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzService.findPizzaById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "single-pizza";
	}
}

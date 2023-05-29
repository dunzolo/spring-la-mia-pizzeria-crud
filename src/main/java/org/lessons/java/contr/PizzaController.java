package org.lessons.java.contr;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pojo.Pizza;
import org.lessons.java.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Pizza> pizza_list = pizzaService.findAllPizza();
		
		model.addAttribute("pizzaList", pizza_list);
		
		return "index";
	}
	
	@PostMapping("/pizza/nome")
	public String getBookByTitle(Model model, @RequestParam(required = false) String nome) {
		
		List<Pizza> pizza_list = pizzaService.findByNome(nome);
		model.addAttribute("pizzaList", pizza_list);
		model.addAttribute("nome", nome);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model,
			@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "single-pizza";
	}
	
	@GetMapping("/pizza/create")
	public String createPizza() {
		
		return "create-pizza";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(@ModelAttribute Pizza pizza) {
		
		pizzaService.savePizza(pizza);
		
		return "redirect:/";
	}
}

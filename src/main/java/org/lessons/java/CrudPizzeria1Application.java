package org.lessons.java;

import org.lessons.java.pojo.Pizza;
import org.lessons.java.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudPizzeria1Application implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(CrudPizzeria1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Pizza p1 = new Pizza("Margherita", 
				"Pizza Margherita", 
				"https://primochef.it/wp-content/uploads/2019/08/SH_pizza_fatta_in_casa-1200x800.jpg.webp",
				8);
		
		Pizza p2 = new Pizza("Cotto", 
				"Pizza col Cotto", 
				"https://efru.it/efru-upload/2020/03/pizza-prosciutto-cotto.jpg",
				9);
		
		Pizza p3 = new Pizza("Crudo", 
				"Pizza col Crudo", 
				"https://wips.plug.it/cips/buonissimo.org/cms/2011/12/pizza-al-prosciutto-crudo.jpg?w=712&a=c&h=406",
				10);
		
		pizzaService.savePizza(p1);
		pizzaService.savePizza(p2);
		pizzaService.savePizza(p3);
	}
}


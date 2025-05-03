package br.com.fiap.restaurante.entities;

import java.util.Set;

public class MenuItem {

	private String name;
	private String description;
	private double price;
	private boolean available;
	private int calories;
	private boolean vegan;
	private boolean glutenFree;

	private Set<Produto> ingredients; // Corrigido para Set<Produto>

	public MenuItem(String name, String description, double price, boolean available,
					int calories, boolean vegan, boolean glutenFree, Set<Produto> ingredients) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
		this.calories = calories;
		this.vegan = vegan;
		this.glutenFree = glutenFree;
		this.ingredients = ingredients;
	}

	// Getters e Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	public Set<Produto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Produto> ingredients) {
		this.ingredients = ingredients;
	}

	public void showInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Description: " + this.description);
		System.out.println("Price: $" + this.price);
		System.out.println("Available: " + (this.available ? "Yes" : "No"));
		System.out.println("Calories: " + this.calories + " kcal");
		System.out.println("Vegan: " + (this.vegan ? "Yes" : "No"));
		System.out.println("Gluten-Free: " + (this.glutenFree ? "Yes" : "No"));

		System.out.println("Ingredients:");
		if (ingredients != null) {
			for (Produto p : ingredients) {
				System.out.println("- " + p.getNome());
			}
		} else {
			System.out.println("- (none)");
		}
	}

	public static class Validation {

		public static boolean validatePrice(double price) {
			return price > 0;
		}

		public static boolean validateName(String name) {
			return name != null && !name.isEmpty();
		}
	}
}

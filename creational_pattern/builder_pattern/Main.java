package creational_pattern.builder_pattern;

import java.util.List;

class BurgerMeal {
    // required things
    private String bun;
    private String patty;

    // optional things
    private boolean cheese;
    private List<String> toppings;
    private boolean tomato;

    private BurgerMeal(BurgerBuilder burgerBuilder) {
        this.bun = burgerBuilder.bun;
        this.patty = burgerBuilder.patty;
        this.cheese = burgerBuilder.cheese;
        this.toppings = burgerBuilder.toppings;
        this.tomato = burgerBuilder.tomato;
    }

    public static class BurgerBuilder {
        // required things
        private String bun;
        private String patty;

        // optional things
        private boolean cheese;
        private List<String> toppings;
        private boolean tomato;

        public BurgerBuilder(String bun, String patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public BurgerBuilder withChesse(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public BurgerBuilder withTomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public BurgerBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BurgerMeal plainBurgerMeal = new BurgerMeal.BurgerBuilder("Wheat", "Aalo").build();
        BurgerMeal burgerWithCheese = new BurgerMeal.BurgerBuilder("wheat", "chicken")
                .withChesse(true)
                .build();

        System.out.println(plainBurgerMeal);
        System.out.println(burgerWithCheese);
    }
}

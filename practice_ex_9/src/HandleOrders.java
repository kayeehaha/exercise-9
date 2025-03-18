import java.util.ArrayList;
import java.util.Scanner;

// 新增 CustomPizza 类
class CustomPizza {
    private String toppings;
    private double price;

    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Custom Pizza with " + toppings + ": €" + price;
    }
}

// 新增 OrderLogs 类
class OrderLogs {
    private java.util.ArrayDeque<String> orderLogs;

    public OrderLogs() {
        this.orderLogs = new java.util.ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Most recent log entry: " + orderLogs.peek());
        } else {
            System.out.println("The log is empty.");
        }
    }

    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        }
        return null;
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.println("Enter your choice (1–5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (String log : orderLogs) {
                        System.out.println(log);
                    }
                    break;
                case 2:
                    mostRecentLogEntry();
                    break;
                case 3:
                    if (!orderLogsEmpty()) {
                        System.out.println("Removed log: " + getOrderLog());
                    } else {
                        System.out.println("The log is empty.");
                    }
                    break;
                case 4:
                    removeAllLogEntries();
                    System.out.println("All log entries removed.");
                    break;
                case 5:
                    if (orderLogsEmpty()) {
                        System.out.println("The log is completely empty");
                    } else {
                        System.out.println("The log is not completely empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class HandleOrders {

    private static final double PIZZA_BASE_PRICE = 10.0;

    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int numberOfPizzasOrdered = 0;
    StringBuilder pizzaOrderSummary = new StringBuilder();
    private ArrayList<CustomPizza> customPizzas = new ArrayList<>(); // 新增 customPizzas 列表

    Scanner input = new Scanner(System.in);

    public void takeOrder() {
        String orderAnother = "Y";
        int j = 0;
        int m = 0;
        int n = 0;
        int p = 0;

        do {
            int i = 1;
            System.out.println("Welcome to Slice - o - Heaven Pizzeria. Here’s what we serve: \n");
            for (PizzaSelection pizza : PizzaSelection.values()) {
                System.out.println(i + ". " + pizza);
                i++;
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose: \n");

            System.out.println("Please enter your choice (1 - 6): \n");
            int choice = input.nextInt();
            input.nextLine();

            if (choice > 0 && choice < 6) {
                switch (choice) {
                    case 1:
                        System.out.println("You have selected " + PizzaSelection.PEPPERONI);
                        pizzasOrdered[j] = PizzaSelection.PEPPERONI.toString();
                        totalOrderPrice += PizzaSelection.PEPPERONI.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 2:
                        System.out.println("You have selected " + PizzaSelection.HAWAIIAN);
                        pizzasOrdered[j] = PizzaSelection.HAWAIIAN.toString();
                        totalOrderPrice += PizzaSelection.HAWAIIAN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 3:
                        System.out.println("You have selected " + PizzaSelection.VEGGIE);
                        pizzasOrdered[j] = PizzaSelection.VEGGIE.toString();
                        totalOrderPrice += PizzaSelection.VEGGIE.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 4:
                        System.out.println("You have selected " + PizzaSelection.BBQ_CHICKEN);
                        pizzasOrdered[j] = PizzaSelection.BBQ_CHICKEN.toString();
                        totalOrderPrice += PizzaSelection.BBQ_CHICKEN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    case 5:
                        System.out.println("You have selected " + PizzaSelection.EXTRAVAGANZA);
                        pizzasOrdered[j] = PizzaSelection.EXTRAVAGANZA.toString();
                        totalOrderPrice += PizzaSelection.EXTRAVAGANZA.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again.");
                        break;
                }
            } else if (choice == 6) {
                double customPizzaPrice = 0;

                System.out.println("For your custom pizza, here are the toppings:");
                int k = 1;
                for (PizzaToppings topping : PizzaToppings.values()) {
                    System.out.println(k + ". " + topping);
                    k++;
                }
                System.out.println("Please enter a maximum of 10 topping choices.\n");

                StringBuilder customPizza = new StringBuilder(" Custom Pizza with ");
                StringBuilder customPizzaToppings = new StringBuilder(); // 新增 customPizzaToppings

                int l = 1;
                do {
                    System.out.println("Enter topping #" + l + ". To stop, type 0: ");
                    int toppingChoice = input.nextInt();
                    input.nextLine();
                    if (toppingChoice == 0) {
                        break;
                    }
                    customPizza.append(PizzaToppings.values()[toppingChoice - 1].getTopping() + ", ");
                    customPizzaToppings.append(PizzaToppings.values()[toppingChoice - 1].getTopping() + ", "); // 追加配料
                    customPizzaPrice += PizzaToppings.values()[toppingChoice - 1].getToppingPrice();
                    l++;
                } while (l <= 10);

                customPizzaPrice += PIZZA_BASE_PRICE;

                customPizza.append(": €" + customPizzaPrice);

                pizzasOrdered[j] = customPizza.toString();
                totalOrderPrice += customPizzaPrice;
                numberOfPizzasOrdered++;
                j++;

                // 创建 CustomPizza 对象并添加到列表中
                CustomPizza customPizzaObj = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
                customPizzas.add(customPizzaObj);
            }

            i = 1;
            System.out.println("Here are the pizza sizes options: \n");
            for (PizzaSize pizza : PizzaSize.values()) {
                System.out.println(i + ". " + pizza);
                i++;
            }

            System.out.println("Pick one size (1 - 3): \n");
            int sizeChoice = input.nextInt();
            input.nextLine();

            pizzaSizesOrdered[m] = PizzaSize.values()[sizeChoice - 1].getPizzaSize() + ": €" + PizzaSize.values()[sizeChoice - 1].getAddToPizzaPrice();
            totalOrderPrice += PizzaSize.values()[sizeChoice - 1].getAddToPizzaPrice();
            m++;

            System.out.println("Here are the side dishes options: \n");
            i = 1;
            for (SideDish sideDish : SideDish.values()) {
                System.out.println(i + ". " + sideDish);
                i++;
            }

            System.out.println("Pick one side dish (1 - 4): \n");
            int sideDishChoice = input.nextInt();
            input.nextLine();

            sideDishesOrdered[n] = SideDish.values()[sideDishChoice - 1].getSideDishName() + ": €" + SideDish.values()[sideDishChoice - 1].getAddToPizzaPrice();
            totalOrderPrice += SideDish.values()[sideDishChoice - 1].getAddToPizzaPrice();
            n++;

            System.out.println("Here are the drinks options: \n");
            i = 1;
            for (Drinks drink : Drinks.values()) {
                System.out.println(i + ". " + drink);
                i++;
            }

            System.out.println("Pick one drink (1 - 3): \n");
            int drinkChoice = input.nextInt();
            input.nextLine();

            drinksOrdered[p] = Drinks.values()[drinkChoice - 1].getDrinkName() + ": €" + Drinks.values()[drinkChoice - 1].getAddToPizzaPrice();
            totalOrderPrice += Drinks.values()[drinkChoice - 1].getAddToPizzaPrice();
            p++;

            System.out.println("Would you like to order another pizza? (Y/N): \n");
            orderAnother = input.nextLine();

        } while (orderAnother.equalsIgnoreCase("Y"));
    }

    public void createOrderSummary() {

        pizzaOrderSummary.append("\nThank you for dining with Slice - o - Heaven. Your order details are as follows: \n");

        for (int i = 0; i < numberOfPizzasOrdered; i++) {
            pizzaOrderSummary.append((i + 1) + " " + pizzasOrdered[i] + "\n");
            pizzaOrderSummary.append(pizzaSizesOrdered[i] + "\n");
            pizzaOrderSummary.append(sideDishesOrdered[i] + "\n");
            pizzaOrderSummary.append(drinksOrdered[i] + "\n \n");

        }

        pizzaOrderSummary.append("ORDER TOTAL: €" + totalOrderPrice + "\n");
    }

    // 新增 displayCustomPizzas 方法
    public void displayCustomPizzas() {
        System.out.println("Custom Pizzas Ordered:");
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    @Override
    public String toString() {
        return pizzaOrderSummary.toString();
    }

    public static void main(String[] args) {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.createOrderSummary();
        System.out.println(handleOrders);
        handleOrders.displayCustomPizzas();

        OrderLogs orderLogs = new OrderLogs();
        orderLogs.addOrderLog("Order placed at " + java.time.LocalDateTime.now());
        orderLogs.handleLogs();
    }
}

// 假设这些枚举类已经定义
enum PizzaSelection {
    PEPPERONI(12.0),
    HAWAIIAN(13.0),
    VEGGIE(11.0),
    BBQ_CHICKEN(14.0),
    EXTRAVAGANZA(15.0);

    private double price;

    PizzaSelection(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

enum PizzaToppings {
    CHEESE("Cheese", 1.0),
    PEPPERONI("Pepperoni", 1.5),
    MUSHROOMS("Mushrooms", 1.2),
    ONIONS("Onions", 0.8),
    PEPPERS("Peppers", 1.1);

    private String topping;
    private double toppingPrice;

    PizzaToppings(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public String getTopping() {
        return topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }
}

enum PizzaSize {
    SMALL("Small", 2.0),
    MEDIUM("Medium", 3.0),
    LARGE("Large", 4.0);

    private String pizzaSize;
    private double addToPizzaPrice;

    PizzaSize(String pizzaSize, double addToPizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
}

enum SideDish {
    FRIES("Fries", 3.0),
    WINGS("Wings", 5.0),
    SALAD("Salad", 4.0),
    BREADSTICKS("Breadsticks", 2.5);

    private String sideDishName;
    private double addToPizzaPrice;

    SideDish(String sideDishName, double addToPizzaPrice) {
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
}

enum Drinks {
    COKE("Coke", 2.0),
    SPRITE("Sprite", 2.0),
    WATER("Water", 1.0);

    private String drinkName;
    private double addToPizzaPrice;

    Drinks(String drinkName, double addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
}    
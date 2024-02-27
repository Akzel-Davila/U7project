import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Randomly generated package info: ");
        System.out.println("What would you like to do?");
        System.out.println("1. Calculate cost of one package");
        System.out.println("2. Simulate packages");
        System.out.println("3. How package costs are calculated");
        System.out.println("4. Exit");
        System.out.print("Input: ");
        String choice = s.nextLine();
        if (choice.equals("1")){
            System.out.print("Enter the zip code of the origin package: ");
            String start = s.nextLine();
            System.out.print("Enter the zip code of the destination package: ");
            String end = s.nextLine();
            System.out.print("Enter the weight of the package: ");
            double weight = Double.parseDouble(s.nextLine());
            System.out.print("Enter the length of the package: ");
            double length = Double.parseDouble(s.nextLine());
            System.out.print("Enter the width of the package: ");
            double width = Double.parseDouble(s.nextLine());
            System.out.print("Enter the height of the package: ");
            double height = Double.parseDouble(s.nextLine());
            double cost = PostageCalculator.calculatePostage(start, end, weight, length, width, height);
            System.out.print("Cost: " + cost);
        }
        if(choice.equals("2")){
            System.out.println("Randomly generated package info: ");
            System.out.print("How many packages would you like to simulate? ");
            int num = Integer.parseInt(s.nextLine());
            System.out.println("Randomly generated package info: ");
            PackageSimulator sim = new PackageSimulator();
            sim.generatePackages(num);
            sim.getSimulationInfo();
            sim.resetSimulation();
        }
        if(choice.equals("3")){
            System.out.println("Calculation Details:");
            System.out.println("To calculate the postage for a package, the following steps are performed:");
            System.out.println("1. Determine the base cost: $3.75");
            System.out.println("2. Calculate the weight cost: 5 cents for each pound of weight");
            System.out.println("3. Calculate the oversize cost: 10 cents for each inch over 36 inches in any dimension");
            System.out.println("4. Adjust the base cost for overweight packages: 10 cents for each pound over 40 pounds");
            System.out.println("5. Calculate the difference in county codes and add it to the final total");
        }
        if (choice.equals("4")){
            System.out.println("Ending program.");
        }
    }
}
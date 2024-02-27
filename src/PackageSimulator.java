import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageSimulator {
    private ArrayList<Package> packList;
    public PackageSimulator(){
        packList = new ArrayList<Package>();
    }
    public void generatePackages(int num){
        ArrayList <String> codes = readFile();
        for (int i = 0; i<num; i++)
        {
            String start = "123 Random Street, City, State ";
            String end =  "123 Random Street, City, State ";
            int random =(int) (Math.random() * codes.size()-1);
            start += codes.get(random);
            random =(int) (Math.random() * codes.size()-1);
            end += codes.get(random);
            Address address1 = new Address(start);
            Address address2 = new Address(end);
            double weight = Math.random() * (60-.1 + 1) + .1;
            double length = Math.random() *  (30-2+1) +2;
            double width = Math.random() *  (30-2+1) +2;
            double height = Math.random() *  (30-2+1) +2;
            Package p = new Package(address1, address2, weight, length, height, width);
            packList.add(p);
        }
    }
    public double generateTotalCost(){
        double cost = 0;
        for (Package box: packList){
            cost += PostageCalculator.calculatePostage(box);
            cost = Math.round(cost * 100.0) / 100.0;
        }
        return cost;
    }
    public void getSimulationInfo(){
        int counter = 1;
        for (Package p: packList){
            System.out.println("Package " + counter + ": _______________");
            counter++;
            System.out.println("Origin address: " + p.getStart());
            System.out.println("Destination address: " + p.getEnd());
            System.out.println("Weight: " + p.getWeight() + " pounds");
            System.out.println("Length: " + p.getLength() + " inches");
            System.out.println("Width: " + p.getWidth()+ " inches");
            System.out.println("Height: " + p.getHeight() + "inches");
            System.out.println("Cost: " + PostageCalculator.calculatePostage(p));
        }
        System.out.println("_______________");
        System.out.println("Total Cost of all packages: " + generateTotalCost());
    }
    public void resetSimulation(){
        packList = new ArrayList<Package>();
    }
    public ArrayList<String> readFile(){
        File f = new File("data/Codes");
        Scanner s;
        ArrayList<String> zipCodes = new ArrayList<String>();
        try
        {
            s = new Scanner(f);
            while(s.hasNextLine()){
                String currentLine = s.nextLine();
                zipCodes.add(currentLine);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
        return zipCodes;
    }
}

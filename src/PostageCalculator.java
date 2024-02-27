public class PostageCalculator {

    public static double calculatePostage(String startZip, String endZip, double weight, double length, double width, double height){
        int start = Integer.parseInt(startZip.substring(0,3));
        int end = Integer.parseInt(endZip.substring(0,3));
        double difference = Math.abs(start-end) / 100.0;
        difference = Math.round(difference * 100.0) / 100.0;
        double cost = noZipCost(length*width*height, weight);
        cost = Math.round(cost * 100.0) / 100.0;
        return cost + difference;
    }
    public static double calculatePostage(Address a1, Address a2, double weight, double length, double width, double height){
        int start = Integer.parseInt(a1.getZip().substring(0,3));
        int end = Integer.parseInt(a2.getZip().substring(0,3));
        double difference = (double) Math.abs(start-end) / 100;
        difference = Math.round(difference * 100.0) / 100.0;
        double cost = noZipCost(length*width*height, weight);
        cost = Math.round(cost * 100.0) / 100.0;
        return cost + difference;
    }
    public static double calculatePostage(Package box){
        int start = Integer.parseInt(box.getStart().getZip().substring(0,3));
        int end = Integer.parseInt(box.getEnd().getZip().substring(0,3));
        double difference = (double) Math.abs(start-end) / 100;
        difference = Math.round(difference * 100.0) / 100.0;
        double cost = noZipCost(box.getHeight() * box.getLength() * box.getWidth(), box.getWeight());
        cost = Math.round(cost * 100.0) / 100.0;
        return cost + difference;
    }
    private static double noZipCost(double size, double weight) {
        double base = 3.75;
        double weightCost = weight * 0.05;
        double oversizeCost = 0;
        if (size > 36) {
            oversizeCost = (size - 36) * 0.10;
        }
        if (weight > 40) {
            double overweight = weight - 40;
            double overweightCost = overweight * 0.10;
            base += overweightCost;
        }
        base += oversizeCost;
        base += weightCost;
        base = Math.round(base * 100.0) / 100.0;

        return base;
    }
}
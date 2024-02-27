public class Package {
    private Address start;
    private Address end;
    private double weight;
    private double length;
    private double height;
    private double width;
    public Package(Address start, Address end, double weight, double length, double height, double width){
        if (length>2 && width >2 && height>2 && weight>.1) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.length = length;
            this.height = height;
            this.width = width;
        }
        else{
            System.out.println("Your package is too small to be calculated");
        }
    }

    public Address getStart() {
        return start;
    }

    public void setStart(Address start) {
        this.start = start;
    }

    public Address getEnd() {
        return end;
    }

    public void setEnd(Address end) {
        this.end = end;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

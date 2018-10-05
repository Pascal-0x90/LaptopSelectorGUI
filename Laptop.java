package Assignment6;

import java.text.DecimalFormat;

public class Laptop {

    private String brand, model;	//brand & model of the laptop
    private double CPU, RAM;		//CPU in GHz, RAM in GB
    private double price;
    int x;
    int y;
    //Constructor. It initializes all instance variables to their default values.

    public Laptop() {
        brand = new String("?");
        model = new String("?");
        CPU = 0.0;
        RAM = 0.0;
        price = 0.0;
    }

    //Overloaded constructor, used to initialize all instance varibles
    public Laptop(String nBrand, String nModel, double CPU, double RAM, double nPrice) {
        brand = nBrand;
        model = nModel;
        this.CPU = CPU;
        this.RAM = RAM;
        price = nPrice;
    }

    //Accessor method of the instance variable brand
    public String getBrand() {
        return brand;
    }

    //Accessor method of the instance variable model
    public String getModel() {
        return model;
    }

    //Accessor method of the instance variable CPU
    public double getCPU() {
        return CPU;
    }

    //Accessor method of the instance variable RAM
    public double getRAM() {
        return RAM;
    }

    // Adding an override or two to help the input pane realize what the heck is going on with these objects
    // Gotta modify this so my input and purchase pane know when an object of laptop doesnt exist within a list
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Laptop other = (Laptop) obj;
        if (other == null) {
            return true;
        }
        if (!this.brand.equals(other.brand) || !this.model.equals(other.model) || this.CPU != other.CPU || this.RAM != other.RAM || this.price != other.price) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }
    //Accessor method of the instance variable price

    public double getPrice() {
        return price;
    }

    //Mutator method of the instance variable brand
    public void setBrand(String nBrand) {
        brand = nBrand;
    }

    //Mutator method of the instance variable model
    public void setModel(String nModel) {
        model = nModel;
    }
    //Mutator method of the instance variable price

    public void setPrice(double nPrice) {
        price = nPrice;
    }

    //toString method creates a string containing values of
    //instance variables using the specified format and returns it
    public String toString() {
        DecimalFormat fmt1 = new DecimalFormat("0.0");
        DecimalFormat fmt2 = new DecimalFormat("$0.00");

        String result = "Brand:\t" + brand
                + "\nModel:\t" + model
                + "\nCPU:\t\t" + fmt1.format(CPU)
                + "\nRAM:\t" + fmt1.format(RAM)
                + "\nPrice:\t" + fmt2.format(price) + "\n\n";
        return result;
    }
} //end of the Laptop class
// \|/
// AXA
///XXX\
//\XXX/
// `^'
// Pineapple

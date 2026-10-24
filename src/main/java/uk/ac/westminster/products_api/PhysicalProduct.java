package uk.ac.westminster.products_api;


// A PhysicalProduct IS-A Product because it represents a product with additional physical properties.
// A ShoppingCart is not a Product because it contains products rather than being a type of product.


public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions){
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg(){
        return weightKg;
    }

    public String getDimensions(){
        return dimensions;
    }
}

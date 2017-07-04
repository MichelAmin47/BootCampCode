package examples;

public class AutoAdvanced {

    public String brand;

    public AutoAdvanced(String brand){
        this.brand = brand;
        System.out.println("Brand of your car is " + brand);
        askQuestion();
    }

    public void askQuestion(){
        System.out.println("Which type is your " + brand + "?");
    }
}

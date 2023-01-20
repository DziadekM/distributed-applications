import jakarta.ejb.Stateless;

@Stateless
public class BMIStatelessBean {
    public double calculateBMI(double weight, double height) {
        System.out.println("Hello, here is the BMIStatelessBean!");
        return weight / (height * height);
    }

}

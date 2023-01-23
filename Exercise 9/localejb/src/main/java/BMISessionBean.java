import jakarta.ejb.Stateless;
//import java.io.File;

@Stateless
public class BMISessionBean implements BMICalculatorLocal {

    @Override
    public Double calculateBMI(Double weight, Double height) {
        System.out.println("Hello, here is the BMISessionBean!");

        return weight / (height * height);
    }
}

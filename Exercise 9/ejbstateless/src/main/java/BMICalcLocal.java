import jakarta.ejb.*;

@Local
public interface BMICalcLocal {
    // Method to calculate the BMI
    public Double calculateBMI(Double weight, Double height);
}

import jakarta.ejb.*;
//Local Business Interface

@Local // --> not neccessary, because without annotation its automatically local
public interface BMICalculatorLocal {
    public Double calculateBMI(Double weight, Double height);
}

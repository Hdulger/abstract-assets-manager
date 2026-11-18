import java.math.BigDecimal;
import java.time.LocalDate;


public class Vehicle extends Asset{
    String  makeModel;
    int year;
    int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public int charmTotal(){
        return 1;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue(){
        int age= LocalDate.now().getYear()-year;
        age = Math.max(age, 0);


        BigDecimal carValue=BigDecimal.ZERO;
        BigDecimal red=BigDecimal.ZERO;

        switch (age){
            case 0,1,2,3->{
                red =originalCost.multiply(new BigDecimal("0.03")).multiply(BigDecimal.valueOf(age));
                carValue=originalCost.subtract(red);
            }
            case 4,5,6->{
                red =originalCost.multiply(new BigDecimal("0.06")).multiply(BigDecimal.valueOf(age));
                carValue=originalCost.subtract(red);
            }
            case 7,8,9, 10->{
                red =originalCost.multiply(new BigDecimal("0.08")).multiply(BigDecimal.valueOf(age));
                carValue=originalCost.subtract(red);
            }
            default -> {
                carValue=new BigDecimal("1000.00");
            }
        }
        if(odometer>100000 && (!getMakeModel().equalsIgnoreCase("Honda")|| !getMakeModel().equalsIgnoreCase("Toyota"))){
            carValue=carValue.subtract(carValue.multiply(new BigDecimal("0.25")));
        }
        return carValue;
    }

}

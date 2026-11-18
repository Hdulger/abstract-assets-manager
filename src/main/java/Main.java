import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets=new ArrayList<>();


        BigDecimal housePrice=new BigDecimal("250000");
        BigDecimal carPrice=new BigDecimal("2000");

        //Before the abstract class
        //Asset a=new Asset("assets", "2010",carPrice);
//        assets.add(a);
//        a=new House("House", "2000", housePrice, "NY", 6, 25, 3);
//        assets.add(a);
//
//        a=new Vehicle("Car", "2020", carPrice, "Brooklyn", 2025, 10000 );
//        assets.add(a);


        //After the abstract class

        assets.add(new House("House", "2000", housePrice, "NY", 6, 25, 3));
        assets.add(new Vehicle("Car", "2020", carPrice, "Brooklyn", 2025, 10000 ));




        BigDecimal netWorth=BigDecimal.ZERO;
        BigDecimal vehicleTotal=BigDecimal.ZERO;
        int charmTotal=0;

        for (Asset as:assets){
            System.out.println( as.getDescription()+as.getValue());
            netWorth=netWorth.add(as.getValue());
            System.out.println(netWorth);
            if(as instanceof Vehicle){
                vehicleTotal=vehicleTotal.add(as.getValue());
                System.out.println(vehicleTotal);

            }
            if(as instanceof Vehicle){
                Vehicle vehicleCharmTotal=(Vehicle) as;//The reason we cast here, there is no charm total in assets while there is in vehicles.
                charmTotal+=vehicleCharmTotal.charmTotal(); //we can use the casting with different classes too.

            }
        }




    }
}
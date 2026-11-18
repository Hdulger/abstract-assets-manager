import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets=new ArrayList<>();


        BigDecimal housePrice=new BigDecimal("250000");
        BigDecimal carPrice=new BigDecimal("2000");
        BigDecimal toyotaPrice=new BigDecimal("15000");

        //Before the abstract class
        //Asset a=new Asset("assets", "2010",carPrice);
//        assets.add(a);
//        a=new House("House", "2000", housePrice, "NY", 6, 25, 3);
//        assets.add(a);
//
//        a=new Vehicle("Car", "2020", carPrice, "Brooklyn", 2025, 10000 );
//        assets.add(a);


        //After the abstract class

        assets.add(new House("House", "2000", housePrice, "NY", 4, 25, 3));
        assets.add(new Vehicle("Car", "2020", carPrice, "Brooklyn", 2025, 10000 ));
        assets.add(new Vehicle("Toyota", "2025", toyotaPrice, "Brooklyn", 2025, 10000 ));
        assets.add(new Cash("Cash", "2024", BigDecimal.ZERO, BigDecimal.valueOf(2000)));
        assets.add(new Cash("Cash", "2026", BigDecimal.ZERO, BigDecimal.valueOf(5000)));




        BigDecimal netWorth=BigDecimal.ZERO;
        BigDecimal vehicleTotal=BigDecimal.ZERO;
        BigDecimal cashAmount=BigDecimal.ZERO;
        int charmTotal=0;

        for (Asset as:assets){
           // System.out.println( as.getDescription()+as.getValue());
            netWorth=netWorth.add(as.
                    getValue());

            if(as instanceof Vehicle){
                vehicleTotal=vehicleTotal.add(as.getValue());


            }
            if(as instanceof Vehicle){
                Vehicle vehicleCharmTotal=(Vehicle) as;//The reason we cast here, there is no charm total in assets while there is in vehicles.
                charmTotal+=vehicleCharmTotal.charmTotal();


            }
            if(as instanceof Cash){
                Cash cash=(Cash) as;
                cashAmount=cashAmount.add(as.getValue());


            }
            //System.out.println( "Cash from: "+as.getDateAcquired()+" is "+ as.getValue());

        }


        System.out.println("Total cash: "+cashAmount);
        System.out.println("netWorth="+netWorth);
        System.out.println("Total Charm="+charmTotal);//we can use the casting with different classes too.
        System.out.println("Total Vehicle:"+vehicleTotal);


    }
}
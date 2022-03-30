package casting;

public class CarChecker {

    public static void main(String[] args) {

        // Oppretter et objekt av typen RentalCar, og bruker RentalCar-konstruktøren.
        // Ingen casting skjer her
        RentalCar myRentalCar = new RentalCar();

        // Oppretter et objekt av typen RentalCar, men bruker CleanCar-konstruktøren.
        // Her blir CleanCar upcastet til å behandles som en RentalCar
        RentalCar myCleanCar = new CleanCar();

        // Oppretter et objekt av typen RentalCar, men bruker DirtyCar-konstruktøren.
        // Her blir DirtyCar upcastet til å behandles som en RentalCar
        RentalCar myDirtyCar = new DirtyCar();

        // Oppretter et objekt av typen RentalCar, men bruker BumpedCar-konstruktøren.
        // Her blir BumpedCar upcastet til å behandles som en RentalCar
        RentalCar myBumpedCar = new BumpedCar();

        // Oppretter et String-objekt som skal brukes til demonstrasjon senere
        String myString = "This is my string";

        // Kjører checkCar-metoden på alle fire "biler"
        checkCar(myRentalCar);
        checkCar(myCleanCar);
        checkCar(myDirtyCar);
        checkCar(myBumpedCar);

        // Denne linja vil føre til kræsj nå, men vil virke om vi bytter ut hvilken
        // versjon av checkCar som er i bruk. Se lenger ned for mer informasjon
//        checkCar(myString);

        // Linje 38 vil føre til kræsj siden myRentalCar-objektet ble opprettet som en
        // RentalCar. Derfor kan det ikke downcastes, og vi vil få en ClassCastException
//        myRentalCar = (CleanCar) myRentalCar;
    }

    // En metode som tar inn et argument av typen RentalCar
    public static void checkCar(RentalCar car) {

        // Hvis car-parameteren er av typen CleanCar, skjer dette:
        if (car instanceof CleanCar) {

            // Downcaster car til å være en CleanCar istedenfor RentalCar
            // og lagrer det som cleanCar
            CleanCar cleanCar = (CleanCar) car;

            // Kjører den unike metoden som tilhører CleanCar-klassen
            cleanCar.readyForRental();

        } else if (car instanceof DirtyCar) {

            // Downcaster car til å være en DirtyCar istedenfor RentalCar
            // og lagrer det som dirtyCar
            DirtyCar dirtyCar = (DirtyCar) car;

            // Kjører den unike metoden som tilhører DirtyCar-klassen
            dirtyCar.setForCleaning();

        } else if (car instanceof BumpedCar) {

            // Downcaster car til å være en BumpedCar istedenfor RentalCar
            // og lagrer det som bumpedCar
            BumpedCar bumpedCar = (BumpedCar) car;

            // Kjører den unike metoden som tilhører BumpedCar-klassen
            bumpedCar.setForBumpRemoval();

        } else {
            System.out.println("This car does not need checking");
        }
    }

    // En alternativ versjon av checkCar-metoden, som tar inn et argument
    // av Object-klassen istedenfor RentalCar-klassen. Denne vil også
    // fungere med Strings, og alle andre objekter
//    public static void checkCar(Object car) {
//
//        if (car instanceof CleanCar) {
//            CleanCar cleanCar = (CleanCar) car;
//            cleanCar.readyForRental();
//
//        } else if (car instanceof DirtyCar) {
//            DirtyCar dirtyCar = (DirtyCar) car;
//            dirtyCar.setForCleaning();
//
//        } else if (car instanceof BumpedCar) {
//            BumpedCar bumpedCar = (BumpedCar) car;
//            bumpedCar.setForBumpRemoval();
//
//        } else if (car instanceof RentalCar) {
//            System.out.println("This car does not need checking");
//
//        } else {
//            System.out.println("This is not a car");
//        }
//    }
}

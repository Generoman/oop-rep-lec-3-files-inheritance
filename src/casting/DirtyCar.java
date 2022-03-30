package casting;

public class DirtyCar extends RentalCar {

    // Denne klassen arver fra RentalCar, og har en unik metode. Brukes kun for demonstrasjon av casting

    public void setForCleaning() {
        System.out.println("This car needs cleaning");
    }
}

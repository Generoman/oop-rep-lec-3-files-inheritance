package casting;

public class CarChecker {

    public static void main(String[] args) {

        RentalCar myRentalCar = new RentalCar();
        RentalCar myCleanCar = new CleanCar();
        RentalCar myDirtyCar = new DirtyCar();
        RentalCar myBumpedCar = new BumpedCar();

        checkCar(myRentalCar);
        checkCar(myCleanCar);
        checkCar(myDirtyCar);
        checkCar(myBumpedCar);

//        myRentalCar = (CleanCar) myRentalCar;
//        checkCar(myRentalCar);
    }

    public static void checkCar(RentalCar car) {

        if (car instanceof CleanCar) {
            CleanCar cleanCar = (CleanCar) car;
            cleanCar.readyForRental();

        } else if (car instanceof DirtyCar) {
            DirtyCar dirtyCar = (DirtyCar) car;
            dirtyCar.setForCleaning();

        } else if (car instanceof BumpedCar) {
            BumpedCar bumpedCar = (BumpedCar) car;
            bumpedCar.setForBumpRemoval();

        } else {
            System.out.println("This car does not need checking");
        }
    }
}

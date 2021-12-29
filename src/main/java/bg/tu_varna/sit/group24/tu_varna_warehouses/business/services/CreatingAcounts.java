package bg.tu_varna.sit.group24.tu_varna_warehouses.business.services;

public class CreatingAcounts {


    public static String input_validation(String name1,String username1,String pass1,String pass2){
        if(name1.length()<8){
            return "The full name must be at least 8 letters";


        }
        else if(username1.length()<4){
            return "Your username must be at least 4 letters";

        }
        else if(pass1.length()<5){
            return "Your password is not strong enough";

        }
        else if(pass1.equals(pass2)==false){
            return "You need to the same password on fields!";

        }
        return "good";
    }
}

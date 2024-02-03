package cl.neoris.pruebatecnica.util;

public class NumberUtil {

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}

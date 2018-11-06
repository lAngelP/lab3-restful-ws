package rest.addressbook.utils;

public class CloneUtils {

    public static String clone(String str){
        return str != null ? new String(str.getBytes()) : null;
    }

}

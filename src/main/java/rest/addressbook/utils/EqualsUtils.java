package rest.addressbook.utils;

import java.util.List;

public class EqualsUtils {

    public static <T> boolean checkList(List<T> one, List<T> other){
        boolean equals = one.size() == other.size();
        int i = 0;
        while(equals && i < one.size()){
            equals = one.get(i).equals(other.get(i));
            i++;
        }
        return equals;
    }

    public static <T> boolean checkObject(T one, T other){
        return one == null && other == null || one != null && one.equals(other);
    }
}

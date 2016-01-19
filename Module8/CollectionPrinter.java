import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by COOLib on 17.01.2016.
 */
public class CollectionPrinter {

    public static void printObject(Object obj) {

        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.print(field.getName() + " | ");
        }
        System.out.println();
        System.out.println();
    }


    public static void printCollection(Collection collection) {

        for (Object object : collection) {
            Class c = object.getClass();
            System.out.println(c.toString());
            Field[] fields = c.getDeclaredFields();
            System.out.println(fields.length);
            for (Field field : fields) {
                System.out.print(field.getName() + " | ");
            }
        }
        System.out.println();
    }
}
package Files;

import java.util.Date;

public class Picture extends File {

    public Picture(String name, int size, Date date) {
        super(name, size, date);
    }

    public void open(){
        System.out.println("Picture was opened.");
    }
    public void close(){
        System.out.println("Picture was closed.");
    }
}
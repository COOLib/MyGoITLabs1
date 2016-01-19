package Files;

import java.util.Date;

public class TextFile extends File {

    public TextFile(String name, int size, Date date) {
        super(name, size, date);
    }

    public void open(){
        System.out.println("Text file was opened.");
    }
    public void close(){
        System.out.println("Text file was closed.");
    }
}
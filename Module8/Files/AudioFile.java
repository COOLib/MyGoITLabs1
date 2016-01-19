package Files;

import java.util.Date;

public class AudioFile extends File {
    public AudioFile(String name, int size, Date date) {
        super(name, size, date);
    }

    public void open(){
        System.out.println("Audio file was opened.");
    }
    public void close(){
        System.out.println("Audio file was closed.");
    }
}
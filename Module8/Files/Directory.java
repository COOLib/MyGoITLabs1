package Files;

import java.util.ArrayList;
import java.util.Date;

public class Directory {

    private String name;
    private Date date;
    private ArrayList<File> files = new ArrayList<File>();

    public void addFiles() {
      //  files.add(new AudioFile("AudioFile", 20000, new Date()));
        files.add(new TextFile("TextFile", 5000, new Date()));
        files.add(new Picture("Picture", 150000, new Date()));
    }
    public Directory(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public boolean isEmpty(){return false;}

    public ArrayList<String> namesOfContainedFiles(){
        ArrayList<String> names = new ArrayList<String>();
        for (File file : files)
            names.add(file.getName());
        return names;
    }
}
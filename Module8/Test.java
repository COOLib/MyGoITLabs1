import Files.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        AudioFile file = new AudioFile("AudioFile", 24500, new Date());
        //CollectionPrinter.printObject(file);
        ArrayList<File> fileArray = new ArrayList<File>();
        fileArray.add(new AudioFile("AudioFile", 24500, new Date()));
       // CollectionPrinter.printObject(fileArray.get(0));
        fileArray.add(new TextFile("TextFile", 5000, new Date()));
        fileArray.add(new TextFile("TextFile2", 500, new Date()));
        fileArray.add(new AudioFile("AudioFile2", 20000, new Date()));
        fileArray.add(new Picture("Picture", 150000, new Date()));

        Directory d = new Directory("Simple directory", new Date(), 2000);

        d.addFiles();

        ArrayList<Directory> dirArray = new ArrayList<Directory>();

       dirArray.add(new Directory("Simple directory", new Date()));
       dirArray.add(new Directory("Simple directory", new Date()));
       dirArray.add(new Directory("Simple directory", new Date()));

        CollectionPrinter.printCollection(dirArray);


        CollectionPrinter.printObject(d);
       // CollectionPrinter.printCollection(d.getFiles());
        */
    }
}

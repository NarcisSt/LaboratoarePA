package EntityClasses;

import EntityClasses.Entities.Book;
import EntityClasses.Entities.Song;
import Optional.Errors.IncorrectPathException;

public class Main {
    public static void main(String[] args) throws IncorrectPathException {
        Catalog catalog =  new Catalog();

        Book book = new Book("Ion", "C:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\Ion.txt", "232414");

        Song song = new Song("Bambolina",
                            "C:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\y2mate.com - KILLA FONIC feat. Carla’s Dreams - Bambolina _ Official Video_ppFIcp4jfMw.mp3",
                                "Killa Fonic");


        catalog.add(book);
        catalog.add(song);

        catalog.save("C:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\save.txt");
        catalog.play(book);
        catalog.play(song);

//        catalog.load("Z:\\Users\\Narcis\\OneDrive\\Desktop\\Lab5PA\\save.txt");
    }
}

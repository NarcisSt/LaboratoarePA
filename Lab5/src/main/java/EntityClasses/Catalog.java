package EntityClasses;

import EntityClasses.Entities.BaseItem;
import Optional.Errors.IncorrectPathException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Catalog class contains a list of items, and the actions applicable to that items.
 */
public class Catalog {
    List<BaseItem> items = new ArrayList<>();

    /**
     * Method that add a new item in the catalog
     *
     * @param baseItem is an item
     */
    public void add(BaseItem baseItem) {
        items.add(baseItem);
    }

    /**
     * Method that lists all the items from the catalog
     */
    public void list() {
        for (BaseItem baseItem : items) {
            System.out.println(baseItem);
        }
    }

    /**
     * Method that plays an item from the catalog
     *
     * @param baseItem is an item
     */
    public void play(BaseItem baseItem) {
        if (items.contains(baseItem)) {
            try {
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                desktop.open(new File(baseItem.getPath()));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * This method saves the entire catalog in a file
     *
     * @param savePath the path to the file we want to save the catalog in
     */
    public void save(String savePath) throws IncorrectPathException {

        try {
            FileOutputStream f = new FileOutputStream(savePath);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (BaseItem baseItem : items) {
                o.writeObject(baseItem);
            }

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new IncorrectPathException("Incorrect path");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    /**
     * This method loads the catalog from a file
     *
     * @param loadPath the path to the file we want to load the catalog from
     */
    public void load(String loadPath) throws IncorrectPathException {
        try {

            FileInputStream fis = new FileInputStream(loadPath);
            try (ObjectInputStream input = new ObjectInputStream(fis)) {
                while (input.readObject() != null) {
                    BaseItem obj = (BaseItem) input.readObject();
                    items.add(obj);
                    System.out.println(obj.toString());
                }
            } catch (FileNotFoundException e) {
                throw new IncorrectPathException("Incorrect path");
            } catch (EOFException e) {
                return;
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException | IncorrectPathException e) {
            throw new IncorrectPathException("Incorrect path");
        }
    }
}

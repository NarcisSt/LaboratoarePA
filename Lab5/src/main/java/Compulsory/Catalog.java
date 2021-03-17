package Compulsory;

import Compulsory.Entities.BaseItem;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<BaseItem> items = new ArrayList<>();

    public void add(BaseItem baseItem) {
        items.add(baseItem);
    }

    public void list() {
        for (BaseItem baseItem : items) {
            System.out.println(baseItem);
        }
    }

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

    public void save(String savePath) {
        try {
            FileOutputStream f = new FileOutputStream(savePath);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (BaseItem baseItem : items) {
                o.writeObject(baseItem);
            }

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void load(String loadPath) {
        try {

            FileInputStream fis = new FileInputStream(loadPath);
            boolean cont = true;
            while (cont) {
                try (ObjectInputStream input = new ObjectInputStream(fis)) {
                    BaseItem obj = (BaseItem) input.readObject();
                    if (obj != null) {
                        items.add(obj);
                    } else {
                        cont = false;
                    }
                } catch (IOException e) {
                    System.out.println("Error initializing stream");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

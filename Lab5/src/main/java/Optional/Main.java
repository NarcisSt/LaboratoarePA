package Optional;

import Optional.Errors.IncorrectCommandException;
import Optional.Errors.IncorrectPathException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IncorrectCommandException, IncorrectPathException {

        Catalog catalog = new Catalog();

        catalog.start();
    }
}

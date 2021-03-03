package OptionalAndBonus;

/**
 * Class for Factories, that extends the Source class, with setter and getter and a constructor.
 */

public class Factory extends Source{

    /**
     * Constructor to give a name to a warehouse.
     *
     * @param name name of the factory
     */
    public Factory(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

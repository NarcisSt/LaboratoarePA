package OptionalAndBonus;

/**
 * Class for Warehouses, that extends the Source class, with setter and getter and a constructor.
 */

public class Warehouse extends Source {

    /**
     * Constructor to give a name to a warehouse.
     *
     * @param name name of the warehouse
     */
    public Warehouse(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

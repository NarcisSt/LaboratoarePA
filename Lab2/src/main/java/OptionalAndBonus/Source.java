package OptionalAndBonus;

/**
 * The Source class describes the sources, this class extends the Factory and Warehouse classes, so an object of type Source can have a name and can be a Factory or a Warehouse.
 */

public abstract class Source {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)) {
            return false;
        }
        Source other = (Source) obj;
        return name.equals(other.name);
    }

}

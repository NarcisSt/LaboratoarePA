package EntityClasses;

/**
 * @author Barat Narcis Stefan
 * In this class i am defying the Sources, with the appropiate setters, getters and constructors.
 */

public class Source {

    private String name;
    private SourceType type;

    public String getName() {
        return name;
    }

    public SourceType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public Source() { }

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}


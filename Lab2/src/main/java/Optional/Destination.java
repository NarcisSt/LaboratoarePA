package Optional;

import java.util.Objects;

public class Destination {

    private String name;

    public Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) obj;
        return name.equals(other.name);
    }

}

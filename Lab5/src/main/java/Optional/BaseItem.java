package Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
/**
 * The Class BaseItem, which is an abstract class that contains the common properties of an item. It implements the Serializable interface.
 */
public class BaseItem implements Serializable {
    private String name;
    private String path;
}

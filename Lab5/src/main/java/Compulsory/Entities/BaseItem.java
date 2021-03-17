package Compulsory.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseItem implements Serializable {
    private String name;
    private String path;
    private static final long serialVersionUID = 1L;
}

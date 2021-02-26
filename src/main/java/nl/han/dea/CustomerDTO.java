package nl.han.dea;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private String name;
    private Integer id;

    public CustomerDTO(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public CustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

package tiger.com.mrxjava;

import java.io.Serializable;

/**
 * Created by Tiger on 2016/7/23.
 */
public class Student implements Serializable {

    public Student(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

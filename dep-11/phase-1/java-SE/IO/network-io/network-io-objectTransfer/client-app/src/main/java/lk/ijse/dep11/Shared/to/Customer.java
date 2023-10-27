package lk.ijse.dep11.Shared.to;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Customer implements Serializable {
    private String id;
    private String name;
    private  String address;
}

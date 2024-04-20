package ceing.ceing.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Data
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){}

    public Item(String itemName , Integer price , Integer quantity){
        this.itemName= itemName;
        this.price = price;
        this.quantity=quantity;
    }
}

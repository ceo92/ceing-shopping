package ceing.ceing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private Long id;
    private String itemName;
    private ItemSize itemSize;
    private Integer price;
    private Integer quantity;

    public Item(){}

    public Item(String itemName , Integer price , Integer quantity){
        this.itemName= itemName;
        this.price = price;
        this.quantity=quantity;
    }
}

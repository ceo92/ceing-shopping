package ceing.ceing.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    private String itemName;
    private ItemSize itemSize;
    private int price;
    private int stockQuantity;

    public Item(){}

    public Item(String itemName , int price , int stockQuantity){
        this.itemName= itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}

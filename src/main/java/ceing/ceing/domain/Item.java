package ceing.ceing.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    private int price;
    private int stockQuantity; //관리자 설정
    private double averageRate; //평균 별점
    //한 상품에는 여러 리뷰를 쓸 수 있음 즉 리뷰가 N이고 상품은 1

    private String detail; //상품 설명

    @OneToMany(mappedBy = "item") //이런 식으로 값 타입 컬렉션이 아닌 연관관계 엔티티를 만들어서 양방향으로 List로 받자 !
    private List<ItemSize> itemSizes = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Color> color = new ArrayList<>();


    private String washingTip; //Dry Cleaning!

    private String fabric; //Cotton 100%

    // 한 브랜드(1)는 여러 아이템(N)을 가질 수 있고, 한 아이템은 한 브랜드에게만 소속됨.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;




    //한 상품에는 여러 ItemSize가 할당됨
    // 즉 ItemSize가 N , 상품이 1


    public Item(){}

    public Item(String itemName , int price , int stockQuantity){
        this.itemName= itemName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}

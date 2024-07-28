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
    private String name;
    private int price;
    private int stockQuantity; //관리자 설정
    //한 상품에는 여러 리뷰를 쓸 수 있음 즉 리뷰가 N이고 상품은 1

    private String content; //상품 설명
    
    private String washingTip; //Dry Cleaning!


    private String fabric; //Cotton 100%


    //한 팀은 여러 회원 갖고 , 한 회원은 한 팀에게만 소속됨 이때 1이 팀이고 N이 회원이므로 N이 연관관계 주인 즉 Member이 주인이 됨
    //한 옷은 여러 칼라들을 갖고 한 칼라는 한 옷에만 할당됨 , 즉 칼라가 N이고 ManyToOne이 됨
    @OneToMany(mappedBy = "item")
    private List<Color> colors = new ArrayList<>(); //남색 , 파란색 , 초록색 , ... , 등록자가 임의의 단일 값을 넣어주면 되므로

    // 한 브랜드(1)는 여러 아이템(N)을 가질 수 있고, 한 아이템은 한 브랜드에게만 소속됨.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand; // 한 상품은 한 브랜드에게 소속됨 , 한 브랜드(1)는 여러 상품(N)을 찍어낼 수 잇음
    //한 팀은 여러 멤버들을 가짐

    //사이즈를 실제로 한 row에서 여러 개를 갖지 않고 한 사이즈만 가지니까 enum이지 정의 틀만 가지면 되니 enum
    @Enumerated(value = EnumType.STRING)
    private ItemSizeConst itemSize;

    //DB에선 컬렉션을 다룰 수 없음 => 즉 다중 값을 갖는 테이블과 따로 엔티티 뽑아서 연관관계 맺으면 됨 , @ElementCollection은 쓰면 안 되므로 !


    public Item(){}

    public Item(String name, int price , int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}

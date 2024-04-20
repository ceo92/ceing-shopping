package ceing.ceing.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/*
@Entity
@Getter @Setter
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; //UID392RK
    //주문 상태(주문 대기, 주문 완료  , 배송 중 , 배송 완료)
    private String orderStatus;
    //주문 날짜
    private LocalDateTime orderDate;

    //도착 예정 날짜?
    private LocalDateTime arriveDate;

    public Order(){}
}
*/

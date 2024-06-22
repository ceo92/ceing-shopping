package ceing.ceing.domain;

import ceing.ceing.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Getter @Setter(AccessLevel.PRIVATE)
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long id; //UID392RK
    //주문 상태(주문 대기, 주문 완료  , 배송 중 , 배송 완료)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    //주문 날짜
    private LocalDateTime orderDate;

    //도착 예정 날짜?
    private LocalDateTime arriveDate;

    public Order(){}
}

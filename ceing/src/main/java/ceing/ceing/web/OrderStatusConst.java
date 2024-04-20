package ceing.ceing.web;

public enum OrderStatusConst {

    ORDER_WAITING(1) , ORDER_SUCCESS(2) , DELIVERING(3) , DELIVER_SUCCESS(4);
    private final int orderStatus;


    OrderStatusConst(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}

package ceing.ceing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private GenderConst gender; //성별 정보

    public Member(String name, Address address, String phoneNumber, String loginId, String password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loginId = loginId;
        this.password = password;
    }

    /**
     * 로그인 필드
     */
    private String loginId;
    private String password;


    /**
     * Member 설정자 초기화 메서드
     */
    public void changeMemberInfo(String name , Address address , String phoneNumber){
        this.name=name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void changePassword(){

    }

    public Member(){}






}

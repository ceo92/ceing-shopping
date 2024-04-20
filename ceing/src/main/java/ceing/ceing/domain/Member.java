package ceing.ceing.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String username;
    private String address;
    private String phoneNumber;
    private String loginId;
    private String password;

    public Member(){}



    public Member(String username , String address , String phoneNumber , String loginId , String password){
        this.username = username;
        this.address=address;
        this.phoneNumber = phoneNumber;
        this.loginId = loginId;
        this.password = password;
    }


}

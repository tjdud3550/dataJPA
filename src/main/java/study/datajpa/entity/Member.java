package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter

public class Member {

    @Id @GeneratedValue //식별자인식, pk가 자동입력
    private  Long id;
    private  String username;

    protected Member(){

    }//기본생성자 하나는 있어야한다.
    public Member(String username){
        this.username = username;

    }

}

package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NamedQuery(
        name="Member.findByUsername",
        query="select m from Member m where m.username = :username")

@NoArgsConstructor(access = AccessLevel.PROTECTED) //access 레벨 알아두기
@ToString(of = {"id","username", "age"}) //team 적으면 안된다. 연관관계 문제생김
public class Member {

    @Id @GeneratedValue //식별자인식, pk가 자동입력
    @Column(name = "member_id")
    private  Long id;
    private  String username;
    private int age;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }
    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team){
        this.username = username;
        this.age  = age;
        if(team !=null){
            changeTeam(team);
        }


    }
    //연관관계 세팅 메소드
    public void changeTeam (Team team){
        this.team = team;
        team.getMembers().add(this);
    }

}

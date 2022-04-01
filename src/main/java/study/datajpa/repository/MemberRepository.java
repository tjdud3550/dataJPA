package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByUsernameAndGreaterThan (String username, int age);
    // 길어지면 답이 없음

   // @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username =:username and m.age=:age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    //jpql를 바로 인터페이스에 작성가능하다



}


    //findBy 조건이 없으면 전체 조회


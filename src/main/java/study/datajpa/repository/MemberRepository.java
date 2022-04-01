package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByUsernameAndGreaterThan (String username, int age);
    // 길어지면 답이 없음

   // @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username =:username and m.age=:age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    //jpql를 바로 인터페이스에 작성가능하다

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new study.data-jpa.dto.MemberDto(m.id, m.username, t.name) " +
            "from Member m join m.team t")
    List<MemberDto> findMemberDto();
    //new 객체 생성하는 것 처럼.. dto 를 반환

    @Query("select m from Member m where m.username in :names")
    List <Member> findByNames(@Param("names") List<String> names);

    List<Member> findListByUsername(String name); //컬렉션
    Member findMemberByUsername(String name); //단건
    Optional<Member> findOptionalByUsername(String name); //단건 Optional


    Page <Member> findByAge(int age, Pageable pageable);

    @Modifying(clearAutomatically = true) //clear 과정 자동으로 해준다.
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);



}


    //findBy 조건이 없으면 전체 조회


package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamJpaRepository {

    @PersistenceContext
    private EntityManager em;

    //기본적인 crud

    public Team save(Team team){
        em.persist(team);
        return  team;

    }

    public void delete(Team team) {em.remove(team);}

    public List<Team> findAll(){
        return em.createQuery("select t from Team t",Team.class)
                .getResultList();
    }
    public Optional<Team> findById(Long id){
        Team team = em.find(Team.class  ,id);
        return Optional.ofNullable(team); //null 일수도 잇다.

    }

    public long count(){
        return em.createQuery("select count(t) from Team t", Long.class)
                .getSingleResult();
    }



}

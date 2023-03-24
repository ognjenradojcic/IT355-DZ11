package com.metropolitan.repository;

import com.metropolitan.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member update(Member member) {
        return entityManager.merge(member);
    }

    @Override
    public int delete(int memberId) {
        return entityManager.createQuery("delete from Member m where m.id=:memberId")
                .setParameter("memberId", memberId)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Member> listMembers() {
        Query query = entityManager.createQuery("select m from Member m", Member.class);
        return query.getResultList();
    }

    @Override
    public Member getById(int memberId) {
        return entityManager.find(Member.class, memberId);
    }
}

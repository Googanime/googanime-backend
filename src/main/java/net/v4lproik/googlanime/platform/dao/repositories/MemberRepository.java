package net.v4lproik.googlanime.platform.dao.repositories;

import net.v4lproik.googlanime.platform.dao.api.MemberDao;
import net.v4lproik.googlanime.platform.service.api.entities.Member;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends AbstractRepository implements MemberDao {

    private static final Logger log = LoggerFactory.getLogger(MemberRepository.class);

    public final SessionFactory sessionFactory;

    @Autowired
    public MemberRepository(final SessionFactory sessionFactory) {
        super(Member.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Member save(Member member) {
        Transaction tx = currentSession().beginTransaction();

        Integer idSave = Integer.parseInt(currentSession().save(member).toString());

        currentSession().flush();
        tx.commit();

        return new Member(new Long(idSave));
    }

    @Override
    public void delete(Long id) {
        Transaction tx = currentSession().beginTransaction();

        currentSession().delete(id.toString(), Member.class);

        currentSession().flush();
        tx.commit();
    }

    @Override
    public Member findById(Long id) {
        Transaction tx=currentSession().beginTransaction();
        Member member = (Member) sessionFactory.getCurrentSession().get(Member.class, id);
        tx.commit();

        return member;
    }

    @Override
    public Member find(String email) {
        return (Member) getBySimpleCondition(Member.class, "email", email);
    }
}

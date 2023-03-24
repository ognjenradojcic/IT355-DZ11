package com.metropolitan.repository;

import com.metropolitan.domain.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Player player) {
        entityManager.persist(player);
    }

    @Override
    public Player update(Player player) {
        return entityManager.merge(player);
    }

    @Override
    public int delete(int playerId) {
        return entityManager.createQuery("delete from Player p where p.id=:playerId")
                .setParameter("playerId", playerId)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Player> listPlayers() {
        Query query = entityManager.createQuery("select p from Player p", Player.class);
        return query.getResultList();
    }

    @Override
    public Player getById(int playerId) {
        return entityManager.find(Player.class, playerId);
    }
}

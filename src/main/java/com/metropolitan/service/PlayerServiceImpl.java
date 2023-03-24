package com.metropolitan.service;

import com.metropolitan.domain.Member;
import com.metropolitan.domain.Player;
import com.metropolitan.repository.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    @Transactional
    public void add(Player player) {
        playerDao.add(player);
    }


    @Override
    @Transactional
    public int remove(int playerId) {
        return playerDao.delete(playerId);
    }

    @Override
    @Transactional
    public List<Player> list() {
        return playerDao.listPlayers();
    }

    @Override
    @Transactional
    public Player update(Player player) {
        return playerDao.update(player);
    }

    @Override
    @Transactional
    public Player getPlayerById(int id) {
        return playerDao.getById(id);
    }
}

package com.metropolitan.repository;

import com.metropolitan.domain.Member;
import com.metropolitan.domain.Player;

import java.util.List;

public interface PlayerDao {
    void add(Player player);

    List<Player> listPlayers();

    Player update(Player player);

    int delete(int playerId);


    Player getById(int playerId);
}

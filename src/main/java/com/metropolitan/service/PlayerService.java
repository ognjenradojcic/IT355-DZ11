package com.metropolitan.service;

import com.metropolitan.domain.Member;
import com.metropolitan.domain.Player;

import java.util.List;

public interface PlayerService {
    void add(Player player);

    int remove(int playerId);

    Player update(Player player);

    List<Player> list();

    Player getPlayerById(int id);
}

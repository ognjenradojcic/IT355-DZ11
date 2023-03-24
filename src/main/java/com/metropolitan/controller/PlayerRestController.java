package com.metropolitan.controller;

import com.metropolitan.domain.Player;
import com.metropolitan.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerRestController {
    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/players")
    public List<Player> playerList() {
        return playerService.list();
    }

    @GetMapping("/players/{id}")
    public ResponseEntity getPlayer(@PathVariable("id") int id) {
        Player player = playerService.getPlayerById(id);

        if (player == null) {
            return new ResponseEntity("No player found for id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(player, HttpStatus.OK);
    }


    @PostMapping("/players")
    public ResponseEntity createPlayer(@RequestBody Player player) {
        playerService.add(player);

        return new ResponseEntity(player, HttpStatus.OK);
    }


    @DeleteMapping(value = "/players/{id}")
    public ResponseEntity removePlayer(@PathVariable("id") int playerId) {
        if (playerService.remove(playerId) == 0) {
            return new ResponseEntity("No player found for id: " + playerId, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(playerId, HttpStatus.OK);
    }


    @PutMapping("/players/{id}")
    public ResponseEntity updatePlayer(@PathVariable("id") int playerId, @RequestBody Player player) {
        player.setId(playerId);
        if (playerService.update(player) == null) {
            return new ResponseEntity("No player found for id: " + playerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(player, HttpStatus.OK);
    }
}

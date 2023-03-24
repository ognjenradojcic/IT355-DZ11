/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.controller;

import com.metropolitan.domain.Member;
import com.metropolitan.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Vlada
 */

@RestController
public class MemberRestController {

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members")
    public List<Member> memberList() {
        return memberService.list();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity getMember(@PathVariable("id") int id) {
        Member member = memberService.getMemberById(id);

        if (member == null) {
            return new ResponseEntity("No member found for id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(member, HttpStatus.OK);
    }


    @PostMapping("/members")
    public ResponseEntity createMember(@RequestBody Member member) {
        memberService.add(member);

        return new ResponseEntity(member, HttpStatus.OK);
    }


    @DeleteMapping(value = "/members/{id}")
    public ResponseEntity removeMember(@PathVariable("id") int memberId) {
        if (memberService.remove(memberId) == 0) {
            return new ResponseEntity("No member found for id: " + memberId, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(memberId, HttpStatus.OK);
    }


    @PutMapping("/members/{id}")
    public ResponseEntity updateMember(@PathVariable("id") int memberId, @RequestBody Member member) {
        member.setId(memberId);
        if (memberService.update(member) == null) {
            return new ResponseEntity("No member found for id: " + memberId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(member, HttpStatus.OK);
    }
}


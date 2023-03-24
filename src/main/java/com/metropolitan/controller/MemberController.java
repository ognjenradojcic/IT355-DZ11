/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.controller;

import com.metropolitan.domain.Member;
import com.metropolitan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vlada
 */

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/memberList")
    public String memberList(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }


    @PostMapping("/memberList")
    public String addMember(@ModelAttribute(name = "member") Member member, Model model) {
        memberService.add(member);
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }

    @PostMapping(value = "/remove")
    public String removeMember(@RequestParam("memberId") int memberId, Model model) {
        memberService.remove(memberId);
//

        return "redirect:/memberList";
    }

    @GetMapping(value = "/memberEdit")
    public String memberEditInit(@RequestParam("memberId") int memberId, Model model) {
        Member member = memberService.getMemberById(memberId);

        model.addAttribute("member", member);

        return "memberEdit";
    }

    @PostMapping("/memberEdit")
    public String editMember(@ModelAttribute(name = "member") Member member, @RequestParam("memberId") int memberId, Model model) {
        memberService.update(member);
        return "redirect:/memberList";
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.domain.Member;

import java.util.List;

/**
 *
 * @author Vlada
 */
public interface MemberService {

    void add(Member member);

    int remove(int memberId);

    Member update(Member member);

    List<Member> list();

    Member getMemberById(int id);

}

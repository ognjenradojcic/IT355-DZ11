/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.domain.Member;
import com.metropolitan.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vlada
 */
@Service
class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    private Map<String, Member> members = new TreeMap<>();


    @Override
    @Transactional
    public void add(Member member) {
        memberDao.add(member);
    }


    @Override
    @Transactional
    public int remove(int memberId) {
        return memberDao.delete(memberId);
    }

    @Override
    @Transactional
    public List<Member> list() {
        return memberDao.listMembers();
    }

    @Override
    @Transactional
    public Member update(Member member) {
        return memberDao.update(member);
    }

    @Override
    @Transactional
    public Member getMemberById(int id) {
        return memberDao.getById(id);
    }
}

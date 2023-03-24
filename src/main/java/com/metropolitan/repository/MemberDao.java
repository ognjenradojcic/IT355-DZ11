package com.metropolitan.repository;

import com.metropolitan.domain.Member;

import java.util.List;

public interface MemberDao {
    void add(Member member);

    List<Member> listMembers();

    Member update(Member member);

    int delete(int memberId);


    Member getById(int memberId);
}

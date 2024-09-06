package kr.or.nextit.springmvc.member;

import java.util.List;

public interface MemberMapper {
    List<MemberDTO> selectMembers();
    MemberDTO selectMember(String id);
    int insertMember(MemberDTO member);
    int updateMember(MemberDTO member);
    int deleteMember(String id);
}

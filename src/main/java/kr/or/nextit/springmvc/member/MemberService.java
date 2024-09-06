package kr.or.nextit.springmvc.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    public List<MemberDTO> selectMembers() {
        return mapper.selectMembers();
    }

    public MemberDTO selectMember(String id) {
        return mapper.selectMember(id);
    }

    public int insertMember(MemberDTO member) {
        return mapper.insertMember(member);
    }

    public int updateMember(MemberDTO member) {
        return mapper.updateMember(member);
    }

    public int deleteMember(String id) {
        return mapper.deleteMember(id);
    }
}

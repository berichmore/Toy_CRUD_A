package board.crud.member.dao;


import board.crud.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

    //id로 조회 (로그인 겸용)
    Member selectMemberById(String id);

    //회원 가입에서 등록
    void insertMember(Member member);

    //회원 정보 수정
    void updateMember(Member member);

    //회원 삭제
    void deleteMember(String id);


}

package board.crud.bbs.mapper;


import board.crud.bbs.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    //id로 조회 (로그인 겸용)
    MemberVO selectMemberId(String id);

    //회원 가입에서 등록
    void insertMember(MemberVO memberVO);

    //회원 정보 수정
    void updateMember(MemberVO memberVO);

    //회원 삭제
    void deleteMember(String id);


}

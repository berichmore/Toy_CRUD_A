package board.crud.bbs.service;

import board.crud.bbs.domain.Bbs;
import board.crud.bbs.dao.BbsDao;
import board.crud.bbs.dto.request.CreateBbsRequest;
import board.crud.bbs.dto.request.UpdateBbsRequest;
import board.crud.bbs.dto.response.BbsResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BbsServiceImpl implements BbsService{

    private final BbsDao bbsDao;

    public BbsServiceImpl(BbsDao bbsDao){
        this.bbsDao = bbsDao;
    }


    @Override
    public Map<String, Object> getBbsListWithCount(int page, int size) {
        int offset = (page - 1) * size;
        List<Bbs> list = bbsDao.selectBbsListPaging(offset, size);
        int count = bbsDao.selectBbsCount();

        List<BbsResponse> resultList = list.stream()
                .map(BbsResponse::new)
                .collect(Collectors.toList());
        Map<String, Object> result = new HashMap<>();
        result.put("bbsList", resultList);
        result.put("totalCount", count);
        return result;
    }

    @Override
    public List<BbsResponse> searchBbs(String type, String keyword) {
        return  bbsDao.searchBbs(type, keyword)
                .stream()
                .map(BbsResponse::new)
                .collect(Collectors.toList());

    }


    @Override
    public BbsResponse getBbsBySeq(int seq) {
        Bbs bbs = bbsDao.selectBbsBySeq(seq);
        return new BbsResponse(bbs);
    }

    @Override
    public void registerBbs(CreateBbsRequest request, String writerId) {
        Bbs bbs = new Bbs();
        bbs.setTitle(request.getTitle());
        bbs.setContent(request.getContent());
        bbs.setId(writerId);
        bbs.setDel(0);
        bbs.setReadCount(0);

        bbsDao.insertBbs(bbs);
        bbsDao.updateRef(bbs.getSeq());
    }

    @Override
    public void modifyBbs(UpdateBbsRequest request, String writerId) {
        Bbs origin = bbsDao.selectBbsBySeq(request.getSeq());

        if (origin == null){
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        if (!origin.getId().equals(writerId)){
            throw new SecurityException("작성자만 수정할 수 있습니다.");
        }

        origin.setTitle(request.getTitle());
        origin.setContent(request.getContent());

        bbsDao.updateBbs(origin);


    }

    @Override
    public void removeBbs(int seq, String requestUserId) {
        Bbs origin = bbsDao.selectBbsBySeq(seq);

        if(origin == null){
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        if(!origin.getId().equals(requestUserId)){
            throw new SecurityException("작성자만 삭제할 수 있습니다.");
        }

        bbsDao.deleteBbs(seq);

    }

    @Override
    public void increaseReadCount(int seq) {
        bbsDao.increaseReadCount(seq);

    }
}
//public BbsServiceImpl(BbsDao bbsDao) {
//    this.bbsDao = bbsDao;
//}
//
//@Override
//public List<Bbs> getBbsList(int size, int page) {
//    //페이지가 1부터 들어온다고 가정할 때,
//    int offset = (page - 1) * size;
//    //mybatis mapper 호출
//    return bbsDao.selectBbsListPaging(offset, size);
//}
//
//@Override
//public Bbs getBbsById(String id) {
//    return bbsDao.selectBbsById(id);
//}
//
////회원찾기
//public Bbs findBbsBySeq(int seq) {
//    return bbsDao.selectBbsBySeq(seq);
//}
//
//@Override
//public int getTotalCount() {
//    return bbsDao.selectBbsCount();
//}
//
//
//@Override
//public Bbs getBbsBySeq(int seq) {
//    return bbsDao.selectBbsBySeq(seq);
//}
//
//@Override
//public void registerBbs(Bbs bbs) {
//    bbsDao.insertBbs(bbs);
//    updateRef(bbs.getSeq());
//
//}
//
//@Override
//public void updateRef(int seq) {
//    bbsDao.updateRef(seq);
//}
//
//@Override
//public void modifyBbs(Bbs bbs) {
//    bbsDao.updateBbs(bbs);
//}
//
//@Override
//public void removeBbs(int seq) {
//    bbsDao.deleteBbs(seq);
//}
//
//@Override
//public void increaseReadCount(int seq) {
//    bbsDao.increaseReadCount(seq);
//}
//
//@Override
//public List<Bbs> searchBbs(String type, String keyword) {
//    return bbsDao.searchBbs(type, keyword);
//}
//

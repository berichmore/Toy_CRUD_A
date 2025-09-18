package board.crud.bbs.service;


import board.crud.bbs.dao.BbsDao;
import board.crud.bbs.domain.Bbs;
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
        List<BbsResponse> dtoList = list.stream().map(BbsResponse::new).collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("bbsList", dtoList);
        result.put("totalCount", count);
        return result;
    }

    @Override
    public List<BbsResponse> searchBbs(String type, String keyword) {
        return bbsDao.searchBbs(type, keyword).stream()
                .map(BbsResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public BbsResponse getBbsBySeq(int seq) {
        Bbs bbs = bbsDao.selectBbsBySeq(seq);
        return new BbsResponse(bbs);
    }

    @Override
    public void registerBbs(CreateBbsRequest createRequest, String writerId) {
        Bbs registerBbs = new Bbs();
        registerBbs.setTitle(createRequest.getTitle());
        registerBbs.setContent(createRequest.getContent());
        registerBbs.setId(writerId);
        registerBbs.setDel(0);
        bbsDao.insertBbs(registerBbs);
        bbsDao.updateRef(registerBbs.getSeq());
    }

    @Override
    public void modifyBbs(UpdateBbsRequest modifyRequest, String writerId) {
        Bbs origin = bbsDao.selectBbsBySeq(modifyRequest.getSeq());
        if(origin == null) throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        if (!origin.getId().equals(writerId)) throw new SecurityException("작성자만 수정할 수 있습니다.");
        origin.setTitle(modifyRequest.getTitle());
        origin.setContent(modifyRequest.getContent());
        bbsDao.updateBbs(origin);
    }

    @Override
    public void removeBbs(int seq, String requestUserId) {
        Bbs origin = bbsDao.selectBbsBySeq(seq);
        if(origin == null) throw new IllegalArgumentException("게시글이 존재하지 않습니다");
        if(!origin.getId().equals(requestUserId)) throw new SecurityException("작성자만 삭제할 수 있습니다.");
        bbsDao.deleteBbs(seq);
    }

    @Override
    public void increaseReadCount(int seq) {
        bbsDao.increaseReadCount(seq);

    }
}

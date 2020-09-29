package com.mxc.service;

import com.isyscore.isc.neo.NeoMap;
import com.isyscore.isc.neo.db.NeoPage;
import com.mxc.dao.WorldDao;
import com.mxc.transfer.WorldTransfer;
import com.mxc.domain.WorldDO;
import com.mxc.web.vo.Pager;
import com.mxc.web.vo.PagerRsp;
import com.mxc.web.vo.req.*;
import com.mxc.web.vo.rsp.WorldQueryRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author robot
 */
@Service
public class WorldService {

    @Autowired
    private WorldDao dao;

    public Integer insert(WorldInsertReq insertReq) {
        dao.insert(WorldTransfer.insertReqToEntity(insertReq));
        return 1;
    }

    public Integer delete(Long id) {
        return dao.delete(id);
    }

    public Integer update(WorldUpdateReq updateReq) {
        dao.update(WorldTransfer.updateReqToEntity(updateReq));
        return 1;
    }

    public PagerRsp<List<WorldQueryRsp>> pageList(Pager<WorldQueryReq> pageReq) {
        PagerRsp<List<WorldQueryRsp>> pagerRsp = new PagerRsp<>();

        NeoMap searchMap = NeoMap.from(pageReq.getParam());
        NeoPage page = NeoPage.of(pageReq.getPageNo(), pageReq.getPageSize());

        List<WorldQueryRsp> queryRspList = dao.page(WorldDO.class, searchMap, page).stream().map(WorldTransfer::entityToQueryRsp).collect(Collectors.toList());

        pagerRsp.setDataList(queryRspList);
        pagerRsp.setTotalNum(dao.count(pageReq.getParam()));
        return pagerRsp;
    }
}

package com.mxc.transfer;

import com.mxc.domain.WorldDO;
import com.mxc.web.vo.req.WorldInsertReq;
import com.mxc.web.vo.req.WorldUpdateReq;
import com.mxc.web.vo.rsp.WorldQueryRsp;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

/**
 * @author robot
 */
@UtilityClass
public class WorldTransfer {

    public WorldDO insertReqToEntity(WorldInsertReq req) {
        WorldDO entity = new WorldDO();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    public WorldDO updateReqToEntity(WorldUpdateReq req) {
        WorldDO entity = new WorldDO();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    public WorldQueryRsp entityToQueryRsp(WorldDO entity) {
        WorldQueryRsp rsp = new WorldQueryRsp();
        BeanUtils.copyProperties(entity, rsp);
        return rsp;
    }
}

package com.mxc.web.controller;

import com.isyscore.isc.mikilin.annotation.AutoCheck;
import com.mxc.service.WorldService;
import com.mxc.web.vo.Pager;
import com.mxc.web.vo.PagerRsp;
import com.mxc.web.vo.req.WorldInsertReq;
import com.mxc.web.vo.req.WorldQueryReq;
import com.mxc.web.vo.req.WorldUpdateReq;
import com.mxc.web.vo.rsp.WorldQueryRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author robot
 */
@AutoCheck
@RequestMapping("${api-prefix}/world")
@RestController
public class WorldController {

    @Autowired
    private WorldService worldservice;

    @PostMapping("add")
    public Integer add(@RequestBody WorldInsertReq insertReq) {
        return worldservice.insert(insertReq);
    }

    @DeleteMapping("delete/{id}")
    public Integer delete(@PathVariable Long id) {
        return worldservice.delete(id);
    }

    @PutMapping("update")
    public Integer update(@RequestBody WorldUpdateReq updateReq) {
        return worldservice.update(updateReq);
    }

    @PostMapping("getPage")
    public PagerRsp<List<WorldQueryRsp>> pageList(@RequestBody Pager<WorldQueryReq> pageReq) {
        return worldservice.pageList(pageReq);
    }
}

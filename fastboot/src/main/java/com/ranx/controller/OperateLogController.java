package com.ranx.controller;


import com.ranx.common.request.QueryReq;
import com.ranx.common.result.PagingDto;
import com.ranx.common.result.ResultT;
import com.ranx.model.dto.OperateLogDto;
import com.ranx.model.req.OperateLogReq;
import com.ranx.service.FundRestService;
import com.ranx.service.OperateLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 操作日志
 */
@RestController
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @Autowired
    private FundRestService fundRestService;

    @PostMapping("/queryPage")
    @ApiOperation("分页查询")
    public ResultT<PagingDto<List<OperateLogDto>>> queryPage(@RequestBody @Validated QueryReq queryReq) {
        return operateLogService.queryPage(queryReq);
    }


    @ApiOperation(value="新增操作日志",notes = "新增操作日志")
    @PostMapping("/saveup")
    public ResultT insertOperateLog(@RequestBody OperateLogReq operateLogReq){
        operateLogReq = new OperateLogReq();
        operateLogReq.setMemberId(1L);
        operateLogReq.setLogContent("Test");
        operateLogReq.setType(1);
        operateLogService.insertOperateLog(operateLogReq);

        List<OperateLogReq> OperateLogReqs = new ArrayList<>();
        OperateLogReqs.add(operateLogReq);
        operateLogService.insertOperateLogBatch(OperateLogReqs);

        operateLogReq.setId(2L);
        operateLogReq.setLogContent("Test Up");
        OperateLogReqs.add(operateLogReq);
        operateLogService.updateOperateLogBatch(OperateLogReqs);

//        fundRestService.fundGet(operateLogReq);
//        fundRestService.fundDailyStat(operateLogReq);

        fundRestService.saveToken(2L);
        return ResultT.success();
    }
}

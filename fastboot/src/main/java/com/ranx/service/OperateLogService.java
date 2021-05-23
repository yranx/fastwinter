package com.ranx.service;

import com.ranx.common.request.QueryReq;
import com.ranx.common.result.ResultT;
import com.ranx.model.req.OperateLogReq;

import java.util.List;

/**
 * @description: 操作日志服务接口
 * @author:
 * @date: 2021年5月11日09:39:46
 */
public interface OperateLogService {

    /**
     * 分页查询
     */
    ResultT  queryPage(QueryReq queryReq);

    /**
     * 新增操作日志
     * @param OperateLogReq
     * @return
     */
    ResultT<Long> insertOperateLog(OperateLogReq OperateLogReq);

    /**
     * @Description 批量新增操作日志
     */
    ResultT<Boolean> insertOperateLogBatch(List<OperateLogReq> OperateLogReqs);

    /**
     * @Description 批量更新操作日志
     */
    ResultT<Boolean> updateOperateLogBatch(List<OperateLogReq> OperateLogReqs);
}

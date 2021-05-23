package com.ranx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ranx.common.request.QueryReq;
import com.ranx.common.result.PagingDto;
import com.ranx.common.result.ResultT;
import com.ranx.config.AccessTokenConfig;
import com.ranx.mapper.base.OperateLogMapper;
import com.ranx.mapstruct.OperateLogConvert;
import com.ranx.model.Do.OperateLogDo;
import com.ranx.model.Do.OperateLogDoExample;
import com.ranx.model.dto.OperateLogDto;
import com.ranx.model.req.OperateLogReq;
import com.ranx.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Value("${spring.profiles.active}")
    private  String  currentPro;

    @Autowired
    private AccessTokenConfig accessTokenConfig;


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    @Override
    public ResultT<List<OperateLogDto>> queryPage(QueryReq queryReq) {
        if (accessTokenConfig.getAppId() != null && accessTokenConfig.getSecretKey() != null) {
            return ResultT.success(queryLogs(queryReq));
        }
        return ResultT.success();
    }

    public PagingDto<List<OperateLogDto>> queryLogs(QueryReq queryReq) {
        Page<Object> page = PageHelper.startPage(queryReq.getPageIndex(), queryReq.getPageSize());
        PagingDto<List<OperateLogDto>> pagingDto = new PagingDto<>();

        OperateLogDoExample example = new OperateLogDoExample();
        example.setOrderByClause("id desc");
        OperateLogDoExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(1L).andValidEqualTo(1);


        List<OperateLogDo> appraiseReminds = operateLogMapper.selectByExample(example);
        List<OperateLogDto> res = Lists.newArrayList();
        appraiseReminds.forEach(logDo -> {
            OperateLogDto logDto = OperateLogConvert.operateLogConvert
                    .operateLogDoToDto(logDo);
            res.add(logDto);
        });
        queryReq.setTotal(new Long(page.getTotal()).intValue());

        pagingDto.setTotal((int) page.getTotal());
        pagingDto.setData(res);
        pagingDto.setPageIndex(queryReq.getPageIndex());
        pagingDto.setPageSize(queryReq.getPageSize());
        return pagingDto;
    }

    @Override
    public ResultT<Long> insertOperateLog(OperateLogReq operateLogReq) {
        OperateLogDo operateLogDo = OperateLogConvert.operateLogConvert.operateLogReqToDo(operateLogReq);
        operateLogDo.setCreatedTime(new Date());
        operateLogDo.setUpdateTime(new Date());

        operateLogDo.setValid(1);
        // 入库
        operateLogMapper.insert(operateLogDo);

        return ResultT.success(operateLogDo.getId());

    }

    @Override
    public ResultT<Boolean> insertOperateLogBatch(List<OperateLogReq> OperateLogReqs) {
        List<OperateLogDo> logs = Lists.newArrayList();
        if (CollectionUtils.isEmpty(OperateLogReqs)) {
            return ResultT.fail();
        }
        OperateLogReqs.forEach(item -> {
            logs.add(OperateLogConvert.operateLogConvert.operateLogReqToDo(item));
        });
        int res = operateLogMapper.insertBatch(logs);
        return res > 0 ? ResultT.success() : ResultT.fail();
    }

    @Override
    public ResultT<Boolean> updateOperateLogBatch(List<OperateLogReq> OperateLogReqs) {
        List<OperateLogDo> logs = Lists.newArrayList();
        if (CollectionUtils.isEmpty(OperateLogReqs)) {
            return ResultT.fail();
        }
        OperateLogReqs.forEach(item -> {
            logs.add(OperateLogConvert.operateLogConvert.operateLogReqToDo(item));
        });
        int res = operateLogMapper.batchUpdate(logs);
        return res > 0 ? ResultT.success() : ResultT.fail();
    }

}

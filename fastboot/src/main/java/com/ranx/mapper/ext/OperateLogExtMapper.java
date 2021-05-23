package com.ranx.mapper.ext;

import com.ranx.model.Do.OperateLogDo;

import java.util.List;

public interface OperateLogExtMapper {

    int insertBatch(List<OperateLogDo> logs);

    int batchUpdate(List<OperateLogDo> logs);
}
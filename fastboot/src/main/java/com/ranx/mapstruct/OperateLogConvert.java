package com.ranx.mapstruct;


import com.ranx.model.Do.OperateLogDo;
import com.ranx.model.dto.OperateLogDto;
import com.ranx.model.req.OperateLogReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: ranx.zhao
 * @date 2021/4/19 13:08
 * description:
 */
@Mapper
public interface OperateLogConvert {
    OperateLogConvert operateLogConvert = Mappers.getMapper(OperateLogConvert.class);

    OperateLogDo operateLogReqToDo(OperateLogReq operateLogReq);

    OperateLogDto operateLogDoToDto(OperateLogDo operateLogDo);


}

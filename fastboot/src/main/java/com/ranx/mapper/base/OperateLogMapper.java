package com.ranx.mapper.base;

import com.ranx.mapper.ext.OperateLogExtMapper;
import com.ranx.model.Do.OperateLogDo;
import com.ranx.model.Do.OperateLogDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateLogMapper extends OperateLogExtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    long countByExample(OperateLogDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    int insert(OperateLogDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    int insertSelective(OperateLogDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    List<OperateLogDo> selectByExample(OperateLogDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OperateLogDo record, @Param("example") OperateLogDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OperateLogDo record, @Param("example") OperateLogDoExample example);
}
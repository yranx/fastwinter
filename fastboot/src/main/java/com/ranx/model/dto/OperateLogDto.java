package com.ranx.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author:
 * @date:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLogDto {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "日志")
    private String logContent;


}

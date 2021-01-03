package com.ranx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ranx
 */
@Api(tags = "示例")
@RestController
@RequestMapping("/basic")
public class Expcontroller {

    @ApiOperation("BASIC:示例接口")
    @PostMapping("/exp")
    public String  expInterface() {
        return "exp";
    }

}

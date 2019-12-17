package com.ilabservice.service.controller;

import com.ilabservice.common.exceptions.BadRequestException;
import com.ilabservice.common.exceptions.NotFoundException;
import com.ilabservice.common.exceptions.ServerInternalException;
import com.ilabservice.common.result.CommonPageResult;
import com.ilabservice.common.result.CommonResult;
import com.ilabservice.common.result.ResultErrorCode;
import com.ilabservice.service.model.Device;
import com.ilabservice.service.vo.DeviceItem;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/device")
@Api(value = "device", description = "设备相关接口", tags = {"device"})
public class DeviceController {


    @ApiOperation(value = "get device list", notes = "使用 optional 的过滤器来查询设备, 支持模糊查询和翻页")
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数非法"),
            @ApiResponse(code = 404, message = "设备不存在"),
            @ApiResponse(code = 500, message = "服务器错误"),
            @ApiResponse(code = 200, message = "设备列表 with 简化设备项")

    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "设备名, 模糊查询", dataType = "string", example = "dev", paramType = "query"),
            @ApiImplicitParam(name = "model", value = "型号, 模糊查询", dataType = "string", example = "XYZ001", paramType = "query")
    })
    @GetMapping("")
    CommonPageResult<List<DeviceItem>> getDeviceList(@RequestParam(required = false, value = "name") String name,
                                                     @RequestParam(required = false, value = "model") String mode,
                                                     @RequestParam(required = false, value = "offset") Integer offset,
                                                     @RequestParam(required = false, value = "limit") Integer limit) {

        // TODO: add logic here, following is fake logic
        try {
            if (name == "db not found") {
                log.error("device not found");
                throw new NotFoundException(ResultErrorCode.DB_ERROR.getValue());
            } else if (name == "") {
                log.error("device name illegal");
                throw new BadRequestException(ResultErrorCode.DB_ERROR.getValue());
            }
        } catch (Exception e){
            log.error("unexpected error: " + e.toString());
            throw new ServerInternalException(e.toString());
        }



        return new CommonPageResult<>();
    }

    @ApiOperation(value = "get device by id", notes = "查询指定id的设备")
    @ApiResponses({
            @ApiResponse(code = 404, message = "设备不存在"),
            @ApiResponse(code = 500, message = "服务器错误"),
            @ApiResponse(code = 200, message = "设备详细信息")

    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "设备id", dataType = "int", example = "1", paramType = "path")
    })
    @GetMapping("/{id}")
    CommonResult<Device> getDevice(@PathVariable(required = true, value = "id") Integer id) {

        // TODO: add logic here

        return new CommonResult<>();
    }
}

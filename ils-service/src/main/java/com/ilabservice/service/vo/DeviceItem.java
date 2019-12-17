package com.ilabservice.service.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "设备列表中的设备项")
public class DeviceItem {

    @ApiModelProperty(value = "设备 id", example = "11", dataType = "int")
    Integer id;

    @ApiModelProperty(value = "设备名", example = "dev-001")
    String name;

    @ApiModelProperty(value = "设备型号", example = "YX001")
    String model;
}

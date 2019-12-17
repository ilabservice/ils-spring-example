package com.ilabservice.service.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "device")
@TableName("device")
public class Device {
    @ApiModelProperty(value = "device id")
    @TableId(value = "id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "device name", example = "dev-001")
    @TableField(value = "name")
    private String name;

    /**
     * 商标
     */
    @ApiModelProperty(value = "manufacture brand", example = "thermofisher")
    @TableField(value = "brand")
    private String brand;

    /**
     * 型号
     */
    @ApiModelProperty(value = "device model", example = "YX001")
    @TableField(value = "model")
    private String model;

    /**
     * 重量
     */
    @ApiModelProperty(value = "device weight in kg", example = "3.22")
    @TableField(value = "weight")
    private Double weight;

    /**
     * 长度
     */
    @ApiModelProperty(value = "device length in cm", example = "100")
    @TableField(value = "length")
    private Integer length;

    /**
     * 高度
     */
    @ApiModelProperty(value = "device height in cm", example = "50")
    @TableField(value = "height")
    private Integer height;

}

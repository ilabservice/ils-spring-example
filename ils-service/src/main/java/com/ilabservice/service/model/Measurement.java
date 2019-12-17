package com.ilabservice.service.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "measurement")
@TableName("measurement")
public class Measurement {

    @ApiModelProperty(value = "")
    @TableId(value = "id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "")
    @TableField(value = "name")
    private String name;

    /**
     * 单位
     */
    @ApiModelProperty(value = "")
    @TableField(value = "unit")
    private String unit;

    /**
     * 别名
     */
    @ApiModelProperty(value = "")
    @TableField(value = "alias")
    private String alias;

}

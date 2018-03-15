package com.otn.controller;


import com.otn.pojo.MaintenanceRecordDTO;
import com.otn.service.ResMaintenanceRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "MaintenanceRecord", description = "检修单相关操作")
@RequestMapping("/maintenanceRecords")
public class MaintenanceRecordController {
    @Resource
    private ResMaintenanceRecordService maintenanceRecordService;

    @ApiOperation(value = "增加", notes = "新增检修单")
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
    public MaintenanceRecordDTO createLinkType(@RequestBody MaintenanceRecordDTO recordDTO) {
        return maintenanceRecordService.addRecord(recordDTO);
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    @ApiOperation(value = "查询某个版本下的所有检修单信息")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MaintenanceRecordDTO> listNetElement() {
        return maintenanceRecordService.listRecord();
    }

    @ApiOperation(value = "更新", notes = "修改链路类型")
    @RequestMapping(value = "/{maintenanceRecordId}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public MaintenanceRecordDTO updateByLinkTypeId(@PathVariable Long maintenanceRecordId) {
        return maintenanceRecordService.updateRecord(maintenanceRecordId);
    }


}
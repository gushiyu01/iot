package com.ictbda.iot.controller;

import com.ictbda.iot.entity.EFence;
import com.ictbda.iot.entity.Equipment;
import com.ictbda.iot.entity.Output;
import com.ictbda.iot.entity.UseUser;
import com.ictbda.iot.service.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Equipment)表控制层
 *
 * @author makejava
 * @since 2020-06-09 11:02:52
 */
@RestController
@RequestMapping("/iot-api/equipment")
public class EquipmentController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private EquipmentService equipmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Equipment selectOne(Long id) {
        return this.equipmentService.queryById (id);
    }

    /**
     * 添加设备
     *
     * @param e
     * @return
     */
    @PostMapping("addEquipment")
    @ApiOperation("添加设备")
    public Output addEquipment(@RequestBody Equipment e) {

        Long loginUserId = getLoginUserId ( );
        e.setLoginUserId (loginUserId);

        Equipment insert = equipmentService.insert (e);
        if ( insert.getId ( ) > 0 ) {
            return Output.ok ("设备添加成功");
        } else if (insert.getId ( ) == 0L ) {
            return Output.error ("请勿添加相同设备");
        } else {
            return Output.error ("设备添加失败");
        }

    }

    /**
     * 查询list
     *
     * @return
     */
    @GetMapping("getEquipmentList")
    @ApiOperation("查询设备列表")
    public Output getEquipmentList() {

        Equipment s = new Equipment ( );
        s.setLoginUserId (getLoginUserId ( ));

        List<Equipment> equipments = equipmentService.queryAll (s);
        return Output.ok ("查询设备列表成功", equipments);

    }

    /**
     * 更新设备信息
     *
     * @param eFence
     * @return
     */
    @PostMapping("/updateEquipment")
    @ApiOperation("更新设备信息")
    public Output updateEquipment(@RequestBody Equipment equipment) {

        Equipment insert = equipmentService.update (equipment);
        if ( insert.getId ( ) > 0 ) {
            return Output.ok ("设备信息更新成功");
        } else {
            return Output.error ("设备信息更新失败");
        }
    }

    /**
     * 删除设备信息
     *
     * @param eFence
     * @return
     */
    @GetMapping("/deleteEquipment")
    @ApiOperation("删除设备信息")
    public Output deleteEquipment(@RequestParam("id") Long id) {

        Equipment equipment = new Equipment ( );
        equipment.setId (id);
        equipment.setDelFlag (2);

        Equipment insert = equipmentService.update (equipment);
        if ( insert.getDelFlag ( ) > 1 ) {
            return Output.ok ("设备信息更新成功");
        } else {
            return Output.error ("设备信息更新失败");
        }
    }

}
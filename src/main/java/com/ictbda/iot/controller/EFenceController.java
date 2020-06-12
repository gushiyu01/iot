package com.ictbda.iot.controller;

import com.ictbda.iot.entity.EFence;
import com.ictbda.iot.entity.Output;
import com.ictbda.iot.service.EFenceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 电子围栏表(EFence)表控制层
 *
 * @author makejava
 * @since 2020-06-09 10:16:34
 */
@RestController
@RequestMapping("/iot-api/eFence")
public class EFenceController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private EFenceService eFenceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EFence selectOne(Long id) {
        return this.eFenceService.queryById(id);
    }

    /**
     * 添加电子围栏
     * @param eFence
     * @return
     */
    @PostMapping("/addEFence")
    @ApiOperation("添加电子围栏")
    public Output addEFence(@RequestBody EFence eFence){

        Long loginUserId = getLoginUserId ();
        eFence.setLoginUserId (loginUserId);

        EFence insert = eFenceService.insert (eFence);
        if ( insert.getId () > 0 ) {
            return Output.ok ("电子围栏添加成功");
        } else {
            return Output.error ("电子围栏添加失败");
        }
    }

    @GetMapping("getEFenceByUseUserId")
    @ApiOperation ("根据使用者id获取其电子围栏信息")
    public Output getEFenceByUseUserId(@RequestParam("useUserId") Long useUserId){

        return Output.ok ("设备list", this.eFenceService.queryByUserId (useUserId));
    }

    /**
     * 更新电子围栏
     * @param eFence
     * @return
     */
    @PostMapping("/updateEFence")
    @ApiOperation("更新电子围栏")
    public Output updateEFence(@RequestBody EFence eFence){

        EFence insert = eFenceService.update (eFence);
        if ( insert.getId () > 0 ) {
            return Output.ok ("电子围栏更新成功");
        } else {
            return Output.error ("电子围栏更新失败");
        }
    }

    /**
     * 删除电子围栏
     * @param eFence
     * @return
     */
    @GetMapping("/updateEFence")
    @ApiOperation("删除电子围栏")
    public Output deleteEFence(@RequestParam("useUserId") Long useUserId, @RequestParam("equipmentId") Long equipmentId){

        EFence eFence = new EFence ();
        eFence.setUserId (useUserId);
        eFence.setId (equipmentId);
        eFence.setDelFlag (2);

        EFence insert = eFenceService.update (eFence);
        if ( insert.getDelFlag () > 1 ) {
            return Output.ok ("电子围栏更新成功");
        } else {
            return Output.error ("电子围栏更新失败");
        }
    }

}
package com.ictbda.iot.controller;

import com.ictbda.iot.entity.Output;
import com.ictbda.iot.entity.UseUser;
import com.ictbda.iot.service.UseUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备穿戴人员信息表(UseUser)表控制层
 *
 * @author makejava
 * @since 2020-06-09 11:41:32
 */
@RestController
@RequestMapping("/iot-api/useUser")
public class UseUserController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private UseUserService useUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UseUser selectOne(Long id) {
        return this.useUserService.queryById(id);
    }

    @PostMapping("addUseUser")
    public Output addUseUser(@RequestBody UseUser useUser){

        Long loginUserId = getLoginUserId ();
        useUser.setLoginUserId (loginUserId);

        UseUser insert = useUserService.insert (useUser);
        if ( insert.getId () > 0 ) {
            return Output.ok ("添加使用者成功");
        } else {
            return Output.error ("添加使用者失败");
        }


    }

    /**
     * 查询list
     * @return
     */
    @GetMapping("getUseUserList")
    public Output getUseUserList() {

        UseUser s = new UseUser ( );
        s.setLoginUserId (getLoginUserId ( ));

        List<UseUser> useUsers = useUserService.queryAll (s);
        return Output.ok ("查询监管人员列表成功", useUsers);

    }

    /**
     * 更新使用人员信息
     * @param eFence
     * @return
     */
    @PostMapping("/updateUseUser")
    @ApiOperation("更新使用人员信息")
    public Output updateUseUser(@RequestBody UseUser useUser){

        UseUser insert = useUserService.update (useUser);
        if ( insert.getId () > 0 ) {
            return Output.ok ("使用人员信息更新成功");
        } else {
            return Output.error ("使用人员信息更新失败");
        }
    }

    /**
     * 删除使用人员信息
     * @param eFence
     * @return
     */
    @GetMapping("/deleteUseUser")
    @ApiOperation("删除使用人员信息")
    public Output deleteUseUser(@RequestParam("useUserId") Long useUserId){

        UseUser useUser = new UseUser ();
        useUser.setId (useUserId);
        useUser.setDelFlag (2);

        UseUser insert = useUserService.update (useUser);
        if ( insert.getDelFlag () > 1 ) {
            return Output.ok ("删除成功");
        } else {
            return Output.error ("删除失败");
        }
    }
}
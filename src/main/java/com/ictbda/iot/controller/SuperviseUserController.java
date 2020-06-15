package com.ictbda.iot.controller;

import com.ictbda.iot.entity.Output;
import com.ictbda.iot.entity.SuperviseUser;
import com.ictbda.iot.service.SuperviseUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 监管人员信息表(SuperviseUser)表控制层
 *
 * @author makejava
 * @since 2020-06-09 10:16:10
 */
@RestController
@RequestMapping("/iot-api/superviseUser")
public class SuperviseUserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SuperviseUserService superviseUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SuperviseUser selectOne(Long id) {
        return this.superviseUserService.queryById (id);
    }

    /**
     * 添加监管人员
     *
     * @param user
     * @return
     */
    @PostMapping("/addSuperviseUser")
    public Output addSuperviseUser(@RequestBody SuperviseUser user) {

        Long loginUserId = getLoginUserId ( );
        user.setLoginUserId (loginUserId);

        SuperviseUser insert = superviseUserService.insert (user);
        if ( insert.getId ( ) > 0 ) {
            return Output.ok ("新增监管人员成功");
        } else {
            return Output.error ("新增监管人员失败");
        }

    }

    /**
     * 查询list
     * @return
     */
    @GetMapping("getSuperviseUserList")
    public Output getSuperviseUserList() {

        SuperviseUser s = new SuperviseUser ( );
        s.setLoginUserId (getLoginUserId ( ));

        List<SuperviseUser> superviseUsers = superviseUserService.queryAll (s);
        return Output.ok ("查询监管人员列表成功", superviseUsers);

    }

    /**
     * 更新监管人员信息
     * @param eFence
     * @return
     */
    @PostMapping("/updateSuperviseUser")
    @ApiOperation("更新监管人员信息")
    public Output updateSuperviseUser(@RequestBody SuperviseUser superviseUser){

        SuperviseUser insert = superviseUserService.update (superviseUser);
        if ( insert.getId () > 0 ) {
            return Output.ok ("监管人员信息更新成功");
        } else {
            return Output.error ("监管人员信息更新失败");
        }
    }

    /**
     * 删除监管人员信息
     * @param eFence
     * @return
     */
    @GetMapping("/deleteSuperviseUser")
    @ApiOperation("删除监管人员信息")
    public Output deleteSuperviseUser(@RequestParam("id") Long id){

        SuperviseUser superviseUser = new SuperviseUser ();
        superviseUser.setId (id);
        superviseUser.setDelFlag (2);

        SuperviseUser insert = superviseUserService.update (superviseUser);
        if ( insert.getDelFlag () > 1 ) {
            return Output.ok ("删除成功");
        } else {
            return Output.error ("删除失败");
        }
    }

}
package xyz.ibudai.controller;

import xyz.ibudai.entity.SysUser;
import xyz.ibudai.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2022-07-20 10:21:46
 */
@RestController
@RequestMapping("/api/sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param sysUser     筛选条件
     * @param offset      分页对象
     * @param limit       分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<SysUser>> queryByPage(SysUser sysUser,
                                                     @RequestParam("offset") int offset,
                                                     @RequestParam("limit") int limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        return ResponseEntity.ok(this.sysUserService.queryByPage(sysUser, pageRequest));
    }

    @GetMapping("list")
    public ResponseEntity<List<SysUser>> List() {
        return ResponseEntity.ok(this.sysUserService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysUser> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysUser> add(SysUser sysUser) {
        return ResponseEntity.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysUser> edit(SysUser sysUser) {
        return ResponseEntity.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.sysUserService.deleteById(id));
    }

}


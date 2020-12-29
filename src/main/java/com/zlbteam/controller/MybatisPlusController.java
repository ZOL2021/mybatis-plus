package com.zlbteam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlbteam.entity.User;
import com.zlbteam.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhoulibin
 */
@RestController
@ResponseBody
public class MybatisPlusController {
    @Resource
    private IUserService iUserService;

    /*
     * -------------------
     * -------------------
     *
     * Service CRUD 接口
     *
     * -------------------
     * -------------------
     */

    /**
     * -------------------
     * Save
     * // 插入一条记录（选择字段，策略插入）
     * boolean save(T entity);
     * // 插入（批量）
     * boolean saveBatch(Collection<T> entityList);
     * // 插入（批量）
     * boolean saveBatch(Collection<T> entityList, int batchSize);
     * -------------------
     */

    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return iUserService.save(user);
    }

    @PostMapping("/saveBatch")
    public boolean saveBatch(@RequestBody List<User> list) {
        return iUserService.saveBatch(list);
    }

    @PostMapping("/saveBatchSize")
    public boolean saveBatchSize(@RequestBody List<User> list, int batchSize) {
        return iUserService.saveBatch(list, batchSize);
    }

    /**
     * -------------------
     * SaveOrUpdate
     * // TableId 注解存在更新记录，否插入一条记录
     * boolean saveOrUpdate(T entity);
     * // 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
     * boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper);
     * // 批量修改插入
     * boolean saveOrUpdateBatch(Collection<T> entityList);
     * // 批量修改插入
     * boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);
     * -------------------
     */

    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody User user) {
        return iUserService.saveOrUpdate(user);
    }

    @PostMapping("/saveOrUpdateWrapper")
    public boolean saveOrUpdateWrapper(@RequestBody User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.saveOrUpdate(user, wrapper);
    }

    @PostMapping("/saveOrUpdateBatch")
    public boolean saveOrUpdateBatch(@RequestBody List<User> list) {
        return iUserService.saveOrUpdateBatch(list);
    }

    @PostMapping("/saveOrUpdateBatchSize")
    public boolean saveOrUpdateBatchSize(@RequestBody List<User> list, int batchSize) {
        return iUserService.saveOrUpdateBatch(list, batchSize);
    }

    /**
     * -------------------
     * Remove
     * // 根据 entity 条件，删除记录
     * boolean remove(Wrapper<T> queryWrapper);
     * // 根据 ID 删除
     * boolean removeById(Serializable id);
     * // 根据 columnMap 条件，删除记录
     * boolean removeByMap(Map<String, Object> columnMap);
     * // 删除（根据ID 批量删除）
     * boolean removeByIds(Collection<? extends Serializable> idList);
     * -------------------
     */

    @PostMapping("/remove")
    public boolean remove(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.remove(wrapper);
    }

    @PostMapping("/removeById")
    public boolean removeById(@RequestBody User user) {
        return iUserService.removeById(user.getId());
    }

    @PostMapping("/removeByMap")
    public boolean removeByMap(@RequestBody Map<String, Object> map) {
        map.put("id", 1);
        return iUserService.removeByMap(map);
    }

    @PostMapping("/removeByIds")
    public boolean removeByIds(@RequestBody List<Integer> list) {
        return iUserService.removeByIds(list);
    }

    /**
     * -------------------
     * Update
     * // 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     * boolean update(Wrapper<T> updateWrapper);
     * // 根据 whereEntity 条件，更新记录
     * boolean update(T entity, Wrapper<T> updateWrapper);
     * // 根据 ID 选择修改
     * boolean updateById(T entity);
     * // 根据ID 批量更新
     * boolean updateBatchById(Collection<T> entityList);
     * // 根据ID 批量更新
     * boolean updateBatchById(Collection<T> entityList, int batchSize);
     * -------------------
     */

    @PostMapping("/update")
    public boolean update(@RequestBody User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.update(wrapper);
    }

    @PostMapping("/updateWrapper")
    public boolean updateWrapper(@RequestBody User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.update(user, wrapper);
    }

    @PostMapping("/updateById")
    public boolean updateById(@RequestBody User user) {
        return iUserService.updateById(user);
    }

    @PostMapping("/updateBatchById")
    public boolean updateBatchById(@RequestBody List<User> list) {
        return iUserService.updateBatchById(list);
    }

    @PostMapping("/updateBatchByIdSize")
    public boolean updateBatchByIdSize(@RequestBody List<User> list, int batchSize) {
        return iUserService.updateBatchById(list, batchSize);
    }

    /**
     * -------------------
     * Get
     * // 根据 ID 查询
     * T getById(Serializable id);
     * // 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
     * T getOne(Wrapper<T> queryWrapper);
     * // 根据 Wrapper，查询一条记录
     * T getOne(Wrapper<T> queryWrapper, boolean throwEx);
     * // 根据 Wrapper，查询一条记录
     * Map<String, Object> getMap(Wrapper<T> queryWrapper);
     * // 根据 Wrapper，查询一条记录
     * <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
     * -------------------
     */

    @PostMapping("/getById")
    public User getById(@RequestBody User user) {
        return iUserService.getById(user.getId());
    }

    @PostMapping("/getOne")
    public User getOne(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.getOne(wrapper);
    }

    @PostMapping("/getOneThrowEx")
    public User getOneThrowEx(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.getOne(wrapper, false);
    }

    @PostMapping("/getMap")
    public Map<String, Object> getMap(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.getMap(wrapper);
    }

    @PostMapping("/getObj")
    public User getObj(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.getObj(wrapper, o -> (User) o);
    }

    /**
     * -------------------
     * List
     * // 查询所有
     * List<T> list();
     * // 查询列表
     * List<T> list(Wrapper<T> queryWrapper);
     * // 查询（根据ID 批量查询）
     * Collection<T> listByIds(Collection<? extends Serializable> idList);
     * // 查询（根据 columnMap 条件）
     * Collection<T> listByMap(Map<String, Object> columnMap);
     * // 查询所有列表
     * List<Map<String, Object>> listMaps();
     * // 查询列表
     * List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);
     * // 查询全部记录
     * List<Object> listObjs();
     * // 查询全部记录
     * <V> List<V> listObjs(Function<? super Object, V> mapper);
     * // 根据 Wrapper 条件，查询全部记录
     * List<Object> listObjs(Wrapper<T> queryWrapper);
     * // 根据 Wrapper 条件，查询全部记录
     * <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
     * -------------------
     */

    @PostMapping("/list")
    public List<User> list() {
        return iUserService.list();
    }

    @PostMapping("/listWrapper")
    public List<User> listWrapper(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        return iUserService.list(wrapper);
    }

    @PostMapping("/listByIds")
    public List<User> listByIds(@RequestBody List<Integer> list) {
        return iUserService.listByIds(list);
    }

    @PostMapping("/listByMap")
    public List<User> listByMap(@RequestBody Map<String, Object> map) {
        return iUserService.listByMap(map);
    }

    @PostMapping("/listMaps")
    public List<Map<String, Object>> listMaps() {
        return iUserService.listMaps();
    }

    @PostMapping("/listMapsWrapper")
    public List<Map<String, Object>> listMapsWrapper(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.listMaps(wrapper);
    }

    @PostMapping("/listObjs")
    public List<Object> listObjs() {
        return iUserService.listObjs();
    }

    @PostMapping("/listObjsUser")
    public List<User> listObjsUser() {
        return iUserService.listObjs(o -> (User) o);
    }

    @PostMapping("/listObjsWrapper")
    public List<Object> listObjsWrapper(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.listObjs(wrapper);
    }

    @PostMapping("/listObjsUserWrapper")
    public List<User> listObjsUserWrapper(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.listObjs(wrapper, o -> (User) o);
    }

    /**
     * -------------------
     * Page
     * // 无条件分页查询
     * IPage<T> page(IPage<T> page);
     * // 条件分页查询
     * IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
     * // 无条件分页查询
     * IPage<Map<String, Object>> pageMaps(IPage<T> page);
     * // 条件分页查询
     * IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper);
     * -------------------
     */

    @PostMapping("/page")
    public IPage<User> page(@RequestParam("pageNo") int pageNo, @RequestParam("PageSize")int pageSize) {
        Page<User> page = new Page<>(pageNo, pageSize);
        return iUserService.page(page);
    }

    @PostMapping("/pageWrapper")
    public IPage<User> pageWrapper(@RequestBody User user, @RequestParam("pageNo") int pageNo, @RequestParam("PageSize")int pageSize) {
        Page<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.page(page, wrapper);
    }

    @PostMapping("/pageMaps")
    public IPage<Map<String, Object>> pageMaps(@RequestParam("pageNo") int pageNo, @RequestParam("PageSize")int pageSize) {
        return iUserService.pageMaps(new Page<>(pageNo, pageSize));
    }

    @PostMapping("/pageMapsWrapper")
    public IPage<Map<String, Object>> pageMapsWrapper(@RequestBody User user, @RequestParam("pageNo") int pageNo, @RequestParam("PageSize")int pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.pageMaps(new Page<>(pageNo, pageSize), wrapper);
    }

    /**
     * -------------------
     * Count
     * // 查询总记录数
     * int count();
     * // 根据 Wrapper 条件，查询总记录数
     * int count(Wrapper<T> queryWrapper);
     * -------------------
     */

    @PostMapping("/count")
    public int count() {
        return iUserService.count();
    }

    @PostMapping("/countWrapper")
    public int countWrapper(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", user.getId());
        return iUserService.count(wrapper);
    }

    /**
     * -------------------
     * Chain
     *
     *
     * -----------
     * query
     * -----------
     *
     * // 链式查询 普通
     * QueryChainWrapper<T> query();
     * // 链式查询 lambda 式。注意：不支持 Kotlin
     * LambdaQueryChainWrapper<T> lambdaQuery();
     *
     * // 示例：
     * query().eq("column", value).one();
     * lambdaQuery().eq(Entity::getId, value).list();
     *
     * -----------
     * update
     * -----------
     *
     * // 链式更改 普通
     * UpdateChainWrapper<T> update();
     * // 链式更改 lambda 式。注意：不支持 Kotlin
     * LambdaUpdateChainWrapper<T> lambdaUpdate();
     *
     * // 示例：
     * update().eq("column", value).remove();
     * lambdaUpdate().eq(Entity::getId, value).update(entity);
     * -------------------
     * @return
     */
    @PostMapping("/query")
    public User query(@RequestBody User user) {
        return iUserService.query().eq("id", user.getId()).one();
    }

    @PostMapping("/lambdaQuery")
    public List<User> lambdaQuery(@RequestBody User user) {
        return iUserService.lambdaQuery().eq(User::getId, user.getId()).list();
    }

    @PostMapping("/updateRemove")
    public boolean updateRemove(@RequestBody User user) {
        return iUserService.update().eq("id", user.getId()).remove();
    }

    @PostMapping("/lambdaUpdate")
    public boolean lambdaUpdate(@RequestBody User user) {
        return iUserService.lambdaUpdate().eq(User::getId, user.getId()).update(user);
    }

}

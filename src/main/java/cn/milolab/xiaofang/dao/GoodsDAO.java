package cn.milolab.xiaofang.dao;

import cn.milolab.xiaofang.bean.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author milowang
 */
@Repository
public interface GoodsDAO {
    /**
     * 获取所有商品列表
     *
     * @return 商品列表
     */
    List<Goods> getAllGoods();

    /**
     * 获取指定的goods
     *
     * @param id 商品id
     * @return Goods实体
     */
    Goods findById(int id);
}

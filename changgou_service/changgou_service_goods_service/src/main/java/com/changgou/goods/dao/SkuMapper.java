package com.changgou.goods.dao;
import com.changgou.goods.pojo.Sku;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


public interface SkuMapper extends Mapper<Sku> {
     //解决超卖问题 数据库的行级锁
    @Update(value="update tb_sku set num=num-#{num},sale_num=sale_num+#{num} where id =#{skuId} and num >=#{num}")
    public int decrCount(@Param("id") Long id , @Param("num") Integer num);
}

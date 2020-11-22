package seckill.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="seckill")
@RequestMapping("/seckillGoods")
public interface SeckillGoodsFeign {

}
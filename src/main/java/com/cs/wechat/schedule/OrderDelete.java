package com.cs.wechat.schedule;

import com.cs.wechat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cs on 2017/8/31.
 */
@Component
public class OrderDelete {
    @Autowired
    OrderService orderService;

    /*private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }*/

    /*@Scheduled(fixedRate = 1000*60*SCHEDULE_TIME)
    public void delete() {
        List<OrderRecord> orderRecords = orderService.findByStatus(1);
        for(OrderRecord orderRecord:orderRecords){
            Date createTime = orderRecord.getCreateTime();
            long time = new Date().getTime() - createTime.getTime();
            time = time/(60*1000);
            if(time>SCHEDULE_TIME){
                System.out.println("已删除:  " + orderRecord);
                orderService.deleteObject(orderRecord);
            }
        }
    }*/
}

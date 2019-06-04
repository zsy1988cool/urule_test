package com.ylz.ruletest.invoke;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.ylz.ruletest.entity.Customer;
import com.ylz.ruletest.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class Invokor {

    public void doTest() throws Exception{
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包"projectName/test123"
        KnowledgePackage knowledgePackage=service.getKnowledge("保险业务/client_score");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        KnowledgeSession session= KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order();
        order1.setName("订单1");
        order1.setAmount(1000);
        order1.setPrice(1000);
        orders.add(order1);

        Order order2 = new Order();
        order2.setName("订单2");
        order2.setAmount(100);
        order2.setPrice(1000);
        orders.add(order2);

        Order order3 = new Order();
        order3.setName("订单1");
        order3.setAmount(1020);
        order3.setPrice(1000);
        orders.add(order3);

        Customer customer = new Customer();
        customer.setName("张三");
        customer.setAge(10);
        customer.setCar(true);
        customer.setHouse(true);
        customer.setGender(true);
        customer.setOrders(orders);

        //将业务数据对象Employee插入到KnowledgeSession中
        session.insert(customer);
        //执行所有满足条件的规则
        session.fireRules();

        System.out.println(customer.getName());
    }
}

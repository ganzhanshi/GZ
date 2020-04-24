package com.liuqi.hibernate.demo1;

import com.liuqi.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.security.cert.X509Certificate;

/**
 * @author LiuQi
 * @date 2020/4/24 - 15:40
 */
public class CustomerDemo3 {
    @Test
    public void test(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();

        Customer customer1 = session.get(Customer.class, 7L);
        customer1.setCustomer_name("林青霞");
        transaction.commit();
        session.close();
    }
//    验证hibernate的一级缓存
    @Test
    public void test2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer1 = session.get(Customer.class, 7L);

        System.out.println(customer1);
        session.clear();
        Customer customer2 = session.get(Customer.class, 7L);

        System.out.println(customer2);

        System.out.println(customer1==customer2);
        customer1.setCustomer_name("关于");
        transaction.commit();
        session.close();
    }

//    测试与线程绑定的session
    @Test
    public void test3(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Customer customer = new Customer();
        customer.setCustomer_name("状流口水");
        currentSession.save(customer);
        transaction.commit();
    }
}

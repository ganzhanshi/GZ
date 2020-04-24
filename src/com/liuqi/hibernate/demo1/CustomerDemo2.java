package com.liuqi.hibernate.demo1;

import com.liuqi.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import sun.plugin2.message.CustomSecurityManagerRequestMessage;

import java.util.Arrays;
import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * @author LiuQi
 * @date 2020/4/24 - 9:54
 */
public class CustomerDemo2 {
    @Test
    public void test2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
//          保存客户
//        customer.setCustomer_name("wanghaiyan");
//        session.save(customer);
//        查询客户
        /**
         * get() 和 load()的区别
         * get():采用的是立即加载，执行到这行代码的时候，就会马上发送SQL语句去查询
         *         查询后获得的是真实的实体对象
         *          查询一个找不到的对象的时候，返回的是null
         * load()：延迟加载（懒加载lazy）,执行到这行代码的时候，不会发送SQL语句，当真正使用这个对象的时候才会发送SQL语句
         *          查询后获得的是代理对象：javassist-3.18-GA.jar 利用 javassist技术产生的代理
         *          查询一个找不到的对象的时候，返回ObjectNotFoundException
         */
//        使用get查询
//        Customer customer1 = session.get(Customer.class, 1l);
//        System.out.println(customer1);
//        使用load查询
        Customer customer2 = session.load(Customer.class, 1L);
        System.out.println(customer2);
        transaction.commit();
        session.close();
    }
//    修改表的操作
    @Test
    public void test3(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
//        直接修改
//        customer.setId(1L);
//        customer.setCustomer_name("赵彩彩");
//        session.update(customer);
//        先查询后修改
        Customer customer1 = session.get(Customer.class, 1L);
        customer1.setCustomer_name("赵永康");
        customer1.setCustomer_age(23L);
        session.update(customer1);
        transaction.commit();
        session.close();
    }

    //    删除表中数据的操作
    @Test
    public void test4(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
//        直接修改
//        customer.setId(1L);
//        session.delete(customer);
//        先查询后修改(推荐)(级联删除)
        Customer customer1 = session.get(Customer.class, 6L);
        session.delete(customer1);
        transaction.commit();
        session.close();
    }

    //    保存或更新
    @Test
    public void test5(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(7L);
        customer.setCustomer_name("wanghaiyan");
        customer.setCustomer_age(22L);
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
    }
//    查询所有
    @Test
    public void test6(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
//        使用hql语句进行查询
//        Query query = session.createQuery("from Customer");
//        List<Customer> list = query.list();
//        for (Customer cus: list){
//            System.out.println(cus);
//        }
//        使用sql语句进行查询
        SQLQuery sqlQuery = session.createSQLQuery("select * from customer");
        List<Object[]> list = sqlQuery.list();
        for(Object[] o : list){
            System.out.println(Arrays.toString(o));
        }
        transaction.commit();
        session.close();
    }
}

package com.liuqi.hibernate.demo1;

import com.liuqi.hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * @author LiuQi
 * @date 2020/4/24 - 16:21
 */
public class CustomerDemo4 {
//    测试查询 Query
    @Test
    public void test1(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Customer customer = new Customer();
//        普通查询
//        String hql = "from Customer";
//        Query query = currentSession.createQuery(hql);
//        条件查询
//        String hql ="from Customer where customer_name like ?";
//        Query query = currentSession.createQuery(hql);
//        query.setParameter(0,"wang%");
//        分页查询
        String hql = "from Customer";
        Query query = currentSession.createQuery(hql);
        query.setFirstResult(2);
        query.setMaxResults(2);
        List<Customer> list = query.list();
        for(Customer cus : list){
            System.out.println(cus);
        }
        transaction.commit();
    }

    //    测试查询 Criteria
    @Test
    public void test2(){
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Customer customer = new Customer();
//        普通查询
//        Criteria criteria = currentSession.createCriteria(Customer.class);
//        分页查询
//        Criteria criteria = currentSession.createCriteria(Customer.class);
//        criteria.setFirstResult(0);
//        criteria.setMaxResults(3);
//        条件查询
        Criteria criteria = currentSession.createCriteria(Customer.class);
        criteria.add(Restrictions.like("customer_name","琦", MatchMode.END));
        List<Customer> list = criteria.list();
        for(Customer cus : list){
            System.out.println(cus);
        }
        transaction.commit();
    }
}

package com.liuqi.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate的configuration工具类
 * @author LiuQi
 * @date 2020/4/24 - 9:49
 */
public class HibernateUtils {
    private static final Configuration cfg;
    private static final SessionFactory sf;

    static {
        cfg=new Configuration().configure();
        sf=cfg.buildSessionFactory();
    }
    public static Session openSession(){
        return  sf.openSession();
    }

    public static Session getCurrentSession(){
        return sf.getCurrentSession();
    }
}

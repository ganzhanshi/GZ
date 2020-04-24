package com.liuqi.hibernate.demo1;

/**
 * @author LiuQi
 * @date 2020/4/24 - 8:03
 * CREATE TABLE customer(
 * 	id BIGINT(11),
 * 	customer_name VARCHAR(225),
 * 	customer_age BIGINT(20),
 * 	customer_sno VARCHAR(225),
 * 	customer_address VARCHAR(225),
 * 	customer_phone VARCHAR(225)
 * );
 */
public class Customer {
    private Long id;
    private String customer_name;
    private Long customer_age;
    private String customer_sno;
    private String customer_address;
    private String customer_phone;
    private Long is_delete;

    public Long getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Long is_delete) {
        this.is_delete = is_delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Long getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(Long customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_sno() {
        return customer_sno;
    }

    public void setCustomer_sno(String customer_sno) {
        this.customer_sno = customer_sno;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_age=" + customer_age +
                ", customer_sno='" + customer_sno + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }
}

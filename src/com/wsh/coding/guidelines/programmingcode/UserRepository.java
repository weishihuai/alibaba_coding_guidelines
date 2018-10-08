package com.wsh.coding.guidelines.programmingcode;

/**
 * @Title: UserRepository
 * @ProjectName alibaba_coding_guidelines
 * @Description:
 * @Author WeiShiHuai
 * @Date 2018/10/8 14:05
 */
public interface UserRepository {

    //不推荐用法
//    public abstract void getUserDetail(Long userId);
//    public static final String COMPAN_EMAIL = "12345678@qq.com";

    //推荐用法
    void getUserDetail(Long userId);
    String COMPAN_EMAIL = "12345678@qq.com";





}

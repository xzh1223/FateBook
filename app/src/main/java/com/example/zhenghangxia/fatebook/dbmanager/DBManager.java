package com.example.zhenghangxia.fatebook.dbmanager;

import com.example.zhenghangxia.fatebook.bean.AccountBean;
import com.example.zhenghangxia.fatebook.bean.PlanBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghangxia on 17-7-20.
 */

public class DBManager {


    /**
     *  添加账目
     */
    public static boolean addAccountBean(AccountBean accountBean) {
        try {
            return accountBean.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *  读取账目列表
     *
     */
    public static List<AccountBean> queryAccountBeanList(AccountBean bean) {
        try {
            List<AccountBean> mList = new ArrayList<>();
            mList = DataSupport.order("day desc").where("year=? and month=?",
                    String.valueOf(bean.getYear()),String.valueOf(bean.getMonth()))
                    .find(AccountBean.class);
            return mList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  添加规划
     *
     */
    public static boolean addPlanBean(PlanBean planBean) {
        try {
            return planBean.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 读取所有规划列表
     *
     */
    public static List<PlanBean> queryPlanBeanList() {
        try {
            List<PlanBean> planBeanList = DataSupport.order("id desc").find(PlanBean.class);
            return planBeanList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

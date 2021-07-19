package com.fankf.hutool.core;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fankf
 * @date 2021/7/5 16:06
 * @description
 */
//@Log4j
public class CoreCloneTest {
    private static final Logger log = LoggerFactory.getLogger(CoreCloneTest.class);

    public static void main(String[] args) {
        // 浅clone
        List<String> strList = new ArrayList<>();
        strList.add("user1");
        UserDemo user = new UserDemo("zhangsan", "beijing",strList);
        log.info("==>>> user :{}",user.toString());

        UserDemo clone = user.clone();
        clone.getTags().add("user2");

        log.info("user:{}" , user);
        log.info("clone:{}" + clone);
        // extend clone
        UserDemo2 demo = new UserDemo2("zhangsan","henan",strList);
        UserDemo2 clone1 = demo.clone();
        clone.getTags().add("user3");
        log.info("demo2:{}",demo);
        log.info("clone1:{}",clone1);


        UserDemo2 deep = ObjectUtil.cloneByStream(demo);
        deep.getTags().add("user4");
        log.info("demo:{}",demo);
        log.info("deep:{}",deep);
    }

    /**
     * clone 集成了Cloneable和Object 的 clone方法
     */
    @Data
    @AllArgsConstructor
    private static class UserDemo implements Cloneable<UserDemo>, Serializable {
        private String name;
        private String address;
        private List<String> tags;


        @Override
        public UserDemo clone() {
            try {
                return (UserDemo) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    private static class UserDemo2 extends CloneSupport<UserDemo2> implements Serializable {
        private String name;
        private String address;
        private List<String> tags;
    }

}

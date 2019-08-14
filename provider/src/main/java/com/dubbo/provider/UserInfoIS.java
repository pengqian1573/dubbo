package com.dubbo.provider;

import com.dubbo.iprovider.UserInfoISV;
import org.apache.dubbo.config.annotation.Service;


//Service一定要使用apache.dubbo的注解，alibaba和sprig的都不要用
@Service(version = "1.0.0")
public class UserInfoIS implements UserInfoISV {


    @Override
    public String sayHello(String name) {

        System.out.println( " provider : "+name  +" coming !  ~~~~  ");

        return "hi! "+name ;
    }
}

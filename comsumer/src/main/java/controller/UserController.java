package controller;

import com.dubbo.iprovider.UserInfoISV;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    @Reference(version = "1.0.0")
    UserInfoISV userInfoISV;


    @GetMapping("/hello")
    public  String sayHello(@RequestParam String name){

        System.out.println( "comsumer : "+name +" is coming ! ");
        return  userInfoISV.sayHello(name);
    }


}

package com.yusys;

import com.yusys.domain.User;
import com.yusys.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan(basePackages = {"com.yusys.repository.mapper"})
@RequestMapping("/api")
@RestController
public class YususZhuzbPracticeApplication {
    @Autowired
    UserService u ;

    @GetMapping("/save/{id}")
    public void save(@PathVariable("id")String id){
        UserService service = new UserService();
        User user = new User();
        user.setId(id);
        user.setName("zj");
        u.saveUser(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(YususZhuzbPracticeApplication.class, args);

    }

}

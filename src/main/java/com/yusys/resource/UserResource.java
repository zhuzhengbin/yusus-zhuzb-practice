package com.yusys.resource;

import com.yusys.domain.User;
import com.yusys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 */
@RequestMapping("/user")
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(@RequestParam String id, String name){
        System.out.println(id+":"+name);
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.saveUser(user);
    }

    @RequestMapping("/api")
    public String test(){
        System.out.println("get.");
        return "success";
    }
}

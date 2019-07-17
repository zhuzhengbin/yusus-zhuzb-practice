package com.yusys.resource;

import com.yusys.domain.ResultDto;
import com.yusys.domain.User;
import com.yusys.service.UserService;
import com.yusys.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 用户接口
 */
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * 简单的接口测试
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/test")
    public String test() {
        System.out.println("get.");
        return "success";
    }

    /**
     * 保存含有完整数据的用户信息
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/saveUser")
    public String saveUser() {

        User user = new User();
        user.setId("002");
        user.setName("user02");
        user.setUserInfo("用字符串代替CLOB对象");

        // 读取图片，并将其转换为字节数组
        byte[] photo01 = IOUtils.turnFileIntoBytes(new File("D:\\intelliJ IDEA2019\\ideaProjects\\yusys\\yusus-zhuzb-practice\\src\\main\\resources\\themes\\images\\001.jpg"));
        user.setPhoto(photo01);
        userService.saveUser(user);
        return "Success";
    }

    /**
     * 根据ID读取用户照片
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/readPhoto")
    public String readPhoto() {
        String id = "001";
        // 从数据库读取图片（BLOB格式），并将其转换为图片文件存储
        byte[] photoBytes = userService.readPhoto(id);
        IOUtils.turnBytesToFile(photoBytes, "D:\\intelliJ IDEA2019\\ideaProjects\\yusys\\yusus-zhuzb-practice\\src\\main\\resources\\themes\\images\\photo01.jpg");
        System.out.println("成功了");
        return "Success";
    }

    /**
     * 新增用户信息（使用POST方法传入参数）
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/addUser")
    public String addUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("userInfo") String userInfo, @RequestParam("photo") MultipartFile multipartFile) {
        System.out.println("调用成功.");
        User user = new User();
        user.setUserInfo(userInfo);
        user.setId(id);
        user.setName(name);
        try {
            user.setPhoto(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setUserInfo(userInfo);
        userService.addUser(user);
        return "Success";
    }

    /**
     * 根据ID获取用户的名字、照片等信息返回给前端
     *
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getUserDetailById")
    @ResponseBody
    public ResultDto getUserDetailById(@RequestParam("id") String id) {
        File cacheImg = new File("D:\\intelliJ IDEA2019\\ideaProjects\\yusys\\yusus-zhuzb-practice\\src\\main\\resources\\themes\\images\\cache_" + id + ".jpg");
        if(!cacheImg.exists()){ // 如果不存在，则从数据库读取并缓存
            User user = userService.getUserDetailById(id);
            IOUtils.turnBytesToFile(user.getPhoto(),"D:\\intelliJ IDEA2019\\ideaProjects\\yusys\\yusus-zhuzb-practice\\src\\main\\resources\\themes\\images\\cache_" + id + ".jpg");
        }
        return new ResultDto();
    }


}

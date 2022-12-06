package com.example.demo.demos.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    // 测试
    // http://127.0.0.1:8080/test/123/roles/222
    @RequestMapping("/test")
    @ResponseBody
    public Test test() {
        Test test = new Test();
        test.setId(1);
        test.setName("get请求成功");
        return test;
    }

    // 测试testPath传参
    // http://127.0.0.1:8080/testPath/123/roles/222
    @RequestMapping(value = "/testPath/{userId}/roles/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public String testPath(@PathVariable("userId") String userId, @PathVariable("roleId") String roleId) {
        return "User Id : " + userId + " Role Id : " + roleId;
    }

    // 测试testParams传参
    // http://127.0.0.1:8080/testPath/?id=1&type=2
    @RequestMapping("/testParams")
    @ResponseBody
    public String testParams(String id, String type) {
        return "User Id : " + id + ";type : " + type;
    }

    // 测试post请求
    @PostMapping("/post")
    @ResponseBody
    public Test post(@RequestParam("id") Integer id) {
        Test test = new Test();
        test.setId(2);
        test.setName("post请求成功,参数为" + id);
        return test;
    }

    // 测试post请求
    @PostMapping("/postParams")
    @ResponseBody
    public Test postParams(@RequestParam("id") Integer id) {
        Test test = new Test();
        test.setId(id);
        test.setName("post请求成功,参数为" + id);
        return test;
    }


}

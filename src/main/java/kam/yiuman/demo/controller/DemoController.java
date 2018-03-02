package kam.yiuman.demo.controller;

import kam.yiuman.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@RestController
public class DemoController {

    @RequestMapping("index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("maptest")
    public Map<String,String> jsonTest(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("sssss","sssss");
        map.put("aaaaa","aaaaa");
        return map;
    }

    @RequestMapping("usermap")
    public Map<String,String> getUser(User user){
        Map<String,String> map = new HashMap<String, String>();
        map.put("user",user.toString());
        return map;
    }
}

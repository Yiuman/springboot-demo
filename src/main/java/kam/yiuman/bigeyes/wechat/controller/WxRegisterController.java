package kam.yiuman.bigeyes.wechat.controller;

import kam.yiuman.bigeyes.wechat.service.WxSinatureService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信验证
 */
@Controller
@RequestMapping("/wechat/")
public class WxRegisterController extends WxBaseController {

    @Autowired
    private WxSinatureService wxService;

    @RequestMapping(value = "signature", method = {RequestMethod.GET, RequestMethod.POST})
    public void signature(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isGet = request.getMethod().equals("GET");
        if (isGet) {
//            System.out.println(request.getAttribute("code")+"1111111111111");
            wxService.signature(request, response);
        } else {
//            WxMpXmlMessage message= WxMpXmlMessage.fromXml(request.getInputStream());
//            System.out.println(request.getAttribute("code")+"22222222222222");
//            wxService.doService(message,response);
        }
    }


}



package kam.yiuman.bigeyes.wechat.controller;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/wx/")
public class WxBaseController {

    @RequestMapping("personal/toauthpage")
    public void auth(HttpServletRequest request) throws WxErrorException {
        String code = request.getParameter("code");
        if (code != null) {
            WxMpService wxMpService = new WxMpServiceImpl();
            WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
            wxConfigProvider.setAppId("wx85e3442d786e8f2e");
            wxConfigProvider.setSecret("accb5566b2bd0924ebe2318070cd9b76");
            wxMpService.setWxMpConfigStorage(wxConfigProvider);
            WxMpOAuth2AccessToken token = wxMpService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(token, null);
            System.out.println(wxMpUser);
        }
    }

    @RequestMapping("/personal/jsapiConfig")
    public WxJsapiSignature jsapiConfig(String url) throws WxErrorException {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
        wxConfigProvider.setAppId("wx85e3442d786e8f2e");
        wxConfigProvider.setSecret("accb5566b2bd0924ebe2318070cd9b76");
        wxMpService.setWxMpConfigStorage(wxConfigProvider);
        wxMpService.setWxMpConfigStorage(wxConfigProvider);
        return wxMpService.createJsapiSignature(url);
    }
}

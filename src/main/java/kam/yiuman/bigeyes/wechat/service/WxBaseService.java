package kam.yiuman.bigeyes.wechat.service;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class WxBaseService {

    protected  WxMpInMemoryConfigStorage wxConfigProvider;

    @Value("${wx.token}")
    protected String token;

    @Value("${wx.appId}")
    protected String appId;

    @Value("${wx.appSecret}")
    protected String appSecret;
}

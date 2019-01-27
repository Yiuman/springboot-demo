package kam.yiuman.bigeyes.wechat.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu/")
public class WxMenuController {
    /**
     * 创建菜单
     */
    @RequestMapping("create")
    public void createMenu() throws WxErrorException, UnsupportedEncodingException {
        String domain = "http://c7yxnm.natappfree.cc/wxlogin?redirectPath=";

        WxMenuButton button1 = new WxMenuButton();
        button1.setName("校园服务");

        WxMenuButton button1_2 = new WxMenuButton();
        button1_2.setType("view"); //点击事件按钮
        button1_2.setName("我的账单");
        String button1_2_uri = URLEncoder.encode(domain + "/wx/pay/allbills", "utf-8");
        String button1_2_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button1_2_uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button1_2.setUrl(button1_2_url);

        WxMenuButton button1_1 = new WxMenuButton();
        button1_1.setType("view"); //点击事件按钮
        button1_1.setName("校园钱包");
        String button1_1_uri = URLEncoder.encode(domain + "/wx/pay/mywallet", "utf-8");
        String button1_1_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button1_1_uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button1_1.setUrl(button1_1_url);

        WxMenuButton button1_5 = new WxMenuButton();
        button1_5.setType("view"); //点击事件按钮
        button1_5.setName("我要缴费");
        String button1_5_uri = URLEncoder.encode(domain + "/wx/pay/wanttopay", "utf-8");
        String button1_5_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button1_5_uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button1_5.setUrl(button1_5_url);

        //创建一个复合菜单
        WxMenuButton button2 = new WxMenuButton();
        button2.setName("家校互动");


        WxMenuButton button2_2 = new WxMenuButton();
        button2_2.setType("view"); //点击事件按钮
        button2_2.setName("考勤管理");
        String button2_2_uri = URLEncoder.encode(domain + "/wx/attendance/classes", "utf-8");
        String url2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button2_2_uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button2_2.setUrl(url2);

        WxMenuButton button2_1 = new WxMenuButton();
        button2_1.setType("view"); //点击事件按钮
        button2_1.setName("课外辅导");
        String button2_1_uri = URLEncoder.encode(domain + "/wx/tutorship/index", "utf-8");
        String button2_1_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button2_1_uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button2_1.setUrl(button2_1_url);


        WxMenuButton button3 = new WxMenuButton();
        button3.setName("平安校园");

        WxMenuButton button3_1 = new WxMenuButton();
        button3_1.setName("身份认证");
        button3_1.setType("view");
        String button3_1uri = URLEncoder.encode(domain + "/wx/personal/toauthpage", "utf-8");
        String button3_1url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button3_1uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button3_1.setUrl(button3_1url);  //必须添加http

        WxMenuButton button3_2 = new WxMenuButton();
        button3_2.setName("个人中心");
        button3_2.setType("view");
        String button3_2uri = URLEncoder.encode(domain + "/wx/personalCenter", "utf-8");
        String button3_2url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button3_2uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button3_2.setUrl(button3_2url);

        WxMenuButton button3_3 = new WxMenuButton();
        button3_3.setName("注册绑定");
        button3_3.setType("view");
        String button3_3uri = URLEncoder.encode(domain + "/wx/resgiterpage", "utf-8");
        String button3_3url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button3_3uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_USERINFO + "&state=1#wechat_redirect";
        button3_3.setUrl(button3_3url);


        List<WxMenuButton> subButtons = new ArrayList<WxMenuButton>();
        subButtons.add(button1_1);
        subButtons.add(button1_2);
        subButtons.add(button1_5);
//        subButtons.add(button1_3);
//        subButtons.add(button1_4);
        button1.setSubButtons(subButtons);

        List<WxMenuButton> subButtons2 = new ArrayList<>();
        subButtons2.add(button2_2);
        subButtons2.add(button2_1);
        button2.setSubButtons(subButtons2);

        List<WxMenuButton> subButtons3 = new ArrayList<>();
        subButtons3.add(button3_1);
        subButtons3.add(button3_2);
        subButtons3.add(button3_3);
        button3.setSubButtons(subButtons3);

        List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        WxMenu menu = new WxMenu();
        menu.setButtons(buttons);

        WxMpService service = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
        wxConfigProvider.setAppId("wx85e3442d786e8f2e");
        wxConfigProvider.setSecret("accb5566b2bd0924ebe2318070cd9b76");
        service.setWxMpConfigStorage(wxConfigProvider);

        service.getMenuService().menuCreate(menu);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String domain = "http://cmbcampus.natapp1.cc/wxlogin?redirectPath=";
        String button3_2uri = URLEncoder.encode(domain + "/wx/personalCenter", "utf-8");
        String button3_2url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx85e3442d786e8f2e" +
                "&redirect_uri=" + button3_2uri + "&response_type=code&scope=" + WxConsts.OAuth2Scope.SNSAPI_BASE + "&state=1#wechat_redirect";
        System.out.println(button3_2url);
    }
}

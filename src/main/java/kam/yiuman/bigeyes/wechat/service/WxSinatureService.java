package kam.yiuman.bigeyes.wechat.service;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMusicMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class WxSinatureService extends WxBaseService {

    public void signature(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //微信工具类
        WxMpService wxService = new WxMpServiceImpl();
        wxConfigProvider = new WxMpInMemoryConfigStorage();
        //注入token的配置参数
        /**
         * 生产环境 建议将WxMpInMemoryConfigStorage持久化
         */
        //注入token值
        wxConfigProvider.setToken(token);
        wxService.setWxMpConfigStorage(wxConfigProvider);
        boolean flag = wxService.checkSignature(timestamp, nonce, signature);

        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (flag) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
    }

    public void doService(WxMpXmlMessage message, HttpServletResponse response) {

        //配置微信参数  获取wxService
        WxMpService wxService = new WxMpServiceImpl();
        //微信配置参数
        WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
        wxConfigProvider.setAppId("wx60a8f1c3a95b0b9c");
        wxConfigProvider.setSecret("5b0e8613b538da5ac4bbc610998f10ba");
        wxService.setWxMpConfigStorage(wxConfigProvider);

        //消息处理
        String messageType = message.getMsgType();
        if (messageType == "event") {
//            response.sendRedirect("s");//消息类型
        }
        String fromUser = message.getFromUser();
        String touser = message.getToUser();
        String content = message.getContent();

        System.out.println(messageType);
        //文本消息
        if (content.equals("文本")) {
            System.out.println("文本消息========");
            //创建消息文本
            WxMpXmlOutTextMessage text = WxMpXmlOutTextMessage.TEXT().toUser(fromUser).fromUser(touser).content("我是文本消息").build();
            String xml = text.toXml();
            System.out.println("xml:" + xml);

            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(xml);
            } catch (IOException e) {
                out.close();
                out = null;
                e.printStackTrace();
            }
            out.close();
        }

        //图片消息
        if (content.equals("图片")) {

            System.out.println("图片消息==============");

            //创建file对象
            File file = new File("C:\\Users\\Zhangsy\\Desktop\\二维码.jpg");

            WxMediaUploadResult result = null;
            try {
                result = wxService.getMaterialService().mediaUpload(WxConsts.MaterialType.IMAGE, file);
            } catch (WxErrorException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (result != null) {
                String mediaId = result.getMediaId();

                WxMpXmlOutImageMessage image = WxMpXmlOutImageMessage.IMAGE().toUser(fromUser).fromUser(touser).mediaId(mediaId).build();

                String xml = image.toXml();
                System.out.println("xml:" + xml);

                PrintWriter out = null;
                try {
                    out = response.getWriter();
                    out.print(xml);
                } catch (IOException e) {
                    out.close();
                    out = null;
                    e.printStackTrace();
                }
                out.close();

            }

        }

        if (content.equals("音乐")) {

            System.out.println("音乐消息==============");
            //上传素材  获取mediaid

            //创建file对象
            File file = new File("F:\\Music\\music.mp3");

            WxMediaUploadResult result = null;
            try {
                result = wxService.getMaterialService().mediaUpload(WxConsts.MaterialType.IMAGE, file);
            } catch (WxErrorException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (result != null) {
                String mediaId = result.getMediaId();
                WxMpXmlOutMusicMessage music = WxMpXmlOutMusicMessage.MUSIC().toUser(fromUser).fromUser(touser).title("Hello小姐.mp3").description("Hello小姐").musicUrl("http://weixindemo123.ngrok.cc/weixin/media/music.mp3").hqMusicUrl("http://weixindemo123.ngrok.cc/weixin/media/music.mp3").thumbMediaId(mediaId).build();


                String xml = music.toXml();
                System.out.println("xml:" + xml);

                PrintWriter out = null;
                try {
                    out = response.getWriter();
                    out.print(xml);
                } catch (IOException e) {
                    out.close();
                    out = null;
                    e.printStackTrace();
                }
                out.close();
            }
        }
    }
}

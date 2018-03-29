package com.oracle.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oracle.service.UserService;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@Controller
public class LoginHandler {


 private    String appid= "wxf12091ccaf315bf3";
 private    String secret= "ee79b88a51e28488ef32bc42c9bf2a55";

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "signin.do",method = RequestMethod.GET)//此处填自己要用到的项目名。
    //接收用户传过来的code，required=false表明如果这个参数没有传过来也可以。
    public  User getOpenid(@RequestParam(value="code",required=false)String code,String nickname,String headimg) {
        System.out.println(code);
        //接收从客户端获取的code
        //向微信后台发起请求获取openid的url
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        //这三个参数就是之后要填上自己的值。
        //替换appid，appsecret，和code
        String requestUrl = WX_URL.replace("APPID", this.appid).//填写自己的appid
                replace("SECRET", this.secret).replace("JSCODE", code).//填写自己的appsecret，
                replace("authorization_code", "authorization_code");

        //调用get方法发起get请求，并把返回值赋值给returnvalue
        String  returnvalue=GET(requestUrl);
        System.out.println(requestUrl);//打印发起请求的url
        System.out.println(returnvalue);//打印调用GET方法返回值
        //定义一个json对象。
        JSONObject convertvalue=new JSONObject();

        //将得到的字符串转换为json
        convertvalue=(JSONObject) JSON.parse(returnvalue);
        //把openid和sessionkey分别赋值给openid和sessionkey
        String openid=(String) convertvalue.get("openid");
        String sessionkey=(String) convertvalue.get("session_key");//定义两个变量存储得到的openid和session_key.
        System.out.println("return openid is ："+openid); //打印得到的openid
        System.out.println("return sessionkey is ："+sessionkey);//打印得到的sessionkey，

        //return openid;//返回openid
        User user = new User();
        user.setUserid(openid);
        user.setNickname(nickname);
        user.setHeadimg(headimg);
        user.setSessionkey(sessionkey);
        System.out.println("1"+user);
        userService.saveUserInfo(user);
        System.out.println("2"+user);
        return user;
    }
    //发起get请求的方法。
    public static String GET(String url) {
        String result = "";
        BufferedReader in = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            // 异常记录
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e2) {
                // 异常记录
            }
        }
        return result;
    }

/*此方法没有用到。就先放在这吧
public static String jedisOperate(String Session_key, String openid) {
    //这里需要引入一下jedis的dependenicy
    Jedis jedis = new Jedis("localhost");
    String openid = openid;
    String session_key = session_key;
    String uid = UUID.randomUUID().toString();
    StringBuffer sb = new StringBuffer();
    sb.append(openid);
    sb.append(","+session_key);
    jedis.set(uid, sb.toString());
    return uid;
    //如果需要获取登录用户的用户名和昵称，我们就需要注意一个问题，如果昵称中有中文就会出现乱码，这是因为微信对于中文是按照ISO-8859-1来进行编码的而我们需要的utf8编码，对于获取用户昵称出现乱码这个问题我们做一下简单的处理就可以解决：
    //String nickNameDecode = new String(nickName.getBytes("ISO-8859-1"),"utf-8");

}
*/





}

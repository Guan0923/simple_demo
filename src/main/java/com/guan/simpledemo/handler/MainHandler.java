package com.guan.simpledemo.handler;

import com.guan.simpledemo.pojo.DemoCommonContext;
import com.guan.simpledemo.pojo.ResultEntity;
import com.guan.simpledemo.pojo.User;
import com.guan.simpledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:04
 */
@Controller
public class MainHandler {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String MainPage() {
        return "index";
    }

    @RequestMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login/info.html")
    public String loginInfo(User user, HttpSession session, ModelMap modelMap) {
        session.setAttribute(DemoCommonContext.USER_LOGIN_SIGN, user);
        boolean res = userService.loginCheck(user);
        if (res) {
            return "redirect:/main.html";
        } else {
            modelMap.addAttribute("msg", "登陆失败");
            return "login";
        }
    }

    @RequestMapping("/main.html")
    public String mainPage(HttpSession session, ModelMap modelMap) {
        Object attribute = session.getAttribute(DemoCommonContext.USER_LOGIN_SIGN);
        if (attribute == null) {
            modelMap.addAttribute(DemoCommonContext.ERROR, "请先登陆");
            return "redirect:/login.html";
        }
        return "main";
    }

    @RequestMapping("/reg/page.html")
    public String createAccountPage(User user, ModelMap modelMap) {

        ResultEntity<String> res = userService.saveUserInfo(user);
        if (res.getCode() == 200) {
            modelMap.addAttribute(DemoCommonContext.USER_NAME, user.getUserName());
            return "login";
        }
        modelMap.addAttribute(DemoCommonContext.ERROR, res.getMessage());
        return "reg";
    }

    @RequestMapping("/logout.html")
    public String logout(HttpSession session, ModelMap modelMap) {

        if (session.getAttribute(DemoCommonContext.USER_LOGIN_SIGN) == null) {
            modelMap.addAttribute(DemoCommonContext.ERROR, "请先登录");
            return "login";
        }

        session.invalidate();

        return "redirect:/";
    }

}

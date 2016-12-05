package org.qydata.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.qydata.entity.User;
import org.qydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/11/20.
 */
@Controller

public class ViewController {

    private final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    UserService userService;
    /**
     * 登录
     * @return
     */
    @RequestMapping("/")
    public String loginUrl() { return "view/login";}
    /**
     * 未授权
     * @return
     */
    @RequestMapping("/view/unauthUrl")
    public String unauthUrl() {
        return "view/role";
    }
    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/view/successUrl")
    public String successUrl() {
        return "view/welcome";
    }

    @RequestMapping("/view/Login")
    public String login(HttpServletRequest request, String username, String password, RedirectAttributes model) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(username);
        System.out.println(password);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);

            User user = userService.findUserByUsername(username);
            request.getSession().setAttribute("userInfo", user);
            return "redirect:/view/successUrl";
        } catch (Exception e) {
            e.printStackTrace();
            model.addFlashAttribute("msg","用户名或密码不正确");
            return "redirect:/";
        }
    }
}

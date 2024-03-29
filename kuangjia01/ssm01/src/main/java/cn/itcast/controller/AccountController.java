package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户！");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list",accounts);
        return "list";
    }

    @RequestMapping("/save")
    public void saveAll(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}

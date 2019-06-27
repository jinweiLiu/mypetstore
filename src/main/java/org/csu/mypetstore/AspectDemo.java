package org.csu.mypetstore;

import com.google.gson.Gson;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Logger;

//申明是个切面
@Aspect
//申明是个spring管理的bean
@Component
@Order(1)
public class AspectDemo {
    private Logger log = Logger.getLogger(getClass().toString());
    private Gson gson = new Gson();


    @Autowired
    LogService logService;

    @Pointcut("execution(public * org.csu.mypetstore.controller.*.*(..))")
    private void ControllerAspect() {
    }

    //请求method前打印内容
    @Before(value = "ControllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String class_method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Log myLog = null;
        if (account != null) {
            switch (class_method) {
                case ("org.csu.mypetstore.controller.CatalogController.viewItem"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " viewed Item : " + joinPoint.getArgs()[0].toString());
                    break;
                case ("org.csu.mypetstore.controller.CatalogController.viewProduct"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " viewed Product : " + joinPoint.getArgs()[0].toString());
                    break;
                case ("org.csu.mypetstore.controller.CatalogController.viewCategory"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " viewed Category : " + joinPoint.getArgs()[0].toString());
                    break;
                case ("org.csu.mypetstore.controller.CartController.addCart"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " added " + joinPoint.getArgs()[0].toString()+" to cart");
                    break;
                case ("org.csu.mypetstore.controller.CartController.removeCart"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " removed " + joinPoint.getArgs()[0].toString()+" from cart");
                    break;
                case ("org.csu.mypetstore.controller.OrderController.viewOrder"):
                    myLog = new Log(account.getUsername(), new Date(), account.getUsername() + " made a new order ");

            }
            //log.info(class_method);
            //log.info(joinPoint.getArgs()[0].toString());
            if(myLog != null)
            logService.insertLog(myLog);

        }
    }



 }



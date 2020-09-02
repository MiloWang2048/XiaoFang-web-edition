package cn.milolab.xiaofang.filter;

import cn.milolab.xiaofang.bean.business.BasketBO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化session
 * @author milowang
 */
@WebFilter(filterName = "sessionInit", urlPatterns = "/*")
public class SessionInitFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest) servletRequest).getSession();
        var basketObject = session.getAttribute("basket");
        if(!(basketObject instanceof BasketBO)){
            basketObject = new BasketBO();
            var basket = (BasketBO) basketObject;
            basket.setBasketItems(new HashMap<>());
        }
        session.setAttribute("basket", basketObject);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

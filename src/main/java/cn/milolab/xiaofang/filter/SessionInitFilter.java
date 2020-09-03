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
 *
 * @author milowang
 */
@WebFilter(filterName = "sessionInit", urlPatterns = "/*")
public class SessionInitFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 获取session并转化为HttpSession
        var session = ((HttpServletRequest) servletRequest).getSession();

        // 获取购物车对象
        var basketObject = session.getAttribute("basket");

        // 如果购物车对象不合规定或为空，创建一个新的
        if (!(basketObject instanceof BasketBO)) {
            basketObject = new BasketBO();
            var basket = (BasketBO) basketObject;
            basket.setBasketItems(new HashMap<>());
            session.setAttribute("basket", basket);
        }

        // 继续执行请求
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

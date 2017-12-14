package com.xu.common.utility;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie操作工具类
 */
public class CookieUtil {

    /**
     * 添加Cookie
     *
     * @param httpServletResponse
     * @param httpServletRequest
     * @param name
     * @param value
     * @param age
     */
    public static void addCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String name, String value, Integer age) {
        String domain = getDomain(httpServletRequest);
        Cookie cookies = new Cookie(name, value);
        cookies.setPath("/");
        cookies.setMaxAge(age);
        cookies.setDomain(domain);
        httpServletResponse.addCookie(cookies);
    }

    public static String getCookieValue(HttpServletRequest httpServletRequest, String cookieName) {
        if (StringUtils.isBlank(cookieName)) {
            return null;
        }
        Cookie cookie = getCookie(httpServletRequest, cookieName);
        return null == cookie ? null : cookie.getValue();
    }

    /**
     * 获取Cookie
     *
     * @param httpServletRequest
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(HttpServletRequest httpServletRequest, String cookieName) {
        if (StringUtils.isBlank(cookieName)) {
            return null;
        }
        for (Cookie cookie : httpServletRequest.getCookies()) {
            return cookieName.equals(cookie.getName()) ? cookie : null;
        }
        return null;
    }

    /**
     * 删除Cookie
     *
     * @param httpServletResponse
     * @param httpServletRequest
     * @param cookieName
     * @return
     */
    public static boolean deleteCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String cookieName) {
        if (StringUtils.isBlank(cookieName)) {
            return false;
        }
        String domain = getDomain(httpServletRequest);
        Cookie cookie = getCookie(httpServletRequest, cookieName);
        if (cookie != null) {
            cookie.setMaxAge(0);//如果0，就说明立即删除
            cookie.setPath("/");//不要漏掉
            cookie.setDomain("." + domain);
            httpServletResponse.addCookie(cookie);
            return true;
        }
        return false;
    }


    /**
     * 清除所有cookie
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public static void clear(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (int i = 0, len = cookies.length; i < len; i++) {
            Cookie localCookie = new Cookie(cookies[i].getName(), null);
            localCookie.setMaxAge(0);
            localCookie.setPath("/");
            localCookie.setDomain(getDomain(httpServletRequest));
            Cookie domainCookie = new Cookie(cookies[i].getName(), null);
            domainCookie.setMaxAge(0);
            domainCookie.setPath("/");
            domainCookie.setDomain("." + getDomain(httpServletRequest));
            httpServletResponse.addCookie(localCookie);
            httpServletResponse.addCookie(domainCookie);
        }
    }

    /**
     * 获取域名
     *
     * @param httpServletRequest
     * @return
     */
    public static String getDomain(HttpServletRequest httpServletRequest) {
        String scheme = httpServletRequest.getScheme();
        String serverName = httpServletRequest.getServerName();
        return serverName.replace(scheme + "//", "");
    }

}
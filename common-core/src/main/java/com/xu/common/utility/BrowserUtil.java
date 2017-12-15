package com.xu.common.utility;


import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 浏览器工具类
 */
public class BrowserUtil {
                         
    private static final String IE11 = "rv:11.0";
    private static final String IE10 = "MSIE 10.0";
    private static final String IE9 = "MSIE 9.0";
    private static final String IE8 = "MSIE 8.0";
    private static final String IE7 = "MSIE 7.0";
    private static final String IE6 = "MSIE 6.0";
    private static final String MAXTHON = "Maxthon";
    private static final String QQ = "QQBrowser";
    private static final String GREEN = "GreenBrowser";
    private static final String SE360 = "360SE";
    private static final String FIREFOX = "Firefox";
    private static final String OPERA = "Opera";
    private static final String CHROME = "Chrome";
    private static final String SAFARI = "Safari";
    private static final String CAMINO = "Camino";
    private static final String OTHER = "其它";

    public final static String GBKENCODE = "GBK";
    public final static String ISO8859ENCODE = "ISO-8859-1";
    // \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
    // 字符串在编译时会被转码一次,所以是 "\\b"
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
    static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    //移动设备正则匹配：手机端、平板
    static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    private static boolean checkMobile(String userAgent) {
        // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        if (matcherPhone.find() || matcherTable.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检测是否是移动设备访问
     *
     * @param userAgent 浏览器标识
     * @return true:移动设备接入，false:pc端接入
     * @Title: checkMobile
     * @Date : 2014-7-7 下午01:29:07
     */
    public static boolean checkMobile(HttpServletRequest request) {
        //获取ua，用来判断是否为移动端访问
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        return checkMobile(userAgent);
    }

    // 判断是否是IE
    public static boolean isIE(HttpServletRequest request) {
        return (getUserAgent(request).toLowerCase().indexOf("msie") > 0 || getUserAgent(request).toLowerCase().indexOf("rv:11.0") > 0) ? true : false;
    }

    /**
     * 获取IE版本
     *
     * @param request
     * @return
     */
    public static Double getIEversion(HttpServletRequest request) {
        Double version = 0.0;
        if (getBrowserType(request, IE11)) {
            version = 11.0;
        } else if (getBrowserType(request, IE10)) {
            version = 10.0;
        } else if (getBrowserType(request, IE9)) {
            version = 9.0;
        } else if (getBrowserType(request, IE8)) {
            version = 8.0;
        } else if (getBrowserType(request, IE7)) {
            version = 7.0;
        } else if (getBrowserType(request, IE6)) {
            version = 6.0;
        }
        return version;
    }

    /**
     * 获取浏览器类型
     *
     * @param request
     * @return
     */
    public static String getBrowserType(HttpServletRequest request) {
        String browserType = null;
        if (getBrowserType(request, IE11)) {
            browserType = IE11;
        }
        if (getBrowserType(request, IE10)) {
            browserType = IE10;
        }
        if (getBrowserType(request, IE9)) {
            browserType = IE9;
        }
        if (getBrowserType(request, IE8)) {
            browserType = IE8;
        }
        if (getBrowserType(request, IE7)) {
            browserType = IE7;
        }
        if (getBrowserType(request, IE6)) {
            browserType = IE6;
        }
        if (getBrowserType(request, FIREFOX)) {
            browserType = FIREFOX;
        }
        if (getBrowserType(request, SAFARI)) {
            browserType = SAFARI;
        }
        if (getBrowserType(request, CHROME)) {
            browserType = CHROME;
        }
        if (getBrowserType(request, OPERA)) {
            browserType = OPERA;
        }
        if (getBrowserType(request, CAMINO)) {
            browserType = CAMINO;
        }
        return browserType;
    }

    private static boolean getBrowserType(HttpServletRequest request, String browserType) {
        return getUserAgent(request).indexOf(browserType) > 0 ? true : false;
    }


    public static String checkBrowse(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        if (regex(OPERA, userAgent))
            return OPERA;
        if (regex(CHROME, userAgent))
            return CHROME;
        if (regex(FIREFOX, userAgent))
            return FIREFOX;
        if (regex(SAFARI, userAgent))
            return SAFARI;
        if (regex(SE360, userAgent))
            return SE360;
        if (regex(GREEN, userAgent))
            return GREEN;
        if (regex(QQ, userAgent))
            return QQ;
        if (regex(MAXTHON, userAgent))
            return MAXTHON;
        if (regex(IE11, userAgent))
            return IE11;
        if (regex(IE10, userAgent))
            return IE10;
        if (regex(IE9, userAgent))
            return IE9;
        if (regex(IE8, userAgent))
            return IE8;
        if (regex(IE7, userAgent))
            return IE7;
        if (regex(IE6, userAgent))
            return IE6;
        return OTHER;
    }

    public static boolean regex(String regex, String str) {
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 客户端信息
     *
     * @param request
     * @return
     */
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("USER-AGENT");
    }

}
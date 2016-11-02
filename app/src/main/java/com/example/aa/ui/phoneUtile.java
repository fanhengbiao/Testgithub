package com.example.aa.ui;

import java.util.regex.Pattern;

/**
 * Created by fanhengbiao on 16-11-2.
 */

public class  phoneUtile {
    /**
     * 判断是否是电话号码
     * @param phone
     * @return
     */
    public static boolean isRightMobilePhoe(String phone) {
        if (phone == null) {
            return false;
        }
        String head1 = "";
        String head2 = "";

        // 去除前后的空白
        phone = phone.trim();

        // 判断输入的电话号码是否合法
        if (phone.length() < 11) {
            return false;
        } else {
            // 处理国内的+86开头
            if (phone.startsWith("+")) {
                phone = phone.substring(1);
            }
            if (phone.startsWith("86")) {
                phone = phone.substring(2);
            }
        }
        // 去除+86后电话号码应为11位
        if (phone.length() != 11) {

            return false;
        }
        // 判断去除+86后剩余的是否全为数字
        if (!isNumeric(phone)) {
            System.out.println(" not num");
            return false;
        }
        // 截取前3或前4位电话号码，判断运营商
        head1 = phone.substring(0, 3);
        head2 = phone.substring(0, 4);

        // 移动前三位
        boolean cmcctemp3 = head1.equals("135") || head1.equals("136")
                || head1.equals("137") || head1.equals("138")
                || head1.equals("139") || head1.equals("147")
                || head1.equals("150") || head1.equals("151")
                || head1.equals("152") || head1.equals("157")
                || head1.equals("158") || head1.equals("159")
                || head1.equals("182") || head1.equals("187")
                || head1.equals("188");

        if (cmcctemp3) {
            return true;
        }
        // 移动前4位
        boolean cmcctemp4 = head2.equals("1340") || head2.equals("1341")
                || head2.equals("1342") || head2.equals("1343")
                || head2.equals("1344") || head2.equals("1345")
                || head2.equals("1346") || head2.equals("1347")
                || head2.equals("1348");

        if (cmcctemp4) {
            return true;
        }
        // 联通前3位
        boolean unicomtemp = head1.equals("130") || head1.equals("131")
                || head1.equals("132") || head1.equals("145")
                || head1.equals("155") || head1.equals("156")
                || head1.equals("185") || head1.equals("186");

        if (unicomtemp) {
            return true;
        }
        // 电信前3位
        boolean telecomtemp = head1.equals("133") || head1.equals("153")
                || head1.equals("180") || head1.equals("189") || head1.equals("181");

        if (telecomtemp) {
            return true;
        }
        //虚拟运营商
        boolean virtualtemp = head1.equals("170");

        if (virtualtemp) {
            return true;
        }

        return false;
    }

    /**
     * 判断字符串是否只包含数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}

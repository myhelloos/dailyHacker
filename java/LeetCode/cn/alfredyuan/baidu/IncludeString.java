/**
 * 404 Team
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package cn.alfredyuan.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author alfred.yx
 * @version v 0.1 Sep 28, 2015 8:42:09 PM alfred Exp $
 */
public class IncludeString {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        Set<Character> inputs = new HashSet<>();
        for (int i=0; i<str1.length(); ++i) {
            inputs.add(str1.charAt(i));
        }
        for(int i=0; i<str2.length(); ++i) {
            if (!inputs.contains(str2.charAt(i))) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}

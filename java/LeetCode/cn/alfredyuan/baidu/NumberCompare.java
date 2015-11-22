/**
 * 404 Team
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package cn.alfredyuan.baidu;

import java.util.Scanner;

/**
 * 
 * @author alfred.yx
 * @version v 0.1 Sep 28, 2015 8:12:35 PM alfred Exp $
 */
public class NumberCompare {
    public static void main(String...args) {
        Scanner input = new Scanner(System.in);
        int readTime = Integer.parseInt(input.nextLine());
        NumberCompare compare = new NumberCompare();
        for (int i=0; i<readTime; ++i) {
            System.out.println(compare.getStrRankInBase(input.nextLine()));
        }
        input.close();
    }
    
    public long factorialResult(long baseValue) {
        if (baseValue <= 1l)
            return 1l;
        return baseValue * factorialResult(baseValue-1);
    }

    public int countSmallCharInRight(String str, int index) {
        int countRight = 0;
        char base = str.charAt(index);
        for (int i = index+1; i < str.length(); ++i)
            if (str.charAt(i) < base)
                ++countRight;
        return countRight;
    }

    int getStrRankInBase (String str)
    {
        int strLength = str.length();
        long leftMostFact = factorialResult(strLength);
        int rank = 1;

        for (int i = 0; i < strLength; ++i)
        {
            leftMostFact = leftMostFact / strLength - i;

            rank += leftMostFact * countSmallCharInRight(str, i);
        }

        return rank;
    }

}

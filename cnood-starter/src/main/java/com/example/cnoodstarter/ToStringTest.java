package com.example.cnoodstarter;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;

/**
 * @author ToStringTest
 * @Date 2023/6/13
 * @Description
 */
public class ToStringTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(arr);
        System.out.println("--------------------------------");
        System.out.println(JSON.toJSON(arr));
    }
}

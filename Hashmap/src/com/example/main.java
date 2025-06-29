package com.example;

import com.example.HashMap.MyHashMap;

public class main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>(22);
        mp.put("key1", 6);
        mp.put("key2", 10);

        System.out.println(mp.get("key1"));
        System.out.println(mp.get("key2"));

        System.out.println(mp.get("key3"));

        System.out.println(mp.remove("key1"));
        System.out.println(mp.get("key1"));
    }
}
package com.rizqi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    List<String> a = new ArrayList<>();
    a.add("e");
    List<String> b = Arrays.asList("a");
    b = a;
    System.out.println(Arrays.toString(b.toArray()));
    }
}

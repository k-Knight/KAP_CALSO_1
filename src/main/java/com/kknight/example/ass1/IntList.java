package com.kknight.example.ass1;

import java.util.ArrayList;

public class IntList {
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public boolean add(int number) {
        return list.add(number);
    }

    public boolean remove(int number) {
        boolean removed = false;
        while (list.contains(number)) {
            removed = true;
            list.remove(new Integer(number));
        }
        return removed;
    }

    public boolean clear() {
        list.clear();
        return true;
    }

    public int length() {
        return list.size();
    }

    @Override
    public String toString() {
        if (list.size() < 1)
            return "empty";

        String str = "";
        for (int numner: list) {
            str += numner + " ";
        }
        str = str.replaceAll("\\s+$", "");

        return str;
    }
}

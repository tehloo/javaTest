package com.company;

import java.util.*;

public class Main {
    static Map<String, Integer> sMapCount;
    static final boolean DEBUG = false;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("number of rectangles : ");
        String countMsg = scan.nextLine();
        int count = Integer.parseInt(countMsg);

        List<MyRect> rects = new ArrayList<MyRect>();
        for (int i = 0; i < count; i++) {
            String rectMsg = scan.nextLine();
            rects.add(getRect(rectMsg));
        }

        MyRect range = getMaxRange(rects);
        scanRanges(range, rects);

        if (DEBUG) {
            System.out.println("Rects " + count + "/ Range is " + range.toString());
        }


        Iterator<String> keys = sMapCount.keySet().iterator();

        int i = 0;
        int maxSize = 0;
        while (keys.hasNext()) {
            int size = sMapCount.get(keys.next());
            maxSize = maxSize < size ? size : maxSize;
            //System.out.println(i + " - " +  sMapCount.get(key));
            i++;
        }
        System.out.println(" All rect is " + (i - 1) + " and Max size is " + maxSize);

    }

    private static void scanRanges(MyRect range, List<MyRect> rects) {
        sMapCount = new HashMap<>();

        for (int x = range.x1; x < range.x2; x++) {
            for (int y = range.y1; y < range.y2; y++) {
                PosVal pos = new PosVal();
                for (int i = 0; i < rects.size(); i++) {
                    MyRect rect = rects.get(i);
                    if (rect.x1 <= x && rect.x2 > x
                            && rect.y1 <= y && rect.y2 > y) {
                        pos.markIt(i);
                    }
                }
                if (DEBUG) System.out.println(x + ", " + y + " = " + pos.toString());
                String key = pos.toString();
                if (sMapCount.get(key) == null) {
                    sMapCount.put(pos.toString(), 1);
                } else {
                    sMapCount.put(pos.toString(), sMapCount.get(key) + 1);
                }
            }
        }
    }

    public  int byteArrayToInt(byte bytes[]) {
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) << 8) |
                (((int)bytes[3] & 0xff)));
    }

    private static MyRect getMaxRange(List<MyRect> rects) {
        MyRect range = new MyRect(10000, 10000, 0, 0);
        for (int i = 0; i < rects.size(); i++) {
            MyRect rect = rects.get(i);
            if (DEBUG) System.out.println("Rect #" + i + " - " + rect.toString());
            MyRect normal = new MyRect(0,0,0,0);

            normal.x1 = rect.x1 < rect.x2 ? rect.x1 : rect.x2;
            normal.y1 = rect.y1 < rect.y2 ? rect.y1 : rect.y2;
            normal.x2 = rect.x1 > rect.x2 ? rect.x1 : rect.x2;
            normal.y2 = rect.y1 > rect.y2 ? rect.y1 : rect.y2;

            range.x1 = range.x1 < normal.x1 ? range.x1 : normal.x1;
            range.y1 = range.y1 < normal.y1 ? range.y1 : normal.y1;
            range.x2 = range.x2 > normal.x2 ? range.x2 : normal.x2;
            range.y2 = range.y2 > normal.y2 ? range.y2 : normal.y2;
        }

        return range;
    }

    private static MyRect getRect(String rectMsg) {
        String[] splits = rectMsg.split(" ");
        if (splits.length != 4) {
            new Exception("rect number is not matched.");
        }
        return new MyRect(splits);
    }


}

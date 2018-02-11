package com.tehloo;

public class MyRect {
    public int x1, y1, x2, y2;

    public MyRect(String[] splits) {

        for (int i = 0; i < splits.length; i++) {
            int n = Integer.parseInt(splits[i]);
            switch(i) {
                case 0:
                    x1 = n;
                    break;
                case 1:
                    y1 = n;
                    break;
                case 2:
                    x2 = n;
                    break;
                case 3:
                    y2 = n;
                    break;
            }

        }
    }

    public MyRect(MyRect rect) {
        this.x1 = rect.x1;
        this.y1 = rect.y1;
        this.x2 = rect.x2;
        this.y2 = rect.y2;
    }

    @Override
    public String toString() {
        return "MyRect{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public MyRect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

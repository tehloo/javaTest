package com.company;

public class MyRect {
    public int x1, y1, x2, y2;

    public MyRect(String[] splits) {
        int _x1 = 0, _y1 = 0, _x2 = 0, _y2 = 0;

        for (int i = 0; i < splits.length; i++) {
            int n = Integer.parseInt(splits[i]);
            switch(i) {
                case 0:
                    _x1 = n;
                    break;
                case 1:
                    _y1 = n;
                    break;
                case 2:
                    _x2 = n;
                    break;
                case 3:
                    _y2 = n;
                    break;
            }
            if (_x1 < _x2) {
                x1 = _x1;
                x2 = _x2;
            } else {
                x1 = _x2;
                x2 = _x1;
            }
            if (_y1 < _y2) {
                y1 = _y1;
                y2 = _y2;
            } else {
                y1 = _y2;
                y2 = _y1;
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

package com.lge.apt.jam.r2p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    private static final int STATUS_START = 0;
    private static final int STATUS_GET_CASES = 1;
    private static final int STATUS_L_M_N = 2;
    private static final int STATUS_L = 3;
    private static final int STATUS_M = 4;
    private static final int STATUS_N = 5;

    private final String mFilename;
    private GraphCase[] mCases;

    public DataLoader(String filename) {
        mFilename = filename;

        parse();
    }

    private void parse() {
        File f = new File(mFilename);
        try {
            Scanner sc = new Scanner(f);
            int status = STATUS_START;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                int[] nums = getNumbers(line);

                switch (status) {
                    case STATUS_START :
                        mCases = new GraphCase[nums[0]];


                        break;

                    case STATUS_GET_CASES :

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[] getNumbers(String line) {
        String[] tokens = line.split(" ");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.getInteger(tokens[i]);
        }
        return nums;
    }
}

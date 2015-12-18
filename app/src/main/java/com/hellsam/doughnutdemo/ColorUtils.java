package com.hellsam.doughnutdemo;

import android.graphics.Color;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by hellsam on 15/12/17.
 */
public class ColorUtils {
    /**
     * 获取某个百分比下的渐变颜色值
     * @param precent
     * @param colors
     * @return
     */
    public static int getCurrentColor(float precent, int[] colors){
        float[][] f = new float[colors.length][3];
        for(int i=0;i<colors.length;i++){
            int red = (colors[i] & 0xff0000) >> 16;
            int green = (colors[i] & 0x00ff00) >> 8;
            int blue = (colors[i] & 0x0000ff);
            f[i][0] = red;
            f[i][1] = green;
            f[i][2] = blue;
        }
        float[] result = new float[3];
//        for(int i=0;i<3;i++){
//            if(precent < 0.5f){
//                result[i] = f[0][i] - (f[0][i] - f[1][i])*precent;
//            }else if(precent == 0.5f){
//                result[i] = f[1][i];
//            }else if(precent > 0.5f){
//                result[i] = f[1][i] - (f[1][i] - f[2][i])*precent;
//            }
//        }
        if(precent < 0.5f){
            result[0] = 255f*precent*2;
            result[1] = 255;
            result[2] = 0;
        }else if(precent == 0.5f){
            result[0] = 255;
            result[1] = 255;
            result[2] = 0;
        }else if(precent > 0.5f){
            result[0] = 255;
            result[1] = 255 - 255f*precent*2;
            result[2] = 0;
        }
        Log.e("TAG", Arrays.toString(result));
        Log.e("TAG", Color.rgb((int) result[0], (int) result[1], (int)result[2]) + "");
        return Color.rgb((int) result[0], (int) result[1], (int)result[2]);
    }

}

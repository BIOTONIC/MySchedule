package ca.wlu.hztw.myschedule.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import ca.wlu.hztw.myschedule.R;

import java.util.*;

// https://stackoverflow.com/a/36399045

public class ColorManager {
    private static ColorManager INSTANCE = null;
    public static int THEME_PICS = 0;
    private static int THEME_BRIGHT = 0;

    private int vibrant;
    private int vibrantDark;
    private int vibrantLight;
    private int muted;
    private int mutedDark;
    private int mutedLight;

    private ColorManager(Resources resources) {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, getPicture());

        Palette palette = Palette.from(bitmap).generate();
        vibrant = palette.getVibrantSwatch().getRgb();
        vibrantDark = palette.getDarkVibrantColor(vibrant);
        vibrantLight = palette.getLightVibrantColor(vibrant);
        muted = palette.getMutedColor(vibrant);
        mutedDark = palette.getDarkMutedColor(vibrant);
        mutedLight = palette.getLightMutedColor(vibrant);
    }

    public static synchronized ColorManager getInstance(Resources resources) {
        if (INSTANCE == null) {
            INSTANCE = new ColorManager(resources);
        }
        return INSTANCE;
    }

    public static int getPicture() {
        if (THEME_PICS == 0) {
            Random r = new Random();
            List<Integer> list = new ArrayList<Integer>();
            list.add(R.drawable.spring);
            list.add(R.drawable.summer);
            list.add(R.drawable.fall);
            list.add(R.drawable.winter);
            THEME_PICS = list.get(r.nextInt(2));
            THEME_BRIGHT = r.nextInt(3);
        }
        return THEME_PICS;
    }

    public int getVibrant() {
        switch (THEME_BRIGHT) {
            case 0:
                return vibrantLight;
            case 1:
                return vibrantDark;
            default:
                return vibrant;
        }
    }

    public int getMuted() {
        switch (THEME_BRIGHT) {
            case 0:
                return mutedLight;
            case 1:
                return mutedDark;
            default:
                return muted;
        }
    }

}

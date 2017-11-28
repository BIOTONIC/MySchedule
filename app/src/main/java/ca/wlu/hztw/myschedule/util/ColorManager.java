package ca.wlu.hztw.myschedule.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import ca.wlu.hztw.myschedule.R;

// https://stackoverflow.com/a/36399045

public class ColorManager {
    private static ColorManager INSTANCE = null;
    public static int THEME_PIC = R.drawable.spring;

    private int vibrant;
    private int vibrantDark;
    private int vibrantLight;
    private int muted;
    private int mutedDark;
    private int mutedLight;

    private ColorManager(Resources resources, int resourceId) {
        THEME_PIC = resourceId;
        getColor(resources);
    }

    private ColorManager(Resources resources) {
        getColor(resources);
    }

    private void getColor(Resources resources) {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, THEME_PIC);

        Palette palette = Palette.from(bitmap).generate();
        vibrant = palette.getVibrantSwatch().getRgb();
        vibrantDark = palette.getDarkVibrantColor(vibrant);
        vibrantLight = palette.getLightVibrantColor(vibrant);
        muted = palette.getMutedColor(vibrant);
        mutedDark = palette.getDarkMutedColor(vibrant);
        mutedLight = palette.getLightMutedColor(vibrant);
    }

    public static synchronized ColorManager getInstance(Resources resources, int resourceId) {
        if (INSTANCE == null) {
            INSTANCE = new ColorManager(resources, resourceId);
        }
        return INSTANCE;
    }

    public static synchronized ColorManager getInstance(Resources resources) {
        if (INSTANCE == null) {
            INSTANCE = new ColorManager(resources);
        }
        return INSTANCE;
    }

    public int getVibrant() {
        return vibrant;
    }

    public int getVibrantDark() {
        return vibrantDark;
    }

    public int getVibrantLight() {
        return vibrantLight;
    }

    public int getMuted() {
        return muted;
    }

    public int getMutedDark() {
        return mutedDark;
    }

    public int getMutedLight() {
        return mutedLight;
    }
}

package com.example.proy_comidas_ep1.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.proy_comidas_ep1.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_reporte, R.string.tab_registro, R.string.tab_gastos, R.string.tab_ingresos};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment destino = null;
        switch (position) {
            case 0:
                destino = new ReporteFragment();
                break;
            case 1:
                destino = new RegistroFragment();
                break;
            case 2:
                destino = new GastosFragment();
                break;
            case 3:
                destino = new IngresosFragment();
                break;
           
        }
        return destino;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}
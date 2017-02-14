package com.somo.test.view;

/**
 * Created by krcho on 2015-10-14.
 */
public interface TabColorizer {

    /**
     * @return return_remote the color of the indicator used when {@code position} is selected.
     */
    int getIndicatorColor(int position);

    /**
     * @return return_remote the color of the divider drawn to the right of {@code position}.
     */
    int getDividerColor(int position);

}
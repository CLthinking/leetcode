package com.uestc.designpattern.principle.denpendenceinversion;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:54
 */
public class CLthinking {

    private ICource iCource;

    public void setiCource(ICource iCource) {
        this.iCource = iCource;
    }

    public void studyCource() {
       iCource.studyCource();
   }
}

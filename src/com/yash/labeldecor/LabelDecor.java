package com.yash.labeldecor;

import android.graphics.*;
import android.widget.TextView;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
public class LabelDecor extends AndroidNonvisibleComponent {

  public LabelDecor(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction
  public void AddShadow(AndroidViewComponent label,int radius,int shadowX,int shadowY,String hexColor){
    TextView tv = (TextView) label.getView();
    tv.setShadowLayer(radius,shadowX,shadowY, Color.parseColor(hexColor));
    tv.invalidate();
  }

  @SimpleFunction
  public void AddGradient(AndroidViewComponent label, String startColor,String endColor){
    TextView tv = (TextView) label.getView();
    tv.invalidate();
    Shader textShader = new LinearGradient(
            0,
            0,
            tv.getMeasuredWidth(),
            0,
            Color.parseColor(startColor),
            Color.parseColor(endColor),
            Shader.TileMode.CLAMP);
    tv.getPaint().setShader(textShader);
  }

  @SimpleFunction
  public void AddStroke(AndroidViewComponent label,float outlineWidth){
    TextView tv = (TextView) label.getView();
    tv.getPaint().setStyle(Paint.Style.STROKE);
    tv.getPaint().setStrokeWidth(outlineWidth);
    tv.invalidate();
   }

  @SimpleFunction
  public void AddBlurEffect(AndroidViewComponent label, float radius,String color, String Blurtype){
    TextView tv = (TextView) label.getView();
    BlurMaskFilter filter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.valueOf(Blurtype));
    tv.getPaint().setMaskFilter(filter);
    tv.setTextColor(Color.parseColor(color));
    tv.invalidate();
  }

  @SimpleProperty
  public String BlurNormal(){
    return "NORMAL";
  }

  @SimpleProperty
  public String BlurInner(){
    return "INNER";
  }

  @SimpleProperty
  public String BlurOuter(){
    return "OUTER";
  }

  @SimpleProperty
  public String BlurSolid(){
    return "SOLID";
  }

}

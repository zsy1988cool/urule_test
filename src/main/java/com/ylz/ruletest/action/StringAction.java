package com.ylz.ruletest.action;

import com.bstek.urule.model.library.action.annotation.ActionBean;
import com.bstek.urule.model.library.action.annotation.ActionMethod;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;

/**
 * @author Jacky.gao
 * @since 2015年11月27日
 */
@ActionBean(name="字符串")
public class StringAction {
    public StringAction() {
        int i = 0;
        i++;
    }
    @ActionMethod(name="去空格")
    @ActionMethodParameter(names={"目标字符串"})
    public String trim(String str){
        if(str==null){
            return str;
        }
        return str.trim();
    }

    @ActionMethod(name="指定起始的字符串截取")
    @ActionMethodParameter(names={"目标字符串","开始位置","结束位置"})
    public String substring(String str,int start,int end){
        return str.substring(start, end);
    }
}
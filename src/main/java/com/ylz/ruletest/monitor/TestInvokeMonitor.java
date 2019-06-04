package com.ylz.ruletest.monitor;

//import com.bstek.urule.model.GeneralEntity;
import com.bstek.urule.runtime.monitor.InvokeMonitor;
import com.bstek.urule.runtime.monitor.MonitorData;

/**
 * @author Jacky.gao
 * @since 2018年12月17日
 */
public class TestInvokeMonitor implements InvokeMonitor {

    public void doMonitor(MonitorData data) {
        if(data.isShowLog()) {
            System.out.println("日志："+data.getLogs());
        }
        if(data.isShowFiredFlowNodeList()) {
            System.out.println("触发的规则节点列表："+data.getFiredFlowNodeList());
        }
        if(data.isShowMatchedRuleList()) {
            System.out.println("匹配的规则列表："+data.getMatchedRuleList());
        }
        if(data.isShowNotMatchRuleList()) {
            System.out.println("不匹配的规则列表："+data.getNotMatchRuleList());
        }
        System.out.println("耗时："+data.getTotalDuration());
        System.out.println("packageInfo："+data.getPackageInfo());
        System.out.println("输入数据:"+data.getInputData());
        System.out.println("输出数据:"+data.getOutputData());
    }
}
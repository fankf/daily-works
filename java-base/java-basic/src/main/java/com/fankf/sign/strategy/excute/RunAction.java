package com.fankf.sign.strategy.excute;

import com.fankf.sign.strategy.AbstractAction;

public class RunAction extends AbstractAction {
    @Override
    public void action(String name) {
        System.out.println(name+"说：“我想跑着去远方 ...”");
    }
}

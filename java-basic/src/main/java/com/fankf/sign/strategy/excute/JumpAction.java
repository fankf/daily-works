package com.fankf.sign.strategy.excute;

import com.fankf.sign.strategy.AbstractAction;

public class JumpAction extends AbstractAction {
    @Override
    public void action(String name) {
        System.out.println(name + "说：“跳一跳就长大了 ...”");
    }
}

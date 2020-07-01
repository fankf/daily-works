package com.fankf.sign.strategy;

import com.fankf.sign.strategy.excute.JumpAction;
import com.fankf.sign.strategy.excute.RunAction;

public class Introduce {
    public static void main(String[] args) {
        Person person = new Person(new JumpAction());
        person.excute("xiao ming");

        Person person1 = new Person(new RunAction());
        person1.excute("xiao hong");
    }
}

package com.fankf.sign.mediator;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 10:03
 * @package com.fankf.sign.madiator
 */
public class Mediator implements Media{

    private User1 user1;
    private User2 user2;

    public User1 getUser1() {
        return user1;
    }

    public User2 getUser2() {
        return user2;
    }

    @Override
    public void createUser(){
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void exe(){
        user1.exe();
        user2.exe();
    }
}

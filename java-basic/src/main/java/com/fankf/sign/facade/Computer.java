package com.fankf.sign.facade;

/**
 * **************************************
 *
 * @author fankunfeng
 * @datetime 2020-07-23 11:43
 * @package com.fankf.sign.facade
 * ***************************************
 */
public class Computer {

    private CPU cpu;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
    }

    public void start() {
        cpu.start();
        memory.start();
    }

    public void destroy() {
        cpu.destroy();
        memory.destroy();
    }
}

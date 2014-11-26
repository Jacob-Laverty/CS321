package com.cs.gmu.project321;

/**
 * Created by Hayley on 11/25/2014.
 */
public class HVACDevice {

    public boolean currentMode;
    protected long physicalAddress;

    void on(){ currentMode = true; }

    void off(){ currentMode = false; }
}

package animate;

import java.awt.Container;

interface Animator {
    final static   //half size of the screen
        int MX = Animation.scaled(320), MY = Animation.scaled(240);
    int doTick(); //performs drawing, returns milliseconds before next call
    Container container(); //drawing area -- called once
    String description(); //what does it do?
    String author();  //who made it?
}

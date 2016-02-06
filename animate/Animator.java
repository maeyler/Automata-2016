package animate;

import java.awt.Container;

interface Animator {
    int doTick(); //performs drawing, returns milliseconds before next call
    Container container(); //drawing area -- called once
    String description(String source); //what does it do?
    String author();
}

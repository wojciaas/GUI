package Ćwiczenia.cw10.exent;

import java.awt.*;
import java.util.EventObject;

public
    class ColorEvent
    extends EventObject {

    private Color color;

    public ColorEvent(Object source, Color color) {
        super(source);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

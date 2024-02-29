package com.ushmodin.patterns.template.factory;

import com.ushmodin.patterns.template.MovingBox;
import com.ushmodin.patterns.template.MovingObject;
import com.ushmodin.patterns.template.MovingStar;

import java.awt.*;

public class MovingBoxFactory implements MovingObjectFactory {

    Dimension dimension;

    public MovingBoxFactory(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public MovingObject createInstance() {
        return new MovingBox(dimension);
    }
}

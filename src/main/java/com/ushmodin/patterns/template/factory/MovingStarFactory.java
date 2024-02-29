package com.ushmodin.patterns.template.factory;

import com.ushmodin.patterns.template.MovingBall;
import com.ushmodin.patterns.template.MovingObject;
import com.ushmodin.patterns.template.MovingStar;

import java.awt.*;

public class MovingStarFactory implements MovingObjectFactory {

    Dimension dimension;

    public MovingStarFactory(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public MovingObject createInstance() {
        return new MovingStar(dimension);
    }
}

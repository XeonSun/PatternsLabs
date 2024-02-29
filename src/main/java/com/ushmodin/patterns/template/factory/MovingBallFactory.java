package com.ushmodin.patterns.template.factory;

import com.ushmodin.patterns.template.MovingBall;
import com.ushmodin.patterns.template.MovingObject;

import java.awt.*;

public class MovingBallFactory implements MovingObjectFactory {

    Dimension dimension;

    public MovingBallFactory(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public MovingObject createInstance() {
        return new MovingBall(dimension);
    }
}

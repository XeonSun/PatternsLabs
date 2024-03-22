package com.ushmodin.patterns.mvc;

import java.awt.geom.Point2D;
import java.util.stream.IntStream;

public class Controller {
        private Model model;
        private Scene view;

    public Controller(Model model, Scene view) {
        this.model = model;
        this.view = view;
    }

    void updateModel(){
        System.out.println("update model");
        var table = view.getTableModel();
        model.calcPoints(IntStream.range(0,table.getRowCount()-1).mapToObj(i-> new Point2D.Double(
                Double.parseDouble((String) table.getValueAt(i,0)),
                0)
        ).toArray(Point2D.Double[]::new));
        var res = model.getPoints();
        IntStream.range(0,table.getRowCount()-1).forEach(i -> table.setValueAt(res[i].y,i,1));
    }
}

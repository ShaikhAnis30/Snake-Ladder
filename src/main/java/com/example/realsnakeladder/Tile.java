package com.example.realsnakeladder;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Tile extends Rectangle { // all the properties of rectangle class will be used here
    public Tile(int width , int height){
        setWidth(width);  // tile width
        setHeight(height); // tile height
        setFill(Color.RED); // tile color
        setStroke(Color.BLACK); // border of tile
        // 1st step
    }
}

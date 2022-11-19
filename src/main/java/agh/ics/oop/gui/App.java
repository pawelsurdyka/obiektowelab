package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import agh.ics.oop.MapBoundary;

public class App extends Application {
    List<Animal> A;
    List<Grass> G;
    Vector2d[] positions = new Vector2d[2];
    Vector2d[] Border;
    int xs;
    int ys;
    int xe;
    int ye;
    @Override
    public void init(){
        try {
            List<String> args = getParameters().getRaw();
            new OptionsParser();
            ArrayList<MoveDirection> directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(10);
            positions[0] = new Vector2d(2,2);
            positions[1] = new Vector2d(3,4);
            SimulationEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            A = engine.getA();
            G = engine.getG();
            Border = engine.getBorder();
        } catch(IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("World");
        GridPane grid = new GridPane();
        xs = Border[0].x;
        ys = Border[0].y;
        xe = Border[1].x;
        ye = Border[1].y;
        for(int i=0;i<=xe-xs+1;i++){
            for(int j=0;j<=ye-ys+1;j++){
                int X = i+xs-1;
                int Y = ye-j+1;
                if(i==0 && j!=0){
                    grid.getRowConstraints().add(new RowConstraints(25)); // column 1 is 200 wide
                    Label lab1 = new Label("" + Y);
                    GridPane.setHalignment(lab1, HPos.CENTER);
                    grid.add(lab1, i, j, 1, 1);
                }
                else if(j==0 && i!=0){
                    grid.getColumnConstraints().add(new ColumnConstraints(25)); // column 0 is 100 wide
                    Label lab1 = new Label("" + X);
                    GridPane.setHalignment(lab1, HPos.CENTER);
                    grid.add(lab1, i, j, 1, 1);
                }
                else if(i==0 && j==0){
                    grid.getRowConstraints().add(new RowConstraints(25)); // column 1 is 200 wide
                    grid.getColumnConstraints().add(new ColumnConstraints(25)); // column 0 is 100 wide
                    Label lab1 = new Label("x/y");
                    GridPane.setHalignment(lab1, HPos.CENTER);
                    grid.add(lab1, i, j, 1, 1);
                }
                else {
                    for(Grass g:G){
                        if(g.getPosition().x==X && g.getPosition().y==Y) {
                            Label lab1 = new Label("*");
                            GridPane.setHalignment(lab1, HPos.CENTER);
                            grid.add(lab1, i, j, 1, 1);
                        }
                    }
                    for(Animal a:A){
                        if(a.getPosition().x==X && a.getPosition().y==Y) {
                            Label lab1 = new Label("A");
                            GridPane.setHalignment(lab1, HPos.CENTER);
                            grid.add(lab1, i, j, 1, 1);
                        }
                    }
                }
            }
        }
//        Label label = new Label("Zwierzak");
//        Scene scene = new Scene(label, 400, 400);
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
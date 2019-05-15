package controllers;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class AnimateStoreWord {

        private ParallelTransition an0 = new ParallelTransition();
        private ParallelTransition an1 = new ParallelTransition();
        private ParallelTransition an2 = new ParallelTransition();
        private ParallelTransition an3 = new ParallelTransition();
        private ParallelTransition an4 = new ParallelTransition();
        private ParallelTransition an5 = new ParallelTransition();
        private ArrayList<Shape> paths;
        private ArrayList<Circle> circle;

        public AnimateStoreWord(ArrayList<Circle> circle, ArrayList<Shape> lines) {
            this.circle = circle;
            paths = lines;
            createArray();

        }

        protected void animate() {

            SequentialTransition seq = new SequentialTransition();
            seq.getChildren().addAll(an0, an1, an2, an3, an4, an5);
            seq.play();

        }

        protected void createArray() {

            for(int i = 0; i < paths.size(); i++) {
                PathTransition t0 = new PathTransition();
                Circle cir = circle.get(i);
                Shape path = paths.get(i);
                t0.setDuration(Duration.seconds(2));
                t0.setPath(path);
                t0.setNode(cir);

                circle.get(i).relocate(path.getTranslateX() - 8.5, path.getTranslateY() - 8.5);

                if(i < 2) {
                    an0.getChildren().add(t0);
                } else if( i < 3) {
                    an1.getChildren().add(t0);
                } else if( i < 9) {
                    an2.getChildren().add(t0);
                }else if( i < 12) {
                    an3.getChildren().add(t0);
                } else if( i < 14) {
                    an4.getChildren().add(t0);
                } else {
                    an5.getChildren().add(t0);
                }
            }




    }
}

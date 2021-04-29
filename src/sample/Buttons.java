package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;

public class Buttons {

    static Button[] buttons = new Button[16];
    static Label label = new Label("");
    static String oldValue = "";
    static String newValue = "";
    static char opp;
    static boolean op = false;


    protected static Scene getScene() {

        label.setTranslateX(10);
        label.setTranslateY(30);

        Pane pane = new Pane();
        pane.getChildren().addAll(getGridPane(),label);
        pane.setId("pane");
        pane.getStylesheets().add("sample/css.css");

        return  new Scene(pane,500,603);
    }

    private static GridPane getGridPane() {

        GridPane gridPane = new GridPane();
        gridPane.setTranslateY(150);
        gridPane.setPrefSize(500,450);
        gridPane.setId("gridPane");


        int row = 0;
        int column = 0;

        for(int i = 0; i < buttons.length; i++) {

            buttons[i] = new Button();
            buttons[i].setPrefSize(300,100);
            set(buttons[i],i);
            GridPane.setMargin(buttons[i],new Insets(3) );

            gridPane.add(buttons[i], column, row);

            column++;
            if(column == 4){
                row++;
                column =0;
            }
        }
        return gridPane;
    }

    private static void set(Button button, int i) {

        button.addEventHandler(MouseEvent.ANY,(MouseEvent e)->{
            InnerShadow innerShadow = new InnerShadow(15,Color.WHITE);
            if(e.getEventType().equals(MouseEvent.MOUSE_ENTERED)) { button.setEffect(innerShadow);}
            else if(e.getEventType().equals(MouseEvent.MOUSE_EXITED)) {button.setEffect(null); }
        });

        if(i >= 0 && i <= 3) {
            button.setId("operation");
            if(i == 0) { button.setText("-");

            button.setOnMouseClicked((MouseEvent e)-> {
                if (!oldValue.equals("")) {
                    op = true;
                    opp = '-';
                    label.setText(label.getText() + " " + button.getText());
                }
            }
            );}

            else if(i == 1) { button.setText("+");

            button.setOnMouseClicked((MouseEvent e)-> {
                if (!oldValue.equals("")) {
                    op = true;
                    opp = '+';
                    label.setText(label.getText() + " " + button.getText());
                }
            });
            }

            else if(i == 2) { button.setText("x");

            button.setOnMouseClicked((MouseEvent e)-> {
                if (!oldValue.equals("")) {
                    op = true;
                    opp = 'x';
                    label.setText(label.getText() + " " + button.getText());
                }
            });}

            else { button.setText("÷");

            button.setOnMouseClicked((MouseEvent e)-> {
                if (!oldValue.equals("")) {
                    op = true;
                    opp = '/';
                    label.setText(label.getText() + " " + button.getText());
                }
            });}
        }

        else if (i >= 4 && i <= 11 || i == 13 || i == 14) {
            button.setId("nums");

            if(i == 4) { button.setText("0");
                    button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op)
                    oldValue += button.getText();
                else
                    newValue += button.getText();
            });
            }

            else if(i == 5) { button.setText("1");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
            if(!op) oldValue += button.getText();
            else newValue += button.getText();
            });
            }

            else if(i == 6) { button.setText("2");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                label.setText(label.getText()+button.getText());
            if(!op) oldValue += button.getText();
            else newValue += button.getText();
            });
            }

            else if(i == 7) { button.setText("3");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op) oldValue += button.getText();
                else newValue += button.getText();
            });
            }

            else if(i == 8) { button.setText("4");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op) oldValue += button.getText();
                else newValue += button.getText();
            });
            }

            else if(i == 9) { button.setText("5");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op) oldValue += button.getText();
                else newValue += button.getText();
            });
            }

            else if(i == 10){ button.setText("6");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
            if(!op) oldValue += button.getText();
            else newValue += button.getText();
            });
            }

            else if(i == 11){ button.setText("7");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op) oldValue += button.getText();
                else newValue += button.getText();
            });
            }

            else if(i == 13) {
                button.setText("8");
                button.setOnMouseClicked((MouseEvent e) -> {
                    if (label.getText().length() <= 5) {
                        label.setText(label.getText() + button.getText());
                        if (!op) oldValue += button.getText();
                        else newValue += button.getText();
                    }
                });

            }

            else  { button.setText("9");
            button.setOnMouseClicked((MouseEvent e) ->{
                if(label.getText().length() <= 5)
                    label.setText(label.getText()+button.getText());
                if(!op) oldValue += button.getText();
                else newValue += button.getText();
            });
            }
        }

        else if (i == 12){
            button.setId("clear");button.setOnMouseClicked((MouseEvent e) ->{
                label.setText("");
            oldValue = "";
            newValue = "";
            opp = 'd';
            op = false;
            });
            button.setText("C");
        }

        else {
            button.setId("result");
            button.setText("=");
            button.setOnMouseClicked((MouseEvent e)->{
                int fn = Integer.parseInt(oldValue);
                System.out.println(fn);
                int sn = Integer.parseInt(newValue);
                if(opp == '-')
                    label.setText(label.getText() + " = " + (fn-sn));
                if(opp == '+')
                    label.setText(label.getText() + " = " + (fn+sn));
                if(opp == '/'){
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    label.setText(label.getText() + " = " + decimalFormat.format((double)fn/sn));
                }

                if(opp == 'x')
                    label.setText(label.getText() + " = " + (fn*sn));



            });
        }
    }
}

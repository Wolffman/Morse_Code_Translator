/*
 * Copyright (c) 2011, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

public class FXMLExample extends Application {
    
    public static void main(String[] args) {
        Application.launch(FXMLExample.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/Users/student/IdeaProjects/Morse_Code_Translator1/res/fxml_example.fxml"));


        VBox root= new VBox();
        root.setAlignment(Pos.CENTER);



//        VBox root = new VBox();


        Label label = new Label("Morse Code Translation");
        label.setId("outputText");
        //label.setStyle("-fx-padding: 0 0 0 110;" +"");
        root.getChildren().add(label);

//        Label label3 = new Label("code");
//        label3.setId("code");
//        //label3.setStyle("-fx-padding: 120 10 10 130;" +"");
//        root.getChildren().add(label3);

        root.setSpacing(20);
        TextArea text = new TextArea("");
        text.setId("inputText");
//        text.setMinHeight(0);
        text.setMaxHeight(100);
//        text.setMinWidth(0);
        text.setMaxWidth(200);
        root.getChildren().add(text);

        Button go = new Button("Translate!");
        go.setId("translation");
        go.setStyle("-fx-padding: 5 5 5 5;" +"");
        root.getChildren().add(go);


        stage.setTitle("Morse Code/English Translator");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jcoil on 2021-01-07
 */
public class Controller extends Application {
    public Model model;
    public View view;
    private HashMap<String,String> searchState;


    @Override
    public void start(Stage primaryStage) throws Exception {
        searchState = new HashMap<>();
        searchState.put("Region","");
        searchState.put("Suit","");
        searchState.put("Rank","");
        searchState.put("SearchField","");
        //Instantiate the model and view here
        model = new Model();
        model.SampleCards();
        view = new View(model);

        //Place view on scene and put scene on stage, then show stage
        primaryStage.setScene(new Scene(view, 450, 400));
        primaryStage.show();

        //EVENTHANDLERS
        //Handling events for region search function
        for(int i = 0; i < view.regionButtons.size();i++){
            int specificIndex = i;
            view.regionButtons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleRegionSearch(view.regionButtons.get(specificIndex).getText());
                }
            });
        }

        //Handling events for suit search function
        for(int i = 0; i < view.suitButtons.size();i++){
            int specificIndex = i;
            view.suitButtons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleSuitSearch(view.suitButtons.get(specificIndex).getText());
                }
            });
        }

        //Handling events for rank search function
        for(int i = 0; i < view.rankButtons.size();i++){
            int specificIndex = i;
            view.rankButtons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleRankSearch(view.rankButtons.get(specificIndex).getText());
                }
            });
        }

        //Clear button will clear all selected toggles
        view.clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(RadioButton b: view.regionButtons){
                    b.setSelected(false);
                }
                searchState.put("Region","");
                for(RadioButton b: view.suitButtons){
                    b.setSelected(false);
                }
                searchState.put("Suit","");
                for(RadioButton b: view.rankButtons){
                    b.setSelected(false);
                }
                searchState.put("Rank","");
                model.displayList(model.search(searchState));
                view.update();
            }
        });

        //Search Button checks if card name contains search string
        view.searchField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //Check if string is empty
                handleSearchField(view.searchField.getText().trim());
//                if(!view.searchField.getText().isEmpty()) {
//
//                }
            }
        });

    }
    //Handle the search field event handler
    public void handleSearchField(String s){
        //Update search state
        searchState.put("SearchField",s);
        //Update model and view
        model.displayList(model.search(searchState));
        view.update();
    }


    public void handleRegionSearch(String r){
        //Update search state
        searchState.put("Region",r);
        //Update model and view
        model.displayList(model.search(searchState));
        view.update();
    }

    public void handleSuitSearch(String s){
        //Update search state
        searchState.put("Suit",s);
        //Update model and view
        model.displayList(model.search(searchState));
        view.update();
    }

    public void handleRankSearch(String rnk){
        //Update Search state
        searchState.put("Rank",rnk);
        //Update model and view
        model.displayList(model.search(searchState));
        view.update();
    }

}

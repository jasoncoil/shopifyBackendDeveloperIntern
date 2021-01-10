import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * Created by jcoil on 2021-01-07
 */
public class View extends GridPane {
    public Model model;
    public TextField searchField;
    public ArrayList<RadioButton> regionButtons;
    public ArrayList<RadioButton> suitButtons;
    public ArrayList<RadioButton> rankButtons;
    public ArrayList<ImageView> images;
    public GridPane imageDisplay;
    public ScrollPane scrollImagePane;
    public GridPane searchFunctionDisplay;
    public ToggleGroup regionToggle;
    public ToggleGroup suitToggle;
    public ToggleGroup rankToggle;
    public Button clearButton;

    public View(Model m){
        model = m;
        imageDisplay = new GridPane();
        searchFunctionDisplay = new GridPane();
        scrollImagePane = new ScrollPane();
        images = new ArrayList<>();
        //Button that can clear selected toggles
        clearButton = new Button("Clear Selected Toggles");
        searchFunctionDisplay.add(clearButton,4,1);

        //Creating the label and radio buttons for the region search function
        Label regionSearch = new Label("Search by Region");
        searchFunctionDisplay.add(regionSearch,2,1,2,1);
        regionToggle = new ToggleGroup();
        regionButtons = new ArrayList<>();
        regionButtons.add(new RadioButton("Kabul"));
        regionButtons.add(new RadioButton("Punjab"));
        regionButtons.add(new RadioButton("Kandahar"));
        regionButtons.add(new RadioButton("Herat"));
        regionButtons.add(new RadioButton("Persia"));
        regionButtons.add(new RadioButton("Transcaspia"));
        //Add them to toggle group
        for(int i =0; i<regionButtons.size();i++){
            regionButtons.get(i).setToggleGroup(regionToggle);
            if(i % 2 == 0) {
                searchFunctionDisplay.add(regionButtons.get(i), 2, 2 + i/2);
            }
            else{
                searchFunctionDisplay.add(regionButtons.get(i), 3, 2 + i/2);
            }
        }

        //Create label and radio button for the suit search function
        Label suitSearch = new Label("Search by Suit");
        searchFunctionDisplay.add(suitSearch,2,5,2,1);
        suitToggle = new ToggleGroup();
        suitButtons = new ArrayList<>();
        suitButtons.add(new RadioButton("Political"));
        suitButtons.add(new RadioButton("Intelligence"));
        suitButtons.add(new RadioButton("Economic"));
        suitButtons.add(new RadioButton("Military"));
        //Add them to toggle group
        for(int i =0; i<suitButtons.size();i++){
            suitButtons.get(i).setToggleGroup(suitToggle);
            if(i % 2 == 0) {
                searchFunctionDisplay.add(suitButtons.get(i), 2, 6 + i/2);
            }
            else{
                searchFunctionDisplay.add(suitButtons.get(i), 3, 6 + i/2);
            }
        }

        //Create label and radio button for the rank search function
        Label rankSearch = new Label("Search by Rank");
        searchFunctionDisplay.add(rankSearch,2,8,2,1);
        rankToggle = new ToggleGroup();
        rankButtons = new ArrayList<>();
        rankButtons.add(new RadioButton("1"));
        rankButtons.add(new RadioButton("2"));
        rankButtons.add(new RadioButton("3"));

        //Add them to toggle group
        for(int i =0; i<rankButtons.size();i++){
            rankButtons.get(i).setToggleGroup(rankToggle);
            if(i % 2 == 0) {
                searchFunctionDisplay.add(rankButtons.get(i), 2, 9 + i/2);
            }
            else{
                searchFunctionDisplay.add(rankButtons.get(i), 3, 9 + i/2);
            }
        }

        //Spacing
        searchFunctionDisplay.setHgap(5);
        searchFunctionDisplay.setVgap(5);

        //Add search function grid pane to main grid pane
        add(searchFunctionDisplay,2,1);
        setHalignment(searchFunctionDisplay, HPos.RIGHT);

        //Create search field
        searchField = new TextField();
        searchField.setPrefSize(100,30);
        searchField.setPromptText("Search For Card by Name");
        add(searchField,0,0);
        add(scrollImagePane,0,1);
        update();
    }

    public void update(){
        imageDisplay.getChildren().clear();
        getChildren().remove(imageDisplay);
        images.clear();

        for(int i = 0; i < model.displayedCards.size(); i++){
            images.add(new ImageView(model.displayedCards.get(i).getCardImage()));
        }

        for(int i = 0; i < images.size();i++){
             if(i % 3 == 0) {
             imageDisplay.add(images.get(i), 0, 1 + i/3);
             }
             else if(i % 3 == 1){
              imageDisplay.add(images.get(i), 1, 1 + i/3);
             }
             else{
                 imageDisplay.add(images.get(i), 2, 1 + i/3);
             }
        }
        scrollImagePane.setContent(imageDisplay);

    }



}

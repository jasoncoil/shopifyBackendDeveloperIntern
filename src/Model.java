import javafx.collections.FXCollections;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jcoil on 2021-01-07
 */


public class Model {
    public ArrayList<CourtCard> allCards;
    public ArrayList<CourtCard> displayedCards;
    public ArrayList<String> regionNames;
    public ArrayList<String> suitNames;

    public Model(){
        allCards = new ArrayList<>();
        displayedCards = new ArrayList<>();
//        String[] regions = {"Persia","Kabul","Kandahar","Herat","Transcaspia","Punjab"};
//        regionNames.addAll(FXCollections.observableArrayList(regions));
//        String[] suits = {"Economic","Political","Intelligence","Military"};
//        suitNames.addAll(FXCollections.observableArrayList(suits));
    }


    public void SampleCards(){
        allCards.add(new CourtCard("null","Russian","Political",1,"Transcaspia","Allah Quli Bahdadur", new String[]{"Tribe", "Army", "Spy"},
                 new String[]{"Betray"}, new Image("/Court Cards/Allah Quli Bahadur.png")));
        allCards.add(new CourtCard("British","Russian","Economic",1,"Persia","Anglo-Persian Trade", new String[]{"Road", "Leverage"},
                new String[]{"Tax","Build"}, new Image("/Court Cards/Anglo-Persian Trade.png")));
        allCards.add(new CourtCard("British","Afghanistan","Military",3,"Punjab","Army of the Indus", new String[]{"Army", "Army", "Army"},
                new String[]{"March"}, new Image("/Court Cards/Army of Indus.png")));
        allCards.add(new CourtCard("null","Afghanistan","Economic",1,"Kabul","Balkh Arsenic Mine", new String[]{"Road", "Military"},
                new String[]{"Build","Betray"}, new Image("/Court Cards/Balkh Arsenic Mine.png")));
        allCards.add(new CourtCard("null","Russian","Political",1,"Kandahar","Baluchi Chiefs", new String[]{"Tribe", "Army"},
                new String[]{"Build","Tax"}, new Image("/Court Cards/Baluchi Chiefs.png")));
        allCards.add(new CourtCard("null","null","Economic",2,"Kandahar","Bank", new String[]{"Road", "Road","Leverage","Intelligence"},
                new String[]{"Gift"}, new Image("/Court Cards/Bank.png")));
        allCards.add(new CourtCard("British","Russian","Military",2,"Kandahar","British Regulars", new String[]{"Army", "Army"},
                new String[]{"Battle","March"}, new Image("/Court Cards/British Regulars.png")));
        allCards.add(new CourtCard("null","British","Intelligence",1,"Transcaspia","Bukharan Jews", new String[]{"Spy", "Leverage","Economic"},
                new String[]{"Gift","Build"}, new Image("/Court Cards/Bukharan Jews.png")));
        allCards.add(new CourtCard("null","null","Intelligence",2,"Kandahar","Charles Masson", new String[]{"Spy", "Spy"},
                new String[]{"Build"}, new Image("/Court Cards/Charles Masson.png")));
        allCards.add(new CourtCard("null","Afghanistan","Intelligence",1,"Kabul","Charles Stoddart", new String[]{"Tribe"},
                new String[]{"Gift","March"}, new Image("/Court Cards/Charles Stoddart.png")));
        allCards.add(new CourtCard("null","null","Military",1,"Kabul","Citadel of Ghazni", new String[]{"Army"},
                new String[]{"Build"}, new Image("/Court Cards/Citadel of Ghazni.png")));
        allCards.add(new CourtCard("null","null","Economic",3,"Kabul","City of Ghazni", new String[]{"Road", "Road","Road","Army"},
                new String[]{"Gift"}, new Image("/Court Cards/City of Ghazni.png")));

        displayedCards.addAll(allCards);
    }

    public ArrayList<CourtCard> search(HashMap<String,String> searchParams){
        ArrayList<CourtCard> displayedList = allCards;
        for(String param: searchParams.keySet()){
            if(param.equals("Region")){
                if(!searchParams.get("Region").isEmpty()) {
                    displayedList = regionFilter(searchParams.get("Region"), displayedList);
                }
            }
            else if(param.equals("Suit")){
                if(!searchParams.get("Suit").isEmpty()) {
                    displayedList = suitFilter(searchParams.get("Suit"), displayedList);
                }
            }
            else if(param.equals("Rank")){
                if(!searchParams.get("Rank").isEmpty()) {
                    displayedList = rankFilter(searchParams.get("Rank"), displayedList);
                }
            }
            else if(param.equals("SearchField")){
                displayedList = filterViaOtherAttributes(searchParams.get("SearchField"),displayedList);
            }
        }
        return displayedList;
    }


    //Filter by region
    public ArrayList<CourtCard> regionFilter(String region, ArrayList<CourtCard> dList){
        ArrayList<CourtCard> results = new ArrayList<>();
        for(int i = 0; i < dList.size(); i++){
            if(dList.get(i).getRegion().equals(region)){
                results.add(dList.get(i));
            }
        }
        return results;
    }
    //Filter by suit
    public ArrayList<CourtCard> suitFilter(String suit, ArrayList<CourtCard> dList){
        ArrayList<CourtCard> results = new ArrayList<>();
        for(int i = 0; i < dList.size();i++){
            if(dList.get(i).getSuit().equals(suit)){
                results.add(dList.get(i));
            }
        }
        return results;
    }
    //Filter by Rank
    public ArrayList<CourtCard> rankFilter(String rank, ArrayList<CourtCard> dList){
        ArrayList<CourtCard> results = new ArrayList<>();
        for(int i = 0; i < dList.size();i++){
            if(Integer.toString(dList.get(i).getRank()).equals(rank)){
                results.add(dList.get(i));
            }
        }
        return results;

    }


    public void displayList(ArrayList<CourtCard> searchedList){
        displayedCards = new ArrayList<>(searchedList);
    }

    //If search field has text, search through to see if it matches card name, core actions, card actions, or russian/afghan/british loyalist/prize
    public ArrayList<CourtCard> filterViaOtherAttributes(String inputString, ArrayList<CourtCard> dList){
        ArrayList<CourtCard> results = new ArrayList<>();
        //Keeping another list to prevent adding duplicates
        ArrayList<CourtCard> previouslyAddedCards = new ArrayList<>();
        for(int i = 0; i < dList.size(); i++){
            //Check card name match
            if(dList.get(i).getCardName().toLowerCase().contains(inputString.toLowerCase())){
                if(!previouslyAddedCards.contains(dList.get(i))){
                    results.add(dList.get(i));
                    previouslyAddedCards.add(dList.get(i));
                }
            }
            //Check core action match
            for(int j = 0; j < dList.get(i).getCoreActions().size();j++){
                if(dList.get(i).getCoreActions().get(j).toLowerCase().contains(inputString.toLowerCase())){
                    if(!previouslyAddedCards.contains(dList.get(i))){
                        results.add(dList.get(i));
                        previouslyAddedCards.add(dList.get(i));
                    }
                }
            }
            //Check card action match
            for(int j = 0; j < dList.get(i).getCardActions().size();j++){
                if(dList.get(i).getCardActions().get(j).toLowerCase().contains(inputString.toLowerCase())){
                    if(!previouslyAddedCards.contains(dList.get(i))){
                        results.add(dList.get(i));
                        previouslyAddedCards.add(dList.get(i));
                    }
                }
            }
            //Check russian/afghan/british prize
            if(dList.get(i).getPrize().toLowerCase().contains(inputString.toLowerCase()) ||
                    ((dList.get(i).getPrize() + " prize").toLowerCase().contains(inputString.toLowerCase()) && !dList.get(i).getPrize().equals("null"))){
                if(!previouslyAddedCards.contains(dList.get(i))){
                    results.add(dList.get(i));
                    previouslyAddedCards.add(dList.get(i));
                }
            }
            //Check russian/afghan/british loyalist
            if(dList.get(i).getPatriot().toLowerCase().contains(inputString.toLowerCase()) ||
                    ((dList.get(i).getPatriot() + " loyalist").toLowerCase().contains(inputString.toLowerCase()) && !dList.get(i).getPatriot().equals("null"))
            || ((dList.get(i).getPatriot() + " patriot").toLowerCase().contains(inputString.toLowerCase()) && !dList.get(i).getPatriot().equals("null"))){
                if(!previouslyAddedCards.contains(dList.get(i))){
                    results.add(dList.get(i));
                    previouslyAddedCards.add(dList.get(i));
                }
            }
        }
        return results;
    }

}

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jcoil on 2021-01-07
 */
public class CourtCard{
    //Card number is inherited from Card Class
    //patriot == "null" if not a patriot
    private String patriot;
    //prize == "null" if no prize
    private String prize;
    //Suits are: Economic, Political, Military, and Intelligence
    private String suit;
    private Integer rank;
    private String region;
    private String cardName;
    //Core actions are [Road, Army, Leverage, Spy, Tribe, Favored Suit]
    //Card actions are [Build, Tax, Gift, March, Betray, Battle]
    private ArrayList<String> coreActions;
    private ArrayList<String> cardActions;
    private Image cardImage;

    //GETTERS
    public String getPatriot() { return patriot; }
    public String getPrize() { return prize; }
    public Integer getRank(){ return rank;}
    public String getRegion(){ return region; }
    public Image getCardImage(){ return cardImage; }
    public String getCardName(){ return cardName; }
    public ArrayList<String> getCoreActions() { return coreActions; }
    public ArrayList<String> getCardActions() { return cardActions; }
    public String getSuit(){ return suit;}


    //CONSTRUCTORS
    //Cards with patriot and prize, if patriot or prize or both is null input "null"
    public CourtCard(String pat, String pr, String s, Integer rnk, String reg, String cn, String[] core, String[] card, Image img){
        coreActions = new ArrayList<>();
        cardActions = new ArrayList<>();
        patriot = pat;
        prize = pr;
        suit = s;
        rank = rnk;
        region = reg;
        cardName = cn;
        coreActions.addAll(Arrays.asList(core));
        cardActions.addAll(Arrays.asList(card));
        cardImage = img;

    }


    //To String method
    public String toString(){
        return cardName;
    }


}

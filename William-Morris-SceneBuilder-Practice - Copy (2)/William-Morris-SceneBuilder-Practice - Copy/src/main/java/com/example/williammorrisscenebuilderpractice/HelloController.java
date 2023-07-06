package com.example.williammorrisscenebuilderpractice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelloController {

    @FXML
    private ImageView background;

    @FXML
    private Button btnSelect;

    @FXML
    private AnchorPane selectScreen;

    @FXML
    private AnchorPane screenBlackJack;

    @FXML
    private AnchorPane screen5Card;

    @FXML
    private AnchorPane bankScreen;

    @FXML
    private Button btn5Card;


    // BLACKJACK CONTROLS

    @FXML
    private Button btnHit;

    @FXML
    private Button btnStand;

    @FXML
    private Button btnPlayAgain;

    @FXML
    private Label lblDealer;

    @FXML
    private Label lblPlayer;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblDealerScore;

    @FXML
    private Label lblPlayerScore;

    @FXML
    private ImageView DealerFirstCard;

    @FXML
    private ImageView DealerSecondCard;

    @FXML
    private ImageView DealerThirdCard;

    @FXML
    private ImageView DealerFourthCard;

    @FXML
    private ImageView DealerFifthCard;

    @FXML
    private ImageView DealerSixthCard;

    @FXML
    private ImageView PlayerFirstCard;

    @FXML
    private ImageView PlayerSecondCard;

    @FXML
    private ImageView PlayerThirdCard;

    @FXML
    private ImageView PlayerFourthCard;

    @FXML
    private ImageView PlayerFifthCard;

    @FXML
    private ImageView PlayerSixthCard;

    @FXML
    private ImageView BackofCard;


    @FXML
    private Button btn5CardBlack;

    @FXML
    private Button btnBlackjack;

    @FXML
    private Button btnBlackJackBack;

    @FXML
    private Label lblSelectMode;

    @FXML
    private Button btnViewBank;

    @FXML
    private Button btnSelectBack;

    @FXML
    private Button getBtn5Card;

    @FXML
    private Button btn5CardBetOk;

    @FXML
    private Button btn5CardPlaceBet;


    // these are the checkboxes for each card in 5 card draw
    @FXML
    private CheckBox chkCard1;

    @FXML
    private CheckBox chkCard2;

    @FXML
    private CheckBox chkCard3;

    @FXML
    private CheckBox chkCard4;

    @FXML
    private CheckBox chkCard5;


    // these are the imageviews which contain the cards in the GUI of 5 Card Draw
    @FXML
    private ImageView imgCard1;

    @FXML
    private ImageView imgCard2;

    @FXML
    private ImageView imgCard3;

    @FXML
    private ImageView imgCard4;

    @FXML
    private ImageView imgCard5;

    @FXML
    private Button btn5CardOk;


    // giving the exit button functionality

    @FXML
    void onExitButtonClick(MouseEvent event) {
        System.exit(0);
    }

    // takes user to select game mode menu when select button is clicked
    public void onSelectButtonClicked(MouseEvent event) {
        selectScreen.setVisible(true);
    }

    public void onViewBankClick(MouseEvent event) {
        bankScreen.setVisible(true);
    }

    // this method goes back to the main menu from the select game mode screen
    public void selectBackButtonClick(MouseEvent event) {
        selectScreen.setVisible(false);
    }

    public void btnBlackJackBackClicked(MouseEvent event) {
        screenBlackJack.setVisible(false);
    }

    public void btn5CardBlackClicked(MouseEvent event) {
        screen5Card.setVisible(false);
    }

    Dealer dealer5Card = new Dealer();   // creates an instance of the player and dealer classes
    Player player5Card = new Player();

    ArrayList<Card> hand = dealer5Card.deal(5);    // dealer shuffles the cards and deals a hand to the player

    @FXML                   // this method opens the 5 card draw game after its button is clicked from the select menu
    public void open5Card(MouseEvent event) {
        screen5Card.setVisible(true);

        player5Card.receiveHand(hand);   // player receives the hand

        setCardImage(imgCard1, hand.get(0));
        setCardImage(imgCard2, hand.get(1));
        setCardImage(imgCard3, hand.get(2));    // setting and displaying the image for each card in the player's hand
        setCardImage(imgCard4, hand.get(3));
        setCardImage(imgCard5, hand.get(4));
    }

    public void redrawCardsVisibility(boolean vision) {
        chkCard1.setVisible(vision);
        chkCard2.setVisible(vision);
        chkCard3.setVisible(vision);
        chkCard4.setVisible(vision);
        chkCard5.setVisible(vision);
        btn5CardOk.setVisible(vision);
    }

    public void betMenuVisibility(boolean vision) {
        btn5CardBetOk.setVisible(vision);
        btn5CardPlaceBet.setVisible(vision);
    }

    public void btn5CardBetOkClick(MouseEvent event) {
        redrawCardsVisibility(true);
        betMenuVisibility(false);
    }

    public void btn5CardOkClick(MouseEvent event) {
        if (chkCard1.isSelected() == true) {
            hand.remove(0);
            hand.add(0, dealer5Card.deal1Card());
            setCardImage(imgCard1, hand.get(0));
        }
        if (chkCard2.isSelected() == true) {
            hand.remove(1);
            hand.add(1, dealer5Card.deal1Card());
            setCardImage(imgCard2, hand.get(1));
        }
        if (chkCard3.isSelected() == true) {
            hand.remove(2);
            hand.add(2, dealer5Card.deal1Card());
            setCardImage(imgCard3, hand.get(2));
        }
        if (chkCard4.isSelected() == true) {
            hand.remove(3);
            hand.add(3, dealer5Card.deal1Card());
            setCardImage(imgCard4, hand.get(3));
        }
        if (chkCard5.isSelected() == true) {
            hand.remove(4);
            hand.add(4, dealer5Card.deal1Card());
            setCardImage(imgCard5, hand.get(4));
        }

        redrawCardsVisibility(false);


    }

    // the setCardImage method creates a file path to each card in the hand's image using a switch statement
    public void setCardImage(ImageView cardView, Card card) {
        String suitString = "";
        String rankString = "";

        switch (card.getSuit()) {
            case CLUBS -> suitString = "Clubs";
            case DIAMONDS -> suitString = "Diamonds";
            case HEARTS -> suitString = "Hearts";
            case SPADES -> suitString = "Spades";
        }

        switch (card.getRank()) {
            case ACE -> rankString = "Ace";
            case TWO -> rankString = "2";
            case THREE -> rankString = "3";
            case FOUR -> rankString = "4";
            case FIVE -> rankString = "5";
            case SIX -> rankString = "6";
            case SEVEN -> rankString = "7";
            case EIGHT -> rankString = "8";
            case NINE -> rankString = "9";
            case TEN -> rankString = "10";
            case JACK -> rankString = "Jack";
            case QUEEN -> rankString = "Queen";
            case KING -> rankString = "King";
        }

        String imagePath = "C:\\Users\\ldorn\\Downloads\\William-Morris-SceneBuilder-Practice - Copy (2)\\William-Morris-SceneBuilder-Practice - Copy\\src\\main\\java\\com\\example\\williammorrisscenebuilderpractice\\assets\\Poker Large\\" + rankString + "_" + suitString + ".jpg";
        Image image = new Image(imagePath);
        cardView.setImage(image);
    }

    // BLACKJACK METHODS

    Dealer dealerBlackjack = new Dealer();   // creates an instance of the player and dealer classes

    int playerHand;
    int dealerHand;

    public void onBlackJackButtonClick(MouseEvent event) {
        screenBlackJack.setVisible(true);
        BackofCard.setVisible(true);
        btnPlayAgain.setVisible(false);
        btnHit.setDisable(false);

        Card newCard1 = dealerBlackjack.deal1Card();
        Card newCard2 = dealerBlackjack.deal1Card();
        Card newCard3 = dealerBlackjack.deal1Card();
        Card newCard4 = dealerBlackjack.deal1Card();

        setCardImage(DealerFirstCard, newCard1);
        setCardImage(DealerSecondCard, newCard2);
        setCardImage(PlayerFirstCard, newCard3);
        setCardImage(PlayerSecondCard, newCard4);

        playerHand = newCard3.getValue() + newCard4.getValue();
        dealerHand = newCard1.getValue() + newCard2.getValue();

        lblPlayerScore.setText(String.valueOf(playerHand));
        lblDealerScore.setText("???");

        if ((newCard1.getValue() == 11 || newCard2.getValue() == 11) && playerHand > 21) {
            playerHand -= 10;
        }

        if (playerHand == 21){
            lblMessage.setText("You win!");
            stand();
        }
    }

    public void resetImageViews(){
        DealerThirdCard.setImage(null);
        DealerFourthCard.setImage(null);
        DealerFifthCard.setImage(null);
        DealerSixthCard.setImage(null);
        PlayerThirdCard.setImage(null);
        PlayerFourthCard.setImage(null);
        PlayerFifthCard.setImage(null);
        PlayerSixthCard.setImage(null);
    }


    public void onbtnPlayAgain(MouseEvent event) {
        counter = 0;
        dealerHand = 0;
        playerHand = 0;
        lblMessage.setVisible(false);
        btnPlayAgain.setVisible(false);
        BackofCard.setVisible(true);
        hand.clear();
        dealerBlackjack.clearDeck();
        dealerBlackjack.makeNewDeck();
        onBlackJackButtonClick(event);
        resetImageViews();
    }

    int counter = 0;

    public void hit() {
        lblMessage.setText("");
        lblPlayerScore.setVisible(true);
        lblDealerScore.setVisible(true);
        Card newCard1 = dealerBlackjack.deal1Card();
        Card newCard2 = dealerBlackjack.deal1Card();
        Card newCard3 = dealerBlackjack.deal1Card();
        Card newCard4 = dealerBlackjack.deal1Card();
        counter++;

        if (counter > 0) {
            if (counter == 1) {
                setCardImage(PlayerThirdCard, newCard1);
                if (newCard1.getValue() == 11 && playerHand > 21) {
                    playerHand -= 10;
                }
                lblPlayerScore.setText(String.valueOf(playerHand + newCard1.getValue()));
                playerHand += newCard1.getValue();
                if (playerHand < 21) {
                    //continue game
                } else if (playerHand == 21) {
                    stand();
                    if (dealerHand < 21 || dealerHand > 21) {
                        //Player wins
                        lblMessage.setText("You Win!");
                        btnPlayAgain.setVisible(true);
                    } else {
                        lblMessage.setText("It's a tie!");
                        btnPlayAgain.setVisible(true);
                    }
                } else {
                    stand();
                    lblMessage.setText("You Lose. Better luck next time!");
                    btnPlayAgain.setVisible(true);
                }
            } else if (counter == 2) {
                setCardImage(PlayerFourthCard, newCard2);
                if ((newCard1.getValue() == 11 || newCard2.getValue() == 11) && playerHand > 21) {
                    playerHand -= 10;
                }
                lblPlayerScore.setText(String.valueOf(playerHand + newCard2.getValue()));
                playerHand += newCard2.getValue();
                if (playerHand < 21) {
                    //continue game
                } else if (playerHand == 21) {
                    stand();
                    if (dealerHand < 21 || dealerHand > 21) {
                        //Player wins
                        lblMessage.setText("You Win!");
                        btnPlayAgain.setVisible(true);
                    } else {
                        lblMessage.setText("It's a tie!");
                        btnPlayAgain.setVisible(true);
                    }
                } else {
                    stand();
                    lblMessage.setText("You Lose. Better luck next time!");
                    btnPlayAgain.setVisible(true);
                }
            } else if (counter == 3) {
                setCardImage(PlayerFifthCard, newCard3);
                if ((newCard1.getValue() == 11 || newCard2.getValue() == 11 || newCard3.getValue() == 11) && playerHand > 21) {
                    playerHand -= 10;
                }
                lblPlayerScore.setText(String.valueOf(playerHand + newCard3.getValue()));
                playerHand += newCard3.getValue();
                if (playerHand < 21) {
                    //continue game
                } else if (playerHand == 21) {
                    stand();
                    if (dealerHand < 21 || dealerHand > 21) {
                        //Player wins
                        lblMessage.setText("You Win!");
                        btnPlayAgain.setVisible(true);
                    } else {
                        lblMessage.setText("It's a tie!");
                        btnPlayAgain.setVisible(true);
                    }
                } else {
                    stand();
                    lblMessage.setText("You Lose. Better luck next time!");
                    btnPlayAgain.setVisible(true);
                }
            } else if (counter == 4) {
                setCardImage(PlayerSixthCard, newCard4);
                if ((newCard1.getValue() == 11 || newCard2.getValue() == 11 || newCard3.getValue() == 11 || newCard4.getValue() == 11) && playerHand > 21) {
                    playerHand -= 10;
                }
                lblPlayerScore.setText(String.valueOf(playerHand + newCard4.getValue()));
                playerHand += newCard4.getValue();
                if (playerHand < 21) {
                    //continue game
                } else if (playerHand == 21) {
                    stand();
                    if (dealerHand < 21 || dealerHand > 21) {
                        //Player wins
                        lblMessage.setText("You Win!");
                        btnPlayAgain.setVisible(true);
                    } else {
                        lblMessage.setText("It's a tie!");
                        btnPlayAgain.setVisible(true);
                    }
                } else {
                    stand();
                    lblMessage.setText("You Lose. Better luck next time!");
                    btnPlayAgain.setVisible(true);
                }
            }
        }
    }

    public void stand() {
        lblMessage.setVisible(true);
        lblPlayerScore.setVisible(true);
        lblDealerScore.setVisible(true);
        BackofCard.setVisible(false);
        btnHit.setDisable(true);
        Card newCard5 = dealerBlackjack.deal1Card();
        Card newCard6 = dealerBlackjack.deal1Card();
        Card newCard7 = dealerBlackjack.deal1Card();
        Card newCard8 = dealerBlackjack.deal1Card();
        lblDealerScore.setText(String.valueOf(dealerHand));

        if (dealerHand < 17) {
            //continue drawing until 17 or over
            setCardImage(DealerThirdCard, newCard5);
            dealerHand += newCard5.getValue();
            lblDealerScore.setText(String.valueOf(dealerHand));
            if (dealerHand < 17) {
                //continue drawing until 17 or over
                setCardImage(DealerFourthCard, newCard6);
                dealerHand += newCard6.getValue();
                lblDealerScore.setText(String.valueOf(dealerHand));
                if (dealerHand < 17) {
                    //continue drawing until 17 or over
                    setCardImage(DealerFifthCard, newCard7);
                    dealerHand += newCard7.getValue();
                    lblDealerScore.setText(String.valueOf(dealerHand));
                    if (dealerHand < 17) {
                        //continue drawing until 17 or over
                        setCardImage(DealerSixthCard, newCard8);
                        dealerHand += newCard8.getValue();
                        lblDealerScore.setText(String.valueOf(dealerHand));
                    }
                    else if (dealerHand == playerHand) {
                        lblMessage.setText("It's a tie!");
                        btnPlayAgain.setVisible(true);
                    } else if (dealerHand >= 17 && dealerHand < playerHand && dealerHand <= 21) {
                        lblMessage.setText("You win!");
                        btnPlayAgain.setVisible(true);
                    } else if (dealerHand >= 17 && dealerHand > playerHand && dealerHand <= 21) {
                        lblMessage.setText("You lose. Better luck next time!");
                        btnPlayAgain.setVisible(true);
                    } else if (dealerHand > 21) {
                        lblMessage.setText("You won!");
                        btnPlayAgain.setVisible(true);
                    }
                } else if (dealerHand == playerHand) {
                    lblMessage.setText("It's a tie!");
                    btnPlayAgain.setVisible(true);
                } else if (dealerHand >= 17 && dealerHand < playerHand && dealerHand <= 21) {
                    lblMessage.setText("You win!");
                    btnPlayAgain.setVisible(true);
                } else if (dealerHand >= 17 && dealerHand > playerHand && dealerHand <= 21) {
                    lblMessage.setText("You lose. Better luck next time!");
                    btnPlayAgain.setVisible(true);
                } else if (dealerHand > 21) {
                    lblMessage.setText("You won!");
                    btnPlayAgain.setVisible(true);
                }
            } else if (dealerHand == playerHand) {
                lblMessage.setText("It's a tie!");
                btnPlayAgain.setVisible(true);
            } else if (dealerHand >= 17 && dealerHand < playerHand && dealerHand <= 21) {
                lblMessage.setText("You win!");
                btnPlayAgain.setVisible(true);
            } else if (dealerHand >= 17 && dealerHand > playerHand && dealerHand <= 21) {
                lblMessage.setText("You lose. Better luck next time!");
                btnPlayAgain.setVisible(true);
            } else if (dealerHand > 21) {
                lblMessage.setText("You won!");
                btnPlayAgain.setVisible(true);
            }
        } else if (dealerHand == playerHand) {
            lblMessage.setText("It's a tie!");
            btnPlayAgain.setVisible(true);
        } else if (dealerHand >= 17 && dealerHand < playerHand && dealerHand <= 21) {
            lblMessage.setText("You win!");
            btnPlayAgain.setVisible(true);
        } else if (dealerHand >= 17 && dealerHand > playerHand && dealerHand <= 21) {
            lblMessage.setText("You lose. Better luck next time!");
            btnPlayAgain.setVisible(true);
        } else if (dealerHand > 21) {
            lblMessage.setText("You won!");
            btnPlayAgain.setVisible(true);
        }
    }
}

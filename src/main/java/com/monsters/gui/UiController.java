package com.monsters.gui;

import com.monsters.core.GameEngine;
import com.monsters.core.GameUI;
import com.monsters.core.Logger;
import com.monsters.core.model.*;
import com.monsters.core.model.cards.BankCard;
import com.monsters.core.model.cards.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class UiController implements GameUI {
    @FXML
    private Label monsterOneName;
    @FXML
    private Label monsterOneScore;
    @FXML
    private Label monsterOneLife;
    @FXML
    private Label monsterOnePower;
    @FXML
    private Label monsterTwoName;
    @FXML
    private Label monsterTwoScore;
    @FXML
    private Label monsterTwoLife;
    @FXML
    private Label monsterTwoPower;
    @FXML
    private Label monsterThreeName;
    @FXML
    private Label monsterThreeScore;
    @FXML
    private Label monsterThreeLife;
    @FXML
    private Label monsterThreePower;
    @FXML
    private ToggleButton cube_0_button;
    @FXML
    private ToggleButton cube_1_button;
    @FXML
    private ToggleButton cube_2_button;
    @FXML
    private ToggleButton cube_3_button;
    @FXML
    private ToggleButton cube_4_button;
    @FXML
    private ToggleButton cube_5_button;
    @FXML
    private VBox monster_1;
    @FXML
    private VBox monster_2;
    @FXML
    private VBox monster_3;
    @FXML
    private VBox monsterInTokyo;
    @FXML
    private Label monsterInTokyoName;
    @FXML
    private Label monsterInTokyoScore;
    @FXML
    private Label monsterInTokyoLife;
    @FXML
    private Label monsterInTokyoPower;
    @FXML
    private Label whoseTurn;
    @FXML
    private Label rollCount;
    @FXML
    private Button startGameButton;
    @FXML
    private Button rollDicesButton;
    @FXML
    private Button playTurnButton;
    @FXML
    private Button nextPlayerButton;
    @FXML
    private Label turnFinishedLabel;
    @FXML
    private Label finalResultLabel;
    @FXML
    private Label exitCityQuestion;
    @FXML
    private Button exitTokyoYes;
    @FXML
    private Button exitTokyoNo;
    @FXML
    private Label monsterFinishedGame;
    @FXML
    private Label onGameFinishedLabel;
    @FXML
    private Button startNewGameButton;
    @FXML
    private VBox cardsVBox;
    @FXML
    private Label firstCardLabel;
    @FXML
    private Label secondCardLabel;
    @FXML
    private Label thirdCardLabel;
    @FXML
    private Button buyFirstCardButton;
    @FXML
    private Button buySecondCardButton;
    @FXML
    private Button buyThirdCardButton;
    @FXML
    private Label buyingCardQuestionLabel;
    @FXML
    private ToggleButton dodatkowaGlowa1;
    @FXML
    private ToggleButton dodatkowaGlowa2;
    @FXML
    private Button shuffleCardsButton;
    @FXML
    private ScrollPane monsterOneCardOnePane;
    @FXML
    private ScrollPane monsterOneCardTwoPane;
    @FXML
    private ScrollPane monsterOneCardThreePane;
    @FXML
    private ScrollPane monsterOneCardFourPane;
    @FXML
    private ScrollPane monsterTwoCardOnePane;
    @FXML
    private ScrollPane monsterTwoCardTwoPane;
    @FXML
    private ScrollPane monsterTwoCardThreePane;
    @FXML
    private ScrollPane monsterTwoCardFourPane;
    @FXML
    private ScrollPane monsterThreeCardOnePane;
    @FXML
    private ScrollPane monsterThreeCardTwoPane;
    @FXML
    private ScrollPane monsterThreeCardThreePane;
    @FXML
    private ScrollPane monsterThreeCardFourPane;
    @FXML
    private Label monsterOneCardOneLabel;
    @FXML
    private Label monsterOneCardTwoLabel;
    @FXML
    private Label monsterOneCardThreeLabel;
    @FXML
    private Label monsterOneCardFourLabel;
    @FXML
    private Label monsterTwoCardOneLabel;
    @FXML
    private Label monsterTwoCardTwoLabel;
    @FXML
    private Label monsterTwoCardThreeLabel;
    @FXML
    private Label monsterTwoCardFourLabel;
    @FXML
    private Label monsterThreeCardOneLabel;
    @FXML
    private Label monsterThreeCardTwoLabel;
    @FXML
    private Label monsterThreeCardThreeLabel;
    @FXML
    private Label monsterThreeCardFourLabel;

    private List<ToggleButton> cubes;
    private List<Button> buyCardButtons;
    private List<Label> cardLabels;
    private List<MonsterView> monsterViews;
    private MonsterView cityMonsterView;
    private List<List<MonstersCard>> monstersCards;

    public void useExtraCube(int numberOfExtraCubes) {
        if (numberOfExtraCubes == 1) {
            dodatkowaGlowa1.setVisible(true);
            dodatkowaGlowa1.setDisable(false);
            cubes.add(dodatkowaGlowa1);
        }
        if (numberOfExtraCubes == 2) {
            dodatkowaGlowa1.setVisible(true);
            dodatkowaGlowa1.setDisable(false);
            dodatkowaGlowa2.setVisible(true);
            dodatkowaGlowa2.setDisable(false);
            cubes.add(dodatkowaGlowa1);
            cubes.add(dodatkowaGlowa2);
        }
    }

    @Override
    public void prepareBoard() {
        monsterViews = ListUtils.listOf(
                new MonsterView(monster_1, monsterOneName, monsterOneScore, monsterOneLife, monsterOnePower),
                new MonsterView(monster_2, monsterTwoName, monsterTwoScore, monsterTwoLife, monsterTwoPower),
                new MonsterView(monster_3, monsterThreeName, monsterThreeScore, monsterThreeLife, monsterThreePower)
        );
        monsterViews.forEach(monsterView -> monsterView.box.setVisible(true));

        List<MonstersCard> monsterOneCards = ListUtils.listOf(new MonstersCard(monsterOneCardOnePane, monsterOneCardOneLabel),
                            new MonstersCard(monsterOneCardTwoPane, monsterOneCardTwoLabel),
                            new MonstersCard(monsterOneCardThreePane, monsterOneCardThreeLabel),
                            new MonstersCard(monsterOneCardFourPane, monsterOneCardFourLabel));
        List<MonstersCard> monsterTwoCards = ListUtils.listOf(new MonstersCard(monsterTwoCardOnePane, monsterTwoCardOneLabel),
                            new MonstersCard(monsterTwoCardTwoPane, monsterTwoCardTwoLabel),
                            new MonstersCard(monsterTwoCardThreePane, monsterTwoCardThreeLabel),
                            new MonstersCard(monsterTwoCardFourPane, monsterTwoCardFourLabel));
        List<MonstersCard> monsterThreeCards = ListUtils.listOf(new MonstersCard(monsterThreeCardOnePane, monsterThreeCardOneLabel),
                            new MonstersCard(monsterThreeCardTwoPane, monsterThreeCardTwoLabel),
                            new MonstersCard(monsterThreeCardThreePane, monsterThreeCardThreeLabel),
                            new MonstersCard(monsterThreeCardFourPane, monsterThreeCardFourLabel));

        monstersCards = ListUtils.listOf(monsterOneCards, monsterTwoCards, monsterThreeCards);

        cityMonsterView = new MonsterView(monsterInTokyo, monsterInTokyoName, monsterInTokyoScore, monsterInTokyoLife, monsterInTokyoPower);
        cityMonsterView.box.setVisible(false);

        rollDicesButton.setVisible(false);
        playTurnButton.setVisible(false);
        nextPlayerButton.setVisible(false);

        whoseTurn.setVisible(false);
        rollCount.setVisible(false);
        turnFinishedLabel.setVisible(false);
        finalResultLabel.setVisible(false);

        setExitCityQuestionVisibility(false);

        monsterFinishedGame.setVisible(false);
        onGameFinishedLabel.setVisible(false);

        startNewGameButton.setVisible(false);
        cardsVBox.setVisible(false);

        cardLabels = ListUtils.listOf(firstCardLabel, secondCardLabel, thirdCardLabel);
        setCardLabelsVisibility(false);

        buyingCardQuestionLabel.setVisible(false);
        shuffleCardsButton.setVisible(false);

        monsterOneCards.forEach(MonstersCard -> MonstersCard.pane.setVisible(false));
        monsterTwoCards.forEach(MonstersCard -> MonstersCard.pane.setVisible(false));
        monsterThreeCards.forEach(MonstersCard -> MonstersCard.pane.setVisible(false));

        initCubes();
        cubes.forEach((cube) -> cube.setDisable(true));
        initCardButtons();

        dodatkowaGlowa1.setVisible(false);
        dodatkowaGlowa2.setVisible(false);

        exitTokyoYes.setOnAction((actionEvent) -> onExitTokyoResponse(true));
        exitTokyoNo.setOnAction((actionEvent) -> onExitTokyoResponse(false));
    }

    private void initCubes() {
        cubes = ListUtils.listOf(cube_0_button, cube_1_button, cube_2_button, cube_3_button, cube_4_button, cube_5_button);
        resetCubes();
    }

    private void initCardButtons() {
        buyCardButtons = ListUtils.listOf(buyFirstCardButton, buySecondCardButton, buyThirdCardButton);
        buyFirstCardButton.setOnAction((actionEvent) -> onBuyCardButtonClicked(0));
        buySecondCardButton.setOnAction((actionEvent) -> onBuyCardButtonClicked(1));
        buyThirdCardButton.setOnAction((actionEvent) -> onBuyCardButtonClicked(2));
        setBuyCardButtonsVisibility(false);
    }

    private void resetCubes() {
        cubes.forEach((cube) -> cube.setText(""));
    }

    private void setBuyCardButtonsVisibility(boolean isVisible) {
        buyCardButtons.forEach((button -> button.setVisible(isVisible)));
    }

    private void setCardLabelsVisibility(boolean isVisible) {
        cardLabels.forEach((label -> label.setVisible(isVisible)));
    }

    private void setExitCityQuestionVisibility(boolean isVisible) {
        exitCityQuestion.setVisible(isVisible);
        exitTokyoYes.setVisible(isVisible);
        exitTokyoNo.setVisible(isVisible);
    }

    @Override
    public void displayCards(List<Card> cards) {
        for (int i = 0; i < cardLabels.size(); i++) {
            cardLabels.get(i).setText(cards.get(i).title + "\nprice: " + cards.get(i).price
                    + "\n" + cards.get(i).description);
        }
    }

    @Override
    public void onMonsterFinishedGame(Monster monster) {
        monsterFinishedGame.setText(monster.name + " finished the game!");
        monsterFinishedGame.setVisible(true);
    }

    @Override
    public void renderStateForStartTurn(GameState gameState) {
        playTurnButton.setVisible(true);
        cardsVBox.setVisible(true);
        setCardLabelsVisibility(true);
        whoseTurn.setVisible(true);
        rollCount.setVisible(true);

        startGameButton.setVisible(false);
        turnFinishedLabel.setVisible(false);
        finalResultLabel.setVisible(false);
        nextPlayerButton.setVisible(false);
        buyingCardQuestionLabel.setVisible(false);
        monsterFinishedGame.setVisible(false);
        setBuyCardButtonsVisibility(false);
        setExitCityQuestionVisibility(false);
        dodatkowaGlowa1.setVisible(false);
        dodatkowaGlowa2.setVisible(false);
        shuffleCardsButton.setVisible(false);

        initCubes();
        setMonstersProperties(gameState);
        whoseTurn.setText("Player: " + gameState.whoseTurn.name);
        rollCount.setText("Roll count: 0");

        if (gameState.whoIsInTokyo == null) {
            cityMonsterView.box.setVisible(false);
        } else {
            setMonsterInTokyoProperties(gameState.whoIsInTokyo);
        }

        monsterViews.forEach(monsterView -> {
            if (!monsterView.monster.isAlive) monsterView.box.setVisible(false);
        });
    }

    @Override
    public void onGameStateChanged(GameState gameState, List<BankCard> bankCards) {
        startGameButton.setVisible(false);
        playTurnButton.setVisible(false);
        rollDicesButton.setVisible(false);
        whoseTurn.setVisible(true);
        rollCount.setVisible(true);

        turnFinishedLabel.setVisible(true);
        finalResultLabel.setVisible(true);

        cubes.forEach(cube -> {
            cube.setSelected(false);
            cube.setDisable(true);
            cube.setOpacity(1);
        });

        rollDicesButton.setDisable(true);

        // Hide next player button when exit tokyo question is shown
        nextPlayerButton.setVisible(!exitCityQuestion.isVisible());

        turnFinishedLabel.setText("Turn is finished! Next player: \n" + gameState.whoIsNext.name);
        setMonstersProperties(gameState);
        if (gameState.whoIsInTokyo != null) {
            setMonsterInTokyoProperties(gameState.whoIsInTokyo);
        }
        turnFinishedLabel.setText("Turn is finished! Next player: \n" + gameState.whoIsNext.name);

        Logger.d("Bank cards at this point: " + bankCards);
        Logger.d("Monster's power at this point: " + gameState.whoseTurn.power);
        buyCardButtons.forEach(button -> button.setDisable(true));
        setBuyCardButtonsVisibility(false);
        boolean hasAffordableCards = false;
        for (int i = 0; i < bankCards.size(); i++) {
            if (bankCards.get(i).isAffordable()) {
                hasAffordableCards = true;
            }
        }

        if (hasAffordableCards) {
            buyingCardQuestionLabel.setVisible(true);
            setBuyCardButtonsVisibility(true);

            // Enable buy card button for affordable card
            for (int i = 0; i < bankCards.size(); i++) {
                buyCardButtons.get(i).setDisable(!bankCards.get(i).isAffordable());
            }
        }

        if (gameState.whoseTurn.power >= 2) {
            shuffleCardsButton.setVisible(true);
            shuffleCardsButton.setDisable(false);
        } else {
            shuffleCardsButton.setDisable(true);
        }

        monsterViews.forEach(monsterView -> {
            if (!monsterView.monster.isAlive) monsterView.box.setVisible(false);
        });

        for (int iM = 0; iM < gameState.monsters.size(); iM++) {
            for (int iC = 0; iC < gameState.monsters.get(iM).cards.size(); iC++) {
                Logger.d(gameState.monsters.get(iM).name + "cards: " + gameState.monsters.get(iM).cards);
                monstersCards.get(iM).get(iC).pane.setVisible(true);
                monstersCards.get(iM).get(iC).label.setText(gameState.monsters.get(iM).cards.get(iC).title +
                        "\n" + gameState.monsters.get(iM).cards.get(iC).description);
            }
        }
    }

    @Override
    public void onMonsterInTheCityChanged(Monster monster) {
        monsterViews.forEach(monsterView -> monsterView.box.setVisible(true));
        if (monster == null) {
            Logger.d("City centre is empty, hiding monster box");
            cityMonsterView.box.setVisible(false);
            return;
        }

        cityMonsterView.box.setVisible(true);
        cityMonsterView.bindMonster(monster);

        monsterViews.forEach(monsterView -> {
            if (monsterView.monster == cityMonsterView.monster) monsterView.box.setVisible(false);
        });
    }

    @Override
    public void displayTurn(Turn turn) {
        playTurnButton.setVisible(false);
        whoseTurn.setText("Player: " + turn.monsterWhoseTurn.name);
        rollCount.setText("Roll count: " + turn.rollCount);
        displayDices(turn.dices);
    }

    private void displayDices(List<DiceResult> dices) {
        for (int i = 0; i < dices.size(); i++) {
            cubes.get(i).setText(dices.get(i).toString());
        }
    }

    @Override
    public void requestExitCityInput(Monster monster) {
        exitCityQuestion.setText("Does " + monster.name + " want \nto leave the city?");
        setExitCityQuestionVisibility(true);
    }

    @Override
    public void onGameFinished(Monster winnerMonster, GameState gameState) {

        if (gameState.whoIsInTokyo != null) {
            switch (gameState.whoIsInTokyo.name) {
                case "monsterOne":
                case "monsterThree":
                case "monsterTwo":
                    setMonsterInTokyoProperties(gameState.whoIsInTokyo);
                    break;
            }
        }

        setMonstersProperties(gameState);
        onGameFinishedLabel.setText(winnerMonster.name + " won the game!\n      Game is finished!");
        onGameFinishedLabel.setVisible(true);
        rollDicesButton.setVisible(false);
        playTurnButton.setVisible(false);
        rollCount.setVisible(false);
        whoseTurn.setVisible(false);
        nextPlayerButton.setVisible(false);
        turnFinishedLabel.setVisible(false);
        monsterFinishedGame.setVisible(false);
        finalResultLabel.setVisible(false);
        startNewGameButton.setVisible(true);
        for (ToggleButton cube : cubes) {
            cube.setDisable(true);
        }
    }

    public void onStartGameClicked() {
        Logger.d("Start game");
        GameEngine.getInstance().startTurn();
    }

    public void onPlayTurnClicked() {
        cubes.forEach((cube) -> cube.setDisable(false));

        GameEngine.getInstance().processGame();
        rollDicesButton.setDisable(false);
        rollDicesButton.setVisible(true);
    }

    public void onRollDicesClicked() {
        List<Integer> numbers = new ArrayList<>();
        Logger.d("On rollDicesClicked cubez.size = " + cubes.size());
        for (int i = 0; i < cubes.size(); i++) {
            if (cubes.get(i).isSelected()) {
                numbers.add(i);
            }
        }
        Logger.d("Selected cube numbers: " + numbers);
        GameEngine.getInstance().processDiceInput(numbers);
        GameEngine.getInstance().playTurn();
    }

    public void onNextPlayerButtonClicked() {
        GameEngine.getInstance().switchMonster();
        GameEngine.getInstance().startTurn();
        shuffleCardsButton.setVisible(false);
    }

    public void onShuffleCardsButtonClicked() {
        GameEngine.getInstance().shuffleCards();
    }

    private void onExitTokyoResponse(boolean shouldExit) {
        Logger.d("onExitTokyoResponse: " + shouldExit);
        if (shouldExit) {
            GameEngine.getInstance().processExitTokyo(true);
        }
        GameEngine.getInstance().switchMonster();
        GameEngine.getInstance().startTurn();
    }

    public void onStartNewGameClicked() {
        GameEngine.getInstance().initGame();
        GameEngine.getInstance().startTurn();
    }

    private void onBuyCardButtonClicked(int index) {
        GameEngine.getInstance().buyCard(index);
    }

    private void setMonstersProperties(GameState gameState) {
        for (int i = 0; i < monsterViews.size(); i++) {
            monsterViews.get(i).bindMonster(gameState.monsters.get(i));
        }
    }

    private void setMonsterInTokyoProperties(Monster monster) {
        cityMonsterView.box.setVisible(true);
        cityMonsterView.bindMonster(monster);
    }
}

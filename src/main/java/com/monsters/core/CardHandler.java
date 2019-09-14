package com.monsters.core;

import com.monsters.core.model.GameState;
import com.monsters.core.model.Monster;
import com.monsters.core.model.cards.*;
import com.monsters.core.model.cards.odrzuc.*;
import com.monsters.core.model.cards.on_turn_finished_cards.NadchodziPomocCard;
import com.monsters.core.model.cards.zatrzymaj_bez_interakcji.*;
import com.monsters.core.model.cards.on_turn_finished_cards.EnergiaSlonecznaCard;
import com.monsters.core.model.cards.on_turn_finished_cards.FarmerEnergiiCard;
import com.monsters.core.model.cards.on_turn_finished_cards.WegetarianinCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardHandler {
    private List<Card> cards = new ArrayList<>();
    List<Card> bankCards = new ArrayList<>();
    public GameState gameState;
    private GameUI gameUI;

    public CardHandler(GameState gameState, GameUI gameUI) {
        this.gameState = gameState;
        this.gameUI = gameUI;
        initCards();
        initBankCards();
    }

    private void initCards() {
        cards.add(new DoladowanieOdrzucCard());
        cards.add(new EwakuacjaOdrzucCard());
        cards.add(new EwakuacjaOdrzucCard());
        cards.add(new MiotaczOgniaOdrzucCard());
        cards.add(new MysliwiecOdrzucCard());
        cards.add(new PierwszaPomocOdrzucCard());
        cards.add(new SzybkaPrzekaskaOdrzucCard());
        cards.add(new ApartamentowiecOdrzucCard());
        cards.add(new RafineriaOdrzucCard());
        cards.add(new BombardowanieOdrzucCard());
        cards.add(new CzolgOdrzucCard());
        cards.add(new ElektrowniaJadrowaOdrzucCard());
        cards.add(new GwardiaNarodowaOdrzucCard());
        cards.add(new PodmiejskiKajdanOdrzucCard());
        cards.add(new SkokZWiezowcaOdrzucCard());
        cards.add(new WiezowiecOdrzucCard());
        cards.add(new PotwornaNawalnicaOdrzucCard());
        cards.add(new SzalBojowyOdrzucCard());
        cards.add(new KolczastyOgonZatrzymajBezInterakcjiCard());
        cards.add(new JeszczeWiekszyZatrzymajBezInterakcjiCard());
        cards.add(new AtakKwasemZatrzymajBezInterakcjiCard());
        cards.add(new SlodziakZatrzymajBezInterakcjiCard());
        cards.add(new TotalneUnicestwienieZatrzymajBezInterakcjiCard());
        cards.add(new NiszczacyOddechZatrzymajBezInterakcjiCard());
        cards.add(new PotworAlfaZatrzymajBezInterakcjiCard());
        cards.add(new SmakoszZatrzymajBezInterakcjiCard());
        cards.add(new TrujaceKolceZatrzymajBezInterakcjiCard());
        cards.add(new MiastozernyZatrzymajBezInterakcjiCard());
        cards.add(new NadchodziPomocCard());
        cards.add(new EnergiaSlonecznaCard());
        cards.add(new FarmerEnergiiCard());
        cards.add(new WegetarianinCard());
        cards.add(new DodatkowaGlowaCard());
        cards.add(new DodatkowaGlowaCard());
    }

    public void initBankCards() {
        Collections.shuffle(cards);
        cards.forEach(card -> Logger.d(card.title));
        for(int i = 0; i < 3; i++) {
            bankCards.add(cards.get(i));
            cards.remove(cards.get(i));
        }
    }

    public List<BankCard> getCardsMonsterCanAfford(Monster monster) {
        List<BankCard> bankCards = new ArrayList<>();
        this.bankCards.forEach(card -> bankCards.add(new BankCard(card, monster.power >= card.price)));
        return bankCards;
    }

    public void buyCard(int cardIndex) {
        if (gameState.whoseTurn.power >= bankCards.get(cardIndex).price) {
            gameState.whoseTurn.power -= bankCards.get(cardIndex).price;
            Card boughtCard = bankCards.get(cardIndex);
            boughtCard.performAction(gameState);
            if (boughtCard.type != CardType.ODRZUC) {
                gameState.whoseTurn.cards.add(boughtCard);
            }
            Logger.d("Monsters cards: " + gameState.whoseTurn.cards);
            bankCards.remove(boughtCard);
            cards.remove(boughtCard);
            addCardToBank();
            gameUI.displayCards(bankCards);
            gameUI.onGameStateChanged(gameState, getCardsMonsterCanAfford(gameState.whoseTurn));
        }
    }

    private void addCardToBank() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            bankCards.add(cards.get(rand.nextInt(cards.size())));
        }
    }

    public void shuffleCards() {
        bankCards.clear();
        initBankCards();
        gameState.whoseTurn.power -= 2;
        gameUI.onGameStateChanged(gameState, getCardsMonsterCanAfford(gameState.whoseTurn));
    }
}

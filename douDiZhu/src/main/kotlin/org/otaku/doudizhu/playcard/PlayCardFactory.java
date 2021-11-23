package org.otaku.doudizhu.playcard;

import org.otaku.doudizhu.Card;
import org.otaku.doudizhu.PlayCard;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Set;

public abstract class PlayCardFactory {
    private static final Set<Class<? extends PlayCard>> playCardTypes;
    public static final PlayCardFactory DEFAULT = new DefaultPlayCardFactory();

    static {
        Reflections reflections = new Reflections("org.otaku.doudizhu.playcard");
        playCardTypes = reflections.getSubTypesOf(PlayCard.class);
    }

    public abstract PlayCard createPlayCard(Set<Card> cards);

    private static class DefaultPlayCardFactory extends PlayCardFactory {

        @Override
        public PlayCard createPlayCard(Set<Card> cards) {
            for (var playCardType : playCardTypes) {
                try {
                    Constructor<? extends PlayCard> constructor = playCardType.getConstructor(Set.class);
                    return constructor.newInstance(cards);
                } catch (Exception e) {
                }
            }
            throw new IllegalArgumentException("your card is not a card play!");
        }
    }

}

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    private List<Card> cards;
    private int size;

    public Deck(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    {
        this.cards = new ArrayList();
        for (int i = 0; i < paramArrayOfString1.length; i++) {
            for (String str : paramArrayOfString2) {
                this.cards.add(new Card(paramArrayOfString1[i], str, paramArrayOfInt[i]));
            }
        }
        shuffle();
    }

    public boolean isEmpty()
    {
        return this.size < 0;
    }

    public int size()
    {
        return this.size;
    }

    public void shuffle()
    {
        for (int i = this.cards.size() - 1; i > 0; i--)
        {
            int j = i + 1;
            int k = 0;
            int m = (int)(Math.random() * j) + k;
            Card localCard = (Card)this.cards.get(i);
            this.cards.set(i, this.cards.get(m));
            this.cards.set(m, localCard);
        }
        this.size = this.cards.size();
    }

    public Card deal()
    {
        if (isEmpty()) {
            return null;
        }
        this.size -= 1;
        Card localCard = (Card)this.cards.get(this.size);
        return localCard;
    }

    public String toString()
    {
        String str = "size = " + this.size + "\nUndealt cards: \n";
        for (int i = this.size - 1; i >= 0; i--)
        {
            str = str + this.cards.get(i);
            if (i != 0) {
                str = str + ", ";
            }
            if ((this.size - i) % 2 == 0) {
                str = str + "\n";
            }
        }
        str = str + "\nDealt cards: \n";
        for (int i = this.cards.size() - 1; i >= this.size; i--)
        {
            str = str + this.cards.get(i);
            if (i != this.size) {
                str = str + ", ";
            }
            if ((i - this.cards.size()) % 2 == 0) {
                str = str + "\n";
            }
        }
        str = str + "\n";
        return str;
    }
}

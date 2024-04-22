package s240416;

import java.util.*;

/*
* 5. 카드(Card) 클래스를 정의하고, 52장의 카드 객체를 저장하는 리스트를
정의하시오. 리스트에 저장된 카드를 서플(Shuffle)한 후 두 사람에게 2장
씩 나눠주어 누구의 카드가 더 높은지 승부 체크를 하는 프로그램을 작
성하시오.
 조건1) Card 클래스
 필드 : int value(값), int suit(모양)
 Comparable 인터페이스 구현 : compareTo() 메소드 정의
 생성자, 접근자/설정자, toString(), weight() 메소드 정의
 승부체크 메소드 : static int compare(Card[] obj1, Card[] obj2)
 조건2) Collections 클래스의 메소드를 활용하여 정렬, 섞기 수행
* */
class Card implements Comparable<Card> {
    int value; // 카드의 숫자
    int suit; // 카드의 무늬

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }

    public int getValue() {return value;} // 카드의 숫자를 반환
    public void setValue(int value) {this.value = value;} // 카드의 숫자를 설정
    public int getSuit() {return suit;} // 카드의 무늬를 반환
    public void setSuit(int suit) {this.suit = suit;} // 카드의 무늬를 설정

    @Override
    public int compareTo(Card o) { // 카드를 비교하는 기준
        if (this.value == o.value) {
            return this.suit - o.suit; // 숫자가 같으면 무늬로 비교
        } else {
            return this.value - o.value; // 숫자가 다르면 숫자로 비교
        }
    }
}

public class CardTest {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(value, suit)); // 52장의 카드를 생성
            }
        }

        Collections.shuffle(deck); // 카드를 섞음

        Card[] player1 = {deck.get(0), deck.get(1)}; // 플레이어1에게 카드 2장을 줌
        Card[] player2 = {deck.get(2), deck.get(3)}; // 플레이어2에게 카드 2장을 줌

        System.out.println("Player 1's cards: " + Arrays.toString(player1)); // 플레이어1의 카드를 출력
        System.out.println("Player 2's cards: " + Arrays.toString(player2)); // 플레이어2의 카드를 출력

        int result = compare(player1, player2); // 두 플레이어의 카드를 비교
        if (result > 0) {
            System.out.println("Player 1 wins!"); // 플레이어1이 이김
        } else if (result < 0) {
            System.out.println("Player 2 wins!"); // 플레이어2가 이김
        } else {
            System.out.println("It's a draw!"); // 무승부
        }
    }

    static int compare(Card[] player1, Card[] player2) {
        int score1 = Math.max(player1[0].getValue(), player1[1].getValue()); // 플레이어1의 카드 중 높은 숫자를 찾음
        int score2 = Math.max(player2[0].getValue(), player2[1].getValue()); // 플레이어2의 카드 중 높은 숫자를 찾음

        return Integer.compare(score1, score2); // 두 플레이어의 최고 숫자를 비교
    }
}

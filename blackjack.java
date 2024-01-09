/**
 * blackjack.java <br />
 * Explain :  <br />
 *
 * @author sbgu
 */
public class blackjack {
    public static void main(String[] args) {
        // blackjack
        // 1. 카드 개수만큼 인덱스 만들기
        int deck[] = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        // 2. 카드 모양이랑 번호 인덱스
        String[] cardShape = {"♤,", "♡", "♧", "♢"};
        String[] cardNumber = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k"};

        // 2. 랜덤카드 만들기
        for (int i = deck.length - 1; i > 0; i--) {
            int r = (int) (Math.random() * (i + 1));
            int temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        int[] p1Deck = new int[11];
        int[] p2Deck = new int[11];
        int deckIndex = 0;
        int p1DeckIndex = 0;
        int p2DeckIndex = 0;

//		p1Deck[p1DeckIndex++]=deck[deckIndex++];
//		p2Deck[p2DeckIndex++]=deck[deckIndex++];
//
        boolean p1GameEndFlag = true;
        boolean p2GameEndFlag = true;
        int sumP1 = 0;
        int sumP2 = 0;

        for (int j = 0; j < 11; j++) {

            if (p1GameEndFlag) {
                System.out.println("p1 카드를 받으시겠습니까? 1.예 2.아니오");
                String str = new java.util.Scanner(System.in).nextLine();
                if (str.contentEquals("1")) {
                    p1Deck[p1DeckIndex++] = deck[deckIndex++];
                } else if (str.contentEquals("2")) {
                    p1GameEndFlag = false;
                } else {
                    System.out.println("잘못 입력하였습니다.");
                    break;
                }
            }
            if (p2GameEndFlag) {
                System.out.println("p2 카드를 받으시겠습니까? 1.예 2.아니오");
                String str1 = new java.util.Scanner(System.in).nextLine();
                if (str1.contentEquals("1")) {
                    p2Deck[p2DeckIndex++] = deck[deckIndex++];
                } else if (str1.contentEquals("2")) {
                    p2GameEndFlag = false;
                } else {
                    System.out.println("잘못입력하였습니다");
                    break;
                }
            }

            System.out.print("p1Card: ");
            for (int i = 0; i < p1DeckIndex; i++) {
                System.out.print(cardShape[p1Deck[i] / 13] + cardNumber[p1Deck[i] % 13] + " ");
            }
            sumP1 = 0;
            for (int i = 0; i < p1DeckIndex; i++) {
                switch (p1Deck[i] % 13) {
                    case 0:
                        sumP1 = sumP1 + 10;
                        if (sumP1 > 21) {
                            sumP1 = sumP1 - 9;
                        }
                        break;
                    case 10:
                    case 11:
                    case 12:
                        sumP1 = sumP1 + 10;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        sumP1 = sumP1 + p1Deck[i] % 13 + 1;
                        break;
                }
            }
            if (sumP1 > 21) {
                p1GameEndFlag = false;
                p2GameEndFlag = false;
            }
            System.out.println("총점 " + sumP1);

            System.out.println();
            System.out.print("p2Card: ");
            for (int i = 0; i < p2DeckIndex; i++) {
                System.out.print(cardShape[p2Deck[i] / 13] + cardNumber[p2Deck[i] % 13] + " ");
            }
            sumP2 = 0;
            for (int i = 0; i < p2DeckIndex; i++) {
                switch (p2Deck[i] % 13) {
                    case 0:
                        sumP2 = sumP2 + 10;
                        if (sumP2 > 21) {
                            sumP2 = sumP2 - 9;
                        }
                        break;
                    case 10:
                    case 11:
                    case 12:
                        sumP2 = sumP2 + 10;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        sumP2 = sumP2 + p2Deck[i] % 13 + 1;
                        break;
                }

            }
            if (sumP2 > 21) {
                p1GameEndFlag = false;
                p2GameEndFlag = false;
            }
            System.out.println("총점 " + sumP2);

            if ((sumP1 >= 21 || sumP2 >= 21) || (p1GameEndFlag == false || p2GameEndFlag == false)) {
                if (sumP1 == sumP2) {
                    System.out.println("무승부");
                    break;
                } else if (sumP1 > 21) {
                    System.out.println("P2 승리");
                    break;
                } else if (sumP2 > 21) {
                    System.out.println("P1 승리");
                    break;
                } else if (sumP1 > sumP2) {
                    System.out.println("P1 승리");
                    break;
                } else if (sumP2 > sumP1) {
                    System.out.println("P2 승리");
                    break;
                }
            }
        }
    }
}

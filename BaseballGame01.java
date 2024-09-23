package BaseballGame;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame01 {

    int[] num = new int[3]; // 난수가 저장되 배열
    int[] user;             // 사용자가 입력한 값을 저장할 배열

    int strike;
    int ball;

    static Scanner scan = new Scanner(System.in);

    public void getRndNum() {

        Set<Integer> bbNumSet = new HashSet<Integer>();

        // Set을 이용한 3개의 난수 만들기
        while (bbNumSet.size() < 3) {
            bbNumSet.add((int) (Math.random() * 9 + 1));
        }

        // Set의 자료를 배열에 저장하기
        Iterator<Integer> it = bbNumSet.iterator();

        int i = 0;
        while (it.hasNext()) {
            num[i++] = it.next().intValue();
        }

        for (int j = 1; j <= 100; j++) {
            int rnd = (int) (Math.random() * num.length);
            int temp = num[0];
            num[0] = num[rnd];
            num[rnd] = temp;
        }

    }

    public void inputNum() {
        int n1, n2, n3;

        do {
            System.out.print(" □ □ □ 숫자를 입력하세요(숫자 사이에 공백도 함께 입력)");
            System.out.println("");
            n1 = scan.nextInt();
            n2 = scan.nextInt();
            n3 = scan.nextInt();
            if (n1 == n2 || n1 == n3 || n2 == n3) {
                System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요");
            }
        } while (n1 == n2 || n1 == n3 || n2 == n3);

        user = new int[]{n1, n2, n3};
    }

    public void ballCount() {
        strike = 0;
        ball = 0;

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < user.length; j++) {
                if (num[i] == user[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        System.out.println(user[0] + " " + user[1] + " " + user[2] + " ==> " + strike + "S " + ball + "B");

    }

    // 게임을 시작하는 메서드
    public void gameStart() {
        // 난수를 만드는 메서드 호출
        getRndNum();
        int cnt = 0; // 횟수 저장 변수

        do {
            cnt++;
            inputNum();
            ballCount();
        } while (strike != 3);

        System.out.println(cnt + "번째에 맞추셨습니다.");
    }

    public static void main(String[] args) {
        BaseballGame01 baseBall = new BaseballGame01();

        while (true) {
            // 메인 메뉴 출력
            System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
            Scanner scanner = null;

            int a = scan.nextInt();
            if (a == 1) {
                System.out.println("< 게임을 시작합니다 >");
                baseBall.gameStart();
            } else if (a == 2) {
                System.out.println("'게임 기록 보기' 기능은 lv3에서 추가됩니다.");
            } else if (a == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static final int BASEBALL_DIGIT = 3;
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean replay = true;
        while(replay) {
//            try {
                startNewGame();
                replay = isReplay();
//            }catch(IllegalArgumentException e) {
//                break;
//            }
        }
    }
    public static void startNewGame() throws IllegalArgumentException{
        List<Integer> computerNum = getComputerNum();
        Map<String, Integer> ballStrikeMap;
        do {
            List<Integer> userNum = getUserNum();
            ballStrikeMap = getBallStrikeMap(computerNum, userNum);
        } while(!checkAnswer(ballStrikeMap));
    }
    public static boolean isReplay() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine().trim();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }
    public static void printBallStrike(Map<String, Integer> ballStrikeMap) {
        int ballCount = ballStrikeMap.get("ball");
        int strikeCount = ballStrikeMap.get("strike");
        if (ballCount != 0) {
            System.out.print(ballCount+"볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount+"스트라이크");
        }
        System.out.println();
    }
    public static boolean checkAnswer(Map<String, Integer> ballStrikeMap) {
        if (ballStrikeMap.get("strike") == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (ballStrikeMap.get("ball") == 0 && ballStrikeMap.get("strike") == 0) {
            System.out.println("낫싱");
            return false;
        }
        printBallStrike(ballStrikeMap);
        return false;
    }

    public static Map<String, Integer> getBallStrikeMap(List<Integer> computerNum, List<Integer> userNum) {
        Map<String, Integer> ballStrikeMap = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;
        for (int i=0; i<BASEBALL_DIGIT; i++) {
            int computerNumIdx = computerNum.indexOf(userNum.get(i));
            if (computerNumIdx == -1) {
                continue;
            }
            if (computerNumIdx == i) {
                strikeCount++;
            }
            else {
                ballCount++;
            }
        }
        ballStrikeMap.put("ball", ballCount);
        ballStrikeMap.put("strike", strikeCount);
        return ballStrikeMap;
    }

    public static List<Integer> getUserNum() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException();
        }
        List<Integer> userNum = input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
        Set<Integer> userNumSet = new HashSet<>(userNum);
        if (userNumSet.size() != 3) {
            throw new IllegalArgumentException();
        }
        return userNum;
    }

    public static List<Integer> getComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
//        System.out.println("computerNum : "+computerNum);
        return computerNum;
    }
}

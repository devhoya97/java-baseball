package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.plaf.ComponentUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static final int BASEBALL_DIGIT = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Map<String, Integer> ballStrikeMap = getBallStrikeMap(getComputerNum(), getUserNum());
//        System.out.println(ballStrikeMap);
    }
    public static boolean checkAnswer(Map<String, Integer> ballStrikeMap) {
        if (ballStrikeMap.get("strike") == 3) {
            return true;
        }
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

    public static List<Integer> getUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNum = input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
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

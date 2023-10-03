package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        do {
//            List<Integer> computerNum = getComputerNum();
//            List<Integer> userNum = getUserNum();
//
//        } while(true);
    }
//    public static List<Integer> getBallStrike(List<Integer> computerNum, List<Integer> userNum) {
//
//    }
    public static List<Integer> getUserNum() {
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
        return computerNum;
    }
}

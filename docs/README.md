1. public static List<Integer> getComputerNum()
컴퓨터가 가지는 중복된 수 없는 3자릿수 생성하여 List<Integer> 형태로 반환 

2. public static List<Integer> getUserNum() throws IllegalArgumentException
콘솔창 입력을 통해 컴퓨터의 숫자를 맞추기 위한 유저의 숫자를 입력받아서 List<Integer> 형태로 반환.
이 때, 유저가 숫자가 아닌 문자를 입력하거나, 앞 뒤 공백을 제외하고도 4자리 이상의 입력을 주거나, 3자리 숫자를 잘 주었더라도
중복된 입력을 준다면 IllegalArgumentException 객체를 생성해서 throw 한다.

3. public static Map<String, Integer> getBallStrikeMap(List<Integer> computerNum, List<Integer> userNum)
컴퓨터가 가진 값과 사용자의 입력 값을 비교하여 ball count, strike count를 계산한 뒤, 이를 Map 형태로 반환한다.

4. public static void printBallStrike(Map<String, Integer> ballStrikeMap)
ballStrikeMap을 받아서 3스트라이크, 낫싱을 제외한 경우에 대해 알맞은 출력을 내준다.

5. public static boolean checkAnswer(Map<String, Integer> ballStrikeMap)
ballStrikeMap을 받아서 3스트라이크, 낫싱인지 확인하여 알맞은 출력을 내주고, 3스트라이크라면 정답이므로 true를, 그 외엔 오답이므로 false를 반환한다.

6. public static void startNewGame() throws IllegalArgumentException
한 번 게임할 때 필요한 getComputerNum을 생성하고, 반복문을 통해 정답을 맞출 때까지 getUserNum, getBallStrikeMap, checkAnswer를 수행한다.
정답을 맞추면 비로소 한 게임이 끝나므로 반복문을 빠져나갈 수 있다.

7. public static boolean isReplay() throws IllegalArgumentException
main함수 내에서 startNewGame이 종료된 후 사용자의 입력을 1 또는 2로 받아서 1을 입력받으면 새 게임을 시작하므로 true, 
2를 입력받으면 게임이 종료되므로 false를 반환한다. 이 때, 1 또는 2가 아닌 값이 입력으로 들어오면 IllegalArgumentException을 발생시킨다.

8. main 함수
isReplay메서드가 false를 반환할 때 까지 startNewGame 메서드와 isReplay 메서드를 반복한다.   

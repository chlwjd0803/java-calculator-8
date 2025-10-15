package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final Set<String> seperator = new HashSet<>(Arrays.asList(",", ":"));
    private static final String regex = "//[a-zA-Z\\W_]\\\\n";
    private static int sum = 0;

    /**
     * 계산식 문자열을 받아 숫자로 변환하고 합산합니다.
     * 구분자가 유효하지 않은 위치에 있을 경우 예외를 발생시킵니다.
     * 구분자 및 문자 외 잘못된 문자가 입력될 경우에 예외를 발생시킵니다.
     *
     * @param expression 계산식 문자열
     */
    private static void calculate(String expression) {
        StringBuilder sb = new StringBuilder(); // 반복문 시작 전 선언

        for(int i = 0; i < expression.length(); i++) {

            // 1. 구분자가 왔을때
            if(seperator.contains(expression.substring(i, i+1))){
                // 1-1. StringBuilder 내에 값이 존재한다면
                if(!sb.isEmpty()){
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder(); // 재 초기화
                }
                // 1-2. StringBuilder에 값이 없으면 -> 처음부터 구분자를 넣었거나 연속 2번 넣었을때 오류 발생
                else {
                    System.out.println("구분자 위치가 유효하지 않습니다.")..;
                }
            }
            // 2. 숫자가 왔을때 StringBuilder에 올리기
            else if(expression.substring(i, i+1).matches("[0-9]")){
                sb.append(expression.substring(i, i+1));
            }
            // 3. (정의된)구분자도, 숫자도 아닐 경우 -> 잘못된 문자를 입력
            else{
                System.out.println("잘못된 문자가 입력되었습니다.");
            }
        }

        if(!sb.isEmpty()) {
            sum += Integer.parseInt(sb.toString());
        }
    }

    public static void main(String[] args) {
        // 1. 입력
        String input = Console.readLine(); // 입력

        // 2. 계산
        calculate(input);

        // 3. 결과 출력
        System.out.println("결과 : " + sum);

    }
}

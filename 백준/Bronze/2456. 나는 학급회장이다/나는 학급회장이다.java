import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 후보자 점수를 저장할 배열 (각 후보자 1, 2, 3)
        int[] candidate = new int[3];
        // 각 후보자가 받은 점수의 제곱을 저장할 배열 (3점, 2점, 1점의 횟수 계산)
        int[] squared = new int[3];

        // 학생 수 N을 입력받음
        int N = Integer.parseInt(sc.nextLine());

        // 각 학생의 선호도 점수를 입력받음
        for(int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            // 각 후보자에 대한 점수를 정수형으로 변환
            int a = Integer.parseInt(input[0]); // 후보 1에 대한 점수
            int b = Integer.parseInt(input[1]); // 후보 2에 대한 점수
            int c = Integer.parseInt(input[2]); // 후보 3에 대한 점수

            // 후보자 점수 합산
            candidate[0] += a; // 후보 1 점수 합산
            candidate[1] += b; // 후보 2 점수 합산
            candidate[2] += c; // 후보 3 점수 합산

            // 각 후보자 점수의 제곱을 합산 (3점, 2점, 1점의 횟수 확인을 위해)
            squared[0] += a * a; // 후보 1의 제곱 점수 합산
            squared[1] += b * b; // 후보 2의 제곱 점수 합산
            squared[2] += c * c; // 후보 3의 제곱 점수 합산
        }

        // 최고 점수 계산
        int maxScore = Math.max(candidate[0], Math.max(candidate[1], candidate[2]));

        // 최고 점수를 받은 후보가 한 명인지 확인
        if(countOccurrences(candidate, maxScore) == 1) {
            // 유일한 후보를 찾고 출력
            for(int i = 0; i < candidate.length; i++) {
                if(candidate[i] == maxScore) {
                    System.out.println((i + 1) + " " + maxScore); // 후보 번호와 점수 출력
                    break;
                }
            }
        } else {
            // 최고 점수가 여러 후보에 걸쳐 있을 경우
            int maxSquared = Math.max(squared[0], Math.max(squared[1], squared[2]));
            int elected = -1;

            // 제곱 점수로 후보를 결정
            for(int i = 0; i < squared.length; i++) {
                if(squared[i] == maxSquared) {
                    elected = i; // 제곱 점수가 가장 높은 후보 저장
                    break;
                }
            }

            // 제곱 점수도 같은 후보가 여러 명인지 확인
            if(countOccurrences(squared, maxSquared) > 1) {
                // 여러 후보가 동점일 경우
                System.out.println("0 " + candidate[elected]); // 0과 후보의 점수 출력
            } else {
                // 유일한 후보가 결정되었을 경우
                System.out.println((elected + 1) + " " + candidate[elected]); // 후보 번호와 점수 출력
            }
        }
        sc.close(); // 스캐너 닫기
    }

    // 특정 값이 배열에서 몇 번 나타나는지 세는 메소드
    private static int countOccurrences(int[] array, int value) {
        int count = 0;
        for(int v : array) {
            if(v == value) {
                count++; // 값이 같으면 카운트 증가
            }
        }
        return count; // 카운트 반환
    }
}
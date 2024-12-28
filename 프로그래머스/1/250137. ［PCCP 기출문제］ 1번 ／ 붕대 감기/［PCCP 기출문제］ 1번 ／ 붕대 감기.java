class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // attacks의 마지막 배열 공격 시간까지 반복문 실행
        // ex) [11, 5]면 1 ~ 11 까지 for문
        // 변수 하나를 설정해서 attacks의 배열을 하나씩 탐색
        // ex) 2초가 되면 attacks 변수는 +1, 데미지 입히기
        // for문을 실행하면서 bandage의 두번째, 세번째 변수 고려하기
        // health가 0이하면 -1 return하고 반복문 끝내기
        
        // 마지막 공격 시간
        int finalAttackTime = attacks[attacks.length - 1][0];
        
        // attacks를 순환하는 변수
        int attack = 0;
        // 연속 회복 횟수
        int bandaging = 0;
        // 현재 체력 상태
        int healthState = health;
        
        for(int i = 1; i <= finalAttackTime; i++){
            // 공격 받는다면
            if(attacks[attack][0] == i){
                // 체력 감소, 연속 회복 횟수 0 초기화, 다음 공격으로 attack 이동
                healthState -= attacks[attack][1];
                bandaging = 0;
                attack++;
            }
            
            // 공격 받지 않는다면
            else{
                // 체력 회복, 연속 회복 횟수 +1
                if(healthState + bandage[1] <= health){
                    healthState += bandage[1];
                    bandaging++;
                    
                    // 만약 연속 회복 횟수를 모두 채우면 추가 체력
                    if(bandaging == bandage[0]){
                        if(healthState + bandage[2] <= health){
                            healthState += bandage[2];
                            bandaging = 0;    
                        }
                        // 피가 초과한다면
                        else{
                            healthState = health;
                            bandaging = 0;
                        }
                    }
                }
                
                // 피가 초과한다면
                else{
                    healthState = health;
                    bandaging++;
                }
            }
            if(healthState <= 0) return -1;
        }
        return healthState;
    }
}
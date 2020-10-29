package com.company.character;

// 게임에 등장하는 캐릭터들(유저, 손님)의 가장 기본이 되는 속성과 기능을 포함한 클래스 Character 를 상속받는 클래스
// 유저 고유의 속성과 기능을 추가한 클래스
public class Partimer extends Character
{
    // private : 이 클래스의 메소드를 통해서만 변경 가능하도록 하기 위해서 사용
    // static : 유저는 한 명이니까 프로그램이 종료될 때까지 값이 계속 유지되도록하기 위해서 사용
    private static String name;         // 유저에게 입력받은 이름
    private static int skillLevel = 1;  // 숙련도
    private static int salary = 10;     // 한 주에 받는 급여. 단위는 코인이다.
    private static int property = 0;    // 현재 플레이어가 소유하고 있는 재산




}

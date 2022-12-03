# Kiosk Maker
JAVA 주문 시뮬레이터 프로그램

## 클래스 구조

### 패널
- `CategoryPanel` 카테고리 패널
- `MenuPanel` 메뉴 패널
- `OrderPanel` 주문 패널
- `Panels` 패널들 간의 접근을 위한 싱글톤 클래스

### 데이터
- `Data` 메모장 데이터를 읽어오는 싱글톤 클래스
-  `Category` 한 카테고리(아이템의 집합)을 의미함
-  `Item` 한 메뉴 아이템을 의미함

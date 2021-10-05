# Gatling

## Ref 
1. [test 설정](https://gatling.io/docs/gatling/reference/current/cheat-sheet/#injection-profile-open-injection-steps)

## 실행 방법

src.main.scala 는 동작 안함 ... 

### Record

브라우져의 http request를 복사 할 수 있다.

1. firefox 에 SwitchyOmega extension 설치
![img.png](img/img.png)

2. Proxy Tab 에 아래와 같이 입력
![img.png](img/img1.png)

3. 모드를 Proxy로 변경 
4. mvn gatling:recorder 실행 안되면 아래와 같이 
![img.png](img/intellij_maven.png)

5.아래 화면에서 Start 누른 뒤 firefox 에서 request  
![img.png](img/img3.png)

6. test.org.yg 에 RecordedSimulation 으로 파일이 저장됨 


### Run
mvn gatling:test


### 결과 확인 
terminal 에 결과 표시 


## Test 결과 
### proxy-trainer
1. 1차 webflux
![img.png](img/img99.png)
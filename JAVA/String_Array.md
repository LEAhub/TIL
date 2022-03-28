String 배열
===============


### String 배열 생성



int타입의 배열과 생성은 같다. 



```
String[] strArr = new String[3];
```





### String 배열의 초기화



```
String[] nameArr = new String[3];
nameArr[0] = "Jadoo";
nameArr[1] = "Mimi";
nameArr[2] = "Baby";
```

위와 같이 코드를 작성하여 초기화를 할 수 있다.



하지만 원래 String은 클래스이기 때문에 아래처럼 new연산자를 통해 객체를 생성해야 한다.



```
String[] nameArr = new String[3];
nameArr[0] = new String("Jadoo");
nameArr[1] = new String("Mimi");
nameArr[2] = new String("Baby");
```


**기본형 배열이 아닌 경우, *참조형 배열*에 저장되는 것은 객체의 *주소*다.**





### char 배열과 String클래스
```
String 클래스는 char배열에 기능(메소드)를 추가한 것이다.

커스텀 태그
===========


### 커스텀 태그란?


JSTL은 자주 사용하는 태그들을 표준화하여 사용하는 태그 라이브러리이다. 이들을 제외하고 프로그래머가 편할 때 직접 태그를 만들어 사용하는 태그를 __커스텀 태그__ 라고 한다.



1. 작성한 커스텀 태그는 언제든 자신이 필요할 때 재사용할 수 있는 장점이 있다. 다른 사용자가 사용할 수 있다.(jar)



2. JSTL의 장점과 마찬가지로 가독성을 높인다.



3. 자바 문법에 덜 의존적이다.



4. 디자이너와 프로그래머의 분담이 가능하여 효율적인 작업을 기대할 수 있다.




#### 자바 클래스 파일로 태그 생성하기



1. 태그 핸들러(자바 클래스) : 를 필요로 한다. 실질적인 로직은 태그 핸들러에서 진행한다. (controller)



```
TagSupport 클래스 : 태그 안의 내용을 처리하지 않는 경우
------------------------------------------------------------
BodyTagSupport 클래스 : 태그의 내용을 처리하는 경우
------------------------------------------------------------
SimpleTagSupport 클래스 : 태그의 내용의 처리 유무 상관 없이 사용 가능

```

```
태그 내용이 있는 경우 : <tag:welcom>안녕하세요</tag:welcome>
태그 내용이 없는 경우 : <tag:welcom/>
```

```
SimpleTagSupport 클래스를 사용할 때 쓰이는 메소드
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
doTag() : 커스텀 태그를 만나기만 하면 실행된다.
getJspBody() : 커스텀의 내용은 JspFragment 객체를 받아와 처리할 수 있다.
getJspContext().getOut() : JspWriter 객체인 out 객체를 리턴받아 
                           out.println() 메소드를 사용한 것과 같은 결과를 얻을 수 있다.
```

2. .tld : 자바 클래스 파일을 태그로 사용할 수 있도록 등록해주는 역할을 한다.



```
커스텀 갯수 당 <tag> 하나씩 추가해야 한다. 
<tag>
    <name>jsp에서 사용할 태그명</name>
    <tag-class>사용자가 자바 클래스를 생성한 경로,패키지명.클래스명</tag-class>
    <body-content>empty</body-content> 
<tag>

커스텀 태그에 body 즉, 내용이 존재하지 않을 경우 empty로 설정한다.

1. tagdependent : 커스텀 태그의 내용을 처리하지 않고 그대로 사용
2. sciptless : 표현 언어(EL)이나 액션 태그의 처리 결과를 사용할 수 있다
3. empty : 위와 같이 내용이 존재하지 않을 때의 속성
```

3. web.xml : jsp페이지가 tld 파일을 사용할 수 있게 도와주는 중간 다리 역할을 맡는다.



```
<jsp-config>
    <taglib>
        <taglib-uri>자신이 사용하고자 하는 태그를 jsp와 연결해주는 tld파일 경로를 입력</taglib-uri>
        <taglib-location>자신이 사용하고자 하는 태그를 jsp와 연결해주는 tld파일 경로를 입력</taglib-location>
    </taglib>
</jsp-config>

tld파일 하나 당 <taglib> 하나가 필요하다.
```

4. jsp 페이지 : 프로그래머가 생성한 커스텀 태그를 사용한다. 액션 태그, JSTL처럼 사용할 수 있다. (view)


```
<%@taglib prefix="tag" uri="tld파일이 있는 경로 파일명 포함 입력"%>
```



#### 태그 파일에서 태그 만들기



위의 자바 클래스 내에서 로직을 구현하는 방식과는 달리 자바 문법과 거리가 멀고 tld, xml 과정이 사라져 간단하다는 장점이 있다.



.tag를 사용할 경우 jsp가 자동으로 servlet을 변환하는 것처럼 tag는 자동으로 태그 핸들러(자바 클래스)로 변환하여 처리한다.



커스텀 태그 당 하나의 태그 파일을 필요로 한다.



jsp에서는 <%@page%>를 사용하지만 tag에서는 <%@tag%>를 사용한다.
1. tag : 사용자 태그 로직을 기술한다.



```
<%@tag body-content="empty" pageEncoding="utf-8"%>

body-content="empty" 태그 안에 내용이 없을 경우 empty를 사용한다.

1. tagdependent : 커스텀 태그의 내용을 처리하지 않고 그대로 사용
2. sciptless : 표현 언어(EL)이나 액션 태그의 처리 결과를 사용할 수 있다
3. empty : 위와 같이 내용이 존재하지 않을 때의 속성
```

2. jsp 페이지 :  프로그래머가 생성한 커스텀 태그를 사용하여 웹 브라우저에 전달한다.



```
<%@taglib prefix="tag" tagdir="tag 파일이 있는 경로를 입력하되 파일을 담고 있는 상위 폴더명까지"%>
```



#### JAR 파일로 커스텀 태그 배포하는 방법


```
1. 임의의 폴더 생성 (tmp)
2. bulid - classes 폴더 안에 있는 자신이 태그 로직 구현한 자바 클래스 폴더를 tmp 폴더에 복사
3. tmp 폴더 안에 META-INF 폴더 생성
4. 자신이 tag 파일을 만든 상위 폴더를 [tmp]-[META-INF] 폴더에 복사
5. tld 파일은 파일 그대로 [tmp]-[META-INF] 폴더에 복사
6. tag 파일을 JAR 파일로 배포할 때에는 tld 파일을 생성하여 배포함
7. 6번의 tld파일의 위치는 [tmp]-[META-INF] 폴더 안에 지정
8. tmp 폴더에서 명령 프롬프트를 열어 'jar cvf0 study.jar * '입력
```
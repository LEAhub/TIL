JSTL(JSP Standard Tag Library)
=============

JSP에서는 XML처럼 사용자가 태그를 정의해서 사용할 수 있다.


사용자가 직접 만든 태그는 __커스텀 태그__ 라고 부른다.



그들 중 가장 자주 쓰이는 태그들을 표준으로 만들어 제공하는데, 그것이 JSTL이다.



### JSTL core 태그 라이브러리



jsp 페이지 상위에 아래의 taglib 디렉티브를 작성한다.
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```



Core 태그에는 반복문, 화면 출력, 예외처리 등을 할 수 있다.




### JSTL XML 태그 라이브러리


XML태그 라이브러리는 XML을 처리하기 위해 사용한다. 
라이브러리를 사용하기 위해서 jsp 페이지 상위에 아래의 taglib를 추가한다.

```
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
```



### JSTL I18N 태그 라이브러리



JSTL I18N 태그 라이브러리는 다국어 문서를 처리할 때 유용하다. 날짜와 숫자를 다룰 때 사용된다.

```
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
```



### JSTL SQL 태그 라이브러리



JSTL SQL 태그 라이브러리는 DataSource를 이용한 SQL작업 처리를 할 수 있다.
jsp 페이지 상단에 아래의 taglib를 작성하여 사용한다.

```
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%> 
```


select, update, delete, insert 모두 가능하다. 그리고 트랜잭션 처리도 할 수 있다.



### JSTL Functions 태그 라이브러리


JSTL Functions 태그 라이브러리는 JSTL에서 제공하는 함수들을 사용한다.



문자열이나 콜렉션들을 처리한다. 함수가 끝나면 결과값을 반환하기 때문에 태그 하나로 쓰이기 보단



특정 태그 내의 값으로 사용된다.

```
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
```


문자열을 잘라서 배열로 만들고(split()) 길이를 알아내고(length()) 특정 문자열을 포함하는지 알 수 있고(contains()) 



잘라져 배열이 된 String 배열의 문자열들을 어떠한 특정 문자열과 함께 합칠 수 있는(join()),



우리가 흔히 아는 String 관련 함수들을 이 태그 내에서도 사용 가능하다.
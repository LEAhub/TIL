EL (Expression Language)
====================



표현 언어 (LE)는 JSP 페이지 내에서 사용하는 선언문<%!%> 스크립트릿<%%> 표현식<%=%>의 자바코드를 대신하여 사용한다.



JSP에서 html 태그와 자바코드로 혼잡하여 가독성을 떨어뜨리기 때문에 표현 언어를 사용한다.



자바 코드를 대신하는 새로운 언어이다.



> ● null 값이어도 융통성 있게 받아들인다.
>   > 예전에 프로젝트 만드는 중 자꾸만 오류가 뜨기에 뭐가 문제인가 봤더니
>   >
>   >
>   >
>   > 자바빈에서 넘어와야 할 ArrayList의 객체가 넘어오지 않아서 그 객체로 데이터를 반환하지 못하던 에러가 있었다.
>   >
>   >
>   >
>   > 그 때 에러 문구로 "NullPointet Exception"이 출력된 걸로 기억한다.



> ● 파싱에 신경쓰지 않아도 된다.



>   > 웹브라우저에서 요청 받은 모든 정보들은 String 타입이다.



>   > 만일 클라이언트가 숫자를 입력하였더라도 웹서버에서 받은 요청 값은 String이기에 Integer.parseInt() 메소드를 사용하여 파싱을 해줬어야 했다.



>   > 표현 언어에서는 파라미터 값을 parsing 필요 없다.



> ● 변수와 연산자를 쓸 수 있고 함수도 호출할 수 있다.



>   > . : 접근 연산자



>   > [] : 배열이나 리스트의 요소에 접근



>   > % : mod



>   > empty : null인지 확인한다. 비었으면 true를 return하고 하나의 요소라도 존재하면 false를 return한다.



>   > func(args) : 함수 호출이다. func은 임의의 함수명이다. 나중에 자신이 정한 메소드명을 입력하고 괄호 안에는 매개변수를 적어주면 된다.




> ● JSP에 저장된 속성과 자바빈을 표현 언어의 변수로 사용할 수 있다.
>   > ${sessionScope.id} -- session에 저장된 id에 접근할 수 있다.



>   > session, application, request, page가 있다.



>   > ${myCar.price} -- 자바빈 객체인 myCar의 getPrice() 메소드에 접근할 수 있다.



> ● 내장객체를 지원한다. 내장객체에는 무엇이 있을까?
>   > pageScope, requestScope, sessionScope, applicationScope



>   > param : 요청 파라미터 객체, request.getParameter()와 같다.



>   > paramValues : 요청 파라미터 컬렉션이다. request.getParameterValues()와 같다.



>   > header : HTTP 요청 헤더 객체, 헤더 값을 얻어낼 때 사용한다.



>   > headerValues : HTTP 요청 헤도 객체 컬렉션이다.



>   > cookie : 모든 쿠키값 컬렉션. request.getCookie()와 같다.



## 표현 언어 작성하기
--------------------------



### ${name} = <%=name%>



${name}과 같이 사용하고 $와 {,}를 입력하자. 



마치 javascript에서 문자열을 입력하고 쌍따옴표가 아닌 백팃(`)을 사용하여 문자열 안에 해당 변수명을 출력하는 것과 같은 기능을 한다.



C언어와 자바에서 printf를 사용하여 %d, %s를 하는 것 같다.



표현식은 JSP 스크립트 안에는 사용할 수 없다.



표현식 안에서 연산식을 쓸 수 있다.



> 브라켓 연산자(bracket ([]) operator)를 사용할 수 있다.



>   > 브라켓 연산자는 배열의 형태로 객체의 프로퍼티에 접근할 수 있게 도와준다.



>   > 닷 연산자를 대신하여 브라켓 연산자를 사용할 수 있다.



>   > ${myCar['price'] + 2}



>   > ${myCar["price"] + 2}



>   > 작은따옴표, 큰따옴표 모두 표현 가능하다.
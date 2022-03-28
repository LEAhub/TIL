파일 업로드
=======



### 파일 업로드를 위한 폼

method = "post" enctype="multipart/form-data"를 가져야 한다.


-----------------------

### 1. 폼 태그에 속성 설정하기

```
<form name="formName" method="post" enctype="multipart/form-data">
```


1. method : 반드시 post로 지정해야 한다.









2. enctype : 인코딩 방식을 지정한다. 생략이 가능하다.




● **applcation/x-www-form-urlencoded** : 생략할 시 디폴트인 applcation/x-www-form-urlencoded 방식을 사용한다.




공백은 '+'로 특수문자는 아스키 16진수로 변경된 후 전송된다.




●  **multipart/form-data** : 전송 데이터를 인코딩 하지 않는다. 업로드할 때 사용한다.



 ● **text/plain** : 공백을 +로 변환하지 않고 특수문자는 인코딩하지 않는다. 







 3. input태그의 type은 file!
 ```
<input type="file" name="selectFile">
 ```







### 2. input 태그에 속성 지정하기
input 태그에서 html5에서 새로 추가된 formenctype, formmethod 속성을 사용한다.

```
<form action="test.jsp">
    <input type="submit" formmethod="post" formenctype="multipart/from-data" vlaue="전송">
</form>
```



초기에 폼 태그에서 method와 enctype의 방식을 설정하지 않았기 때문에



method 디폴트 방식인 get방식이 설정되고



enctype 디폴트 방식인 applcation/x-www-form-urlencoded 방식이 자동으로 설정된다.



전송 버튼을 누르게 되면 method는 post방식으로, enctype은 multipart/from-data 방식으로 재설정이 된다.



이렇게 재설정된 방식들로 test.jsp 페이지에 전송된다.







### 3. Ajax를 사용하기

자바스트립트에서 서버 요청을 하는 방식이다.



자바스크립트에서 jQuery를 사용하여 파일 업로드 페이지를 요청하는 방식이다.



jQuery Form Plugin을 다운 받아 사용하거나 $.ajax() 메소드에 FormData를 생성하는 방법이 있다.




jQuery Form Plugin는 웹 브라우저 버전에 상관 없이 사용할 수 있다.




$.ajax() 메소드는 IE 웹 브라우저의 경우 10 이상에서만 가능하다.



● html에서의 코드
아래와 같이 script 태그를 추가하여 'jquery.form.min.js'을 사용할 파일 추가한다.
```
<script src="jquery-3.6.0.min.js"></script>
<script src="jquery.form.min.js"></script> 
<form id="form" action="test.jsp" 
          method="post" enctype="multipart/form-data">
<div id="form">
<ul>
...
...
...
```

● 자바스크립트에서의 코드

$("폼아이디").ajaxForm();



form 엘리먼트 객체에 ajaxForm() 메소드를 사용해 action을 취한 페이지로 데이터를 전송한다.



전송 후 결과가 필요할 시엔 success : function(data, status){}를 사용한다.
```
$("#form").ajaxForm({
		success: function(data, status){//업로드에 성공하면 수행
   			$("#result").html(data);//응답받은 결과를 표시
   		}
    });
```
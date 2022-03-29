MultipartRequest 클래스
===========================================



## cos.jar 라이브러리

파일을 업로드하고 폼으로부터 넘어오는 데이터를 얻어내는 라이브러리이다.



그럼, cos.jar 라이브러리에서 위와 같은 과정을 처리를 하는  MultipartRequest 클래스를 사용하여 



파일의 시스템상의 이름, 파일의 본래의 이름, 파일의 콘텐트 타입, 파일의 크기 등을 알아 낼 수 있다.



그러기 위해서 클래스의 객체를 생성하고 객체로 접근하여 메소드를 사용해야 한다.



> 1. MultipartRequest 클래스의 생성자

MultipartRequest의 클래스를 사용하기 위해 객체를 생성한다. 객체를 생성하기 위해선 new연산자를 사용하고 5개의 매개변수가 필요하다.



아래는 MultipartRequest클래스의 객체를 생성하는 예시의 코드이다.



```
MultipartRequest mprq = 
        new MultipartRequest(request, fileSave, 5*1024, "utf-8", new DefualtFileRenamePolicy());
```

>   > request : javax.servlet.http.HttpServletRequest request / HttpServletRequest의 객체를 매개변수로 받는다.
>   > fileSave : 파일을 업로드할 폴더의 경로(문자열)을 담고 있는 매개변수를  MultipartRequest의 생성자 매개변수로 받는다.
>   > 5*1024 : 파일의 최대 크기 설정
>   > "utf-8" : 요청 데이터의 한글 인코딩 방식 설정
>   > new DefualtFileRenamePolicy() : 업로드할 파일명이 기존에 존재하는 파일명과 중복되지 않도록 방지하기 위해 설정







> 2. MultipartRequest 클래스의 메소드


>   > getContentType() 메소드 :
>   >   > 업로드된 파일의 콘텐트 타입을 얻어내는 메소드이다.
>   >   > ```
>   >   > MulipartRequest upload = 
>   >   >                   new MultipartRequest (request, fileSvae, 1024*5, "utf-8", new DefaultFileRenamePolicy());
>   >   > String type = upload.getContentType(name);
>   >   > ```
>   >   > 위와 같이 사용할 수 있다. 
>   >   >
>   >   >
>   >   > 
>   >   > 이때 getContentType(name) 메소드에서 매개변수로 받는 'name'은 



>   >   > 폼에서의 type="file"의 input 태그에서의 name의 파라미터이다.
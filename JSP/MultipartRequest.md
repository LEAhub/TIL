MultipartRequest 클래스
===========================================



### cos.jar 라이브러리

파일을 업로드하고 폼으로부터 넘어오는 데이터를 얻어내는 라이브러리이다.



그럼, cos.jar 라이브러리에서 위와 같은 과정을 처리를 하는  MultipartRequest 클래스를 사용하여 



파일의 시스템상의 이름, 파일의 본래의 이름, 파일의 콘텐트 타입, 파일의 크기 등을 알아 낼 수 있다.



그러기 위해서 클래스의 객체를 생성하고 객체로 접근하여 메소드를 사용해야 한다.



> ## 1. MultipartRequest 클래스의 생성자

MultipartRequest의 클래스를 사용하기 위해 객체를 생성한다. 객체를 생성하기 위해선 new연산자를 사용하고 5개의 매개변수가 필요하다.



아래는 MultipartRequest클래스의 객체를 생성하는 예시의 코드이다.



```
MultipartRequest mprq = 
        new MultipartRequest(request, fileSave, 5*1024, "utf-8", new DefualtFileRenamePolicy());
```

>   > request : javax.servlet.http.HttpServletRequest request / HttpServletRequest의 객체를 매개변수로 받는다.



>   > fileSave : 파일을 업로드할 폴더의 경로(문자열)을 담고 있는 매개변수를  MultipartRequest의 생성자 매개변수로 받는다.



>   > 만일 해당 폴더가 없을 경우 



>   > 객체를 생성할 때 경로를 적은 문자열을 매개변수로 보내면 해당 경로에 입력한 폴더명의 폴더가 자동으로 생성된다.



>   > 5*1024 : 파일의 최대 크기 설정



>   > "utf-8" : 요청 데이터의 한글 인코딩 방식 설정



>   > new DefualtFileRenamePolicy() : 업로드할 파일명이 기존에 존재하는 파일명과 중복되지 않도록 방지하기 위해 설정







> ## 2. MultipartRequest 클래스의 메소드


>   > ### ● getContentType() 메소드 :



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











>   > ### ● getFile() 메소드 :



>   >   > 업로드된 파일을 File 객체로 얻어낼 수 있다.
>   >   > ```
>   >   > File file = upload.getFile(name);
>   >   > ```
>   >   > 주로 파일의 크기를 얻어낼 때 사용된다.












>   > ### ● getFileNames() 메소드 :



>   >   > 폼으로 넘어온 파라미터들 중 type="file"로 된  input 태그의 파라미터들만 받는다.
>   >   > Enumeration 객체를 얻어낼 수 있다.
>   >   > ``
>   >   > Enumeration files = upload.getFileNames();
>   >   > ```
>   >   > 업로드된 파일이 1개 이상일 때에는 컬렉션인 Enumeration 객체에 파일명들을 저장한다.


>   >   > 반복문을 사용하여 각 파일(각 객체)에 접근할 수 있다. 각각의 객체를 얻어내는 메소드로는 nextElement()메소드를 사용한다.



>   >   > nextElement()메소드로 해당 파라미터명을 얻어낼 수 있다.



>   >   > nextElement()메소드는 Object 타입이니 사용에 따라 형변환을 해줄 필요가 있다.



>   >   > 각 얻어낸 객체로 실제 저장된 파일명과 시스템상에 저장된 파일명을 알아낼 수 있다. 아래에서 그 메소드들을 알아보자.












>   > ### ● getFilesystemName() 메소드 :



>   >   > 사용자가 업로드한 파일명(서버상에 업로드된 파일 명이다)을 얻어낼 수 있는 메소드이다.



>   >   > 업로드 시 이미 업로드된 파일명과 중복될 때에는 파일명이 변경되어 업로드 된다.



>   >   > ```
>   >   > String filename = upload.getFilesystemName(name);
>   >   > ```












>   > ### ● getOriginalFileName() 메소드 :



>   >   > 파일의 원래 파일명을 반환한다. 
>   >   > ```
>   >   > String originName = upload.getOriginalFileName(name);
>   >   > ```
>   >   > MultipartRequest 객체를 생성할 때 5개의 매개변수가 있다고 했다. 마지막 매개변수에 new DefaultFileRenamePolicy()가 있었다.



>   >   > 저 방식을 사용하게 되면 본래 저장된 파일명과 중복될 경우 자동으로 파일명을 수정해준다.



>   >   > getOrigicalFileName() 메소드를 사용하면 자동으로 수정된 파일명이 아닌, 본래의 파일명을 반환한다.












>   > ### ● getParameter() 메소드 :



>   >   > 넘어온 파라미터들 중에 type="file"이 아닌 단일 값을 갖는 파라미터를 매개변수로 받는다.
>   >   > ```
>   >   > String name = upload.getParameter(name);
>   >   > ```
>   >   > name의 속성값을 반환한다.












>   > ### ● getParameterNames() 메소드 :



>   >   > 폼으로 넘어온 파라미터들 중 type="file"이 아닌 input 태그가 아닌 파라미터들을 받아서



>   >   > Enumeration 객체가 가리키도록 한다. Enumeration은 컬렉션이다. 
>   >   > ```
>   >   > Enumeratoin params = upload.getParameterNames();
>   >   > ```
>   >   > 위와 같이 params 객체가 가리키는 모든 파라미터에 접근하여 



>   >   > 파라미터 명을 반환하는 메소드를 사용할 수 있고, 파라미터의 속성값을 반환하는 메소드를 사용할 수도 있다.












>   > ### ● getParameterValues() 메소드 :



>   >   > 하나의 파라미터에 대해 여러 개의 값을 가지는 type="checkbox"인 파라미터의 값을 String 배열로 얻어낼 수 있다.
>   >   > ```
>   >   > String[] values = upload.gerParameterValues(name);   // 여러 속성값들을 가져옴
>   >   > for(int i = 0; i < values.length; i++){
>   >   > String value = values[i];    // String 배열 안에 있던 값들 중 반복문으로 통하여 하나의 속성값을 value 참조변수에 가리키게 함
>   >   > }
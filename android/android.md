# 나중에 찾아보기 쉽게 정리
- #### 버터나이프 추가
  - @Bind와 @BindView 는 버전차이(@Bind가 옛날 버전)
````
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:25.0.1'
    compile 'com.android.support:design:25.0.1'
    compile 'com.jakewharton:butterknife:8.8.0'

    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.0' // 이거 꼭해야함. 이거 안해서 하루종일 시간날림

}

````
## 레이아웃
- #### 오른쪽 배치
  - `android:layout_gravity="right"`

- #### content
  - `wrap_content` = 자식 컴포넌트 크기에 맞게 할당 됨
  - `match_content` = 부모 레이아웃의 크기에 맞게 할당 됨



## java
 - String 변수의 널체크
   - `String str = test.getText().toString();
      if(str.isEmpty()) {}`

 - 액티비티 이동
   - `Intent i = new Intent(현재액티비티.this, 이동할액티비티.class);
      startActivity(i);`

 - 타이틀바 삭제
   - `android:theme="@style/Theme.AppCompat.NoActionBar`

 - 스플래시 설정
   - manifest 파일에서 <intent-filter> 위에 스플래시로 사용할 액티비티 선언
     - 스플래시로 사용할 액티비티에 초 설정하는 코드 추가
       - try{
         Thread.sleep(4000);
       }
       catch (InterruptedException e) {
         e.printStackTrace();
       }

       startActivity(new Intent(this,MainActivity.class));
       finish;

# ANDROID
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

- oncreate 함수에 'ButterKnife.bind(this);' 작성


````

## 오류
- 안드로이드 버전을 3.0으로 업데이트 하고 나서 기존에 적용이 되던 라이브러리들이 적용이 안되는 경우가 종종 있다.
  - 나같은 경우에는 build.gradle 에 `classpath "io.realm:realm-gradle-plugin:3.1.2"` 가 원래는 3.1.2 이하였는데 3.1.2 로 수동 업데이트해주고 나니 정상적으로 build 되었다.
`
## 레이아웃
- #### 오른쪽 배치
  - `android:layout_gravity="right"`

- #### content
  - `wrap_content` = 자식 컴포넌트 크기에 맞게 할당 됨
  - `match_content` = 부모 레이아웃의 크기에 맞게 할당 됨
  - `android:layout_centerInParent="true"` = RelativeLayout 안에서 가운데 정렬
  - `android:layout_gravity="center"` = LinearLayout 안에서 가운데 정렬


## java
 - String 객체의 널체크
   - `if(str==null)`
   - **isEmpty** 는 객체의 null 판별이 아니라 객체의 값 유무를 판별
   ```
  String str1 = "";
  String str2 = null;
  String st3 = " "

  if(str1.isEmpty()) -> true
  if(str2.isEmpty()) -> NullException
  if(str3.isEmpty()) -> false

  if(str1.length()) -> true
  if(str2.length()) -> NullException
  if(str3.length()) -> false

  if(str1.equals("")) -> true
  if(str2.equals("")) -> NullException

  if(str1==null) -> false
  if(str2==null) -> true
   ```
 - equals 와 == 의 차이
   - equals: 두 객체가 담고 있는 내용을 비교
   - ==: 두 객체를 비교(같은 객체를 참고하고 있는지)
 ```
 String str1 = new String("this");
 String str2 = new String("this");

 str1.equals(str2)-> true
 str1==str2 -> false
 ```

 ```
 String str1 = new String("this");
 String str2 = str1;

 str1.equals(str2)-> true
 str1==str2 -> true
 ```

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

  - toString() vs String.valueof
    - toString() 은 null exception이 발생
    - String.valueof 는 no exception이

  - getText()를 하면 String 이 아니라 Charsequence 이 넘어 가기 때문에 toString 혹은 String.valueof 를 해야함

## 버튼 선언
### 일반적인 버튼 선언
```
public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        button=(Button)findViewById(R.id.button);
        // 몇 개 안되는 버튼 리스너 작성 시 onCreate 안에 직접 작성
        addbutton.setOnClickListener(new View.OnClickListener() {
        @Override
           public void onClick(View view) {
                Toast.makeText(MapsActivity.this, "클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

```
public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        findViewById(R.id.button).setOnClickListener(mClickListener);
        findViewById(R.id.button2).setOnClickListener(mClickListener);
    }

    // 버튼이 여러개 있을 때 onCreate 밖에서 리스너 작성
    Button.OnClickListener mClickListener = new View.OnClickListener() {
      public void onClick(View v) {
        switch(v.getId()) {
          case R.id.button: // button 버튼이 클릭 되었을 때 동작 할 내용
          break;
          case R.id.button2: // button2 버튼이 클릭 되었을 때 동작 할 내용
          break;
         }
      }
   }
}
```


### 버터나이프 버튼 선언
```
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button) Button button;
    @OnClick(R.id.button)
    void OnClickButton2()
    {
        Toast.makeText(this, "클릭했습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        ButterKnife.bind(this); // 꼭 써야함
    }
}
```

### 라이브러리 이벤트
- 예를 들어 버튼 라이브러리를 받아와서 리스너를 붙일 때 실제적으로 버튼은 아니기 때문에 (Button)findViewById 로 바인딩하면 안됨
- 해당 라이브러리의 id 값으로 바인딩하면 됨
```
findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });
```

### EditText
- 자동 줄바꿈: ` android:scrollHorizontally="false" `
- 수정 불가(읽기 전용)
```
android:clickable="false"
android:focusable="false"
```

### Toolbar
- 간혹 Toolbar를 선언할 때 **ClassCastException** 오류가 뜨면서 **Toolbar cannot be cast** 라고 나올 때가 있음
  - Toolbar 선언과 바인딩의 버전 차이를 예상함
    - 해결:
    ```
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    ```

### Activity vs AppCompatActivity
  - 버전 차이
    - ex) dispatchKeyShortcutEvent() 메소드는 3.0미만의 단말기에서 실행 안됨. 이런 메소드 지원하려고 AppCompatActivity 나옴
    - ActionBar 역시 3.0 이후에 나온 기능이라 3.0 미만의 단말기에서는 동작할 수 없기 때문에 AppCompatActivity 사용

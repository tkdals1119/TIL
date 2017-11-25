# tensorflow
 - 데이터 플로우 그래프(노드로 이루어짐)를 사용해서 numerical 한 computation 계산을 할 수 있는 라이브러리

## Machine Learning
 - 프로그램 자체가 데이터를 보고 학습해서 뭔가를 배우는 능력을 갖는 프로그램
    - Supervised Learning
       - 정해져 있는 데이터, 레이블이 정해져 있음. 즉, training set 으로 학습
       - **regression** : ex) 0 ~ 100점 중 예측해봄
       - **binary classification** : ex) 'pass / non-pass' 둘 중에 하나를 고름
       - **multi-label classification** : ex) 'A,B,C,D,F' 등급 중 하나를 고름(레이블이 많음)

    - Unsupervised Learning
       - 레이블이 정해져 있지 않음

## python
 - 노드생성->세션생성->그래프실행
   - 세션을 생성안하고 노드 자체를 출력할 경우 결과값이 아닌 Tensor 값이 나온다
     - 결과값을 출력하기 위해선 **Session** 정의

 - 가장 기본
   - `import tensorflow as tf
      hello = tf.constant("hello, tensorflow!") // "hello, tensorflow!"라는 텍스트를 가진 hello노드 생성

    sess = tf.Session() // computation 그래프를 실행시키기 위함
    print(sess.run(hello))
   `

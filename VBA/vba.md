# vba (visual basic for application)
```
sub test()
  'a1에 hello World 출력
  Range("a1").Value = "Hello World"

  '"1번 시트"라는 제목을 가진 시티의 a2에 "1번시트 A2"라고 입력
  Sheets(1).Range("a2").Value = "1번시트 A2"
End Sub

- A3 선택하고 글쓰기
Sub test()
  Sheets(1).Range("a3").Select
  Range("a3").Value = "1번시트 A3"
End Sub
```

## 셀에 내용 추가하기
```
sub test()
  i = 1
  j = 1

  Cells(i, j).Select
  Selection.Value = 100
End Sub

[셀에 있는 내용을 지우려면 'Selecet' 대신 'Clear' 함수를 사용하면 됌]
```

## 셀 값 가져오기
```
Sub test() 'B2셀에 있는 값을 가져다가 A11셀에 입력
  Range("A11").Value = Range("B2").Value
End Sub
```

## 셀 값 복사하기
 - 행
```
Sub 글자복사하기()
  For Row = 1 To 10
    Cells(1, Row).Value = Cells(1, Row).Value
  Next
End Sub
```
 - 열
```
Sub 글자복사하기()
  For Row = 1 To 10
    Range("B" & Row).Value = Range("A" & Row).Value
  Next
End Sub
```

## 글자 연걸 하기
```
--> '&' 기호로 문자를 연결함. A1에 있는 내용을 다이얼로그로 띄움
Sub 글자연결하기()
  a = Range("A1").Value
  MsgBox = ("나는" & a & "이다.")
```


### JAVA 알고리즘 문법 정리

----

### String의 다양한 기능   

#### join
```
String[] tokens = {"1","2","3"}
String result = String.join("", Arrays.copyOf(tokens, tokens.length)); /// 123
```

#### split
```
String query = "one and two and three 20";
String[] tokens = query.split(" (and )?"); // {"one","two","three","20"}; 
```

#### 
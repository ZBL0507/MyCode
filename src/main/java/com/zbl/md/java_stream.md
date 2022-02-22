## 1. stream()流中使用排序
```java
// 按年龄排序(Integer类型)
List<StudentInfo> studentsSortName = studentList
                                        .stream()
                                        .sorted(Comparator.comparing(StudentInfo::getAge))
                                        .collect(Collectors.toList());


// 按年龄排序(Integer类型) 倒序排序 
List<StudentInfo> studentsSortName = studentList
                                        .stream()
                                        .sorted(Comparator.comparing(StudentInfo::getAge).reversed())
                                        .collect(Collectors.toList());

// 使用年龄进行降序排序，年龄相同再使用身高升序排序
List<StudentInfo> studentsSortName = studentList
                                        .stream()
                                        .sorted(Comparator.comparing(StudentInfo::getAge).reversed()
                                                          .thenComparing(StudentInfo::getHeight)
                                                )
                                        .collect(Collectors.toList());
```
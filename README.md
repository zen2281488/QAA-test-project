# QA_A_test_project
Мэйн класс: 

    src/main/java/QA_A_test_project/StringAnalyzer.java
Тест классы:

    /test/java/QA_A_test_project/StringAnalyzerTest.java

Зависимости, версии:

    •JVM - 11
    •junit5 - 5.8.2


# Проверка работоспособности класса 

    src/main/java/QA_A_test_project/StringAnalyzer.java


Шаги:

Вводные данные:

    1)input={"qwe", "wqe", "qwee", "a", "a"
    2)input={"abc", "cab", "bca"}
    3)input={"xyz", "zyx", "yxz", "zxy"}
    4)input={"123", "123", "123", "123"}
    5)input={"aaa", "aaa", "aaa", "aaa", "aaa", "aaa"}


Ожидаемый результат:

    1)"eqw = 0, 1" "a = 3, 4"
    2)"abc = 0, 1, 2"
    3)"xyz = 0, 1, 2, 3"
    4)"123 = 0, 1, 2, 3"
    5)"aaa = 0, 1, 2, 3, 4, 5"

Постусловия:

        Тест завершен успешно

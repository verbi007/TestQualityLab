Feature: Авторизация

  Background: Перейти на главную страницу сайта
    Given Открываем сайт "https:/mail.ru"

  Scenario Outline: Перейти на окно авторизации
    When Нажимаем на кнопку вход
    Then Появляется окно авторизации
    And Вводим имя пользователя <login>
    And Нажимаем кнопку Ввести пароль
    And Вводим пароль <password>
    And Нажимаем кнопку Войти
    Then В поле профиля видим введенное имя пользователя <login>

    Examples:
      | login                 | password      |
      | "verbi.anton@mail.ru" | "jumbo785655" |





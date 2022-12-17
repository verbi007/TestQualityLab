Feature: Авторизация

  Background: Перейти на главную страницу сайта
    Given Открываем сайт "https:/mail.ru"

  Scenario Outline: Авторизация
    When Нажимаем на кнопку вход
    Then Появляется окно авторизации
    And Ввести имя пользователя <login>
    And Нажимаем кнопку Ввести пароль
    And Ввести пароль <password>
    And Нажать кнопку Войти
    Then В поле профиля видим введенное имя пользователя <login>

    Examples:
      | login                 | password      |
      | "verbi.anton@mail.ru" | "jumbo785655" |





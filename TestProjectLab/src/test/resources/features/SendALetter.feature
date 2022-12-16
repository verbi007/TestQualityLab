#language: en
Feature: Отправить письмо

  Background: Открыть сайт
    Given Открываем сайт "https:/mail.ru"
    And Авторизация: логин "1", пароль "2"


  Scenario Outline: Отправить письмо
    When Нажимаем на кнопку вход
    Then Появляется окно авторизации
    And Вводим имя пользователя <login>
    And Нажимаем кнопку Ввести пароль
    And Вводим пароль <password>
    And Нажимаем кнопку Войти
    Then В поле профиля видим введенное имя пользователя <login>


    And Нажать на кнопку 'Написать письмо'
    And Появляется окно отправки письма
    And Ввести данные <to> в поле "Кому"
    And Ввести данные "Тест" в поле "Тема"
    And Ввести данные "Тестовое сообщение" в поле "Сообщение"
    And  Нажать кнопку 'Отправить'
    Then Появляется сообщение "Письмо отправлено"

    Examples:
      | login                 | password      | to                   |
      | "verbi.anton@mail.ru" | "jumbo785655" | "rivver007@gmail.com"|


